package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract{
    private final UserEntityService userEntityService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDTO save(UserSaveRequestDTO userSaveRequestDTO) {
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
