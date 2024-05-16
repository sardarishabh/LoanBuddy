package com.cts.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is the main class for Authorisation class
 * 
 * @authorPOD 6
 *
 */
//@EnableEurekaClient
@SpringBootApplication

public class AuthorizationApplication {

	/**
	 * Main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

}
