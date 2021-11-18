package com.hanu.mediumclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@ComponentScan(basePackages = "com.hanu.mediumclone")
@EnableJpaAuditing
public class MediumCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumCloneApplication.class, args);
	}

}
