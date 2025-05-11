package com.toy.chatapp.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    //TODO: Update as we get more exceptions handling. We don't just want to be throwing 500 errors to the client
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleAllExceptions(Exception ex) {
        logger.error("An unexpected error occurred", ex);
        return "An unexpected error occurred.";
    }
    //TODO: Properly handle the NoResourceFoundException: No static resource favicon.ico
}
