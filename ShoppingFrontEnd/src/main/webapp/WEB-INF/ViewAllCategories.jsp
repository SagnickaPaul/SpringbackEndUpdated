<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<hr/>
<br/><br/><br/>
	
<h1 align="center">View Category</h1>
	<hr/>
	
	<br/><br/><br/>
	
	
	<c:if test="${msg ne null}">
	<h3>${msg}</h3>
	</c:if>
	<table border="1">
		<tr>
			<th>Category Name</th>
			<th>Category Description</th>
		</tr>
		
		<c:forEach items="${categories}" var="category">	
			<tr>
				<td>${category.categoryName}</td>
				<td>${category.description }</td>
				<td><a href="${pageContext.request.contextPath}/updateCategory/${category.categoryId}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteCategory/${category.categoryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>