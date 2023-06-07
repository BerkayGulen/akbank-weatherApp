package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
import com.berkaygulen.akbankweatherApp.user.User;
import com.berkaygulen.akbankweatherApp.user.UserEntityService;
import com.berkaygulen.akbankweatherApp.weatherAPI.dto.CityDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class FavouriteCitiesControllerContractImplTest {

    @InjectMocks
    private FavouriteCitiesControllerContractImpl favouriteCitiesControllerContract;
    @Mock
    private FavouriteCitiesEntityService favouriteCitiesEntityService;
    @Mock
    private UserEntityService userEntityService;


    @Test
    void shouldSave() {
        FavouriteCitiesSaveOrDeleteRequestDTO request = Mockito.mock(FavouriteCitiesSaveOrDeleteRequestDTO.class);
        String cityName = "Izmir";
        Long id = 15L;
        User user = Mockito.mock(User.class);
        Optional<User> optionalUser = Optional.of(user);
        List<FavouriteCities> favCityList = new ArrayList<>();

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);
        Mockito.when(request.cityName()).thenReturn(cityName);
        Mockito.when(request.userId()).thenReturn(id);
        Mockito.when(favouriteCitiesEntityService.findFavouriteCitiesByUserId(Mockito.anyLong())).thenReturn(favCityList);

        FavouriteCitiesDTO savedFavCities = favouriteCitiesControllerContract.save(request);

        assertEquals(savedFavCities.cityName(),request.cityName());

    }

    @Test
    void shouldGetAll() {
        String cityName = "Izmir";
        Long id = 15L;
        FavouriteCities city = Mockito.mock(FavouriteCities.class);
        User user = Mockito.mock(User.class);
        Optional<User> optionalUser = Optional.of(user);
        List<FavouriteCities> favCityList = new ArrayList<>();
        favCityList.add(city);

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);
        Mockito.when(favouriteCitiesEntityService.findFavouriteCitiesByUserId(Mockito.anyLong())).thenReturn(favCityList);

        List<FavouriteCitiesDTO> all = favouriteCitiesControllerContract.getAll(Mockito.anyLong());

        assertEquals(1,all.size());

    }

    @Test
    void removeFavouriteCity() {
        FavouriteCitiesSaveOrDeleteRequestDTO request = Mockito.mock(FavouriteCitiesSaveOrDeleteRequestDTO.class);
        String cityName = "Izmir";
        Long id = 15L;
        User user = Mockito.mock(User.class);
        FavouriteCities city = new FavouriteCities();
        city.setCityName(cityName);
        city.setId(id);


        Optional<User> optionalUser = Optional.of(user);
        List<FavouriteCities> favCityList = new ArrayList<>();
        favCityList.add(city);

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);
        Mockito.when(request.cityName()).thenReturn(cityName);
        Mockito.when(request.userId()).thenReturn(id);
        Mockito.when(favouriteCitiesEntityService.findFavouriteCitiesByUserId(Mockito.anyLong())).thenReturn(favCityList);
        Mockito.when(favouriteCitiesEntityService.findByUserIdAndCityName(request)).thenReturn(city);

        Mockito.doNothing().when(favouriteCitiesEntityService).delete((FavouriteCities) Mockito.any());

        favouriteCitiesControllerContract.removeFavouriteCity(request);

    }

}