package com.berkaygulen.akbankweatherApp.auth.dto;

public record LoginRequestDTO(
        String email,
        String password
) {
}
