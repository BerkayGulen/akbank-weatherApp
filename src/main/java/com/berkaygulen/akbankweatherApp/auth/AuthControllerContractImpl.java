package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequestDTO;
import com.berkaygulen.akbankweatherApp.errorMessages.AuthenticationErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.UnauthorizedException;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import com.berkaygulen.akbankweatherApp.user.UserMapper;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthControllerContractImpl implements AuthControllerContract {

    private final UserEntityService userEntityService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode("1231234");

    @Override
    public UserDTO login(LoginRequestDTO loginRequestDTO) {
        if (loginRequestDTO.email()==null || loginRequestDTO.password()==null){
            log.warn("Login request rejected. email: {} ", loginRequestDTO.email());
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }
        User user = userEntityService.findUserEmail(loginRequestDTO.email());
        if (user == null){
            log.warn("User with email: {} not found", loginRequestDTO.email());
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }
        String hashedPassword = user.getPassword();

        if (!passwordEncoder.matches(loginRequestDTO.password(),hashedPassword)){
            log.warn("Login request rejected. Password won't match. User: {} with email: {}", user.getId(),user.getEmail());
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }

        log.info("User: {} logged in",user.getId());
        return UserMapper.INSTANCE.convertToUserDTO(user);



    }
}
