package com.rest.webservices.restfulwebservices.converters;

import com.rest.webservices.restfulwebservices.commands.UserCommand;
import com.rest.webservices.restfulwebservices.models.User;
import org.springframework.core.convert.converter.Converter;

public class UserCommandToUser implements Converter<UserCommand, User> {
    @Override
    public User convert(UserCommand source) {
        User user  = new User();
        user.setId(source.getId());
        user.setName(source.getName());
        user.setBirthdate(source.getBirthdate());
        return user;
    }
}
