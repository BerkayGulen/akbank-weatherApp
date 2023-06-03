package com.berkaygulen.akbankweatherApp.errorMessages;

import com.berkaygulen.akbankweatherApp.general.BaseErrorMessage;

public enum UserErrorMessages implements BaseErrorMessage {
    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists"),
    USER_HAS_NO_FAVOURITES("Users has no favourite cities"),
    USER_HAS_THIS_CITY("Users already has this city on favourite"),
    USER_HAS_NOT_HAVE_THIS_CITY("User has not have this city");



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
