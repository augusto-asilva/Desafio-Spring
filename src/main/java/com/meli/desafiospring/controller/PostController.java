package com.meli.desafiospring.controller;

import com.meli.desafiospring.dto.PostDTO;
import com.meli.desafiospring.dto.PromotionalPostDTO;
import com.meli.desafiospring.dto.UserPostDTO;
import com.meli.desafiospring.repository.PostRepository;
import com.meli.desafiospring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/newpost")
    @ResponseStatus(value = HttpStatus.OK)
    public void newPost(@RequestBody PostDTO postDto) {
        postService.save(postDto);
    }

    @GetMapping("/followed/{userId}/list")
    @ResponseStatus(value = HttpStatus.OK)
    public UserPostDTO getRecentPosts(@PathVariable int userId, @RequestParam(defaultValue = "") String order) {
        return postService.getRecentPosts(userId, order);
    }

    @PostMapping("/newpromopost")
    @ResponseStatus(value = HttpStatus.OK)
    public void newPost(@RequestBody PromotionalPostDTO postDto) {
        postService.savePromotional(postDto);
    }


}
