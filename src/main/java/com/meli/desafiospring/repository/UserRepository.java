package com.meli.desafiospring.repository;

import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.FollowerCountDTO;
import com.meli.desafiospring.dto.UserFollowersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u.ID as userID, u.NAME  as userName, count(f.FOLLOWING_ID) as followersCount FROM USERS u LEFT JOIN USERFOLLOWER  f on u.ID = f.FOLLOWING_ID where u.id = :id GROUP BY u.name", nativeQuery = true)
    FollowerCountDTO countFollower(int id);


    UserFollowersDTO getUserFollowersById(int id);
}




