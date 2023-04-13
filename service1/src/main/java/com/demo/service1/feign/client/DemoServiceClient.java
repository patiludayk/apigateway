package com.demo.service1.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//'demo-service' is an arbitrary client name, which is used to create a Ribbon or any load balancer. we also can specify a URL using the url attribute (absolute value or just a hostname)
//@FeignClient(name = "${feign.name}", url = "${feign.url}")
//@FeignClient(name = "stores", configuration = FooConfiguration.class)
@FeignClient("demo-service")
public interface DemoServiceClient {

    @GetMapping("servicename")
    String serviceName();

    @GetMapping("greeting")
    String greeting();

    @GetMapping("/demo-service/{userName}")
    String helloUser(@PathVariable("userName") Long userName);

}
