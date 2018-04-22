<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add a Company</title>
</head>
<body>
	<foform modelAttribute="company" action="companies" method="post">
	<table>
			<tr>
			<td>Company ID:</td>
			<td><input type="text" name="companyId" /> </td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" /> </td>
		</tr>
		<tr>
			<td>Email Address:</td>
			<td><input type="text" name="emailAddress" /> </td>
		</tr>
		<tr>
			<td>Website:</td>
			<td><input type="text" name="website" /> </td>
		</tr>
	</table>
	<input type="submit"/>

	</form>
</body>
</html>