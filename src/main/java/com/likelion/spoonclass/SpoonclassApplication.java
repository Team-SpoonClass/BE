package com.likelion.spoonclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpoonclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpoonclassApplication.class, args);
	}

}
