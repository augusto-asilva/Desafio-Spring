package com.meli.desafiospring.dto;


import javax.persistence.Column;

public interface UserBasicInformationDTO {
    @Column(name = "NAME")
    String getUserName();
    Integer getUserId();
}
