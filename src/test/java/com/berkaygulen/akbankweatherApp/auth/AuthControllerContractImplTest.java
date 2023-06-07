package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequestDTO;
import com.berkaygulen.akbankweatherApp.errorMessages.AuthenticationErrorMessages;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerContractImplTest {

    @InjectMocks
    private AuthControllerContractImpl authControllerContract;

    @Mock
    private UserEntityService userEntityService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode("1231234");

    @Test
    void shouldLogin() {
        String email = "berkaygulen2@gmail.com";
        String password = "1231234";
        Long id = 15L;

        LoginRequestDTO loginRequestDTO = Mockito.mock(LoginRequestDTO.class);
        User user = new User();
        user.setPassword(hashedPassword);
        user.setId(id);

        Mockito.when(loginRequestDTO.password()).thenReturn(password);
        Mockito.when(loginRequestDTO.email()).thenReturn(email);
        Mockito.when(userEntityService.findUserEmail(Mockito.any())).thenReturn(user);

        UserDTO userDTO = authControllerContract.login(loginRequestDTO);

        assertEquals(id,userDTO.id());

    }
    @Test
    void shouldNotLoginWhenEmailOrPasswordIsNull(){

        LoginRequestDTO loginRequestDTO = Mockito.mock(LoginRequestDTO.class);
        BusinessException businessException = assertThrows(BusinessException.class, () -> authControllerContract.login(loginRequestDTO));
        assertEquals(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST,businessException.getBaseErrorMessage());

    }
    @Test
    void shouldNotLoginWhenEmailIsWrong(){
        LoginRequestDTO loginRequestDTO = Mockito.mock(LoginRequestDTO.class);
        String email = "wrong@gmail.com";
        String password = "1231234";
        Mockito.when(loginRequestDTO.email()).thenReturn(email);
        Mockito.when(loginRequestDTO.password()).thenReturn(password);

        Mockito.when(userEntityService.findUserEmail(Mockito.any())).thenReturn(null);
        BusinessException businessException = assertThrows(BusinessException.class, () -> authControllerContract.login(loginRequestDTO));
        assertEquals(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST,businessException.getBaseErrorMessage());
    }

    @Test
    void shouldNotLoginWhenPasswordWontMatch(){
        String email = "berkaygulen2@gmail.com";
        String password = "123";
        Long id = 15L;

        LoginRequestDTO loginRequestDTO = Mockito.mock(LoginRequestDTO.class);
        User user = new User();
        user.setPassword(hashedPassword);
        user.setId(id);

        Mockito.when(loginRequestDTO.password()).thenReturn(password);
        Mockito.when(loginRequestDTO.email()).thenReturn(email);
        Mockito.when(userEntityService.findUserEmail(Mockito.any())).thenReturn(user);

        BusinessException businessException = assertThrows(BusinessException.class, () -> authControllerContract.login(loginRequestDTO));
        assertEquals(AuthenticationErrorMessages.UNAUTHORIZED_REQUEST,businessException.getBaseErrorMessage());

    }
}