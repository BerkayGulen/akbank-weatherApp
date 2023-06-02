package com.berkaygulen.akbankweatherApp.errorMessages;

import com.berkaygulen.akbankweatherApp.general.BaseErrorMessage;

public enum WeatherApiErrorMessages implements BaseErrorMessage {
    CITY_NOT_FOUND("City not found");


    private String message;
    WeatherApiErrorMessages(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
