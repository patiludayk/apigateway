package com.example.demo.controller;

import com.example.demo.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private CommunicationService commService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = {"/", "demo"})
    public String greetingFromDemoService() {
        return "Hello from Demo Service running on port " + applicationContext.getEnvironment().getProperty("server.port");
    }

    @GetMapping("com")
    public String service1Greeting() {
        return String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>demo service running on port: %s. Calling service1 -->  %s</h1>\n" +
                "\n" +
                "</body>\n" +
                "</html>", applicationContext.getEnvironment().getProperty("server.port"), commService.greeting());
    }
}
