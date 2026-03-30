package com.battilana.onepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OnepageApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnepageApplication.class, args);
    }

}
