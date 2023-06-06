package com.berkaygulen.akbankweatherApp.user;
import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.NotFoundException;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userEntityService.findAll();
        if (userList.isEmpty()){
            log.warn("UserList is empty");
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = null;
        Optional<User> optionalUser = userEntityService.findById(id);
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }else {
            log.warn("User with id: {} not found",id);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optionalUser = userEntityService.findById(id);
        if (optionalUser.isEmpty()){
            log.warn("User with id: {} not found",id);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }

        userEntityService.delete(id);


    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        User user = null;
        Optional<User> optionalUser = userEntityService.findById(id);
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }else {
            log.warn("User with id: {} not found",id);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }

        user = UserMapper.INSTANCE.updateUser(user,userUpdateRequestDTO);
        userEntityService.save(user);

        log.info("User with id: {} updated. New values => {}",id,user.toString());
        return UserMapper.INSTANCE.convertToUserDTO(user);

    }


}
