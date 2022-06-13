package com.duaa.project.payments;


public class PaymentsNotFoundException extends RuntimeException {
	
	PaymentsNotFoundException(Integer id) {
			super("Could not find Patient " + id);
		}
	}



