package com.rest.webservices.restfulwebservices.services;

import com.rest.webservices.restfulwebservices.Exceptions.NotFoundException;
import com.rest.webservices.restfulwebservices.commands.UserCommand;
import com.rest.webservices.restfulwebservices.converters.UserToUserCommand;
import com.rest.webservices.restfulwebservices.models.User;
import com.rest.webservices.restfulwebservices.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private UserRepo userRepo;
    private UserToUserCommand userToUserCommand;

    public UserService(UserRepo userRepo, UserToUserCommand userToUserCommand) {
        this.userRepo = userRepo;
        this.userToUserCommand = userToUserCommand;
    }

    public UserCommand findUserById(Long id){
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()){
            return userToUserCommand.convert(userOptional.get());
        }else{
            throw new NotFoundException("the user with that id : "+ id +" is not found !!!!!!");
        }
    }

    public ArrayList<UserCommand> findAllUsers(){
        ArrayList<User> users = (ArrayList<User>) userRepo.findAll();
        ArrayList<UserCommand> userCommands = new ArrayList<>();
        for(User user: users){
            userCommands.add(userToUserCommand.convert(user));
        }
        return userCommands;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }


    public boolean deleteUserById(Long id){
        if(userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
