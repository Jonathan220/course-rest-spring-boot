package br.com.jonathan.course_rest_with_spring.exception.handler;

import br.com.jonathan.course_rest_with_spring.exception.ExceptionResponse;
import br.com.jonathan.course_rest_with_spring.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class customEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptioms(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
