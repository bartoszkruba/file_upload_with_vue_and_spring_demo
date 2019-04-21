package com.comapny.file_upload_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    private static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*.*")
                .addResourceLocations("file:src/main/resources/static/");
    }
}
