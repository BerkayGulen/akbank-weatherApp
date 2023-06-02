package com.berkaygulen.akbankweatherApp.weatherAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public record ForecastDTO(
        Map<String, Object> list,
       LinkedHashMap<String,Object> city



) {
}
