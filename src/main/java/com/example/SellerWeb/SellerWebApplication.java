package com.example.SellerWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SellerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerWebApplication.class, args);
        System.out.println("server is running at http:://localhost:8080");
        // Module Authentication
        // 1 Add template login và register
        // Căn bản thì do đã config path url của css và js từ lúc làm template home page
        // -> giờ chỉ cần copy paste thì các css/js nhúng tự mapping

        // 2 Khái niệm về DTO design pattern(Data transfer object)
        // Đây là một design pattern nhằm để transfer các attribute của object
        // (Do đặc thù các service khác nhau thì có thể thêm/bớt một số attribute nhất
        // định)

        // Ví dụ : với object User trong database sẽ có đầy đủ các attribute
        // username,password,name,role
        // Tuy nhiên phía client render (Lí do bảo mật là chính), người ta không phải
        // lúc nào cũng cần full các attributes(Chỉ cần name,role là đủ render rồi)-->
        // dùng DTO để cắt/gọt

        // DTO có thể khiến chúng ta viết code ít đi nhưng vẫn đảm bảo được service
        // logic. Tuy nhiên áp dụng không đúng cách sẽ làm code khó maintance

        // Để thực hiện pattern này,ta sẽ tạo một object DTO hứng input sau đó mapping
        // sang model trong database(mapping dùng thư viện mapstruct.Tuy nhiên trong
        // khóa học này mapping bằng cơm)

        // 3
        // Nhắc lại sơ qua về Dependency injection và nguyên lí thiết kế số 5 trong
        // SOLID
        // Dependency Inversion là nguyên lý thiết kế số 5 trong SOLID. Nói về việc giảm
        // bớt sự phụ thuộc giữa các module trong application
        // Inversion of Control là tập hợp các design pattern sinh ra để thiết kế nguyên
        // lý này

        // Một số triển khai bao gồm : Dependency Injection,Delegate,Service
        // Locator,Event,...
        // Và Dependency Injection là một trong các triển khai đó

        // 4 Vấn đề Custom validator
        // -Đây là phần khó và trong khóa học đã cung cấp source code validator phần
        // service.
        // -Như trong module trước ta đã tìm hiểu cách validation khi create
        // user,product thông qua annotation @Valid và handleError @BindingResult
        // -Ở đây chúng ta sẽ custom riêng một custom annotation để handle validation
        // cho phần auth
        // -Về cách define 1 custom annotation xem trong code hoặc search trên baedulng
        // Do các custom validator đều implement từ ConstraintValidator nên ta vẫn dùng
        // @Valid và @BindingResult để catch error validation bình thường

        // -Sau khi custom các annotation xong,ta làm bình thường ,hứng BindingResult và
        // dùng form:error in ra lỗi validation

    }
}
