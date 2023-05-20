package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    //扫描DemoApplication.clasas平级以及下一级的注解
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
