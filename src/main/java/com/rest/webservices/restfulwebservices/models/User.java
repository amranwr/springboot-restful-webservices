package com.rest.webservices.restfulwebservices.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Size(min = 2)
    private String name;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    public User(Long id, String name, LocalDate birthdate, Set<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        if(posts == null){
            this.posts = new HashSet<>();
        }else{
            this.posts = posts;
        }
    }
}
