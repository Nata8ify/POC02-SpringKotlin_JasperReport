package com.n8ify.signink.controller.advice

import com.n8ify.signink._base.model.RESPONSE_ERROR
import com.n8ify.signink._base.model.ResponseStatus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.lang.Exception

@ControllerAdvice
class ExceptionHandlerAdvice {

    fun generateErrorResponse(exception : Exception) : ResponseStatus {
        exception.printStackTrace()
        return ResponseStatus(status = RESPONSE_ERROR, message = "Fetal Error Caused by ${exception.message}")
    }

    @ResponseBody
    @ExceptionHandler(Exception::class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.OK)
    fun handlerException(exception: Exception) : ResponseStatus {
        return generateErrorResponse(exception)
    }
}