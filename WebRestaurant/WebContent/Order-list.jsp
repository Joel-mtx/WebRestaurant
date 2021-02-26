<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="navigationServlet">
	<table>
	<tr>
			<th> </th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Food</th>
			<th>Beverage</th>
			<th>Total</th>
			</tr>
		<c:forEach items="${requestScope.allOrders}" var="currentorder">
			<tr>
				<td><input type="radio" name="id" value="${currentorder.id}"></td>
				<td>${currentorder.name}</td>
				<td>${currentorder.quantity}</td>
				<td>${currentorder.food}</td>
				<td>${currentorder.beverage}</td>
				<td>${currentorder.total}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Edit" name="doThisToOrder">
	<input type="submit" value="Delete" name="doThisToOrder">
	<input type="submit" value="Add" name="doThisToOrder">
</form>
</body>
</html>