package com.color.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.color")
@SpringBootApplication
public class ContentCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCenterApplication.class, args);
	}

}
