package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequest;
import com.berkaygulen.akbankweatherApp.errorMessages.AuthenticationErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.UnauthorizedException;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import com.berkaygulen.akbankweatherApp.user.UserMapper;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AuthControllerContractImpl implements AuthControllerContract {
    private final UserEntityService userEntityService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    @Override
    public UserDTO login(LoginRequest loginRequest) {
        if (loginRequest.email()==null ||loginRequest.password()==null){
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }
        User user = userEntityService.findUserEmail(loginRequest.email());
        if (user == null){
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }
        String hashedPassword = user.getPassword();

        if (!passwordEncoder.matches(loginRequest.password(),hashedPassword)){
            throw new UnauthorizedException(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST);
        }

        return UserMapper.INSTANCE.convertToUserDTO(user);



    }
}
