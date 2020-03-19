package com.wordApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="File too big (File must be less then 10MB).")  // 404
public class FileSizeToBigException extends RuntimeException{
}
