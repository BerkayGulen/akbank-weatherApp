package com.berkaygulen.akbankweatherApp.user;


import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserControllerContractImpl userControllerContract;


    @PostMapping("/api/v1/users")
    ResponseEntity<RestResponse<UserDTO>> sendUser( @Valid @RequestBody UserSaveRequestDTO userSaveRequestDTO){
        UserDTO userDTO = userControllerContract.save(userSaveRequestDTO);
        log.atInfo().log(userDTO.toString());
        return ResponseEntity.ok(RestResponse.of(userDTO));

    }
    @PostMapping("/api/v1/error")
    ResponseEntity<RestResponse<String>> error(){
        throw new BusinessException(UserErrorMessages.USER_NOT_FOUND);
//        return  ResponseEntity.ok(RestResponse.error("adasd"));


    }
}
