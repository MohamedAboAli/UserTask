package com.example.logintask;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableJpaRepositories(basePackages = "repository")  
@ComponentScan(basePackages= {"controllers","services"}) 
@EntityScan(value = "model")   
@SpringBootApplication
public class LoginTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginTaskApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	// it is to solve cors policy issue
                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
            }
        };
    }
	
}
