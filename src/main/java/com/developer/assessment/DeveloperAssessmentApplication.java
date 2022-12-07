package com.developer.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The Class DeveloperAssessmentApplication.
 */
@SpringBootApplication
@EnableWebMvc
public class DeveloperAssessmentApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DeveloperAssessmentApplication.class, args);
	}
}
