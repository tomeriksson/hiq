package com.wordApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="File type not readable")
public class FileTypeNotReadableException extends RuntimeException {
}
