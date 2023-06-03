package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.errorMessages.WeatherApiErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.NotFoundException;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.CityDTO;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.WeatherForecastDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherApiControllerContractImpl implements WeatherApiControllerContract{

    private final WeatherAPI weatherClient;

    @Value("${apiKey}")
    private String apikey;



    @Override
    public List<CityDTO> getGeoCoordinates(String cityName) {
        return weatherClient.getGeoCoordinates(cityName,1,apikey);
    }

    @Override
    public WeatherForecastDTO getWeatherForecast(String cityName) {
        List<CityDTO> cityDTOList = getGeoCoordinates(cityName);

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
        if (weatherForecastDTO == null){
            throw new NotFoundException(WeatherApiErrorMessages.CITY_NOT_FOUND);

        }
        return weatherForecastDTO;

    }
}
