package com.pack.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack.model.User;

public class JDBC_User_Methods {
	private Connection con;
	private String query;
	public PreparedStatement pst;
	private ResultSet rs;

	public JDBC_User_Methods(Connection con) {
		this.con = con;
	}

	public User userLogin(String email, String password) {
		User user = null;

		try {
			query = "select * from users where Email=? ";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);

			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				user.setPreferredType(rs.getString("PrefferedType"));
				user.setPassword(rs.getString("Password"));
			    user.setAddress(rs.getString("Address"));
			}

		} catch (Exception e) {

		}
		return user;
	}

	public User userSignup(String name, String email, String pass, String add, String pt) {
		User user = null;
		int result = 0;
		try {

			query = "insert into users (Name,Email,Password,Address,PrefferedType) values (?,?,?,?,?);";
			// query="INSERT INTO users (Name, Email, Password, Address, PrefferedType)
			// VALUES (5,5,5,5,5);";
			// query="INSERT INTO `restaurant`.`users` (`Name`, `Email`, `Password`,
			// `Address`, `PrefferedType`) VALUES (5, 5, 5, 5, 5);";
			// query="insert into users (Name,Email,Password,Address,PrefferedType) values
			// (ucd,huc,hjgc,huc,hguc);";
			// query="INSERT INTO `restaurant`.`users` (`Name`, `Email`, `Password`,
			// `Address`, `PrefferedType`) VALUES ('sddx', 'scdd', 'sdd', 'sdd', 'sdd');";
			// query="insert into users (Name,Email,Password,Address,PrefferedType) values
			// (\"ddd\",\"neddddw\",\"dd\",\"nddd\",\"ddn\");";
			// query="insert into users (Name,Email,Password,Address,PrefferedType) values
			// ("+name+","+email+","+pass+","+add+","+pt+");";

			PreparedStatement p = this.con.prepareStatement(query);
			p.setString(1, name);
			p.setString(2, email);
			p.setString(3, pass);
			p.setString(4, add);
			p.setString(5, pt);
			result = p.executeUpdate();

		} catch (Exception e) {

		}

		if (result != 0) {
			user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPreferredType(pt);
			user.setAddress(add);
		}

		return user;
	}

}
