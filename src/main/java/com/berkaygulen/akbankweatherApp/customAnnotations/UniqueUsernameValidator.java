package com.berkaygulen.akbankweatherApp.customAnnotations;

import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    private final UserEntityService userEntityService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        User user = userEntityService.findUserUsername(username);
        if (user == null){
            return true;
        }
        return false;
    }
}
