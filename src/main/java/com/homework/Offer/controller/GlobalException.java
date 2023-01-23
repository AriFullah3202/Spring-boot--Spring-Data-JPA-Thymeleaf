package com.homework.Offer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = Exception.class)
    public String anyException() {
		
    	return "exception";
    }
}
