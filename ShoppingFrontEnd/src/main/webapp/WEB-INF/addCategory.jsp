<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Add category</h1>
<hr/>
<br/><br/><br/>
<fieldset>
		<legend>Login Form</legend>
		<f:form action="addCategory" modelAttribute="cObj"  method="post">	
			<table>
				<tr>
					<td>Category Id : </td>
					<td>
						<f:input type="text" path="categoryId" placeholder="Enter your id"/>
					</td>
				</tr>
				<tr>
					<td>Category Name </td>
					<td>
						<f:input type="text" path="categoryName"/>
					</td>
				</tr>
				<tr>
					<td>Category Description </td>
					<td>
						<f:input type="text" path="description"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="submit"/>
 					</td>
				</tr>
			</table>
		</f:form>
	</fieldset>
	

</body>
</html>