package com.platzi.market;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatziMarketApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("PSQL_PASS", dotenv.get("PSQL_PASS"));
		SpringApplication.run(PlatziMarketApplication.class, args);
	}

}
