package com.example.SellerWeb;

import javax.swing.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellerWebApplication {

	// Spring nói chung là một frameWorks để build java application
	// Tuy nhiên,setup cấu hình Spring truyền thống rất phức tạp

	// Spring boot=spring+boot và vai trò của nó
	// - Làm đơn giản hóa quá trình xây dựng Java app sử dụng Spring framework
	// - Giảm thiểu tối đa quá trình "cấu hình" cho dự án:
	// - đơn giản hóa quá trình cài đặt thư viện, quản lý cấu hình thông qua
	// maven...
	// - cung cấp sẵn server để chạy ứng dụng (embedded HTTP server)
	// (không cần phải cài đặt server riêng lẻ)

	// một Java application gồm các phần
	// - Spring boot,Spring REST,Spring MVC,..

	public static void main(String[] args) {
		SpringApplication.run(SellerWebApplication.class, args);
	}

}
