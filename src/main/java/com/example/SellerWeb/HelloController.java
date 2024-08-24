package com.example.SellerWeb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "hello hien vu";
    }

    @GetMapping("/user")
    public String userPage() {
        return "only user can access this page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "only admin can access this page";
    }

}
