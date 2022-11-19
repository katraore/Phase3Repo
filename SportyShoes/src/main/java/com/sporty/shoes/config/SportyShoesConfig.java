package com.sporty.shoes.config;

import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class SportyShoesConfig extends WebServicesAutoConfiguration  {
	
	
	public void configure(HttpStatus http) throws Exception {
		http.getDeclaringClass();
		
		
		
	}
	

}
