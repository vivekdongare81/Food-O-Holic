<%@page import="com.pack.connection.JDBCCon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="components/header.jsp"%>
<title>Login Page</title>

</head>
<body>

	<!--Including Navbar in Login -->
	<%@ include file="components/navbar.jsp"%>

	<section class="vh-100" style="background-color: #9A616D;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://assets.vogue.in/photos/61b3753015fc923d29d9b585/2:3/w_2560%2Cc_limit/Silly-Food-Image-4-819x1024.jpeg"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">

									<form action="login" method="post">

										<div class="d-flex align-items-center mb-3 pb-1">

											<span class="h1 fw-bold mb-0">Sign In</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
											into your account</h5>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example17">Email
												address</label> <input type="email" id="form2Example17"
												class="form-control form-control-lg" name="myEmail" />

										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">Password</label>
											<input type="password" id="form2Example27"
												class="form-control form-control-lg" name="myPass" />

										</div>

										<div class="pt-1 mb-4">
											<button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
										</div>


										<p class="mb-5 pb-lg-2" style="color: #393f81;">
											Don't have an account? <a href="register.jsp"
												style="color: #393f81;">Register here</a>
										</p>

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