package com.meli.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"userId", "userName", "followers_count"})
public interface FollowerCountDTO {
    Integer getUserId();
    String getUserName();
    @JsonProperty("followers_count")
    Integer getFollowersCount();
}
