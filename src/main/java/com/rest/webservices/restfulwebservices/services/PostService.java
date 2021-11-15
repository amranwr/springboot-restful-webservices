package com.rest.webservices.restfulwebservices.services;

import com.rest.webservices.restfulwebservices.Exceptions.NotFoundException;
import com.rest.webservices.restfulwebservices.commands.PostCommand;
import com.rest.webservices.restfulwebservices.converters.PostToPostCommand;
import com.rest.webservices.restfulwebservices.models.Post;
import com.rest.webservices.restfulwebservices.models.User;
import com.rest.webservices.restfulwebservices.repositories.PostRepo;
import com.rest.webservices.restfulwebservices.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class PostService {
    private PostRepo postRepo;
    private UserRepo userRepo;
    private PostToPostCommand postToPostCommand;

    public PostService(PostRepo postRepo, UserRepo userRepo, PostToPostCommand postToPostCommand) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.postToPostCommand = postToPostCommand;
    }

    public PostCommand findPostById(Long user_id , Long post_id){
        Optional<User> user = userRepo.findById(user_id);
        if(user.isPresent()) {
            Optional<Post> post = postRepo.findById(post_id);
            if (post.isPresent()) {
                return postToPostCommand.convert(post.get());
            } else {
                throw new NotFoundException("this post is not found id : " + post_id );
            }
        }else{
            throw new NotFoundException("this user is not found id: "+ user_id);
        }
    }

    public Set<PostCommand> findUserPosts(Long userId){
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            Set<PostCommand> postCommands = new HashSet<>();
            for(Post post: user.get().getPosts()){
                postCommands.add(postToPostCommand.convert(post));
            }
            return postCommands;
        }else{
            throw new NotFoundException("user with that id not found : "+ user);
        }
    }

}
