package com.duaa.project.products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Products {

	@Id
	private  long productCode ;
	private String productName;
	private String productLine ;
	private String productScale ;
	private String productVendor ;
	private String productDescription ;
	private int quantityilStock ;
	private double buyPrice ;
	private double MSRP ;
	
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantityilStock() {
		return quantityilStock;
	}
	public void setQuantityilStock(int quantityilStock) {
		this.quantityilStock = quantityilStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getMSRP() {
		return MSRP;
	}
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}
	public Products(long productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityilStock, double buyPrice, double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityilStock = quantityilStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
}
