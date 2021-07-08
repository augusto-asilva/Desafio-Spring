package com.meli.desafiospring.repository;

import com.meli.desafiospring.domain.Post;
import com.meli.desafiospring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    @Query(value = "SELECT * FROM POSTS WHERE USER_ID IN (:usersId) AND DATE > :currentDate", nativeQuery = true)
    List<Post> getPosts(List<Integer> usersId, LocalDate currentDate);

    List<Post> findPostsByUserAndHasPromoIsTrue(User user);
}
