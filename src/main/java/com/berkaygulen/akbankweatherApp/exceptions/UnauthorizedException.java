package com.berkaygulen.akbankweatherApp.exceptions;

import com.berkaygulen.akbankweatherApp.general.BaseErrorMessage;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends BusinessException {
    public UnauthorizedException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
