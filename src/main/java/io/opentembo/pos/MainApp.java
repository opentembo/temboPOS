package io.opentembo.pos;

import io.opentembo.pos.css.StyleService;
import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ke.co.suncha.tembo.TemboServiceFactory;
import ke.co.suncha.tembo.tenant.helpers.TemboConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Arrays;


public class MainApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(StyleService.CSS_STYLE);
        stage.setTitle(TemboConfig.getAppName());
        stage.setScene(scene);
        stage.show();
        loadSpring();
    }

    private void loadSpring() {
        Task task = new Task<Void>() {
            @Override
            protected Void call() {
                TemboServiceFactory.init();
                return null;
            }
        };
        new Thread(task).start();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
