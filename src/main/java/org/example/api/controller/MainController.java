package org.example.api.controller;

import lombok.extern.java.Log;
import org.example.api.dto.MessageDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
@Log
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

    @GetMapping("/register")
    public String register(){ return "register"; }

    @RequestMapping("/guest")
    public void forGuest(){
        log.info("guest");
    }

    @RequestMapping("/manager")
    public void forManager(){
        log.info("manager");
    }

    @RequestMapping("/admin")
    public void forAdmin(){
        log.info("admin");
    }



}
