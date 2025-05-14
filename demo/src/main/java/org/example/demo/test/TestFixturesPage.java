package org.example.demo.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import java.net.URL;
//@SpringBootApplication
//@ComponentScan(basePackages = {"org.example.demo"})
public class TestFixturesPage extends Application {
//    private ApplicationContext springContext;
//
//    @Override
//    public void init() {
//        // Khởi tạo Spring context
//        springContext = SpringApplication.run(TestFixturesPage.class);
//    }
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlLocation = getClass().getResource("/org/example/demo/FixturesPage.fxml");
        if (fxmlLocation == null) {
            throw new RuntimeException("FXML file not found at /org/example/demo/Fixtures.fxml");
        }
        System.out.println("FXML Location: " + fxmlLocation);

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
//        loader.setControllerFactory(springContext::getBean);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        URL cssLocation = getClass().getResource("/css/Fixtures.css");
        if (cssLocation == null) {
            System.err.println("CSS file not found at /css/Fixtures.css");
        } else {
            scene.getStylesheets().add(cssLocation.toExternalForm());
        }

        stage.setScene(scene);
        stage.setTitle("Fixtures Page");
        stage.show();
    }

        public static void main(String[] args) {
            launch(args);
        }
}
