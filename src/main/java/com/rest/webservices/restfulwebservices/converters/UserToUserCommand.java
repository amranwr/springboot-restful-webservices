package com.rest.webservices.restfulwebservices.converters;

import com.rest.webservices.restfulwebservices.commands.UserCommand;
import com.rest.webservices.restfulwebservices.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {
    @Override
    public UserCommand convert(User source) {
        UserCommand userCommand = new UserCommand(source.getId(), source.getName(),source.getBirthdate());
        return userCommand;
    }
}
