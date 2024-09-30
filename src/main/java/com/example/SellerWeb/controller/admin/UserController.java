package com.example.SellerWeb.controller.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.service.UploadService;
import com.example.SellerWeb.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/user/{id}")
    public String getDetailUser(@PathVariable("id") long userId, Model model) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user")
    public String getUser(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String createUserPage(Model model) {
        // Truyền model User để form ánh xạ
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String storeUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult,
            @RequestParam("avatarFile") MultipartFile file) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
        }
        if (bindingResult.hasErrors()) {
            // Nếu validation error không redirect mà hiện alert lỗi
            return "/admin/user/create";
        }
        String fileName = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setAvatar(fileName);
        // khi setter Role như này thì spring sẽ auto chèn id vào role_id
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{Id}/update")
    public String getUpdatePage(@PathVariable("Id") long Id, Model model) {
        User currentUser = this.userService.getUserById(Id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/{Id}/update")
    public String postUpdateUser(@PathVariable("Id") long Id, Model model, @ModelAttribute("newUser") User newUser) {
        User currentUser = this.userService.getUserById(Id);
        currentUser.setName(newUser.getName());
        currentUser.setAddress(newUser.getAddress());
        currentUser.setPhone(newUser.getPhone());
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user/" + Id;
    }

    @GetMapping("/admin/user/{Id}/delete")
    public String getDeleteUserPage(@PathVariable("Id") long Id, Model model) {
        model.addAttribute("Id", Id);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/{Id}/delete")
    public String postDeleteUser(@PathVariable("Id") long Id) {
        this.userService.deleteUserById(Id);
        return "redirect:/admin/user";
    }
}
