package com.duaa.project.Customer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.duaa.project.orders.Orders;
import com.duaa.project.payments.Payments;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "customers")
public class Customer {
	@Column(name = "customerNumber")
	protected @Id Long customerNumber;

	@Column(name = "customerName")
	protected String customerName;

	@Column(name = "contactLastName")
	protected String contactLastName;

	@Column(name = "contactFirstName")
	protected String contactFirstName;

	@Column(name = "city")
	protected String city;

	@Column(name = "state")
	protected String state;

	@Column(name = "postalCode")
	protected String postalCode;

	@Column(name = "country")
	protected String country;

	@Column(name = "phone")
	protected String phone;

	@Column(name = "addressLine1")
	protected String addressLine1;

	@Column(name = "addressLine2")
	protected String addressLine2;

	@Column(name = "creditLimit")
	protected double creditLimit;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerNumber")
	protected List<Payments> payment;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerNumber")
	protected List<Orders> order;

	public Customer(Long customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, int salesRepEmployeeNumber, int creditLimit) {
		super();
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.creditLimit = creditLimit;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;

		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;

	}

	public Customer() {

	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double d) {
		this.creditLimit = d;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}