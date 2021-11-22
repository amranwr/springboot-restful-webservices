package com.rest.webservices.restfulwebservices.converters;

import com.rest.webservices.restfulwebservices.commands.PostCommand;
import com.rest.webservices.restfulwebservices.models.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostToPostCommand implements Converter<Post, PostCommand> {
    @Override
    public PostCommand convert(Post source) {
        PostCommand postCommand = new PostCommand(source.getId(),source.getDescription());
        return postCommand;
    }
}
