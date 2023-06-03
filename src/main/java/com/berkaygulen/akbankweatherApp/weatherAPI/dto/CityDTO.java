package com.berkaygulen.akbankweatherApp.weatherAPI.dto;

public record CityDTO(
        String name,
        double lat,
        double lon,
        String country
        ) {
}
