package com.rest.webservices.restfulwebservices.dataloader;

import com.rest.webservices.restfulwebservices.models.Post;
import com.rest.webservices.restfulwebservices.models.User;
import com.rest.webservices.restfulwebservices.repositories.PostRepo;
import com.rest.webservices.restfulwebservices.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    private UserRepo userRepo;
    private PostRepo postRepo;

    public DataLoader(UserRepo userRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello there");
        User user1 = User.builder().id(1L).name("amr").birthdate(LocalDate.now()).build();
        User user2 = User.builder().id(2L).name("anwr").birthdate(LocalDate.now()).build();
        User user3 = User.builder().id(3L).name("mohamed").birthdate(LocalDate.now()).build();
        Post post1 = Post.builder().id(1L).description("i am amr ").user(user1).build();
        Post post2 = Post.builder().id(2L).description("i am amr anwr ").user(user1).build();
        Post post3 = Post.builder().id(3L).description("i am anwr ").user(user2).build();
        Post post4 = Post.builder().id(4L).description("i am anwr mohamed").user(user2).build();
        Post post5 = Post.builder().id(5L).description("i am mohamed ").user(user3).build();
        Post post6 = Post.builder().id(6L).description("i am mohamed abd el glel ").user(user3).build();
        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);
        postRepo.save(post5);
        postRepo.save(post6);
    }
}
