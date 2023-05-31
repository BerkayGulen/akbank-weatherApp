package com.berkaygulen.akbankweatherApp.general;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericErrorMessage {
    private LocalDateTime errorDate;
    private String message;
    private String detail;
    private Map<String,String> validationErrors;

    public GenericErrorMessage(LocalDateTime errorDate, String message, String detail) {
        this.errorDate = errorDate;
        this.message = message;
        this.detail = detail;
        this.validationErrors =null;
    }
}
