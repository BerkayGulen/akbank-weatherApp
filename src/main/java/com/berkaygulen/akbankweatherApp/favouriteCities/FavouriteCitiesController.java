package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesDTO;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
import com.berkaygulen.akbankweatherApp.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/favourites")
@RequiredArgsConstructor
public class FavouriteCitiesController {
    private final FavouriteCitiesControllerContractImpl contract;

    @PostMapping
    ResponseEntity<RestResponse<FavouriteCitiesDTO>> save(@RequestBody FavouriteCitiesSaveOrDeleteRequestDTO request){

        FavouriteCitiesDTO favouriteCitiesDTO = contract.save(request);

        return ResponseEntity.ok(RestResponse.of(favouriteCitiesDTO));

    }

    @GetMapping("/{userId}")
    ResponseEntity<RestResponse<List<FavouriteCitiesDTO>>> getFavourites(@PathVariable Long userId){

        List<FavouriteCitiesDTO> all = contract.getAll(userId);

        return ResponseEntity.ok(RestResponse.of(all));
    }

    @DeleteMapping("/delete")
    ResponseEntity<RestResponse<Object>> remove (@RequestBody FavouriteCitiesSaveOrDeleteRequestDTO request){

        contract.removeFavouriteCity(request);

        return ResponseEntity.ok(RestResponse.empty());
    }


}
