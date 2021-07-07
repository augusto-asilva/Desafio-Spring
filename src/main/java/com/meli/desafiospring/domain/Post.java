package com.meli.desafiospring.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_post")
    private Integer id;

    private LocalDate date;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonProperty("detail")
    private Product product;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;

    public Post(Integer id, LocalDate date, Product product , User user) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.user = user;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
