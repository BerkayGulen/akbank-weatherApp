package com.berkaygulen.akbankweatherApp.user.dto;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String username,
        String email,
        String password
) {
}
