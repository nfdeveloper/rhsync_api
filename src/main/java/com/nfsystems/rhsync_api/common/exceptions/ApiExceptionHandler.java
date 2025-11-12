package com.nfsystems.rhsync_api.common.exceptions;

import com.nfsystems.rhsync_api.exceptions.RHSEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RHSEntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> cvsEntityNotFoundException(
            RHSEntityNotFoundException ex,
            HttpServletRequest request,
            BindingResult bindingResult
    ){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }
}
