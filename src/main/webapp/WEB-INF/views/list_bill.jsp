<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bills</title>
</head>
<body>
	<h2>List of All Bills...</h2>
		<table border='1'>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Product</th>
				<th>Amount</th>
				<th>Delete</th>
			</tr>
				<c:forEach var="bill" items="${bills}">
				<tr>
				<td>${bill.firstName}</td>
				<td>${bill.lastName}</td>
				<td>${bill.email}</td>
				<td>${bill.mobile}</td>
				<td>${bill.product}</td>
				<td>${bill.amount}</td>
				<td><a href="deleteBill?id=${bill.id}">delete</a></td>
				</tr>
				
				</c:forEach>		
		</table>
		${msg}
			
</body>
</html>