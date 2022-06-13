package com.duaa.project.payments;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Payments {
	@Id
private int customerNumber;
private String checkNumber;
private Date paymentDate;
private double amount;
public Payments() {
	super();
	// TODO Auto-generated constructor stub
}
public Payments(int customerNumber, String checkNumber, Date paymentDate, double amount) {
	super();
	this.customerNumber = customerNumber;
	this.checkNumber = checkNumber;
	this.paymentDate = paymentDate;
	this.amount = amount;
}
public int getCustomerNumber() {
	return customerNumber;
}
public void setCustomerNumber(int customerNumber) {
	this.customerNumber = customerNumber;
}
public String getCheckNumber() {
	return checkNumber;
}
public void setCheckNumber(String checkNumber) {
	this.checkNumber = checkNumber;
}
public Date getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}


}