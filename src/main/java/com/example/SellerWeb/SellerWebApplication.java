package com.example.SellerWeb;

import javax.swing.Spring;

import org.apache.el.stream.Optional;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SellerWeb.domain.User;

@SpringBootApplication
public class SellerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerWebApplication.class, args);
		System.out.println("server is running at http:://localhost:8080");

		// -Repository cung cấp cho ta interface để tạo method query đến DB
		// -Java Spring hỗ trợ các keyword để đặt tên method queries(Đọc ở repository
		// keyword's method)
		// +Java tự convert tên method->queries database
		// -Mặc dù extends interface CrudRepository đã có sẵn khá nhiều method đủ
		// dùng,tuy thế ta vẫn có thể tự define method query riêng

		// package com.example.SellerWeb.repository;

		// import java.util.Optional;

		// import org.springframework.data.jpa.repository.JpaRepository;
		// import org.springframework.stereotype.Repository;

		// import com.example.SellerWeb.domain.User;

		// @Repository
		// public interface UserRepository extends JpaRepository<User, Long> {
		// User save(User user);

		// Optional findById(Long id);
		// }

	}
}
