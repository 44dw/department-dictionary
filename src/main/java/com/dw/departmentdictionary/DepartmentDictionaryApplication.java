package com.dw.departmentdictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(considerNestedRepositories = true)
@EntityScan(basePackages = "com.dw.departmentdictionary.domain")
public class DepartmentDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentDictionaryApplication.class, args);
	}

}
