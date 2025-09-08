package com.wildies.wildies.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DeporteNotFoundException.class)
    public ProblemDetail DeporteNotFound(DeporteNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Deporte no encontrado");
        return result;
    }

}
