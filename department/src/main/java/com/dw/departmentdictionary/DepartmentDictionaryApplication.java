package com.dw.departmentdictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.dw")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.dw.departmentdictionary.api.feign", "com.dw.employeedepartmentserver.api.feign"})
@EnableJpaRepositories(considerNestedRepositories = true)
@EntityScan(basePackages = "com.dw.departmentdictionary.domain")
public class DepartmentDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentDictionaryApplication.class, args);
	}

}
