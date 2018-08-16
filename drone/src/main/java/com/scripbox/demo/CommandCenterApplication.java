package com.scripbox.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.scripbox.*")
public class CommandCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandCenterApplication.class, args);
	}
}
