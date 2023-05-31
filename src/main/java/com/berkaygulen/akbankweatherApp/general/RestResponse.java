package com.berkaygulen.akbankweatherApp.general;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse <T> implements Serializable {
    private T data;
//    private LocalDateTime localDateTime;
    private boolean isSuccess;
//    private String message;


//    public RestResponse(T data, boolean isSuccess) {
//        this.data = data;
//        this.isSuccess = isSuccess;
////        this.localDateTime = LocalDateTime.now();
//    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t,true);
    }

    public static <T> RestResponse<T> empty (){
        return new RestResponse<>(null,true);
    }

    public static <T> RestResponse<T> error (T t){
        return new RestResponse<>(t,false);
    }



//    public void setMessage(String message) {
//        this.message = message;
//    }
}
