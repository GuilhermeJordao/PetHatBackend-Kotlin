package com.pethat.backendk.exception

import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
class ExceptionConfig (message:String) : RuntimeException(message){
    @ExceptionHandler
    fun errorNotFound(exception: ExceptionConfig): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(HttpStatus.NOT_FOUND.value(), exception.message)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(IllegalArgumentException::class)
    fun errorBadRequest(exception: ExceptionConfig): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(HttpStatus.BAD_REQUEST.value(), exception.message)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

}