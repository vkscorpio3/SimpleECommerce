<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>


</head>
<body>
	<h1>Edit Product</h1>
	<form:form method="post" action="edit" commandName="product">
		<table border="0">
			<tr>
				<td>Product Name</td>
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
				<td colspan="2" align="center"><input type="submit"
					value="Update Product" /></td>
			</tr>
			<form:hidden path="productId" />
		</table>
	</form:form>
</body>
</html>