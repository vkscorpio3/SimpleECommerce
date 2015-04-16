<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>


</head>
<body>
	<h1>Edit Category</h1>
	<form:form method="post" action="edit" commandName="category">
		<table border="0">
			<tr>
				<td>Category Name</td>
				<td><form:input path="categoryName" /></td>
			</tr>
			<tr>
				<td>Parent Category</td>
				<td><form:select path="parentCategory.categoryName">
						<form:option value="-1" label="Top Category" />
						<form:options items="${categoryList}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update Category" /></td>
			</tr>
			<form:hidden path="categoryId" />
		</table>
	</form:form>
</body>
</html>