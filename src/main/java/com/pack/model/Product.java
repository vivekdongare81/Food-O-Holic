package com.pack.model;

public class Product {
	private Integer Id;
	protected String Name;
	private Integer Stock;
	private Integer Price;
	private String Type;
	private Integer Rating;
	private byte[] image;
	private String base64Image;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setbase64Image(String base64image) {
		base64Image = base64image;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Integer getRating() {
		return Rating;
	}

	public void setRating(Integer rating) {
		Rating = rating;
	}

}
