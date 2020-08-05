package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.web")
@EntityScan(basePackages = {"com.web.entity"})
public class WebAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppsApplication.class, args);
	}

}
