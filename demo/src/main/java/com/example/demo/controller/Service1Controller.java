package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service1Controller {
    @GetMapping("servicename")
    public String serviceName() {
        return "serviceName: demo-service";
    }

    @GetMapping("greeting")
    public String greeting() {
        return "Hello from demo-service.";
    }

    @GetMapping("/demo-service/{userName}")
    public String helloUser(@PathVariable("userName") Long userName) {
        return "Welcome to demo-service " + userName;
    }
}
