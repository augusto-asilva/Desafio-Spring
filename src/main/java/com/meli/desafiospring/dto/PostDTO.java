package com.meli.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.meli.desafiospring.domain.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "POSTS")
@JsonPropertyOrder({"id_post", "date", "detail", "category", "price"})
public class PostDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_post")
    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonProperty("detail")
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @JsonIgnore
    private int userId;

    private int category;
    private double price;

    public PostDTO() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
