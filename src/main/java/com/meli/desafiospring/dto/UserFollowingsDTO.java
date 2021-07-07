package com.meli.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.meli.desafiospring.domain.User;

import java.util.List;

@JsonPropertyOrder({"userId", "userName", "followed"})
public class UserFollowingsDTO {
    @JsonProperty("userId")
    private Integer id;

    @JsonProperty("userName")
    private String name;

    @JsonProperty("followed")
    @JsonIgnoreProperties({"followers", "followings"})
    private List<User> followings;

    public UserFollowingsDTO() {
    }

    public UserFollowingsDTO(Integer id, String name, List<User> following) {
        this.id = id;
        this.name = name;
        this.followings = following;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> following) {
        this.followings = following;
    }
}
