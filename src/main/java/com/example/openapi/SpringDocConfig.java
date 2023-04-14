package com.example.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {
	
	@Bean
	public OpenAPI openapi() {
		return new OpenAPI()
				.info(new Info()
				.title("Via Cep api")
				.version(null)
				.description("Rest api via cep")
				.license(new License().name("Apache 2.0")
						.url("http://springdoc.com")));
	}

}
