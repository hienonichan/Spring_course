package com.example.SellerWeb.controller.client;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.domain.dto.RegisterDTO;
import com.example.SellerWeb.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("newRegister", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String postRegisterUser(@ModelAttribute("newRegister") @Valid RegisterDTO userRegister,
            BindingResult bindingResult) {

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
        }
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }
        User user = this.userService.transferRegisterDTOtoUser(userRegister);
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));
        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogicPage() {
        return "client/auth/login";
    }

}
