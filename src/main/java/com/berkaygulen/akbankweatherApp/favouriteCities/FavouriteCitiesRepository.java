package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteCitiesRepository extends JpaRepository<FavouriteCities,Long> {

    List<FavouriteCities> findAllByUserId(Long userId);
    FavouriteCities findFavouriteCitiesByUserIdAndCityName(Long userId, String cityName);
}
