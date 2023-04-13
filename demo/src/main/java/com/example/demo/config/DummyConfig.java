package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Configuration
public class DummyConfig {

    /*@PreDestroy
    public void destroy() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(String.format("shutting down application in %d seconds.", 10 - i));
        }
    }*/
}
