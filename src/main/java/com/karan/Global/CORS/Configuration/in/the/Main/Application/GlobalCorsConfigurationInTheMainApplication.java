package com.karan.Global.CORS.Configuration.in.the.Main.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GlobalCorsConfigurationInTheMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalCorsConfigurationInTheMainApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Apply CORS to all endpoints
						.allowedOrigins("http://localhost:4200") // Replace with your front-end URL
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true); // Allow sending credentials like cookies
			}
		};
	}
}
//or in your controller you can do this "@CrossOrigin(origins = "http://localhost:4200") replace with your actual front end url