package com.skyler.smarthome.server.controller.exceptioncontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainUiExceptionController {

    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception ex) {
        return "error";
    }
}
