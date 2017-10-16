package com.capcom.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication(scanBasePackages="com.capcom.monitoring,com.capcom.monitoring.web,com.capcom.monitoring.service,com.capcom.monitoring.dao")
public class Application extends SpringBootServletInitializer{	
	
	
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/
	
		
    public static void main(String[] args) {
    	//SpringApplication.run(Application.class, args);
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setWebEnvironment(true);
    	//app.addListeners();
    	app.run(args);
    }

}