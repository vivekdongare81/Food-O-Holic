<%@page import="com.pack.connection.JDBCCon"%>
<%@page import="com.pack.connection.JDBC_Product_Methods"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%
JDBC_Product_Methods pm = new JDBC_Product_Methods(JDBCCon.getConnection());
List<Product> products = pm.getAllProducts();
%>

<!doctype html>
<html lang="en">

<head>

<title>Food-0-Holic</title>
<%@ include file="components/header.jsp"%>
</head>

<body>

	<!--Including Navbar in Home -->
	<%@ include file="components/navbar.jsp"%>

	<div class="row">
		<div class="col" style="height: 60px;"></div>
	</div>
	<!--this is slider-->
	<div class="">
		<div id="carouselExampleCaptions" class=" carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<!-- content over slider -->
			<div class="carousel-inner" id="Slider">
				<div class="carousel-content" id="SliderContent">
					<h1>Food-0-Holic</h1>
					<h3>
						Whoever said money can't buy happiness <br>simply didn't know
						where to go and order Food.
					</h3>
				</div>
				<div class="carousel-item active">
					<img
						src="https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?cs=srgb&dl=pexels-chan-walrus-958545.jpg&fm=jpg"
						class="simg  d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>First slide label</h5>
						<p>Some representative placeholder content for the first
							slide.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="https://www.weightlosslatvia.com/wp-content/uploads/2021/04/eat-out.jpg"
						class=" simg d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Second slide label</h5>
						<p>Some representative placeholder content for the second
							slide.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="https://media.cntraveler.com/photos/5a7ef75617acc04e56ef169c/5:4/w_2705,h_2164,c_limit/Ho-Lee-Fook__2018_HLF_Overhead2.jpg"
						class=" simg d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Third slide label</h5>
						<p>Some representative placeholder content for the third
							slide.</p>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

	<!-- Product Cards -->
	<div class="container">
		<div class="row">

			<%
			for (Product p : products) {
			%>
			<%
			String link = "data:image/png;base64," + p.getBase64Image();
			%>
			<div class="col-3 px-2 py-2 pt-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<img style="height: 200px; width: 100%;" class="card-img-top"
						src=<%=link%>>
					<div class="card-body">
						<h5 class="card-title"><%=p.getName()%></h5>
						<p class="text-bold">
							<%=p.getPrice()%>
							/-
						</p>
						<p class="card-text">Some Context about Above Product</p>
						<a href="addToCart?id=<%=p.getId()%>"
							class="btn btn-primary mx-2 my-2">Add to Cart</a>
					</div>
				</div>
			</div>
			<%
			}
			%>


		</div>
	</div>



	<hr id="hrr">

	<!-- bottom part  -->
	<div class="container-fluid mt-5">
		<div
			class="row text-light bg-dark justify-content-evenly footerr text-center">
			<div class="col-sm-3 mt-5">
				<h4>Food-0-Holic</h4>
				<p>It is located near the popular resorts of Vale de Lobo and
					Quinta do Lago. Gourmet Natural is full of charm, charisma,
					elegance and known for its fine quality cuisine. You will discover
					exclusive wines and gourmet flavours in an elegant and intimate
					atmosphere.!</p>
			</div>
			<div class="col-3 mt-5">
				<h4>Important Links</h4>
				<p>
				<ul type="none" id="nono">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="cart.jsp">Cart</a></li>
					<li><a href="orders.jsp">Orders</a></li>
					<li><a href="contact.jsp">Contact</a></li>
				</ul>
				</p>
			</div>
			<div class="col-3 mt-5">
				<h4>Residential Address</h4>
				<p>
					Chennai<br> Estancia , Tamil Nadu<br> 600001
				</p>
			</div>
		</div>
	</div>
	<div class="row footerr ">
		<div class="col text-center  " style="background-color: #c0b6b6;">
			<span class="material-icons" style="transform: scale(0.8, 0.8);">
				copyright </span> 2001-22 By Food-0-Holic All Rights Reserved
		</div>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<%@ include file="components/footer.jsp"%>
</body>

</html>