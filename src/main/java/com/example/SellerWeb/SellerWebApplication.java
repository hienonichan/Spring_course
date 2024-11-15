package com.example.SellerWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
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

        // 5 Nhắc lại sơ về luồng của Spring security

        // -Spring security cung cấp Filter chain layer và nơi này chứa các layer xác
        // thực.Chuỗi các filter này sẽ làm một loại xác thực riêng như xác thực
        // username password, xác thực HTTP, phân quyền
        // Khi xác thực thành công, Spring security store user thông qua
        // UserDetailService vào trong SpringSecurityContext

        // -Khi ta chọn các filter nào, thì Filter chain layer sẽ mapping sang
        // Authentication Provider để lấy những method cần thiết để xác thực theo hình
        // thức authentication mà ta đang sử dụng sao cho phù hợp(OAuth2,LDAP,...)
        // Spring sẽ check để mapping provider phù hợp thông qua ProviderManager

        // 6 Luồng chạy của UsernameAndPasswordFilter lần lượt (Trừu tượng)
        // - UsernamePasswordAuthenticationFilter : chạy đến filter username password
        // - AuthenticationManager : chạy đến layer AuthenticationManager layer(đây là 1
        // interface và Provider Manager là 1 implement của nó)
        // - ProviderManager : chạy phần này để loop tìm Provider phù hợp
        // - DaoAuthenticationProvider : (là 1 implement default của
        // AuthenticationProvider), nó dùng UserDetailService để tìm user và compare
        // password
        // - InMemoryUserDetailsManager (default nếu không custom phần này)
        // - SecurityContextHolderFilter: Sau khi xác thực thành công thì lưu user vào
        // context
        // - SecurityContext có vai trò giữ phiên authentication trong các lần login sau
        // Về các step cụ thể chi tiết ở trong giáo trình của hỏi dân it

        // VỀ LUỒNG CHẠY cụ thể của filter usernamePassword
        // Login-->DAOAuthenticationProvider(chạy đến restriveUser tìm user theo
        // username,--> additionalAuthenticationCheck để check password---> nếu thành
        // công chạy đến createSuccessAuthentication--> return về đối tượng Success để
        // spring security thực hiện lưu vào Context)

        // 7 Lí do khi enable Spring security lại làm cho việc login không chính xác
        // --> dùng BryptHashPassword mà chưa config khai báo--> spring security compare
        // sai

        // 8 CSRF token là một loại Token trong spring dùng để bảo vệ user khỏi tấn công
        // CSRF (áp dụng với website dùng session), CSRF token thường được tạo ra và gửi
        // kèm page HTML để bảo vệ các request POST,PUT,DELETE
        // -Khi login hoặc logout theo cơ chế của Spring chúng ta đều phải gửi CSRF
        // token theo form

        // 9 Sau AuthenticationFilter thì object Authentication sẽ được store trong
        // Spring Context. Khi đó AuthorizationFilter sẽ lấy Object này để phân quyền.
        // Nếu successs thì tiếp tục request còn không thì reject
        // Chi tiết đọc doc Spring phần Authorization cả về config

        // 10 Cơ chế giữ phiên mặc định của Authentication trong Spring Security sẽ dùng
        // session và session sẽ được lưu trong RAM, sessionID lưu ở cookies client

        // Remember me service là một service khá phổ biến trong ứng dụng web,khi user
        // cấu hình remember me thì khi login thành công server sẽ gửi 1 cookie đã hash
        // với thời gian sống lâu để user có thể truy cập lần sau kể cả khi session hết
        // hạn(chi tiết cài đặt remember me đọc doc spring)
        // Session+remember me giống với access token và refresh token trong OAuth2

        // Do cơ chế default của spring security là lưu trong Object Authentication
        // trong memory, nên khi restart lại app thì nó mất phiên (do resert RAM)
        // Để có thể quản lí store session ở redis hoặc db ta dùng Spring Session
        // Và để có thể giữ phiên đăng nhập lâu dùng cơ chế remember me của Spring
        // Security

        // Túm lại
        // Spring Session: quản lí session hiệu quả trong môi trường phân tán
        // Remember me: cơ chế lưu trữ session lâu hơn , tăng trải nghiệm người dùng

        // 11 Đôi chút về Spring Session
        // - Nếu quản lí session theo cách thông thường, khi tắt trình duyệt hoặc
        // restart
        // server thì dữ liệu session sẽ mất do nó được lưu trong server memory
        // -Hơn nữa do lưu trong memory nên nó không có tính serverless và khó có thể
        // đồng bộ data giữa các server nếu application dùng mô hình multi server

        // Spring session cung cấp cơ chế để store session data trong nhiều môi trường
        // khác nhau như database,redis,... Và khi có request của user nó sẽ lấy data từ
        // db vào memmory để dùng

        // 12 về phần render thông tin user trong jsp, có thể access vào trực tiếp
        // ---Authentication Object trong SpringContext ${not empty
        // pageContext.request.userPrincipal.name}
        // ---Hoặc access lấy thông tin thông qua session attribute ${sessionScope.name}
    }
}
