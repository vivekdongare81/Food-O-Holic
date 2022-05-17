<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="components/header.jsp"%>
<title>Contact Page</title>
</head>
<body>

	<!--Including Navbar in Contact -->
	<%@ include file="components/navbar.jsp"%>

	<!-- contact us -->
	<div class="afterstats">
		<div class="container-fluid " id="contact"
			style="filter: drop-shadow(1px 1px 4px grey);">
			<div class="row justify-content-evenly" id="contact">
				<div class="col-12 mt-5 md-5" id="abjustablediv"></div>
				<div class="col-12 mt-5 md-5"></div>
				<div class="col-sm-4 mt-5  ">
					<form action="contactMessageServelet" method="post">
						<div class="p-1">
							<div class="mb-3  ">
								<h4>Contact Form</h4>
								<label for="formGroupExampleInput" class="form-label">Name</label>
								<input name="name" type="text" class="form-control"
									id="formGroupExampleInput" placeholder="Enter Your Name">
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">Email
									address</label> <input name="email" type="email" class="form-control"
									id="exampleFormControlInput1" placeholder="name@example.com">
							</div>
							<div class="mb-3 ">
								<label for="exampleFormControlTextarea1" class="form-label">Message
									Us</label>
								<textarea name="message" class="form-control"
									placeholder="Type here " id="exampleFormControlTextarea1"
									rows="3"></textarea>
							</div>
							<button type="submit" class="btn btn-secondary">Send</button>
						</div>

					</form>
				</div>

				<div class="col-sm-5 mt-3 mb-5 p-4" border:0px solidrgb(233, 231, 231); filter:drop-shadow(1px 1px 2pxgrey); >
					<h4>
						Address <i class="bi bi-geo-fill"></i>
						</h5>
						<p>
							Chennai<br> Estancia , Tamil Nadu<br> 600001
						</p>
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15560.541461716175!2d80.0423041477667!3d12.834528110267128!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a5260db1ff54b03%3A0xa8af6b8bb6419d6f!2sZoho%20Corporation!5e0!3m2!1sen!2sin!4v1652511317078!5m2!1sen!2sin"
							width="600" height="450" style="border: 0;" allowfullscreen=""
							loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</div>
				<div class="col-12 mt-5 md-5"></div>
				<div class="col-12 mt-5 md-5"></div>

			</div>
		</div>
		<%@ include file="components/footer.jsp"%>
</body>
</html>