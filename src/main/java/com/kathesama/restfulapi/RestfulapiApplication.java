package com.kathesama.restfulapi;

import com.kathesama.restfulapi.model.Example;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.kathesama.restfulapi.repository.ExampleRepository;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@EnableConfigurationProperties
@SpringBootApplication()
public class RestfulapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ExampleRepository exampleRepository){
		return args -> {
			Example example = new Example("first example", LocalDateTime.now());
			exampleRepository.insert(example);
		};
	}
}
