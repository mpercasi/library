package com.example.library;

import com.example.library.configuration.DataSourceConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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
		DataSourceConfig devDatasourceConfig = ctx.getBean(DataSourceConfig.class);

		devDatasourceConfig.setup();

	}
}
