package com.javeriana.web.four.covet19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class Covet19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covet19Application.class, args);
	}

}
