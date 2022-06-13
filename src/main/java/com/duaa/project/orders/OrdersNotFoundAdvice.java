package com.duaa.project.orders;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class OrdersNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(OrdersNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PatientNotFoundHandler(OrdersNotFoundException ex) {
		return ex.getMessage();
	}
}
