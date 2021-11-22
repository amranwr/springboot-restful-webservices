package com.rest.webservices.restfulwebservices.converters;

import com.rest.webservices.restfulwebservices.commands.PostCommand;
import com.rest.webservices.restfulwebservices.models.Post;
import org.springframework.core.convert.converter.Converter;

public class PostCommandToPost implements Converter<PostCommand, Post> {
    @Override
    public Post convert(PostCommand source) {
        Post post = new Post();
        post.setId(source.getId());
        post.setDescription(source.getDescription());
        return post;
    }
}
