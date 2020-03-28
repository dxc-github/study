package com.dxc.pages;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxc.pages.dao")
public class PagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagesApplication.class, args);
	}

}
