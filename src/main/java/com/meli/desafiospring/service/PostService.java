package com.meli.desafiospring.service;

import com.meli.desafiospring.domain.Post;
import com.meli.desafiospring.dto.PostDTO;
import com.meli.desafiospring.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private static final ModelMapper MAPPER = new ModelMapper();

    @Autowired
    private UserService userService;

    public void save(PostDTO postDto) {
        Post post = MAPPER.map(postDto, Post.class);
        post.setUser(userService.findById(postDto.getUserId()));
        postRepository.save(post);
    }
}
