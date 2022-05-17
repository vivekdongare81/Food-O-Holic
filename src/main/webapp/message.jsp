<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String errorMessage = (String) request.getSession().getAttribute("msg");
String url1 = "https://static8.depositphotos.com/1431107/919/i/600/depositphotos_9199988-stock-photo-oops-icon.jpg";
String url2 = "https://chpic.su/_data/stickers/y/Yellowboi/Yellowboi_002.webp";
String ans = "";
if (!errorMessage.substring(0, 1).equals(" ")) {
	ans = url1;
} else {
	ans = url2;
}
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="components/header.jsp"%>
<link rel="stylesheet" href="styles/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="components/navbar.jsp"%>
	<div class="container text-center">

		<div>
			<img style="height: 500px; width: 500px" class="pt-5" src=<%=ans%>>
		</div>


		<div style="font-size: 200px;"
			class="row  text-center justify-content-center">
			<h3 class="gradient-multiline">
				<span>errorMessagege %></span>
			</h3>
		</div>
	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>