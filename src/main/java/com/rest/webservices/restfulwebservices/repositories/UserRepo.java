package com.rest.webservices.restfulwebservices.repositories;

import com.rest.webservices.restfulwebservices.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
