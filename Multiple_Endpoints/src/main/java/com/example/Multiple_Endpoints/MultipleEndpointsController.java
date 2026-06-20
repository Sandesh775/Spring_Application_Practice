package com.example.Multiple_Endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// One controller can handle multiple routes.
@RestController
public class MultipleEndpointsController {
    @GetMapping("/goodmorning")
    public String endpoint1(){
        return "Good Morning";
    }

    @GetMapping("/goodafternoon")
    public String endpoint2(){
        return "Good Afternoon";
    }

    @GetMapping("/goodnight")
    public String endpoint3(){
        return "Good Night";
    }

    @GetMapping("/about")
    public String endpoint4(){
        return "Name : Sandesh\nLearning : SpringBoot";
    }

    @GetMapping("/books")
    public String endpoint5(){
        return "Atomic Habits\n" +
                "Bhagavad Gita\n" +
                "The Alchemist";
    }

    @GetMapping("/quote")
    public String endpoint6(){
        return "Quote of the day : Fuck you bitch just go to sleep now !";
    }
}
