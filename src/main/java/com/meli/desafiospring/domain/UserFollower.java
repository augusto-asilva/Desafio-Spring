package com.meli.desafiospring.domain;

public class UserFollower {

    private int userId;
    private int followingId;

    public UserFollower(int userId, int followingId) {
        this.userId = userId;
        this.followingId = followingId;
    }

    public UserFollower() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowingId() {
        return followingId;
    }

    public void setFollowingId(int followingId) {
        this.followingId = followingId;
    }
}
