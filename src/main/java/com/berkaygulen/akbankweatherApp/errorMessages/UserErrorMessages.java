package com.berkaygulen.akbankweatherApp.errorMessages;

import com.berkaygulen.akbankweatherApp.general.BaseErrorMessage;

public enum UserErrorMessages implements BaseErrorMessage {
    USER_NOT_FOUND("User not found"), USER_ALREADY_EXISTS("User already exists");


    private String message;
    UserErrorMessages(String message) {
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
