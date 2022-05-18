package com.pack.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.pack.connection.JDBCCon;
import com.pack.connection.JDBC_Order_Methods;
import com.pack.model.*;
import com.pack.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckOutServelet
 */
@WebServlet("/checkOutServelet")
public class CheckOutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {

			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			User auth = (User) request.getSession().getAttribute("auth");

			if (cart_list != null && auth != null) {
				for (Cart c : cart_list) {
					Order order = new Order();
					order.setProductId(c.getId());
					order.setUserEmail(auth.getEmail());
					order.setQuantity(c.getQuantity());
					if(request.getParameter("DeliveryAdd")==null) {
						 order.setAddress(c.getAddress());
					}else {
						order.setAddress(request.getParameter("DeliveryAdd"));
					}
				
       
					JDBC_Order_Methods m = new JDBC_Order_Methods(JDBCCon.getConnection());
					boolean result = m.insertOrder(order);

				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");
				return;
			} else {
				if (auth == null) {
					response.sendRedirect("login.jsp");
					return;
				}
				response.sendRedirect("cart.jsp");
				return;
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
