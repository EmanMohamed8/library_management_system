package org.example.library_management_system_api.advice;

import org.example.library_management_system_api.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BookNotFoundException> handleBookNotFoundException(BookNotFoundException ex){
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}
