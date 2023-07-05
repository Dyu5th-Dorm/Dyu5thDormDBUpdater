package org.dyu5thdorm.dyu5thdormapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dyu5thDormApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(Dyu5thDormApiApplication.class, args);
    }
}
