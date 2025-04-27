package org.example.demo.config;


import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class SpringFXMLLoader {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static FXMLLoader load(String fxmlPath) {
        try {
            // Tìm resource theo nhiều cách để đảm bảo tìm thấy
            URL resource = SpringFXMLLoader.class.getResource(fxmlPath);
            if (resource == null) {
                resource = SpringFXMLLoader.class.getClassLoader().getResource(fxmlPath);
            }
            if (resource == null) {
                // Thử đường dẫn tuyệt đối
                if (!fxmlPath.startsWith("/")) {
                    resource = SpringFXMLLoader.class.getResource("/" + fxmlPath);
                }
            }

            if (resource == null) {
                throw new IOException("Cannot find FXML file: " + fxmlPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            loader.setControllerFactory(context::getBean);
            return loader;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }
}
