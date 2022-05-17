package com.pack.model;

public class Order extends Product {
	public Integer ProductId;
	public String UserEmail;
	public String Status;
	public Integer Quantity;

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	private Integer Ammount;

	public Order() {
	}

	public Order(int productId, String userEmail, int qunatity) {
		super();
		this.ProductId = productId;
		this.UserEmail = userEmail;
		this.Quantity = qunatity;

	}

	public Order(String userEmail, int qunatity) {
		super();
		this.UserEmail = userEmail;
		this.Quantity = qunatity;

	}

	public Integer getTotalAmmount() {
		return TotalAmmount;
	}

	public void setTotalAmmount(Integer totalAmmount) {
		TotalAmmount = totalAmmount;
	}

	public Integer TotalAmmount;

	public Integer getProductId() {
		return ProductId;
	}

	public void setProductId(Integer productId) {
		ProductId = productId;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Integer getAmmount() {
		return Ammount;
	}

	public void setAmmount(Integer ammount) {
		Ammount = ammount;
	}

}
