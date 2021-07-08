package com.meli.desafiospring.dto;

import java.util.List;

public class UserPostDTO {
    private int userId;
    private List<PostDTO> posts;

    public UserPostDTO(int userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public UserPostDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
