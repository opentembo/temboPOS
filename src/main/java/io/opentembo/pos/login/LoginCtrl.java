package io.opentembo.pos.login;

import com.sun.javafx.tk.Toolkit;
import io.opentembo.pos.css.StyleService;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ke.co.suncha.tembo.Application;
import ke.co.suncha.tembo.TemboServiceFactory;
import ke.co.suncha.tembo.remote.ConnectionService;
import ke.co.suncha.tembo.remote.Response;
import ke.co.suncha.tembo.tenant.admin.security.Credential;
import ke.co.suncha.tembo.tenant.admin.security.LoginResponse;
import ke.co.suncha.tembo.tenant.admin.security.NdovuSecurityService;
import ke.co.suncha.tembo.tenant.helpers.request.ResponseObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by maitha.manyala on 1/7/16.
 */
public class LoginCtrl implements Initializable {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @FXML
    private TextField txtEmailAddress;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnLogin;

    @FXML
    private void login(ActionEvent actionEvent) {
        lblStatus.setTextFill(Color.rgb(21, 117, 84));
        final String username = txtEmailAddress.getText();
        final String password = txtPassword.getText();
        if (StringUtils.isBlank(username)) {
            lblStatus.setText("Email address can not be empty");
            lblStatus.setTextFill(Color.rgb(210, 39, 30));
        } else if (StringUtils.isBlank(password)) {
            lblStatus.setText("Your password can not be empty");
            lblStatus.setTextFill(Color.rgb(210, 39, 30));
        } else {
            lblStatus.setText("Please wait, authenticating ....");
            Task task = new Task<Void>() {
                @Override
                protected Void call() {
                    authenticate(username, password);
                    return null;
                }
            };
            new Thread(task).start();
        }
    }

    private void authenticate(String username, String password) {
        try {
            ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
            Credential credential = new Credential();
            credential.setUsername(username);
            credential.setPassword(password);
            NdovuSecurityService ndovuSecurityService = TemboServiceFactory.getService(NdovuSecurityService.class);
            Response response = ndovuSecurityService.authenticate(credential);
            if (response.isInternalError()) {
                updateUI(response.getPayload(), true);
            } else if (response.isRequestError()) {
                ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                updateUI(restResponse.getMessage(), true);
            } else {
                connectionService.setLoginResponse(response.getPayload());
                updateUI("Authentication ok", false);
            }
        } catch (Exception e) {
            updateUI(e.getMessage(), true);
        }
    }

    private void updateUI(final String message, final Boolean error) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (error) {
                    lblStatus.setText(message);
                    lblStatus.setTextFill(Color.rgb(210, 39, 30));
                } else {
                    lblStatus.setText(message);
                    lblStatus.setTextFill(Color.rgb(21, 117, 84));
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login/assign_session.fxml"));
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(StyleService.CSS_STYLE);
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        log.error(ex.getMessage());
                    }
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
