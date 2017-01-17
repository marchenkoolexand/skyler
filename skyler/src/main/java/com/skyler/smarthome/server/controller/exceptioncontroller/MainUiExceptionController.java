package com.skyler.smarthome.server.controller.exceptioncontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MainUiExceptionController {

    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception ex) {
        return "error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("/error");
        mav.addObject("exception", e);
        return mav;
    }
}
