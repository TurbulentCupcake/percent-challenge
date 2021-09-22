package com.percent.checkoutservice;

import com.percent.checkoutservice.data.ProductPriceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = { "com.percent.checkoutservice" })
@EnableConfigurationProperties
public class CheckoutServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductPriceInfo productPriceInfo;

	public static void main(String[] args) {
		SpringApplication.run(CheckoutServiceApplication.class, args);
	}

	public static void start() {
		SpringApplication.run(CheckoutServiceApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

