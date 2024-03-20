package com.pethat.backendk.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionConfig {

    @ExceptionHandler
    fun errorNotFound(exception: Exception): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(HttpStatus.NOT_FOUND.value(), exception.message)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun errorBadRequest(exception: IllegalArgumentException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(HttpStatus.BAD_REQUEST.value(), exception.message)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}

