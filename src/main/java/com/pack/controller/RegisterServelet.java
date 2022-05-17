package com.pack.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.pack.connection.JDBCCon;
import com.pack.connection.JDBC_User_Methods;
import com.pack.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServelet
 */
@WebServlet("/register")
public class RegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String pass1 = request.getParameter("pass1");
		String add = request.getParameter("add");
		String pt = request.getParameter("pt");

		if (!pass.equals(pass1)) {
			request.getSession().setAttribute("msg", "Password Not Matched, Register Again !");
			response.sendRedirect("message.jsp");
		}

		try {

			JDBC_User_Methods m = new JDBC_User_Methods(JDBCCon.getConnection());
			User u = m.userSignup(name, email, pass, add, pt);

			if (u == null) {
				request.getSession().setAttribute("msg", "User Not Registered ,Try Again !");
				response.sendRedirect("message.jsp");
			} else {
				request.getSession().setAttribute("auth", u);
				response.sendRedirect("home.jsp");
			}
		} catch (Exception e) {

		}
	}

}
