package com.ista.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class GestionPedidosM4BApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPedidosM4BApplication.class, args);
		
	}

}
