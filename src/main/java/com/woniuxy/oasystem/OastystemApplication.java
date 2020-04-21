package com.woniuxy.oasystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.woniuxy.oasystem.dao")
@SpringBootApplication
public class OastystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OastystemApplication.class, args);
	}

}
