package org.example.demo.test;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TestPlayersPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải file FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/PlayersPage.fxml"));
            Parent root = loader.load();

            // Thiết lập scene
            Scene scene = new Scene(root);
            //Kết nối css
            URL cssLocation = getClass().getResource("/css/Players.css");
            if (cssLocation == null) {
                System.err.println("CSS file not found at /css/Players.css");
            } else {
                scene.getStylesheets().add(cssLocation.toExternalForm());
            }

            // Cấu hình stage
            primaryStage.setTitle("Players Page");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
