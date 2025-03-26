package com.gisma.asc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "ASC API", version = "1.0", description = "Advanced Schooling Community API"))
@SpringBootApplication
public class AscApplication {

	public static void main(String[] args) {
		SpringApplication.run(AscApplication.class, args);
	}

}
