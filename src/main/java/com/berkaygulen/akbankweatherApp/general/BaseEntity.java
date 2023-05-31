package com.berkaygulen.akbankweatherApp.general;

import jakarta.persistence.Embedded;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable,Cloneable, BaseEntityModel {

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
