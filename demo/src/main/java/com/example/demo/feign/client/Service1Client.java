package com.example.demo.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//'service1' is an arbitrary client name, which is used to create a Ribbon or any load balancer. we also can specify a URL using the url attribute (absolute value or just a hostname)
//@FeignClient(name = "${feign.name}", url = "${feign.url}")
//@FeignClient(name = "stores", configuration = FooConfiguration.class)
@FeignClient(value = "service1", url = "localhost:8082")
public interface Service1Client {

    @GetMapping("servicename")
    String serviceName();

    @GetMapping("greeting")
    String greeting();

    @GetMapping("/service1/{userName}")
    String helloUser(@PathVariable("userName") Long userName);

}
