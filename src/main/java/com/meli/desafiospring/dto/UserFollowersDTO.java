package com.meli.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.meli.desafiospring.domain.User;

import javax.persistence.*;
import java.util.List;

@JsonPropertyOrder({"userId", "userName", "followers"})
public class UserFollowersDTO {
    @JsonProperty("userId")
    private Integer id;

    @JsonProperty("userName")
    private String name;

    @JsonIgnoreProperties({"followers", "followings"})
    private List<User> followers;

    public UserFollowersDTO() {
    }

    public UserFollowersDTO(Integer id, String name, List<User> followers) {
        this.id = id;
        this.name = name;
        this.followers = followers;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
