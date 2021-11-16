package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.commands.PostCommand;
import com.rest.webservices.restfulwebservices.models.Post;
import com.rest.webservices.restfulwebservices.services.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("user/{user_id}/posts")
    public Set<PostCommand> getUserPosts(@PathVariable String user_id){
        return postService.findUserPosts(Long.valueOf(user_id));
    }

    @GetMapping("user/{user_id}/posts/{post_id}")
    public PostCommand getUserSpecificPost(@PathVariable String user_id ,@PathVariable String post_id){
        return postService.findPostById(Long.valueOf(user_id),Long.valueOf(post_id));
    }


}
