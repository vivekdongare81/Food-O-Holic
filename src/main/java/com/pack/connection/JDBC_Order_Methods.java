package com.pack.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.pack.model.Order;
import com.pack.model.Product;

public class JDBC_Order_Methods {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public JDBC_Order_Methods(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertOrder(Order model) {
		boolean result = false;
		try {
			query = "INSERT INTO `restaurant`.`order` (`UserEmail`, `ProductId`, `Quantity` ,`Address`) VALUES (?,?,?,?);";
			// query = "insert into order ( UserEmail, ProductId, Quantity ) values(?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setString(1, model.getUserEmail());
			pst.setInt(2, model.getProductId());
			pst.setInt(3, model.getQuantity());
			pst.setString(4, model.getAddress());

			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public List<Order> userOrders(String id) {
		List<Order> list = new ArrayList<>();
		int sum = 0;
		try {
			query = "select * from restaurant.order where UserEmail=? order by restaurant.order.OrderId desc";
			pst = this.con.prepareStatement(query);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {

				Order order = new Order();
				JDBC_Product_Methods productDao = new JDBC_Product_Methods(this.con);
				int pId = rs.getInt("ProductId");
				Product product;
				try {
					product = productDao.getSingleProduct(pId);
					System.out.print(product);
					order.setId(rs.getInt("OrderId"));
					order.setId(pId);
					order.setName(product.getName());
					order.setType(product.getType());
					order.setStatus(rs.getString("Status"));
					order.setPrice(product.getPrice() * rs.getInt("Quantity"));
					order.setQuantity(rs.getInt("Quantity"));
					sum += product.getPrice() * rs.getInt("Quantity");

					list.add(order);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if (list.size() != 0) {
			list.get(0).setTotalAmmount(sum);
		}
		return list;
	}

	public ArrayList<String> getUsersInOrder() {
		ArrayList<String> list = new ArrayList<>();

		try {
			query = "select `UserEmail`,`Address` from restaurant.order group by  `UserEmail`";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				String temp = rs.getString("UserEmail");
				String temp2 = rs.getString("Address");
				System.out.print(temp);
				list.add(temp + "-" + temp2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Order> userAllOrders(String id) {
		List<Order> list = new ArrayList<>();
		int sum = 0;
		try {
			query = "select * from restaurant.order";
			pst = this.con.prepareStatement(query);

			rs = pst.executeQuery();

			while (rs.next()) {

				Order order = new Order();
				JDBC_Product_Methods productDao = new JDBC_Product_Methods(this.con);
				int pId = rs.getInt("ProductId");
				Product product;
				try {
					product = productDao.getSingleProduct(pId);
					System.out.print(product);
					order.setId(rs.getInt("OrderId"));
					order.setId(pId);
					order.setUserEmail(rs.getString("UserEmail"));
					order.setName(product.getName());
					order.setType(product.getType());
					order.setStatus("Order Received ! ");
					order.setPrice(product.getPrice() * rs.getInt("Quantity"));
					order.setQuantity(rs.getInt("Quantity"));
					sum += product.getPrice() * rs.getInt("Quantity");

					list.add(order);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if (list.size() != 0) {
			list.get(0).setTotalAmmount(sum);
		}
		return list;
	}

	public void cancelOrderByAdmin(String UserEmail) {
		// boolean result = false;
		try {
			query = "UPDATE `restaurant`.`order` SET `Status` = 'Order Cancelled :(' WHERE (`UserEmail` = ?);";
			pst = this.con.prepareStatement(query);
			pst.setString(1, UserEmail);
			pst.executeUpdate();

			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}

	public void deliverdOrderByAdmin(String UserEmail) {
		// boolean result = false;
		try {
			query = "UPDATE `restaurant`.`order` SET `Status` = 'Order Delivered :)' WHERE (`UserEmail` = ?);";
			pst = this.con.prepareStatement(query);
			pst.setString(1, UserEmail);
			pst.executeUpdate();

			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}

	public void onwayOrderByAdmin(String UserEmail) {
		// boolean result = false;
		try {
			query = "UPDATE `restaurant`.`order` SET `Status` = 'On the Way!' WHERE (`UserEmail` = ?);";
			pst = this.con.prepareStatement(query);
			pst.setString(1, UserEmail);
			pst.executeUpdate();

			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}

	public void cancelOrder(String UserEmail) {
		// boolean result = false;
		try {
			query = "DELETE FROM `restaurant`.`order` WHERE (`UserEmail` = ? );";
			pst = this.con.prepareStatement(query);
			pst.setString(1, UserEmail);
			pst.execute();

			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}
	
	
	public String userNameFromEmail(String email) {
	
   String s ="Usser";
		try {
			query = "select `Name` from restaurant.users where (`Email`= ? ) ;";
			
			 PreparedStatement psts = this.con.prepareStatement(query);
		 	 psts.setString(1, email);
			 ResultSet rss = psts.executeQuery();
			 rss.next();
			 s = rss.getString("Name");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return s;
	}
}
