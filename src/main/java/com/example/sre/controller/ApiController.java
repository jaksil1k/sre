package com.example.sre.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ApiController {

    @GetMapping ("/greet/{name}")
    public ResponseEntity<String> greetUser(@PathVariable String name) {
        String res = "Hello " + name;
        return ResponseEntity.ok(res);
    }

    @GetMapping("/")
    public String getDateTime() {
        return "Server Time: " + new Date();
    }
}
