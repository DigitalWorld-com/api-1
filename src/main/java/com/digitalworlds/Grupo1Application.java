package com.digitalworlds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class Grupo1Application{

	public static void main(String[] args) {
		SpringApplication.run(Grupo1Application.class, args);
	}

}
