<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List of company</title>
</head>
<body>
	<h1>List of company</h1>
	<table border=1>
		<c:forEach var="company" items="${companies}">
			<tr>
				<td>${company.companyId}</td>
				<td>${company.name}</td>
				<td>${company.emailAddress}</td>
				<td>${company.website}</td>
				<td><a href="companies/${company.companyId}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="addCompany"> Add a company</a>
</body>
</html>