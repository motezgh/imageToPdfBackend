package com.test.insertImageToPDF;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InsertImageToPdf1Application {

	public static void main(String[] args) {
		SpringApplication.run(InsertImageToPdf1Application.class, args);
	}

	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofKilobytes(1024));
        factory.setMaxRequestSize(DataSize.ofKilobytes(1024));
        return factory.createMultipartConfig();
    }

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/uploadImage")
                        .allowedOrigins("http://localhost:4200");
                registry.addMapping("/uploadPDF")
                .allowedOrigins("http://localhost:4200");
                registry.addMapping("/pdf")
                .allowedOrigins("http://localhost:4200");
                registry.addMapping("/insertInfo")
                .allowedOrigins("http://localhost:4200");
                registry.addMapping("/pdfBox")
                .allowedOrigins("http://localhost:4200");
                registry.addMapping("/download")
                .allowedOrigins("http://localhost:4200");
            }
        };
    }
	
	
}
