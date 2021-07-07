package com.meli.desafiospring.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.List;


public interface UserFollowersDTO {
    @Column(name = "NAME")
    String getUserName();

    Integer getUserId();

    @JoinTable(
            name = "USERFOLLOWER",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWING_ID"))
    List<UserFollowersDTO> getFollowers();
}
