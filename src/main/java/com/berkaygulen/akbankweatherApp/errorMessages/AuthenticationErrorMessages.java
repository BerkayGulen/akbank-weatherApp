package com.berkaygulen.akbankweatherApp.errorMessages;

import com.berkaygulen.akbankweatherApp.general.BaseErrorMessage;

public enum AuthenticationErrorMessages implements BaseErrorMessage {

    UNAUTHORIZED_REQUEST("Unauthorized request");


    private String message;
    AuthenticationErrorMessages(String message) {
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
