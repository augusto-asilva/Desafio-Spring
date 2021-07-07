package com.meli.desafiospring.service;

import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.FollowerCountDTO;
import com.meli.desafiospring.exception.AlreadyFollowingException;
import com.meli.desafiospring.exception.UserNotFoundException;
import com.meli.desafiospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void follow(Integer userId, Integer followingId){
        User user = this.findById(userId);

        User userToFollow = this.findById(followingId);

        user.addFollowing(userToFollow);

        try {
            repository.save(user);
        }catch (DataIntegrityViolationException exception){
            throw new AlreadyFollowingException("Usuario: " + user.getName() + " já segue o vendedor: " + userToFollow.getName());
        }
    }

    public FollowerCountDTO followCount(Integer userId) {
        FollowerCountDTO dto = repository.countFollower(userId);
        if (dto == null) {
            throw new UserNotFoundException("Usuario não encontrado com o id: " + userId);
        }
        return dto;
    }




    private User findById(Integer userId){
        Optional<User> user = repository.findById(userId);

        if (user.isPresent())
            return user.get();

        throw new UserNotFoundException("Usuario não encontrado com o id: " + userId);

    }
}
