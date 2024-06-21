package com.platzi.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class PlatziMarketApplication {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("Application IP: " + InetAddress.getLocalHost().getHostAddress());
		SpringApplication.run(PlatziMarketApplication.class, args);

	}

}
