module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;


    // Mở các package cho Spring để cho phép reflection và tạo proxy
    opens org.example.demo to javafx.fxml, spring.core, spring.beans, spring.context;
    opens org.example.demo.config to spring.core, spring.beans, spring.context;
    opens org.example.demo.controller to javafx.fxml, spring.core, spring.beans, spring.context;
    opens org.example.demo.test to javafx.fxml, spring.core, spring.beans, spring.context;
    opens org.example.demo.utils to spring.core;

    exports org.example.demo;
    exports org.example.demo.config;
    exports org.example.demo.controller;
    exports org.example.demo.test;
    exports org.example.demo.utils;

}