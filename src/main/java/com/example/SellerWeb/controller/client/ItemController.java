package com.example.SellerWeb.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.SellerWeb.domain.Product;
import com.example.SellerWeb.service.ProductService;

@Controller
public class ItemController {
    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable("id") long prodId, Model model) {
        Product product = productService.findProductById(prodId);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
}
