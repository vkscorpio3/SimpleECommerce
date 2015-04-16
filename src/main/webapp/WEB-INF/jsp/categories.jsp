<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>


</head>
<body>
	<h1>Create Category</h1>
	<form:form method="post" action="createCategory" commandName="category">
		<table border="0">
			<tr>
				<td>Category Name</td>
				<td><form:input path="categoryName" /></td>
			</tr>
			<tr>
				<td>Parent Category</td>
				<td><form:select path="parentCategory">
						<form:option value="-1" label="Top Parent" />
						<form:options items="${categoryList}" itemLabel="categoryName"
							itemValue="categoryId" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Create Category" /></td>
			</tr>
		</table>
	</form:form>

	<h1>List of Categories</h1>
	<table>
		<thead>
			<tr>
				<th>Category Name</th>
				<th>Parent Category Name</th>
				<th>Sub Category</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="val">
				<tr>
					<td><c:out value="${val.categoryName}" /></td>
					<td><c:out value="${val.parentCategory.categoryName}" /></td>
					<td><c:forEach items="${val.subCategories}" var="val2">
					<c:out value="${val2.categoryName}" />
					</c:forEach>
					</td>
					<td><a href="edit/${val.categoryId}">Edit</a></td>
					<td><a href="delete/${val.categoryId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>