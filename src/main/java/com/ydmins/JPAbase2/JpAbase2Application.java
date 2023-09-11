package com.ydmins.JPAbase2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpAbase2Application {

	public static void main(String[] args) {
		SpringApplication.run(JpAbase2Application.class, args);
	}

}
