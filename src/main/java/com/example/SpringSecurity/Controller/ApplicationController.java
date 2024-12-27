package com.example.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {
    @GetMapping("/getmessage")
    public String message(){
        return "welcome to spring security authentication";
    }
    @GetMapping("/home")
    public String homeMessage(){
        return "welcome to home page";
    }
    @GetMapping("/welcome")
    public String welcomMessage(){
        return "welcome to my website your credintails are secured ";
    }
    @GetMapping("/admin")
    public String adminMessage(){
        return "welcome to adminPage ";
    }
    @GetMapping("/student")
    public String studentMessage(){
        return "welcome to student page ";
    }
    @GetMapping("/employe")
    public String employeMessage(){
        return "welcome to Emloye page ";
    }

    //rahul pratice






}
