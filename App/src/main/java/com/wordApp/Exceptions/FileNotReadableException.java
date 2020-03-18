package com.wordApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="File not readable.")
public class FileNotReadableException extends RuntimeException{
}
