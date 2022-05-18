<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--auth - if auth .role ==1 then continue otherwise redirect to oops  -->

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.pack.connection.JDBC_Order_Methods"%>
<%@page import="com.pack.connection.JDBCCon"%>
<%@page import="com.pack.connection.JDBC_Product_Methods"%>
<%@page import="com.pack.model.*"%>
<%@page import="java.util.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
ArrayList<String> users = null;
if (auth != null && auth.getRole() != 1) {
	request.getSession().setAttribute("msg", "Access Denied, You are not Admin !");
	response.sendRedirect("message.jsp");
}
if (auth != null) {
	request.setAttribute("person", auth);
	JDBC_Order_Methods orderDao = new JDBC_Order_Methods(JDBCCon.getConnection());
	users = orderDao.getUsersInOrder();

	System.out.println("1 order size->");
	if (users == null || users.size() <= 0) {
		request.getSession().setAttribute("msg", " You Don't Have any Order, ORDER NOW!");
		response.sendRedirect("message.jsp");
		return;
	}

} else {

	response.sendRedirect("login.jsp");
}
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>
<%@ include file="components/header.jsp"%>
</head>
<body
	style="background-color: #9A616D !important; text-decoration: none;">
	<%@ include file="components/navbar.jsp"%>

	<hr>


	<div class="container mt-5  ">
		<div className="container-fluid mt-5">
			<div className="jumbotron  bg-dark text-white text-center pt-4">
				<h2 className="display-4">Admin Control Panel</h2>

			</div>
		</div>

		<div class="col-3 px-2 py-2 pt-4">
			<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">

				<div class="card-body">
					<a href="addProductByAdmin.jsp" class="btn btn-primary mx-2 my-2">Add
						a Product</a>
				</div>
			</div>
		</div>
		<hr>
		<table class="table table-light">
			<thead>
				<tr>

					<th scope="col">User</th>
					<th scope="col">Items</th>

					<th scope="col">Quantity</th>
					<th scope="col">Amount</th>
					<th scope="col"></th>
					<th scope="col">Status</th>

				</tr>
			</thead>
			<tbody>

				<%
				if (users != null) {
					for (String s : users) {
						String[] ss = s.split("-");
						JDBC_Order_Methods user = new JDBC_Order_Methods(JDBCCon.getConnection());
						String name = user.userNameFromEmail(ss[0]);
				%>
				<td><%=name%></td>
				<td><%=" "%></td>
				<td><%=" "%></td>
				<td><%=" "%></td>
				<td></td>

				<%
				JDBC_Order_Methods orderDao1 = new JDBC_Order_Methods(JDBCCon.getConnection());
				List<Order> orders = orderDao1.userOrders(ss[0]);
				%>
				<%
				for (Order o : orders) {
				%>
				<tr>
					<td><%=" "%></td>
					<td><%=o.getName()%></td>

					<td><%=o.Quantity%></td>
					<td><%=dcf.format(o.getPrice())%></td>
				</tr>

				<%
				}
				%>
				<form action="OrderControl" method="post">
					<thead>


						<th scope="col"><span class="bg-dark text-white">Total
								Amount </span> - <%=orders.get(0).getTotalAmmount()%></th>
						<th scope="col"><span class="bg-dark text-white">
								Delivery Address </span> - <%=ss[1]%></th>
						<th scope="col"></th>
						<th scope="col"><a class="mx-3 btn btn-sm btn-danger"
							href="OrderControl?action=cancel&userEmail=<%=ss[0]%>">
								Cancel</a><a class="mx-3 btn btn-sm btn-primary"
							href="OrderControl?action=onWay&userEmail=<%=ss[0]%>">On Way</a></th>
						<th scope="col"><a class="mx-3 btn btn-sm btn-success"
							href="OrderControl?action=delivered&userEmail=<%=ss[0]%>">
								Delivered</a></th>
						<th scope="col"><%=orders.get(0).getStatus()%></th>
					</thead>
				</form>
				<%
				}
				}
				%>
			
			<thead>
				<tr>

					<th scope="col"></th>
					<th scope="col"></th>
					<th scope="col"></th>


				</tr>
			</thead>
			</tbody>
		</table>

	</div>
	</div>

	</div>
	<%@ include file="components/footer.jsp"%>
</body>
</html>