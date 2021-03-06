package com.wordApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST,
        reason="Content is empty, try submit with content ex. {content : 'this is a text'}.")
public class ContentEmptyException extends RuntimeException{
}
