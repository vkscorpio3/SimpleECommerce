<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Brand</h1>
	<form:form method="post" action="createBrand" commandName="brand">
		<table border="0">
			<tr>
				<td>Brand Name</td>
				<td><form:input path="brandName" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Create Brand" /></td>
			</tr>
		</table>
	</form:form>

	<table>
		<thead>
			<tr>
				<th>Brand</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${brandList}" var="val">
				<tr>
					<td><c:out value="${val.brandName}" /></td>
					<td><a href="edit/${val.brandId}">Edit</a></td>
					<td><a href="delete/${val.brandId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>