

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="components/header.jsp"%>
<title>Add a Product</title>
</head>
<body>

	<!--Including Navbar  -->
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
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKJQp8ndvEkIa-u1rMgJxVc7BBsR11uSLHGA&usqp=CAU"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">

									<form action="addProductByAdmin" method="post"
										enctype="multipart/form-data">

										<div class="d-flex align-items-center mb-3 pb-1"></div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">
											Add Product in Restaurant</h5>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27"> Item
												Image</label> <input type="file" name="photo1" size="50"
												placeholder="Upload Your Image"
												class="form-control form-control-lg" required /><br>


										</div>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example17">Item
												Name </label> <input type="text" id="form2Example17"
												class="form-control form-control-lg" name="name1" />

										</div>

										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Price</label>
											<input type="text" id="form2Example27"
												class="form-control form-control-lg" name="price1" />

										</div>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Stock</label>
											<input type="text" id="form2Example27"
												class="form-control form-control-lg" name="stock1" />

										</div>
										<div class="form-outline mb-1">
											<label class="form-label" for="form2Example27">Category
												Type</label> <select name="category1" class="form-select"
												aria-label="Default select example">
												<option  value="All" selected>All</option>
												<option value="South">South</option>
												<option value="North">North</option>
												<option value="Chinese">Chinese</option>
												<option value="Italian">Italian</option>
											</select>

										</div>


										<div class="pt-1 mb-1">
											<button class="btn btn-dark btn-lg btn-block" type="submit">Add
												to DataBase</button>
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


	<!--Including Navbar in Login -->
	<%@ include file="components/footer.jsp"%>
</body>
</html>