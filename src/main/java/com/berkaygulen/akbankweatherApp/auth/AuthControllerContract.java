package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequest;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;

public interface AuthControllerContract {
    UserDTO login(LoginRequest loginRequest);

}
