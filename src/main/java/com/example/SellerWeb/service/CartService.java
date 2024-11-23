package com.example.SellerWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SellerWeb.domain.CartDetail;
import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.repository.CartDetailRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public CartService(CartDetailRepository cartDetailRepository, UserService userService) {
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
    }

    public List<CartDetail> getAllCartDetail(HttpSession session) {
        Long userId = (Long) session.getAttribute("id");
        User currentUser = this.userService.getUserById(userId);
        if (currentUser != null) {
            return currentUser.getCart().getCartDetails();
        }
        return null;
    }

    public long getTotalSumOfCart(List<CartDetail> cartDetails) {
        long sum = 0;
        for (CartDetail cartDetail : cartDetails) {
            sum += cartDetail.getProduct().getPrice() * cartDetail.getQuantity();
        }
        return sum;
    }
}
