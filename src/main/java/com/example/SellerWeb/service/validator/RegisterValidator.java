package com.example.SellerWeb.service.validator;

import org.springframework.stereotype.Service;
import com.example.SellerWeb.domain.dto.RegisterDTO;
import com.example.SellerWeb.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {
    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;
        // Check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            // Nếu confirmPassword khác so với password ban đầu thì tạo message

            // những thông tin context này sẽ được hứng bởi BindingResult và sau đó được
            // handle bên JSP qua form:error
            context.buildConstraintViolationWithTemplate("Confirm password không khớp")
                    // trên property confirmPassword
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }
        // check email is exists or not
        if (checkEmailExists(user.getEmail())) {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại!")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }
        return valid;
    }

    public boolean checkEmailExists(String email) {
        return this.userService.checkEmailExists(email);
    }
}
