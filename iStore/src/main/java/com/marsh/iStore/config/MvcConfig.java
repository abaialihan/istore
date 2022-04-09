package com.marsh.iStore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//класс который содержит конфигурацию этого приложения
@Configuration
public class MvcConfig {

    public void addViewConfiguration(ViewControllerRegistry registry){
        registry.addViewController("/login")
                .setViewName("login");
    }
}
