package com.meli.desafiospring.repository;

import com.meli.desafiospring.domain.Post;
import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.UserProductPromotionalDTO;
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

    @Query(value = "SELECT us.ID as USERID, us.NAME as USERNAME, COUNT( pr.ID) as PROMOPRODUCTSCOUNT FROM PRODUCTS pr INNER JOIN POSTS po ON pr.Id = po.product_id " +
            "JOIN USERS us on us.Id = po.user_id where us.Id = :id AND po.HAS_PROMO = true", nativeQuery = true)
    UserProductPromotionalDTO findPostsByUserAndHasPromoIsTrueCount(int id);
}