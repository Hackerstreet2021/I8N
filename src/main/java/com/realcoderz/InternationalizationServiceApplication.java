package com.realcoderz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class InternationalizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternationalizationServiceApplication.class, args);
	}
	

}
