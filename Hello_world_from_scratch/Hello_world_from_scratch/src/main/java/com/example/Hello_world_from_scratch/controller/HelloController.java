package com.example.Hello_world_from_scratch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello1() {// @GetMapping helps to run this method when someone visits When someone visits:localhost:8080/hello

        return "Hello";

    }
    @GetMapping("/world")
    public String hello2() {
// @GetMapping helps to run this method when someone visits When someone visits:localhost:8080/world
        return "World";

    }
}