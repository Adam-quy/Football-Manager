package org.example.demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.demo"}) // Quét tất cả các package trong project
public class DemoSpringBootApp {
    // Không cần main method vì sẽ chạy từ TestApplication
}