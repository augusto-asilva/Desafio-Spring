package com.meli.desafiospring.service;

import com.meli.desafiospring.domain.Post;
import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.PostDTO;
import com.meli.desafiospring.dto.UserPostDTO;
import com.meli.desafiospring.repository.PostRepository;
import com.meli.desafiospring.utils.SortUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
