package com.project.customstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class CustomStarterApplication  {

    public static void main(String[] args) {
		SpringApplication.run(CustomStarterApplication.class, args);
	}

}

