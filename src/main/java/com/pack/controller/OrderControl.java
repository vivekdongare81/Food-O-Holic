package com.pack.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.pack.connection.JDBCCon;
import com.pack.connection.JDBC_Order_Methods;
import com.pack.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/OrderControl")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			String userEmail = request.getParameter("userEmail");
			JDBC_Order_Methods orderM = new JDBC_Order_Methods(JDBCCon.getConnection());
			// ArrayList<Cart> cart_list = (ArrayList<Cart>)
			// request.getSession().getAttribute("cart-list");

			if (action != null && userEmail != null) {
				if (action.equals("cancel")) {
					orderM.cancelOrderByAdmin(userEmail);

				} else if (action.equals("delivered")) {

					orderM.deliverdOrderByAdmin(userEmail);
				} else if (action.equals("onWay")) {
					orderM.onwayOrderByAdmin(userEmail);
				}
				response.sendRedirect("admin.jsp");
			} else {
				// todo --set attribute
				response.sendRedirect("message.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
