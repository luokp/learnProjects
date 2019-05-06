package com.luokp.springbootcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackageClasses = SpringbootCodeApplication.class,
        excludeFilters = @ComponentScan.Filter(SpringBootApplication.class))
public class  SpringbootCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCodeApplication.class, args);
    }
}
