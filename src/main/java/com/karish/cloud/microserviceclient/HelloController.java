package com.karish.cloud.microserviceclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping
    public String hello(){
        String url = "http://HELLO-SERVER/rest/hello/server";
        return restTemplate.getForObject(url,String.class);
    }

    public String fallback(Throwable hystrixCommand) {
        hystrixCommand.printStackTrace();
        return "This is falling back";
    }
}
