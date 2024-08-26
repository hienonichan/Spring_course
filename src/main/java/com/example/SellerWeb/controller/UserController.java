package com.example.SellerWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SellerWeb.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    // nạp class userService theo design pattern dependency injection
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Controller chỉ có vai trò điều hướng,logic viết trong service
    @GetMapping("/")
    public String getHomePage(Model model) {
        // -Truyền data vào trong view bằng Model, chúng ta add thuộc tính bằng hàm
        // addAttribute(key,value)
        // -Những cái key-value chúng ta sẽ truy cập được trong view
        model.addAttribute("hello_message", this.userService.handleHello());
        model.addAttribute("footer", "hihi");
        return "client/hello";
    }
}
