package com.hanu.mediumclone.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(name = "/")
    public String hello() {
        return "Hello World";
    }
}
