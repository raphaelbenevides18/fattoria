package br.com.rlb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages="br.com.rlb.entity")
@EnableJpaRepositories(basePackages="br.com.rlb.repository")
@ComponentScan(basePackages="br.com.rlb.controller")
@SpringBootApplication
public class Application {
	
public static void main(String[] args) {
	
	SpringApplication.run(Application.class, args);
}

}
