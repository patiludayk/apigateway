package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PreDestroy;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        System.out.print(String.format("shutting down application in"));
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(String.format(" %d", 5 - i));
        }
    }

}
