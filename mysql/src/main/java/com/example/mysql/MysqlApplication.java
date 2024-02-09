package com.example.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.example.mysql.model"})
@EnableJpaRepositories(basePackages = {"com.example.mysql.dao"})
@ComponentScan(basePackages = {"com.example.mysql.service","com.example.mysql.controller","com.example.mysql.dao"})
public class MysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlApplication.class, args);
	}

}
