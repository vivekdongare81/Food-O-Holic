package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.pack.model.*;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {

    	ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("cart.jsp");
			} else {
				cartList = cart_list;

				boolean exist = false;
				for (Cart c : cartList) {

					if (c.getId() == id) {
						exist = true;
						session.setAttribute("msg", " Already added in Cart !");
						response.sendRedirect("message.jsp");

					}
				}

				if (!exist) {
					cartList.add(cm);
					response.sendRedirect("cart.jsp");

				}
			}
		}
	}

}