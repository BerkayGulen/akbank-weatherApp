package com.berkaygulen.akbankweatherApp.user;


import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserControllerContractImpl userControllerContract;


    @PostMapping
    ResponseEntity<RestResponse<UserDTO>> save( @Valid @RequestBody UserSaveRequestDTO userSaveRequestDTO){
        UserDTO userDTO = userControllerContract.save(userSaveRequestDTO);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping
    ResponseEntity<RestResponse<List<UserDTO>>> findAll(){
        List<UserDTO> userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id){
        UserDTO userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        userControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    ResponseEntity<RestResponse<UserDTO>> update(@PathVariable Long id,@Valid @RequestBody UserUpdateRequestDTO request){

        UserDTO userDTO = userControllerContract.updateUser(id, request);
        return ResponseEntity.ok(RestResponse.of(userDTO));

    }



}
