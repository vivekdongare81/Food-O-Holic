package com.pack.connection;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.Blob;
import com.pack.model.Cart;
import com.pack.model.Product;

public class JDBC_Product_Methods {
	private Connection con;
	private String query;
	public PreparedStatement pst;
	private ResultSet rs;

	public JDBC_Product_Methods(Connection con) {
		this.con = con;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();

		try {
			query = "select * from product";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ProductId"));
				p.setName(rs.getString("Name"));
				p.setStock(rs.getInt("Stock"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getInt("Price"));
				p.setType(rs.getString("Type"));
				p.setRating(rs.getInt("Rating"));

				Blob blob = (Blob) rs.getBlob("Image");

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				p.setbase64Image(base64Image);

				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select Price from Product where ProductId=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while (rs.next()) {
						sum += rs.getInt("Price") * item.getQuantity();
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return sum;
	}

	public Product getSingleProduct(int id) {
		Product row = null;
		try {
			query = "select * from product where ProductId=?";

			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				row = new Product();
				row.setId(rs.getInt("ProductId"));
				row.setName(rs.getString("Name"));
				row.setType(rs.getString("Type"));
				row.setPrice(rs.getInt("Price"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return row;
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> book = new ArrayList<>();
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from Product where ProductId=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("ProductId"));
						row.setName(rs.getString("Name"));
						row.setType(rs.getString("Type"));
						row.setPrice(rs.getInt("Price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						book.add(row);
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return book;
	}

}
