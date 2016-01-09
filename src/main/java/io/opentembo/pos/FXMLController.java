package io.opentembo.pos;

import java.net.URL;
import java.util.ResourceBundle;


import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ke.co.suncha.tembo.TemboServiceFactory;
import ke.co.suncha.tembo.tenant.admin.security.LoginResponse;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;
import ke.co.suncha.tembo.tenant.helpers.TemboConfig;

import javax.annotation.PostConstruct;


public class FXMLController implements Initializable {

    @FXML
    private Label lblResult;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblAuthor;

    @FXML
    @ActionTrigger("loginUser")
    private Button btnOk;

    private Integer count = 0;

    @FXML
    @ActionMethod("loginUser")
    private void btnClicked() {
        lblResult.setText("Clicked: " + count);
        count++;
    }

    @PostConstruct
    public void init() {
        lblResult.setText("Button was clicked " + count + " times");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoginResponse loginResponse = TemboServiceFactory.getService(LoginResponse.class);
        UserSession userSession = TemboServiceFactory.getService(UserSession.class);
        lblTitle.setText(loginResponse.getTenantName() + "/" + userSession.getBusinessUnit().getName() + "/" + userSession.getWarehouse().getName() + " - " + TemboConfig.getAppName());
        lblAuthor.setText(loginResponse.getName() + "/" + userSession.getUserRole().getName());
    }
}
