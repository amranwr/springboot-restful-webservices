package com.rest.webservices.restfulwebservices.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class UserCommand {
    Long id ;
    String name ;
    LocalDate birthdate;
}
