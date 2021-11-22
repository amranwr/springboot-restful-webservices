package com.rest.webservices.restfulwebservices.commands;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserCommand {
    Long id ;
    @Size(min = 2)

    String name ;
    @Past
     LocalDate birthdate;
}
