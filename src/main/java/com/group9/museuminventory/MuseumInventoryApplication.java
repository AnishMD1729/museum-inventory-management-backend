package com.group9.museuminventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EntityScan(basePackages = {"com.group9.museuminventory.models"})
public class MuseumInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumInventoryApplication.class, args);
	}

}
