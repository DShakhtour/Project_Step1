package com.duaa.project.orderdetails;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class OrderdetailsNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(OrderdetailsNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PatientNotFoundHandler(OrderdetailsNotFoundException ex) {
		return ex.getMessage();
	}
}
