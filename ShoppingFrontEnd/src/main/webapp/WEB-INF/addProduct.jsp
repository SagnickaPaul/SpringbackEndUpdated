<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Add Product</h1>
	<hr/>
<br/><br/><br/>
<fieldset>
		<legend>Add Product</legend>
		<f:form action="${pageContext.request.contextPath}/addProduct" modelAttribute="pObj"  method="post">	
			<table>
			<c:if test="${pObj.productId ne 0}">
				 <tr>
					<td>Product Id : </td>
					<td><f:input type="text" path="productId" placeholder="Enter your id"/></td>
				</tr>
				</c:if>
			<tr> 
			<td>Product Name :</td>
			<td><f:input type="text" path="productName"/></td>
			</tr>
			<tr>
			<td>Category :</td>
			<td>
			<f:select path="categoryId">
			<f:option value="0">-------Select Category-----------</f:option>
			<c:forEach items="${categories}" var="cObj">
			<f:option value="${cObj.categoryId}">${cObj.categoryName}</f:option>
			</c:forEach>
			</f:select>
			</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="submit">
				</td>
			</tr>
			</table>
			</f:form>
			</fieldset>
</body>
</html>