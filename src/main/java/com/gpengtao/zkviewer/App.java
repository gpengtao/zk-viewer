package com.gpengtao.zkviewer;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by pengtao.geng on 2017/6/7.
 */
@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        DefaultApplicationArguments arguments = new DefaultApplicationArguments(args);
        boolean has = arguments.containsOption("zkAddress");
        if (!has) {
            throw new RuntimeException("Need command line param zkAddress, for example: --zkAddress=10.0.0.1:2181");
        }

        List<String> port = arguments.getOptionValues("server.port");
        if (port == null || port.isEmpty()) {
            System.setProperty("server.port", "8080");
        } else {
            System.setProperty("server.port", port.get(0));
        }

        SpringApplication.run(App.class, args);
    }
}
