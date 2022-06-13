package com.duaa.project.products;


public class ProductsNotFoundException extends RuntimeException {

	ProductsNotFoundException(int id) {
		super("Could not find products " + id);
	}
}
