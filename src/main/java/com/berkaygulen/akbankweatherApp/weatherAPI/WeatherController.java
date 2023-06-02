package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.errorMessages.WeatherApiErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.NotFoundException;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.WeatherForecastDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/weather")
@CrossOrigin
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherAPI weatherClient;
    @Value("${apiKey}")
    private String apikey;

    @GetMapping("/geoCoordinates")
    public void getGeoCoordinates() {
        List<CityDTO> izmir = weatherClient.getGeoCoordinates("Izmir", 2, apikey);
        System.out.println(izmir);
    }

    @GetMapping("/forecast/{cityName}")
    public ResponseEntity<RestResponse<WeatherForecastDTO>> getWeatherForecast(@PathVariable String cityName) {
        List<CityDTO> cityDTOList = weatherClient.getGeoCoordinates(cityName, 1, apikey);

        if (cityDTOList.size() > 0) {
            String name = cityDTOList.get(0).name();
            if (!cityName.equalsIgnoreCase(name)) {
                throw new NotFoundException(WeatherApiErrorMessages.CITY_NOT_FOUND);
            }
        } else {
            throw new NotFoundException(WeatherApiErrorMessages.CITY_NOT_FOUND);

        }
        CityDTO cityDTO = cityDTOList.get(0);
        WeatherForecastDTO weatherForecastDTO = weatherClient.getWeatherForecast(cityDTO.lat(), cityDTO.lon(), apikey);

        log.atInfo().log(weatherForecastDTO.toString());
        return ResponseEntity.ok(RestResponse.of(weatherForecastDTO));
    }


}
