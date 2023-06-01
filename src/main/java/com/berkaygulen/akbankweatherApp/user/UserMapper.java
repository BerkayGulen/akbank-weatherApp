package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
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

//    List<UserDTO> convertToCustomerDTOList(List<User> customerList);

//    Customer updateCustomer(@MappingTarget Customer customer, CustomerUpdateRequestDto customerUpdateRequestDto);
}
