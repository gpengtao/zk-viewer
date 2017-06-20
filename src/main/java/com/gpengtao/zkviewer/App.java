package com.gpengtao.zkviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by pengtao.geng on 2017/6/7.
 */
@EnableAutoConfiguration
@ComponentScan
public class App {

//    @Bean
//    public ViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/pages/");
//        viewResolver.setSuffix(".ftl");
//        return viewResolver;
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
