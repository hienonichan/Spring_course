package com.example.SellerWeb;

import javax.swing.Spring;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerWebApplication.class, args);
		System.out.println("server is running at http:://localhost:8080");
	}

	// 1 Mô hình MVC(Model-View-Controller)
	// -Model: tương tác dữ liệu với DB
	// -View:render views(những phần client nhìn thấy)
	// -Controller:sau khi khớp route, controller xử lí logic bên model,views và trả
	// về response

	// 2. Khái niệm annotation
	// -Annotation có vai trò chú thích cho class,method,attributes
	// -khi sử dụng annotation là kích hoạt code của spring framework để xử lí logic
	// -Đa phần khi code ta dùng các annotation có sẵn trong spring
}
