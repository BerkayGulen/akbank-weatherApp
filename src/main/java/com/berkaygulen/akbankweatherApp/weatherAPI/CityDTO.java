package com.berkaygulen.akbankweatherApp.weatherAPI;

public record CityDTO(
        String name,
        double lat,
        double lon,
        String country
        ) {
}
