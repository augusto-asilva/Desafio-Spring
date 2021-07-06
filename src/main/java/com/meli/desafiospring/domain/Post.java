package com.meli.desafiospring.domain;

import java.time.LocalDateTime;

public class Post {

    private Integer id;

    private LocalDateTime date;

    private Product product;

    private Integer userId;

    public Post(Integer id, LocalDateTime date, Product product, Integer userId) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.userId = userId;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
