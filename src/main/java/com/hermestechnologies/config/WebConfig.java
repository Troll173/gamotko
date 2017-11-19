package com.hermestechnologies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.hermestechnologies")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");

        registry
                .addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/fonts/");

        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");

        registry
                .addResourceHandler("/img/**")
                .addResourceLocations("classpath:/img/");

        registry
                .addResourceHandler("/vendor/**")
                .addResourceLocations("classpath:/vendor/");
    }

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}

