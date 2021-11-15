package com.rest.webservices.restfulwebservices.Exceptions;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private Date timeStamp;
    private String message ;
    private String details;

}
