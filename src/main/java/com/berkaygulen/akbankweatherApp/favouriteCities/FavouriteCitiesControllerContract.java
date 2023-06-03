package com.berkaygulen.akbankweatherApp.favouriteCities;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;

import java.util.List;

public interface FavouriteCitiesControllerContract  {

    FavouriteCitiesDTO save(FavouriteCitiesSaveOrDeleteRequestDTO favouriteCitiesSaveOrDeleteRequestDTO);
    List<FavouriteCitiesDTO> getAll(Long userId);
    void removeFavouriteCity(FavouriteCitiesSaveOrDeleteRequestDTO favouriteCitiesSaveOrDeleteRequestDTO);

}
