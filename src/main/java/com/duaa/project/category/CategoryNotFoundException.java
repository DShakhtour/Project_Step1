package com.duaa.project.category;


public class CategoryNotFoundException extends RuntimeException {

	CategoryNotFoundException(Integer id) {
		super("Could not find orderdetails " + id);
	}
}

