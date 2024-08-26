package com.example.SellerWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SellerWeb.domain.User;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
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
        System.out.println(user.toString());
        System.out.println(email);
        return "admin/user/create";
    }
}
