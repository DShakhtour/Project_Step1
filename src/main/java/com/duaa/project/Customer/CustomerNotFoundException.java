package com.duaa.project.Customer;

public class CustomerNotFoundException extends RuntimeException {
	
	CustomerNotFoundException(Integer id) {
			super("Could not find Patient " + id);
		}
	}


