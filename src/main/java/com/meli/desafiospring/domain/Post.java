package com.meli.desafiospring.domain;

import java.time.LocalDateTime;

public class Post {

    private int id;

    private LocalDateTime date;

    private Product product;

    private int userId;

    public Post(int id, LocalDateTime date, Product product, int userId) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.userId = userId;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
