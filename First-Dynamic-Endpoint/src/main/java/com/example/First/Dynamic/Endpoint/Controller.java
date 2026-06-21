package com.example.First.Dynamic.Endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello/{name}")
    public String DynamicEndpoint(@PathVariable String name){
        return "Hello "+name;
    }
    // making another endpoint which takes name and also age too
    @GetMapping("/hello/{name}/{age}")
    public String DynamicEndpoint2(@PathVariable String name,@PathVariable int age){
        return "Hello "+name+" , age : "+age;
    }

    @GetMapping("/add/{num1}/{num2}")
    public int addition(@PathVariable int num1,@PathVariable int num2){
        return num1+num2;
    }
}
