package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDTO customerSaveRequestDTO);

    UserDTO convertToUserDTO(User customer);

    List<UserDTO> convertToUserDTOList(List<User> userList);

    User updateUser(@MappingTarget User user, UserUpdateRequestDTO userUpdateRequestDTO);
}
