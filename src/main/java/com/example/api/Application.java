package com.example.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** Main application class for Spring Boot */
// @SpringBootApplication: Represents the combination of following three annotations.
// - @Configuration: Indicates the class has DI (Bean) configurations.
// - @EnableAutoConfiguration: Enables the auto configuration of Beans.
// - @ComponentScan: Tells Spring Boot to look for DI components under the package of this class.
//   Note: Other packages can be scanned by adding a scanBasePackages attribute.
//   ex. @SpringBootApplication(scanBasePackages={"com.example"})
@SpringBootApplication
// @EntityScan：Tells Spring Boot to look for JPA entities under the package of this class.
// Note: Other packages can be scanned by adding a basePackages attribute.
// ex. EntityScan(basePackages={"com.example"})
@EntityScan
// @EnableJpaRepositories: Tells Spring Boot to look for repositories under the package of this class.
// Note: Other packages can be scanned by adding a basePackages attribute.
// ex. @EnableJpaRepositories(basePackages={"com.example"})
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		// Start the Sprint Boot application.
		new Application()
				.configure(new SpringApplicationBuilder(Application.class))
				.run(args);
	}
}