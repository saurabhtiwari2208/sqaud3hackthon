package com.bankdetailssvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaRepositories
@SpringBootApplication
public class BankdetailssvcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BankdetailssvcApplication.class, args);
	}

}
