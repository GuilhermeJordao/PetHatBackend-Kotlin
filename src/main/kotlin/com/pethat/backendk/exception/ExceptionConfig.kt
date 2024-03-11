package com.pethat.backendk.exception

import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
class ExceptionConfig {
    @ExceptionHandler(EmptyResultDataAccessException::class, RuntimeException::class)
    fun errorNotFound(exception: Exception): ResponseEntity<ExceptionError> =
            ResponseEntity(ExceptionError("Requisição não encontrada"), HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException::class)
    fun errorBadRequest(exception: Exception): ResponseEntity<ExceptionError> =
            ResponseEntity(ExceptionError("Requisição ilegal"), HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleHttpRequestMethodNotSupported(): ResponseEntity<ExceptionError> =
            ResponseEntity(ExceptionError("Operação não permitida"), HttpStatus.METHOD_NOT_ALLOWED)
    data class ExceptionError(val error: String)
}