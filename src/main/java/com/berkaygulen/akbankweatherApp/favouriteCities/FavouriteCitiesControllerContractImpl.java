package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.exceptions.NotFoundException;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavouriteCitiesControllerContractImpl implements FavouriteCitiesControllerContract {

    private final FavouriteCitiesEntityService favouriteCitiesEntityService;
    private final UserEntityService userEntityService;


    @Override
    public FavouriteCitiesDTO save(FavouriteCitiesSaveOrDeleteRequestDTO favouriteCitiesSaveOrDeleteRequestDTO) {
        Long userId = favouriteCitiesSaveOrDeleteRequestDTO.userId();
        String cityName = favouriteCitiesSaveOrDeleteRequestDTO.cityName();
        FavouriteCities favouriteCities = null;

        if (isUserNotExists(userId)) {
            log.error("user: {} not found", userId);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);

        }
        if (isUserHasThisCity(userId, cityName)) {
            log.error("User: {} already has {} on his/her favorites",userId,cityName);
            throw new BusinessException(UserErrorMessages.USER_HAS_THIS_CITY);
        }


        favouriteCities = FavouriteCityMapper.INSTANCE.convertToFavouriteCity(favouriteCitiesSaveOrDeleteRequestDTO);
        favouriteCitiesEntityService.save(favouriteCities);
        log.info("{} successfully added in user: {} favourites",cityName,userId);
        return FavouriteCityMapper.INSTANCE.convertToFavouriteCityDTO(favouriteCities);

    }

    @Override
    public List<FavouriteCitiesDTO> getAll(Long userId) {
        List<FavouriteCities> favouriteCitiesByUserId = null;
        if (isUserNotExists(userId)) {
            log.error("user: {} not found", userId);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }

        favouriteCitiesByUserId = favouriteCitiesEntityService.findFavouriteCitiesByUserId(userId);
        if (favouriteCitiesByUserId.isEmpty()) {
            log.error("user: {} favourites empty so couldn't fetched",userId);
            throw new BusinessException(UserErrorMessages.USER_HAS_NO_FAVOURITES);
        }

        log.info("User favourites successfully fetched: {}",favouriteCitiesByUserId
                .stream()
                .map(FavouriteCities::getCityName)
                .collect(Collectors.toSet()));
        return FavouriteCityMapper.INSTANCE.convertToFavouriteCityDTOList(favouriteCitiesByUserId);

    }


    @Override
    public void removeFavouriteCity(FavouriteCitiesSaveOrDeleteRequestDTO favouriteCitiesSaveOrDeleteRequestDTO) {

        Long userId = favouriteCitiesSaveOrDeleteRequestDTO.userId();
        String cityName = favouriteCitiesSaveOrDeleteRequestDTO.cityName();

        if (isUserNotExists(userId)) {
            log.error("user: {} not found", userId);
            throw new NotFoundException(UserErrorMessages.USER_NOT_FOUND);
        }

        if (!isUserHasThisCity(userId, cityName)) {
            log.error("User: {} doesn't have {} on his/her favourites",userId,cityName);
            throw new BusinessException(UserErrorMessages.USER_HAS_NOT_HAVE_THIS_CITY);
        }

        FavouriteCities byUserIdAndCityName = favouriteCitiesEntityService.findByUserIdAndCityName(favouriteCitiesSaveOrDeleteRequestDTO);
        log.info("{} deleted on User: {} favoutrites",cityName,userId);
        favouriteCitiesEntityService.delete(byUserIdAndCityName);

    }

    private boolean isUserNotExists(Long userId) {
        Optional<User> optionalUser = userEntityService.findById(userId);
        if (optionalUser.isEmpty()) {
            return true;
        }
        return false;
    }


    private boolean isUserHasThisCity(Long userId, String cityName) {
        List<FavouriteCities> favouriteCitiesByUserId = favouriteCitiesEntityService.findFavouriteCitiesByUserId(userId);

        if (!favouriteCitiesByUserId.isEmpty()) {
            boolean hasCity = favouriteCitiesByUserId.stream()
                    .anyMatch(item -> item.getCityName().equals(cityName));
            if (hasCity) {
                return true;
            }
        }
        return false;
    }

}
