package com.berkaygulen.akbankweatherApp.favouriteCities;


import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserMapper;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FavouriteCityMapper {


    FavouriteCityMapper INSTANCE = Mappers.getMapper(FavouriteCityMapper.class);

    FavouriteCities convertToFavouriteCity(FavouriteCitiesSaveOrDeleteRequestDTO favouriteCitiesSaveOrDeleteRequestDTO);

    FavouriteCitiesDTO convertToFavouriteCityDTO(FavouriteCities favouriteCities);

    List<FavouriteCitiesDTO> convertToFavouriteCityDTOList(List<FavouriteCities> favouriteCitiesList);

}
