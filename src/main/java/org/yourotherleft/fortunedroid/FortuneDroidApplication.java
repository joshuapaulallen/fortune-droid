package org.yourotherleft.fortunedroid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FortuneDroidApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortuneDroidApplication.class, args);
    }
}
