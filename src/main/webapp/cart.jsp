<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.pack.connection.*"%>

<%@page import="com.pack.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("person", auth);
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

List<Cart> cartProduct = null;
if (cart_list != null) {
	JDBC_Product_Methods pDao = new JDBC_Product_Methods(JDBCCon.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="components/header.jsp"%>
<title>Cart Page</title>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

body {
	background-color: #9A616D;
}
</style>
</head>
<body style="background-color: #9A616D !important;">
	<%@include file="/components/navbar.jsp"%>
	<hr>
	<hr>
	<div class="container mt-5  ">

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getType()%></td>
					<td><%=dcf.format(c.getPrice())%></td>
					<td>
						<form action="orderServelet" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=c.getId()%>"
								class="form-input">

							<div class="number-input md-number-input">
								<a style="text-decoration: none; background-color: grey;"
									href="cartHelper?action=dec&id=<%=c.getId()%>"
									class="btn text-white">-</a> <input class="quantity" min="1"
									name="quantity" value="<%=c.getQuantity()%>" type="number">
								<a style="text-decoration: none; background-color: grey;"
									href="cartHelper?action=inc&id=<%=c.getId()%>"
									class="btn text-white">+</a>
							</div>

						</form>
					</td>
					<td><a href="removeFromCartServelet?id=<%=c.getId()%>"
						class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}
				}
				%>
			</tbody>
		</table>
		<div class=" row d-flex py-3 bg-dark text-white rounded">
			<div class="col-12">

				<span class="text-bold"><h5>Total Price:</h5> <i>
						<h3>Rs. ${(total>0)?dcf.format(total):0} /-</h3>
				</i> </span>
			</div>

			<br>
			<form method="post" action="checkOutServelet" >
			<div class="form-outline mb-1">
				<label class="form-label" for="form2Example27"><h5>Address
						for Delivery</h5></label> <input type="text" id="form2Example27"
					placeholder="Enter Address" class="form-control form-control"
					name="DeliveryAdd" />

			</div>
			<br>
			
				<div class="col-3">
					<button class="mx-3 mt-3 btn btn-sm btn-primary" type="submit"><a  >Checkout</a></button>
				</div>
			</form>

		</div>
	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>