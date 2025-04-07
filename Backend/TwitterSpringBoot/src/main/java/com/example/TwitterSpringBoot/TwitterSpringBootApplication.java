package com.example.TwitterSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringBootApplication.class, args);
		System.out.println("Twitter Clone Running Successfully...");
	}
}
