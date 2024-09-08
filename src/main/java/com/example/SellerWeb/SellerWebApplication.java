package com.example.SellerWeb;

import javax.swing.Spring;

import org.apache.el.stream.Optional;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SellerWeb.domain.User;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SellerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerWebApplication.class, args);
        System.out.println("server is running at http:://localhost:8080");
        // 1. Giao diện dashboard,login,register có thể kiếm trên google sau đó bỏ vào
        // project
        // 2.Reuse file jsp bằng thẻ tag <jsp:include> (dùng cho header,footer,sidebar)
        // --Search keyword(reuse file jsp)

        // 3. Cách lưu trữ file phía server
        // -Lưu bằng service cloud cho thuê(S3,cloudflare)
        // -Lưu vào database
        // -Lưu tại ổ cứng/project
        // (Đi làm dùng ftp server)

        // 4.- mapping thuộc tính là object ví dụ Role trong User thì form có
        // path="role.name"
        // -Để submit file thêm enctype="multipart/form-data" vào form

        // 5 Sau khi lấy file image từ form , ta code UploadService để handleSave file
        // -Save hình ảnh ta dùng ByteStream là object FileOutputStream để save(chi tiết
        // trong code)

        // 6.các hình thức lưu trữ data(encode,hash,encrypt)
        // --encode><decode
        // ++encode/decode data từ dạng này sang dạng khác (2 chiều)
        // ++không được dùng để bảo mật
        // ++dùng để nén/giải nén/streaming

        // --Hashing
        // ++băm data thành special String(băm 1 chiều-Không thể decode)
        // ++dùng để lưu information nhạy cảm như password(input nhập password->hash
        // input sau đó compare với hashedPassword đã lưu trong DB để authenication)

        // -Encryption
        // ++encypt/decrypt là mã hóa 2 chiều sử dụng key/password nên an toàn bảo mật
        // hơn so với encode/decode
    }
}
