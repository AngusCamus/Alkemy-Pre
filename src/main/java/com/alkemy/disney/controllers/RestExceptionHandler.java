package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.ApiErrorDTO;
import com.alkemy.disney.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = Throwable.class)
        protected ResponseEntity<Object> handleThrowable(Throwable ex, WebRequest req){
            ApiErrorDTO apiErrorDTO = new ApiErrorDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage(),
                    Arrays.asList("")
            );
            return handleExceptionInternal((Exception) ex, apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus(),req);
        }
        @ExceptionHandler(value = ParamNotFound.class)
        protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request) {
            ApiErrorDTO errorDTO = new ApiErrorDTO(
                    HttpStatus.BAD_REQUEST,
                    ex.getMessage(),
                    Arrays.asList(EnumErrors.PARAM.getErrorMessage())
            );
            return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }

        //TODO: User already exist
        @ExceptionHandler(value= UserRegisterError.class)
        protected ResponseEntity<Object> handleUserRegisterError(RuntimeException ex, WebRequest request){
            ApiErrorDTO errorDTO = new ApiErrorDTO(
                    HttpStatus.BAD_REQUEST,
                    ex.getMessage(),
                    Arrays.asList(EnumErrors.USER_ALREADY_EXIST.getErrorMessage())
            );
            return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }
        //TODO: Wrong password or email.
        @ExceptionHandler(value= UserWrongLogin.class)
        protected ResponseEntity<Object> handleUserLoginError(RuntimeException ex, WebRequest request){
            ApiErrorDTO errorDTO = new ApiErrorDTO(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                Arrays.asList(EnumErrors.WRONG_CREDENTIALS.getErrorMessage())
            );
            return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(
                MethodArgumentNotValidException ex,
                HttpHeaders headers,
                HttpStatus status,
                WebRequest request){
            List<String> errors = new ArrayList<>();
            for (FieldError error : ex.getBindingResult().getFieldErrors()){
                errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            for (ObjectError error : ex.getBindingResult().getGlobalErrors()){
                errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
            }
            ApiErrorDTO apiError = new ApiErrorDTO(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

            return handleExceptionInternal(
                    ex, apiError, headers, apiError.getStatus(), request);
        }
        @Override
        protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
                HttpRequestMethodNotSupportedException ex,
                HttpHeaders headers,
                HttpStatus status,
                WebRequest request
        ){
            ApiErrorDTO apiError = new ApiErrorDTO(
                    HttpStatus.METHOD_NOT_ALLOWED,
                    ex.getLocalizedMessage(),
                    Arrays.asList(EnumErrors.INVALID_METHOD.getErrorMessage()));

            return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
        }


}
