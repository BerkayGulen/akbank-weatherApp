package com.berkaygulen.akbankweatherApp.customAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

@Constraint(
        validatedBy = {UniqueUsernameValidator.class}
)
public @interface UniqueUsername {
    String message() default "Username must be Unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
