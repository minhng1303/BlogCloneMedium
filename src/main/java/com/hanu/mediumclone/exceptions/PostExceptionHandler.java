package com.hanu.mediumclone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.html.FormSubmitEvent;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Object> handlePostException(ConstraintViolationException e) {
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation c : e.getConstraintViolations()) {
            errorMessages.add(c.getMessage());
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
