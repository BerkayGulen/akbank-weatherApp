package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.errorMessages.WeatherApiErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.NotFoundException;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.CityDTO;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.WeatherForecastDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/weather")
@CrossOrigin
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiControllerContract weatherApiControllerContract;


    @GetMapping("/forecast/{cityName}")
    public ResponseEntity<RestResponse<WeatherForecastDTO>> getWeatherForecast(@PathVariable String cityName) {

        WeatherForecastDTO weatherForecastDTO = weatherApiControllerContract.getWeatherForecast(cityName);

        return ResponseEntity.ok(RestResponse.of(weatherForecastDTO));
    }


}
