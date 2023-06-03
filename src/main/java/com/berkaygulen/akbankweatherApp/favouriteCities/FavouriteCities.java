package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "FAVOURITE_CITIES")
public class FavouriteCities extends BaseEntity {
    @Id
    @GeneratedValue(generator = "FavouriteCities", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FavouriteCities",sequenceName = "FAVOURITE_CITIES_ID_SEQ")
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "CITY_NAME", nullable = false)
    private String cityName;

}
