package com.berkaygulen.akbankweatherApp.weatherAPI.dto;

import lombok.Data;

import java.util.List;


record MainDTO(
         double temp,
         double feels_like,
         double temp_min,
         double temp_max,
         int pressure,
         int sea_level,
         int grnd_level,
         int humidity,
         double temp_kf
) {

}


