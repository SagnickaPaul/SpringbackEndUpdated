<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr/>
<br/><br/><br/>
	
<h1 align="center">View Products</h1>
	<hr/>
	
	<br/><br/><br/>
	
	<table border="1">
		<tr>
			<th>Product Name</th>
		</tr>
		<c:forEach items="${products}" var="pobj">
		<tr>
			<td>${pobj.productName}</td>
			<td><a href="${pageContext.request.contextPath}/deleteProduct/${pobj.productId}">Delete</a></td>
			<td><a href="${pageContext.request.contextPath}/updateProduct/${pobj.productId}">Update</a></td>
		</tr>
		</c:forEach>
	</table>
		
	
</body>
</html>