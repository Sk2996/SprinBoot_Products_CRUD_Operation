package com.coding.ProductApplication.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(description = "Price of the product should not be more than $10000 and Status should be as Pending(1)/Approved(2)/Rejected(3)")
public class ProductDTO {
    public ProductDTO() {
		super();
	}
	public ProductDTO(String name, int price, int status) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@ApiModelProperty(example = "Table")
    private String name;
	@ApiModelProperty(example = "7000")
    private int price;
    @ApiModelProperty(example = "3")
    private int status;
}
