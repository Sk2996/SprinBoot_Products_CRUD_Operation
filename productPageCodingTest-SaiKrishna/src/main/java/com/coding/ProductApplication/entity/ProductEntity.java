package com.coding.ProductApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Date;
@Entity
@Table(name = "product")
public class ProductEntity {
    @Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", priceRange=" + priceRange
				+ ", productStatus=" + productStatus + ", productDateRange=" + productDateRange + "]";
	}
	public ProductEntity() {
		super();
	}
	public ProductEntity(long productId, String productName, int priceRange, int productStatus, Date productDateRange) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.priceRange = priceRange;
		this.productStatus = productStatus;
		this.productDateRange = productDateRange;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public Date getProductDateRange() {
		return productDateRange;
	}
	public void setProductDateRange(Date productDateRange) {
		this.productDateRange = productDateRange;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price_range")
    private int priceRange;
    @Column(name = "status")
    private int productStatus;
    @Column(name = "posted_date")
    private Date productDateRange;
}
