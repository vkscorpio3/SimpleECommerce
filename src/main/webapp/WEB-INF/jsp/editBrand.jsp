<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>


</head>
<body>
	<h1>Edit Brand</h1>
	<form:form commandName="brand" action="edit" method="post">
		<table border="0">
			<tr>
				<td>Brand Name</td>
				<td><form:input path="brandName" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update Brand" /></td>
			</tr>
			<form:hidden path="brandId"/>
		</table>
	</form:form>
</body>
</html>