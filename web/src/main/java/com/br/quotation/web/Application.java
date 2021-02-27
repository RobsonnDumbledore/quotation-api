package com.br.quotation.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

/**
 *
 * @author Robson
 */
@Configuration
@EnableAutoConfiguration
@EnableJdbcRepositories(basePackages = "com.br.quotation.repositories")
@ComponentScan(basePackages={"com.br.quotation"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
