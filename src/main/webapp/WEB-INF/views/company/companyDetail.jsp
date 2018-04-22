<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add a company</title>
</head>
<body>
	<form action="../companies/${company.companyId}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="make" value="${company.name}" /> </td>
		</tr>
		<tr>
			<td>Email Address:</td>
			<td><input type="text" name="emailAddress" value="${company.emailAddress}" /> </td>
		</tr>
		<tr>
			<td>Website:</td>
			<td><input type="text" name="website" value="${company.website}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?companyId=${company.companyId}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>