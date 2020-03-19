package com.wordApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="File empty.")  // 404
public class FileEmptyException extends RuntimeException{
}
