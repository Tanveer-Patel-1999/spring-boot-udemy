package com.tanveer.CurdDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdDemoApplication.class, args);
	}

//	commandLineRunner is executed after the Spring bean have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return  runner-> {
			System.out.println("Hello world...from CommandLineRunner");
		};
	}

}
