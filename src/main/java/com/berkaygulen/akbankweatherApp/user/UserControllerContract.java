package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;

import java.util.List;

public interface UserControllerContract {

    UserDTO save(UserSaveRequestDTO userSaveRequestDTO);
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    void delete(Long id);
    UserDTO updateCustomer(Long id, UserUpdateRequestDTO userUpdateRequestDTO);

}
