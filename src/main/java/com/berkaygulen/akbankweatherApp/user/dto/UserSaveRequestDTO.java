package com.berkaygulen.akbankweatherApp.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record UserSaveRequestDTO(
        @NotNull
        @NotBlank
        String firstName,
        @NotNull
        @NotBlank
        String lastName,
        @NotNull
        @NotBlank
        String username,
        @Email
        @NotNull
        String email,
        @NotNull
        @NotBlank
        String password
) {
}
