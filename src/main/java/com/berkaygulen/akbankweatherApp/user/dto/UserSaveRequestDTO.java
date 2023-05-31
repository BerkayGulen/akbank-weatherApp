package com.berkaygulen.akbankweatherApp.user.dto;

import jakarta.validation.constraints.Email;

public record UserSaveRequestDTO(
        String firstName,
        String lastName,
        String userName,
        @Email
        String email,
        String password
) {
}
