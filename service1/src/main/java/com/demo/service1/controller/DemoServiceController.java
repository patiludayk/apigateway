package com.demo.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoServiceController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/")
    public String rootContext() {
        return "Hello from service1 root context /";
    }

    @GetMapping("servicename")
    public String serviceName() {
        return "serviceName: service1";
    }

    @GetMapping("greeting")
    public String greeting() {
        return "Hello from service1. port: " + applicationContext.getEnvironment().getProperty("server.port");
    }

    @GetMapping("/service1/{userName}")
    public String helloUser(@PathVariable("userName") Long userName) {
        return "Welcome to service1 " + userName;
    }

    @GetMapping("com1")
    public String com1Context() {
        return "Hello from service1 com1 context";
    }
}
