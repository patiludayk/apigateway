package com.demo.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service1")
public class Service1Controller {

    //@Autowired
    //private ServletWebServerApplicationContext webServerAppCtxt;
    
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/")
    public String greetingFromDemoService() {
        final String port_number = applicationContext.getEnvironment().getProperty("server.port");
        return "Hello from service1 running on port " /*+ webServerAppCtxt.getWebServer().getPort()*/ + "/" + port_number;
    }
}
