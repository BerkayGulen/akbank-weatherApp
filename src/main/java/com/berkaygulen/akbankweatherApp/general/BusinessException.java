package com.berkaygulen.akbankweatherApp.general;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{
    private final BaseErrorMessage baseErrorMessage;
}
