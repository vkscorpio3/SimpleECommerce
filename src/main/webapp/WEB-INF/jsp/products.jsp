<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Product</h1>
	<form:form method="post" action="createProduct" commandName="product">
		<table border="0">
			<tr>
				<td>Category Name</td>
				<td><form:input path="productName" /></td>
			</tr>

			<tr>
				<td>Product Brand</td>
				<td><form:select path="productBrand.brandName">
						<form:option value="-1" label="No Brand" />
						<form:options items="${brandList}" itemValue="brandId"
							itemLabel="brandName" />
					</form:select></td>
			</tr>
			<tr>
				
				<td>Product Category</td>
				<td><ul>
						<c:forEach items="${categoryList}" var="val">
							<li><form:checkbox path="${categories}"
									value="${val.categoryId}" label="${val.categoryName}" /></li>
						</c:forEach>
					</ul></td>
		
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Create Product" /></td>
			</tr>
		</table>
	</form:form>

	<h1>List of Products</h1>
	<table>
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Product Brand</th>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="val">
				<tr>
					<td><c:out value="${val.productName}" /></td>
					<td><c:out value="${val.productBrand.brandName}" /></td>
					<td><a href="edit/${val.productId}">Edit</a></td>
					<td><a href="delete/${val.productId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>