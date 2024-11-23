package com.example.SellerWeb.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SellerWeb.domain.CartDetail;
import com.example.SellerWeb.service.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCartPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        List<CartDetail> cartDetails = cartService.getAllCartDetail(session);
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalCartPrice", this.cartService.getTotalSumOfCart(cartDetails));
        return "client/cart/show";
    }

}
