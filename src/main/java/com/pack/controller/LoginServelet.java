package com.pack.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.jdbc.JdbcConnection;
import com.pack.connection.JDBCCon;
import com.pack.connection.JDBC_User_Methods;
import com.pack.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("myEmail");
		String password = request.getParameter("myPass");

		try {

			JDBC_User_Methods m = new JDBC_User_Methods(JDBCCon.getConnection());
			User u = m.userLogin(email, password);

			if (u == null) {
				request.getSession().setAttribute("msg", "User Not Found Please Register !");
				response.sendRedirect("message.jsp");
			} else if (u.getPassword().equals(password)) {
				request.getSession().setAttribute("auth", u);
				response.sendRedirect("home.jsp");
			} else {
				request.getSession().setAttribute("msg", "Password Not Matched, Try Again !");
				response.sendRedirect("message.jsp");
			}

		} catch (Exception e) {

		}

	}

}
