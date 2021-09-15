package com.example.addemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // спринг рулит
@EnableConfigurationProperties // включение конфигурации из.....
@EntityScan(basePackages = {"com"}) //
@EnableJpaRepositories(basePackages = {"com"})
@EnableTransactionManagement
public class AddemployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddemployeeApplication.class, args);
	}

}
