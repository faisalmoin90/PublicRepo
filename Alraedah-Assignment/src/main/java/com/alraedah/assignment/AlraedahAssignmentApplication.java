package com.alraedah.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author FaisalMOI
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.alraedah")
public class AlraedahAssignmentApplication implements WebMvcConfigurer {


	public static void main(String[] args) {
		SpringApplication.run(AlraedahAssignmentApplication.class);
	}



	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
