package com.berdibekov.handler;

import com.berdibekov.dto.error.ErrorDetail;
import com.berdibekov.dto.error.ValidationError;
import com.berdibekov.exception.IncorrectActionException;
import com.berdibekov.exception.ResourceAlreadyExistsException;
import com.berdibekov.exception.ResourceNotFoundException;
import com.berdibekov.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public RestExceptionHandler(@Autowired MessageSource messageSource) {
        this.messageSource = messageSource;
    }

//  There must be Exception handlers.
}
