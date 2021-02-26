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
	<form action="editOrderServlet" method="post">
	Name; <input type="text" name="name" value="${orderToEdit.name}">
	Quantity: <input type="text" name="quantity" value="${orderToEdit.quantity}">
	Food: <input type="text" name="food" value="${orderToEdit.food}">
	Beverage: <input type="text" name="beverage" value="${orderToEdit.beverage}">
	<input type="hidden" name="id" value="${orderToEdit.id}">
	<input type="submit" value="Save Changes">
	</form>
</body>
</html>