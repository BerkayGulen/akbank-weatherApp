package com.berkaygulen.akbankweatherApp.auth;
import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequest;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthControllerContractImpl authControllerContract;

    @PostMapping("/api/v1/auth")
    ResponseEntity<RestResponse<UserDTO>> login(@RequestBody LoginRequest loginRequest ){

        UserDTO userDTO = authControllerContract.login(loginRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));

    }
}
