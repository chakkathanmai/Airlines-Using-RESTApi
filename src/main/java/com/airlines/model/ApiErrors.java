package com.airlines.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrors {
    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;
}
