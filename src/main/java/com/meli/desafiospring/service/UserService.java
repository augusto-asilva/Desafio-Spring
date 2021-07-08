package com.meli.desafiospring.service;

import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.FollowerCountDTO;
import com.meli.desafiospring.dto.UserFollowersDTO;
import com.meli.desafiospring.dto.UserFollowingsDTO;
import com.meli.desafiospring.exception.AlreadyFollowingException;
import com.meli.desafiospring.exception.UnfollowException;
import com.meli.desafiospring.exception.UserNotFoundException;
import com.meli.desafiospring.repository.UserRepository;
import com.meli.desafiospring.utils.SortUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private static final ModelMapper MAPPER = new ModelMapper();

    public void follow(Integer userId, Integer followingId) {
        User user = this.findById(userId);

        User userToFollow = this.findById(followingId);

        user.addFollowing(userToFollow);

        try {
            repository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AlreadyFollowingException("Usuario: " + user.getName() + " já segue o vendedor: " + userToFollow.getName());
        }
    }

    public void unfollow(Integer userId, Integer unfollowingId) {
        User user = this.findById(userId);
        User userToUnfollow = this.findById(unfollowingId);

        if (!userToUnfollow.removeFollower(user))
            throw new UnfollowException("Não foi possível que " + user.getName() + " deixasse de seguir " + userToUnfollow.getName());

        repository.save(user);
    }

    public FollowerCountDTO followCount(Integer userId) {
        FollowerCountDTO dto = repository.countFollower(userId);
        if (dto == null) {
            throw new UserNotFoundException("Usuario não encontrado com o id: " + userId);
        }
        return dto;
    }

    public User findById(Integer userId) {
        Optional<User> user = repository.findById(userId);

        if (user.isPresent())
            return user.get();

        throw new UserNotFoundException("Usuario não encontrado com o id: " + userId);

    }


    public UserFollowingsDTO getFollowing(Integer userId, String order) {
        User user = this.findById(userId);
        sortUsers(user.getFollowings(), order);
        return MAPPER.map(user, UserFollowingsDTO.class);
    }

    public UserFollowersDTO getFollowers(Integer userId, String order) {
        User user = this.findById(userId);
        sortUsers(user.getFollowers(), order);
        return MAPPER.map(user, UserFollowersDTO.class);
    }



    private void sortUsers(List<User> users, String order){
        if(order.equals("name_asc"))
            SortUtil.sort(users);
        else if (order.equals("name_desc"))
            SortUtil.sortDesc(users);
    }

}
