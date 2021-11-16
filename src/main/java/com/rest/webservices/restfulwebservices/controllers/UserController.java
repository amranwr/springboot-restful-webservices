package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.Exceptions.NotFoundException;
import com.rest.webservices.restfulwebservices.commands.UserCommand;
import com.rest.webservices.restfulwebservices.models.User;
import com.rest.webservices.restfulwebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user/{user_id}")
    public UserCommand getUser(@PathVariable String user_id){
        return userService.findUserById(Long.valueOf(user_id));
    }

    @GetMapping("user")
    public ArrayList<UserCommand> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("user/{user_id}/delete")
    public void deleteUser(@PathVariable String user_id){
        if(!userService.deleteUserById(Long.valueOf(user_id)))
            throw new NotFoundException("this user : "+ user_id +" is not found !");
    }
    @PostMapping("user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserCommand userCommand , HttpServletResponse res) {
        User user = User.builder().name(userCommand.getName()).birthdate(userCommand
                .getBirthdate()).build();
        System.out.println("helloooooooooo");
        User user1 = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(location).build();
    }
}
