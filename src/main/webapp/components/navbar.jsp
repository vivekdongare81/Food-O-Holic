<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User authh = (User) request.getSession().getAttribute("auth");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>

<title>Insert title here</title>
</head>
<body>
	<!-- this id navbar -->
	<nav class=" navbar navbar-expand-lg navbar-dark bg-dark  "
		id="topnavbar" style="position: fixed; z-index: 40; width: 100%;">
		<div class="container-fluid ">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<div class=" label text-bold text-primary mx-2">Food-0-Holic</div>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp"><b>HOME</b></a></li>
					<li class="nav-item"><a class="nav-link" href="cart.jsp"><b>CART</b></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="orders.jsp"><b>ORDERS</b></a>
					</li>

					<li class="nav-item"><a class="nav-link " href="contact.jsp"
						tabindex="-1" aria-disabled="true"><b>CONTACT</b></a></li>
			  
			     <% if(authh!=null && authh.getRole()==1){ %>
			    	 <li class="nav-item"><a class="nav-link " href="admin.jsp"	tabindex="-1" aria-disabled="true"><b>ADMIN PANEL</b></a></li>
			    <%  } %>
					
				</ul>
				<div class="d-flex text-danger">
					<%
					if (authh != null) {
					%>
					<h5 class="text-primary mx-3">
						Welcome
						<%=authh.getName()%>
						!
					</h5>
					<%
					}
					%>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						<%
						if (authh == null) {
						%>
						<a class="nav-link" href="login.jsp"><b>SIGN IN</b></a>
						<a class="nav-link" href="register.jsp"><b>REGISTER</b></a>
						<%
						} else {
						%>

						<a class="nav-link text-danger" href="logout"><b>LOGOUT</b></a>
						<%
						}
						%>


					</ul>
				</div>


			</div>
		</div>
	</nav>
</body>
</html>