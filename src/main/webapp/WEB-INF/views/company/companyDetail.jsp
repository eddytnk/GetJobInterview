<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add a company</title>
</head>
<body>
	<form:form modelAttribute="company" action="../companies/${company.getId()}" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${company.name}" />
				</td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="emailAddress"
					value="${company.emailAddress}" /></td>
			</tr>
			<tr>
				<td>Website:</td>
				<td><input type="text" name="website"
					value="${company.website}" /></td>
			</tr>
			<tr>
				<td>zipcode:</td>
				<td><input type="text" name="address.zipcode"
					value="${company.address.zipcode}" /></td>
			</tr>
		</table>
		<input type="submit" value="update" />
	</form:form>
	<form:form action="../deleteCompany/${company.getId()}" method="get">
		<button type="submit">Delete</button>
	</form:form>
</body>
</html>