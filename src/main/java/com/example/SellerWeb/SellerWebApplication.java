package com.example.SellerWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SellerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerWebApplication.class, args);
        System.out.println("server is running at http:://localhost:8080");
        // 2 Template front-end kiếm trên mạng rồi ghép vào project nhàn hơn tự code =))
        // Module product làm tương tự với Module User từ CRUD đến lưu image ảnh

        // 3.Validate Form input
        // --Hạn chế rác dữ liệu trước khi lưu vào DB
        // --Chúng ta có thể validate data ở backend hoặc front-end
        // ++front-end:Dùng js,htms để validate(tiềm ẩn rủi ro vì có thể bị troll từ
        // phía brower-chúng ta chỉ nên validate tại front-end nếu data thực sự không
        // cần bảo mật)
        // ++backend:dùng java để validate(Bảo mật hơn rất nhiều)

        // 4.Trong spring có 2 cách validate dữ liệu phía backend
        // -Cách 1:thông qua jakarta.validation
        // -Cách 2:thông qua hibernate validator

        // 5.Trong dự án này ta dùng luôn Dependency
        // -<spring-boot-starter-validation> trong Spring Boot bao gồm Jakarta
        // Validation (trước đây là Bean Validation) và một implementation mặc định là
        // Hibernate Validator.
        // - Khi bạn thêm dependency này vào dự án của bạn, Spring Boot sẽ tự
        // động cấu hình Jakarta Validation với Hibernate Validator.
        // -Validate dùng annotation @Valid và bindingResultv,bindingResult đặt ngay sau
        // Valid object

        // 6 Nên hạn chế đặt Bean Name trùng nhau, vì Spring Containner không biết đâu
        // là Bean nào
        // Default Spring Container lấy name class làm Bean name

        // 7 Những CRUD qua JpaRepository là của spring Jpa, nó hỗ trợ 1 vài thao tác
        // CRUD bằng cách gọi qua hibernate chứ ta chưa thực sự làm việc với hibernate

        // 8 Form input của spring MVC support render error khi validation thông qua tag
        // <form:errors> (form errors này tự check nếu có lỗi , nó sẽ render một tag
        // span chứa message chúng ta custom)

        // 9 Về việc render HTML số double bị lỗi E^ thì chúng ta có thể search google
        // để fix
        // https://stackoverflow.com/questions/51198011/how-to-prevent-e-when-displaying-double-number-in-jsp

    }
}
