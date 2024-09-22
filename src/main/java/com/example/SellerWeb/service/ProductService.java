package com.example.SellerWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SellerWeb.domain.Product;
import com.example.SellerWeb.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void handleSaveProduct(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }

    public Product findProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }
}
