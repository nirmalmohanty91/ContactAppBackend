package com.cdk.customerdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CustomerService {

  public static void main(String[] args) {
    SpringApplication.run(CustomerService.class, args);
  }
}
