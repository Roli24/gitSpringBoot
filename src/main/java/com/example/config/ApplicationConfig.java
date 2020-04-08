package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.example.converters.StringToEnumConverter;

@Configuration

public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    
    
    @Override
    protected void addFormatters(FormatterRegistry registry) {
    	// TODO Auto-generated method stub
    	//super.addFormatters(registry);
    	
    	registry.addConverter(new StringToEnumConverter());
    }
    
    
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    	// TODO Auto-generated method stub
    	configurer.setDefaultTimeout(5000);
    	configurer.setTaskExecutor(mvcTaskExecutor());
    }
    
    @Bean
    public AsyncTaskExecutor mvcTaskExecutor ()
    {
    	ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    	threadPoolTaskExecutor.setThreadNamePrefix("hplusapp-thread-");
    	return threadPoolTaskExecutor;
    	
    }
    
    
    
}
