package com.example.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.example.employeepayroll")
@EnableSwagger2
public class EmployeepayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeepayrollApplication.class, args);
	}



}
