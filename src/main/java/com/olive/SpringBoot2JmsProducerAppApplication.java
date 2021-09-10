package com.olive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot2JmsProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JmsProducerAppApplication.class, args);
	}

}
