package org.yourotherleft.fortunetwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FortuneTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortuneTwitterApplication.class, args);
    }
}
