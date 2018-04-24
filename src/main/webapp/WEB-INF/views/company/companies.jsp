<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>List of company</h1>
	<table border=1>
		<c:forEach var="company" items="${companies}">
			<tr>
				<td>${company.name}</td>
				<td>${company.emailAddress}</td>
				<td>${company.website}</td>
				<td>${company.address.street}</td>
				<td>${company.address.city}</td>
				<td>${company.address.state}</td>
				<td>${company.address.country}</td>
				<td>${company.address.zipcode}</td>
				<td><c:if
						test="${company.emailAddress==pageContext.request.userPrincipal.name}">
						<a href="companies/${company.getId()}">edit</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<a href="addCompany"> Add a company</a>
</div>
<%@ include file="../footer.jspf"%>