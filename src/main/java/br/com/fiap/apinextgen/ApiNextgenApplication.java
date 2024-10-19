package br.com.fiap.apinextgen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiNextgenApplication {
    public static final String FEEDBACK_QUEUE = "feedback-queue";

    public static void main(String[] args) {
        SpringApplication.run(ApiNextgenApplication.class, args);
    }

}
