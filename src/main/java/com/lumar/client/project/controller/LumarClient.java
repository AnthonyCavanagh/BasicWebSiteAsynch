package com.lumar.client.project.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lumar.client.project")
@SpringBootApplication
public class LumarClient extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LumarClient.class);
	}
    public static void main( String[] args ) {
    	SpringApplication.run(LumarClient.class, args);
    }
}
