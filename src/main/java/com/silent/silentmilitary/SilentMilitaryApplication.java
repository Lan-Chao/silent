package com.silent.silentmilitary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.silent.silentmilitary.proto"})
public class SilentMilitaryApplication {

    public static void main(String[] args) {

        SpringApplication.run(SilentMilitaryApplication.class, args);
        System.out.println("欢迎来到的silent............");

    }

}

