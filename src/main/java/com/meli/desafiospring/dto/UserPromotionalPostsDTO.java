package com.meli.desafiospring.dto;

import java.util.List;

public class UserPromotionalPostsDTO {
    private Integer userId;
    private String userName;
    List<PromotionalPostDTO> posts;

    public UserPromotionalPostsDTO(Integer userId, String userName, List<PromotionalPostDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public UserPromotionalPostsDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PromotionalPostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PromotionalPostDTO> posts) {
        this.posts = posts;
    }
}
