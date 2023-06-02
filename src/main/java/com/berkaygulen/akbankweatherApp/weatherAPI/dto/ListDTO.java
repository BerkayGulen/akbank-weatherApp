package com.berkaygulen.akbankweatherApp.weatherAPI.dto;
import java.util.List;


public record ListDTO(
         long dt,
         MainDTO main,
         List<WeatherDTO> weather,
          String dt_txt
){


}