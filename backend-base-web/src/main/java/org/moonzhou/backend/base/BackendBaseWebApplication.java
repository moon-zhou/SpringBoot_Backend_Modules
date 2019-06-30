package org.moonzhou.backend.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("org.moonzhou.backend.base.dao")
public class BackendBaseWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBaseWebApplication.class, args);
	}

}
