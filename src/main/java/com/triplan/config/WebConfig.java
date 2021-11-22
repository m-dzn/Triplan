package com.triplan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public final String RESOURCES_LOCATION;
    public final String RESOURCES_COMMON_URL;

    public WebConfig(@Value("${app.resources.location}") String RESOURCES_LOCATION,
                     @Value("${app.resources.commonUrl}") String RESOURCES_COMMON_URL) {
        this.RESOURCES_LOCATION = RESOURCES_LOCATION;
        this.RESOURCES_COMMON_URL = RESOURCES_COMMON_URL;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_COMMON_URL + "/**")
                .addResourceLocations("file:///" + RESOURCES_LOCATION + "/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}
