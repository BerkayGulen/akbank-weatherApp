package com.berkaygulen.akbankweatherApp.user;


import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @PostMapping("/api/v1/users")
    void sendUser(@Valid @RequestBody User body){
        userRepository.save(body);
        log.atInfo().log(body.toString());

    }
    @PostMapping("/api/v1/error")
    ResponseEntity<RestResponse<String>> error(){
        throw new BusinessException(UserErrorMessages.USER_NOT_FOUND);
//        return  ResponseEntity.ok(RestResponse.error("adasd"));


    }
}
