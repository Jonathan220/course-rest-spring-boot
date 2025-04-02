package br.com.jonathan.course_rest_with_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

    public UnsupportedMathOperationException(String message){
        super(message);
    }
}
