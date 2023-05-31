package com.berkaygulen.akbankweatherApp.user.dto;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String userName,
        String email,
        String password
) {
}
