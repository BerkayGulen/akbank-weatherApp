package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;

public interface UserControllerContract {

    UserDTO save(UserSaveRequestDTO userSaveRequestDTO);
}
