package com.example.SellerWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.repository.UserRepository;
import com.example.SellerWeb.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String getUser(Model model) {
        List<User> users = this.userService.getAllUser();
        System.out.println(users);
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
    public String createUserPage(Model model) {
        // Truyền model User để form ánh xạ
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
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
}
