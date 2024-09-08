package com.example.SellerWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
    // config Bean PasswordEncoder
    // Override interface PasswordEncoder để mã hóa
    // -Không dùng trực tiếp object BcryptPasswordEncoder , phải cấu hình Bean sđể
    // spring security quản lí depedency injection tự động tiêm vào trong Bean
    // Controller
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
