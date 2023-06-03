package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.weatherAPI.dto.CityDTO;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.WeatherForecastDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "weatherAPI", url = "http://api.openweathermap.org")
public interface WeatherAPI {

    @GetMapping("/geo/1.0/direct?q={cityName}&limit={limit}&appid={apiKey}")
    List<CityDTO> getGeoCoordinates(@PathVariable String cityName, @PathVariable int limit, @PathVariable String apiKey );

    @GetMapping( "/data/2.5/forecast?lat={lat}&lon={lon}&appid={apiKey}&units=metric")
    WeatherForecastDTO getWeatherForecast(@PathVariable double lat, @PathVariable double lon, @PathVariable String apiKey );

}
