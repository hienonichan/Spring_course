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

		// 6 View-engine trong java dùng JSP, nhưng ta dùng thêm JSTL
		// -JSP:nhúng code java trực tiếp vào view,tuy nhiên viết code chay rất dài
		// -JSTL:hỗ trợ các thẻ tag nhanh gọn hơn, như duyệt vòng lặp ,if else
		// Add JSTL vào file HTML/CSS trong giáo trình hoidanit
		// LƯU Ý: Nên dùng JSP thuần vì nhúng code java sẽ tường minh và dễ hơn

		// 7 Setup static file để truy cập chúng trong url.(dùng dể link css)
		// về phần resources và view-engine trong folder webapp
	}
}
