package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.weatherAPI.dto.CityDTO;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.WeatherForecastDTO;

import java.util.List;

public interface WeatherApiControllerContract {

    List<CityDTO> getGeoCoordinates(String cityName);

    WeatherForecastDTO getWeatherForecast(String cityName);
}
