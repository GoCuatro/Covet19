package com.javeriana.web.four.covet19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
public class Covet19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covet19Application.class, args);
	}

}
