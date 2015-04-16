package com.hepsiburada.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid", unique = true, nullable = false)
	private Long productId;

	@Column(name = "productname")
	private String productName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Brand productBrand;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_categories", joinColumns = { @JoinColumn(name = "productid") }, inverseJoinColumns = { @JoinColumn(name = "categoryid") })
	private List<Category> categories = new ArrayList<Category>();

	public Product() {

	}

	public Product(String productName, Brand brand,
			List<Category> categories) {
		
		this.productName = productName;
		this.productBrand = brand;
		this.categories = categories;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Brand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(Brand productBrand) {
		this.productBrand = productBrand;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productBrand=" + productBrand + ", categories="
				+ categories + "]";
	}

}
