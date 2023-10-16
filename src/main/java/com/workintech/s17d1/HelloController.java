package com.workintech.s17d1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name}")
    private String name;
    @GetMapping("/hi")
    public String sayHi(){
        return "Hi " + name + "!";
    }
}


