package com.pack.controller;

import jakarta.servlet.http.HttpServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Blob;
import com.pack.connection.JDBCCon;
import com.pack.connection.JDBC_Order_Methods;
import com.pack.model.Cart;
import com.pack.model.Order;
import com.pack.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class addProductByAdmin
 */
@WebServlet("/addProductByAdmin")
@MultipartConfig(maxFileSize = 16177215)
public class addProductByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			
			response.setContentType("text/html;charset=UTF-8");
			String name = request.getParameter("name1");
			Integer stock = Integer.parseInt(request.getParameter("stock1").trim());
			Integer price = Integer.parseInt((String)request.getParameter("price1").trim());
			String category = request.getParameter("category1");
		
			InputStream inputStream = null;
			
			Part filePart = request.getPart("photo1");
			if (filePart != null) {
				
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				inputStream = filePart.getInputStream();
			}

			Connection conn = null;
			String message = null; 
			try {
				// connects to the database
				conn = JDBCCon.getConnection();
				// constructs SQL statement
				String sql = "INSERT INTO `restaurant`.`product` (`Name`, `Stock`, `Price`, `Type`, `Image`) VALUES ( ?,?,?,?,?);";
				// Using a PreparedStatement to save the file
				PreparedStatement pstmtSave = conn.prepareStatement(sql);
				pstmtSave.setString(1, name);
				pstmtSave.setInt(2, stock);
				pstmtSave.setInt(3, price);
				pstmtSave.setString(4,  category);
				if (inputStream != null) {
				pstmtSave.setBlob(5, inputStream);
				}

				int row = pstmtSave.executeUpdate();
				if (row > 0) {
					message = " Product uploaded and saved into database !";
				}

			} catch (SQLException ex) {
				message = "Error while Adding Product. ";
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				request.getSession().setAttribute("msg", message);
				response.sendRedirect("message.jsp");
			}
		}
	

}
