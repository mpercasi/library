package com.example.library;

import com.example.library.configuration.DataSourceConfig;
import com.example.library.service.SystemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			activeProfile(ctx);
		};
	}

	public void activeProfile(ApplicationContext ctx){
		DataSourceConfig s = ctx.getBean(DataSourceConfig.class);
		s.setup();
	}
}
