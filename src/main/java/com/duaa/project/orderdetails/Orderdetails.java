package com.duaa.project.orderdetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Orderdetails {
private int orderNumber;
@Id
private String productCode;
private int quantityOrderd;
private double priceEach;
private short crderLineNumber;

public Orderdetails() {
	super();
	// TODO Auto-generated constructor stub
}

public Orderdetails(int orderNumber, String productCode, int quantityOrderd, double priceEach, short crderLineNumber) {
	super();
	this.orderNumber = orderNumber;
	this.productCode = productCode;
	this.quantityOrderd = quantityOrderd;
	this.priceEach = priceEach;
	this.crderLineNumber = crderLineNumber;
}

public int getOrderNumber() {
	return orderNumber;
}

public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}

public String getProductCode() {
	return productCode;
}

public void setProductCode(String productCode) {
	this.productCode = productCode;
}

public int getQuantityOrderd() {
	return quantityOrderd;
}

public void setQuantityOrderd(int quantityOrderd) {
	this.quantityOrderd = quantityOrderd;
}

public double getPriceEach() {
	return priceEach;
}

public void setPriceEach(double priceEach) {
	this.priceEach = priceEach;
}

public short getCrderLineNumber() {
	return crderLineNumber;
}

public void setCrderLineNumber(short crderLineNumber) {
	this.crderLineNumber = crderLineNumber;
}


}
