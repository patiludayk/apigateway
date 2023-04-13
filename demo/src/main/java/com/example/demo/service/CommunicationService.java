package com.example.demo.service;

import com.example.demo.feign.client.Service1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService {

    @Autowired
    private Service1Client service1Client;


    public String greeting() {
        return service1Client.greeting();
    }
}
