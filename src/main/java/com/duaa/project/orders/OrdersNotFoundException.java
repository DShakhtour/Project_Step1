package com.duaa.project.orders;


public class OrdersNotFoundException extends RuntimeException {

	OrdersNotFoundException(Integer id) {
		super("Could not find orderdetails " + id);
	}
}
