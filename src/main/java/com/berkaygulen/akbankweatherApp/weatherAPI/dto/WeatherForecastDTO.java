package com.berkaygulen.akbankweatherApp.weatherAPI.dto;
import java.util.List;


public record WeatherForecastDTO(
         List<ListDTO> list
) {
}
