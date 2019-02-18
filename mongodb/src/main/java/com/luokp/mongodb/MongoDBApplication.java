package com.luokp.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDBApplication.class, args);
        System.out.println("hello");
    }
}
