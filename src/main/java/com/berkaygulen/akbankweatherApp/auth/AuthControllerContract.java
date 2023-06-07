package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;

public interface AuthControllerContract {
    UserDTO login(LoginRequestDTO loginRequestDTO);

}
