package com.example.SellerWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.repository.UserRepository;
import com.example.SellerWeb.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
        System.out.println(users);
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @GetMapping("/admin/user/create")
    public String createUserPage(Model model) {
        // Truyền model User để form ánh xạ
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String storeUser(@ModelAttribute("newUser") User user, @RequestParam("email") String email) {
        // Annotation @ModelAttrinute để mapping object và form submit . nó sẽ ánh xạ
        // object với các attributes từ form

        // Lưu ý về @ModelAttribute Annotation : là cách chúng ta convert dữ liệu từ
        // View trả cho controller xử lý

        // @RequestParams có thể lấy data một Attribute từ form,hoặc từ dynamic url

        // Có thể code form bình thường hoặc form JSTL (ModelAttribute đều hỗ trợ)
        // Tuy nhiên nếu form bằng JSTL ta phải truyền object vào view để nó ánh xạ

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
    public String getDeleteUserPage(@PathVariable("Id") long Id) {
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/{Id}/delete")
    public String postDeleteUser(@PathVariable("Id") long Id) {
        this.userService.deleteUserById(Id);
        return "redirect:/admin/user";
    }
}
