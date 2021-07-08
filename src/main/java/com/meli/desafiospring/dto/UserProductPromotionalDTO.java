package com.meli.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface UserProductPromotionalDTO {

    Integer getUserId();

    String getUserName();

    @JsonProperty("promoproducts_count")
    int getPromoProductsCount();
}
