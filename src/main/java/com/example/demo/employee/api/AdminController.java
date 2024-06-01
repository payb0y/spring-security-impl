package com.example.demo.employee.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String hello(Principal principal) {
        return "Hello Admin" + principal.getName();
    }
}
