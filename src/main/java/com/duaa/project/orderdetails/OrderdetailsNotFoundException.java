package com.duaa.project.orderdetails;

public class OrderdetailsNotFoundException extends RuntimeException {

	OrderdetailsNotFoundException(String id) {
		super("Could not find orderdetails " + id);
	}
}
