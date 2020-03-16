package com.wordApp.App;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidTextAdvice {
        @ResponseBody
        @ExceptionHandler(InvalidTextException.class)
        @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
        String invalidTextHandler(InvalidTextException ex) {
            return ex.getMessage();
        }
    }
