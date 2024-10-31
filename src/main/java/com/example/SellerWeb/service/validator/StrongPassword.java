package com.example.SellerWeb.service.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Constraint là việc chúng ta define class nào sẽ handle logic sau annotation
@Constraint(validatedBy = StrongPasswordValidator.class)
// Phạm vi annotation có thể áp dụng trên các Method và Field
@Target({ ElementType.METHOD, ElementType.FIELD })
// Quy định annotation chỉ avaiable trong run-time
@Retention(RetentionPolicy.RUNTIME)
// define rằng annotation sẽ được add vào javadoc
@Documented
public @interface StrongPassword {
    // Đây là error message khi validate thất bại
    String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
