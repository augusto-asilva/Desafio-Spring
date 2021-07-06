package com.meli.desafiospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.desafiospring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
