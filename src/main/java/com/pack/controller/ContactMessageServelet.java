package com.pack.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack.connection.JDBCCon;
import com.pack.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactMessageServelet
 */

@WebServlet("/contactMessageServelet")
public class ContactMessageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactMessageServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rs = 0;
		try {
			Connection con = JDBCCon.getConnection();
			String query;
			PreparedStatement pst;

			query = "INSERT INTO `restaurant`.`messages` (`Name`, `Email`, `Message`) VALUES (?,?,?);";

			PreparedStatement p = con.prepareStatement(query);
			p.setString(1, request.getParameter("name"));
			p.setString(2, request.getParameter("email"));
			p.setString(3, request.getParameter("message"));
			rs = p.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (rs == 1) {
			request.getSession().setAttribute("msg", " Your Message Sent Successfully !");
			response.sendRedirect("message.jsp");
		} else {
			request.getSession().setAttribute("msg", "Message not sent !");
			response.sendRedirect("message.jsp");
		}

	}
}
