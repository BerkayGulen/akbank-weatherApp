package com.berkaygulen.akbankweatherApp.weatherAPI.dto;


public record WeatherDTO(
        int id,
        String main,
        String description,
        String icon
) {

}
