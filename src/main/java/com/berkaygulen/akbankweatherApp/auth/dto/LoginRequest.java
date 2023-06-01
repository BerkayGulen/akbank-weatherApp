package com.berkaygulen.akbankweatherApp.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        String email,
        String password
) {
}
