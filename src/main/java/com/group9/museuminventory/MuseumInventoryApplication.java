package com.group9.museuminventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"com.group9.museuminventory.models"})
public class MuseumInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumInventoryApplication.class, args);
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("http://localhost:3000", "http://ec2-35-92-179-216.us-west-2.compute.amazonaws.com")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.allowCredentials(true);
		}
	}
}
