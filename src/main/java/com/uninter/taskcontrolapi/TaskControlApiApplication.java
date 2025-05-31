package com.uninter.taskcontrolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.uninter.taskcontrolapi.repositories")
@EntityScan("com.uninter.taskcontrolapi.models")
public class TaskControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskControlApiApplication.class, args);
	}

}
