package com.berkaygulen.akbankweatherApp.user.dto;

import com.berkaygulen.akbankweatherApp.customAnnotation.UniqueEmail;
import com.berkaygulen.akbankweatherApp.customAnnotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record UserSaveRequestDTO(
        @NotNull
        @NotBlank
        @Size(max =100)
        String firstName,

        @NotNull
        @NotBlank
        @Size(max =100)
        String lastName,

        @NotNull
        @NotBlank
        @UniqueUsername
        @Size(min = 4, max =50)
        String username,

        @Email
        @NotNull
        @UniqueEmail
        @Size(max =50)
        String email,

        @NotNull
        @NotBlank
        @Size(max =400)
        String password
) {
}
