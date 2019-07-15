package com.booktube.util;

import com.booktube.util.exceptionHandler.LoginExists;
import com.booktube.util.exceptionHandler.LoginUserNotFoundException;
import com.booktube.util.exceptionHandler.UserIdMismatchException;
import com.booktube.util.exceptionHandler.UsernameNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({LoginUserNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Customer not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({UserIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    protected ResponseEntity<Object> handleUsernameNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "The username not exist.",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({LoginExists.class})
    protected ResponseEntity<Object> handleLoginExists(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "The login is already exists.",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}