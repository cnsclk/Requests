package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        String s= "hello " + user.getName() + " you are "+ user.getAge() + " years old.";
        return s;
    }
}

