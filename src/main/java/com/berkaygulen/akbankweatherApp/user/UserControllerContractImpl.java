package com.berkaygulen.akbankweatherApp.user;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserControllerContractImpl implements UserControllerContract{
    private final UserEntityService userEntityService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDTO save(UserSaveRequestDTO userSaveRequestDTO) {
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userEntityService.save(user);
        log.info("User with id: {} saved", user.getId());
        return UserMapper.INSTANCE.convertToUserDTO(user);

    }




}
