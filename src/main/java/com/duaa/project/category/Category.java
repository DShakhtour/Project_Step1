package com.duaa.project.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	protected long id;

	@Column(name = "productLine")
	protected String productLine;

	@Column(name = "textDescription")
	protected String textDescription;

	@Column(name = "htmlDescrip")
	protected String htmlDescrip;

	@Column(name = "image")
	protected int image;

	public Category(String productLine, String textDescription, String htmlDescrip, int image) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescrip = htmlDescrip;
		this.image = image;
	}

	public Category() {
		super();
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescrip() {
		return htmlDescrip;
	}

	public void setHtmlDescrip(String htmlDescrip) {
		this.htmlDescrip = htmlDescrip;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

}
