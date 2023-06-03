package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
import com.berkaygulen.akbankweatherApp.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class FavouriteCitiesEntityService extends BaseEntityService<FavouriteCities,FavouriteCitiesRepository> {

    public FavouriteCitiesEntityService(FavouriteCitiesRepository repository) {
        super(repository);
    }

    public List<FavouriteCities> findFavouriteCitiesByUserId(Long userId){
        return getRepository().findAllByUserId(userId);
    }

    public FavouriteCities findByUserIdAndCityName(FavouriteCitiesSaveOrDeleteRequestDTO request){
        return getRepository().findFavouriteCitiesByUserIdAndCityName(request.userId(), request.cityName());
    }
}
