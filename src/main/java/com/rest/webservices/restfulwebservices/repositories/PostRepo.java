package com.rest.webservices.restfulwebservices.repositories;

import com.rest.webservices.restfulwebservices.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Long> {
}
