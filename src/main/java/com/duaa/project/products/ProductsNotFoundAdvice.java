package com.duaa.project.products;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ProductsNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(ProductsNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PatientNotFoundHandler(ProductsNotFoundException ex) {
		return ex.getMessage();
	}
}

