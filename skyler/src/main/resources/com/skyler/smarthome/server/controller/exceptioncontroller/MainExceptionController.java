package com.skyler.smarthome.server.controller.exceptioncontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MainExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errMsg",ex.toString());
        return model;
    }
}
