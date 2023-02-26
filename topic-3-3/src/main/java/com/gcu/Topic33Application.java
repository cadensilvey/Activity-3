package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.gcu"})
@SpringBootApplication
public class Topic33Application {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		SpringApplication.run(Topic33Application.class, args);
	}

}
