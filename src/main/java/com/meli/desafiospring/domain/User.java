package com.meli.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User implements Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnoreProperties({"followings", "followers"})
    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinTable(
            name = "USERFOLLOWER",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWING_ID"))
    private List<User> followings;

    @JsonIgnoreProperties({"followers", "followings"})
    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinTable(
            name = "USERFOLLOWER",
            joinColumns = @JoinColumn(name = "FOLLOWING_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<User> followers;


    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public void addFollowing(User user) {
        this.followings.add(user);
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

    public List<User> getFollowers() {
        return followers;
    }



    public boolean removeFollower(User userToUnfollow) {
        return this.followers.remove(userToUnfollow);
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}
