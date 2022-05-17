

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.pack.connection.JDBC_Order_Methods"%>
<%@page import="com.pack.connection.JDBCCon"%>
<%@page import="com.pack.connection.JDBC_Product_Methods"%>
<%@page import="com.pack.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
List<Order> orders = null;
if (auth != null) {
	request.setAttribute("person", auth);
	JDBC_Order_Methods orderDao = new JDBC_Order_Methods(JDBCCon.getConnection());
	orders = orderDao.userOrders(auth.getEmail());
	if (orders.size() > 0 == false) {
		request.getSession().setAttribute("msg", " You Don't Have any Order, ORDER !");
		response.sendRedirect("message.jsp");
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
<%@include file="/components/header.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<form action="cancelOrderServelet" method="post">
			<button class="btn btn-danger" type="submit">Cancel Order</button>
		</form>
		<%
		if (orders != null && orders.size() > 0 == false) {
		%>
		<div>
			Order Status - <b><%=orders.get(0).getStatus()%> </b>
		</div>
		<%
		}
		%>

		<table class="table table-light">
			<thead>
				<tr>

					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>

				</tr>
			</thead>
			<tbody>

				<%
				if (orders != null) {
					for (Order o : orders) {
				%>
				<tr>
					<td><%=o.getName()%></td>
					<td><%=o.getType()%></td>
					<td><%=o.Quantity%></td>
					<td><%=dcf.format(o.getPrice())%></td>
				</tr>
				<%
				}
				}
				%>
			
			<thead>
				<tr>

					<th scope="col">Total</th>
					<th scope="col"></th>
					<th scope="col"></th>
					<th scope="col"><%=orders.get(0).getTotalAmmount()%></th>

				</tr>
			</thead>
			</tbody>
		</table>
	</div>
	<%@include file="/components/footer.jsp"%>
</body>
</html>