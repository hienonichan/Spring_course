package com.example.SellerWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class SellerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerWebApplication.class, args);
        System.out.println("server is running at http:://localhost:8080");
        // 1 Khi sử dụng default spring security thì nếu dùng form submit mặc định phải
        // thêm token CSRF(cơ chế protect của spring security)

        // 2 Spring data Jpa support cơ chế nạp dữ liệu (Có thể dùng cách nạp này hoặc
        // dùng method Repository bình thường)
        // Ví dụ user có 1 cart thì khi mình getter nó sẽ nạp luôn data cart vào object
        // user

        // có hai kiểu nạp
        // FetchType.LAZY (ManyToMany, ManyToOne):
        // --Cart không được nạp khi bạn tìm User.
        // Thay vào đó, Cart sẽ được nạp khi bạn truy cập vào trường Cart lần đầu tiên
        // (Lazy Loading).
        // Điều này yêu cầu EntityManager hoặc Hibernate Session vẫn phải hoạt động.
        // -- Không nạp ngay là do Collection rất tốn bộ nhớ

        // FetchType.EAGER:(OneToOne, ManyToOne)
        // --Cart được nạp ngay lập tức khi bạn truy vấn User (Eager Loading).
        // Truy vấn SQL sẽ sử dụng JOIN để lấy dữ liệu của cả User và Cart.
        // Có relationship thì getter luôn nó auto join lấy data cho mình
        // -- Nạp ngay vì 1 Object không tốn quá nhiều memmory

        // 3
    }
}
