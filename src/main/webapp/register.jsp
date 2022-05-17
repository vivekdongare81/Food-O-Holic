<%@page import="com.pack.connection.JDBCCon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="components/header.jsp"%>
<title>Insert title here</title>

</head>
<body>

	<!--Including Navbar in register -->
	<%@ include file="components/navbar.jsp"%>

	<section class="vh-100" style="background-color: #9A616D;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class=" mt-1 col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://assets.vogue.in/photos/61b3753015fc923d29d9b585/2:3/w_2560%2Cc_limit/Silly-Food-Image-4-819x1024.jpeg"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">

									<form action="register" method="post">

										<div class="d-flex align-items-center mb-3 pb-1">

											<span class="h1 fw-bold mb-0">Sign Up</span>
										</div>

										<h5 class="fw-normal mb-1 pb-2" style="letter-spacing: 1px;">Create
											Account</h5>

										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example17">Name</label> <input
												type="text" id="form2Example17"
												class="form-control form-control-lg" name="name" />

										</div>

										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Email</label>
											<input type="email" id="form2Example27"
												class="form-control form-control-lg" name="email" />

										</div>

										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Address</label>
											<input type="text" id="form2Example27"
												class="form-control form-control-lg" name="add" />

										</div>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Preffered
												Type</label> <select name="pt" class="form-select"
												aria-label="Default select example">
												<option selected>All</option>
												<option value="South">South</option>
												<option value="North">North</option>
												<option value="Chinese">Chinese</option>
												<option value="Italian">Italian</option>
											</select>

										</div>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Password</label>
											<input type="password" id="form2Example27"
												class="form-control form-control-lg" name="pass" />

										</div>

										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Confirm
												Password</label> <input type="password" id="form2Example27"
												class="form-control form-control-lg" name="pass1" />

										</div>

										<div class="pt-1 mb-1">
											<button class="btn btn-dark btn-lg btn-block" type="submit">Register</button>
										</div>




									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="components/footer.jsp"%>
</body>
</html>