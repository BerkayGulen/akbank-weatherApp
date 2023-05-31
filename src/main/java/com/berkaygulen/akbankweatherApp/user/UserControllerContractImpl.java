package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract{
    private final UserEntityService userEntityService;
    @Override
    public UserDTO save(UserSaveRequestDTO userSaveRequestDTO) {
        User user = UserMapper.INSTANCE.convertToCustomer(userSaveRequestDTO);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToCustomerDTO(user);
    }
}
