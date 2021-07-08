package com.meli.desafiospring.service;

import com.meli.desafiospring.domain.Post;
import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.PostDTO;
import com.meli.desafiospring.dto.PromotionalPostDTO;
import com.meli.desafiospring.dto.UserPostDTO;
import com.meli.desafiospring.dto.UserPromotionalPostsDTO;
import com.meli.desafiospring.repository.PostRepository;
import com.meli.desafiospring.utils.SortUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private static final ModelMapper MAPPER = new ModelMapper();
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    public void save(PostDTO postDto) {
        Post post = MAPPER.map(postDto, Post.class);
        post.setUser(userService.findById(postDto.getUserId()));
        postRepository.save(post);
    }

    public void savePromotional(PromotionalPostDTO postDto) {
        Post post = MAPPER.map(postDto, Post.class);
        post.setUser(userService.findById(postDto.getUserId()));
        postRepository.save(post);
    }

    public UserPostDTO getRecentPosts(int id, String order) {
        User user = userService.findById(id);

        List<Integer> following = new ArrayList<>();

        user.getFollowings().forEach(x -> following.add(x.getId()));

        LocalDate dueDate = LocalDate.now().minusDays(14);

        List<Post> posts = postRepository.getPosts(following, dueDate);

        this.sortPosts(posts, order);

        List<PostDTO> postDto = this.convertToPostDto(posts);

        return new UserPostDTO(id, postDto);

    }

    public UserPromotionalPostsDTO getUserPromotionalPosts(int userId) {
        User user = userService.findById(userId);

        List<Post> userPromotionalPosts = postRepository.findPostsByUserAndHasPromoIsTrue(user);

        List<PromotionalPostDTO> promotionalPostsDto = convertToPromotionalPostsDto(userPromotionalPosts);

        return new UserPromotionalPostsDTO(user.getId(), user.getName(), promotionalPostsDto);
    }

    private List<PromotionalPostDTO> convertToPromotionalPostsDto(List<Post> userPromotionalPosts) {
        List<PromotionalPostDTO> postsDto = new ArrayList<>();

        for (Post post : userPromotionalPosts) {
            postsDto.add(MAPPER.map(post, PromotionalPostDTO.class));
        }

        return postsDto;
    }

    private List<PostDTO> convertToPostDto(List<Post> posts) {
        List<PostDTO> dtos = new ArrayList<>();

        for (Post post : posts) {
            dtos.add(MAPPER.map(post, PostDTO.class));
        }

        return dtos;
    }

    private void sortPosts(List<Post> posts, String order) {
        if (order.equals("date_asc"))
            SortUtil.sort(posts);
        else if (order.equals("date_desc"))
            SortUtil.sortDesc(posts);
    }
}
