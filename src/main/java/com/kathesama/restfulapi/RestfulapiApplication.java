package com.kathesama.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@EnableConfigurationProperties
@SpringBootApplication()
@EnableMongoAuditing
public class RestfulapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);
	}
}
