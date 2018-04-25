<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>List of company</h1>
<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Name</th>        
	        <th>Email Address</th>
	        <th>Website</th>
	        <th>Street</th>
	        <th>City</th>	        
	        <th>State</th>
	        <th>Country</th>
	        <th>Zip Code</th>
	        <th>Actions</th>
	      </tr>
	    </thead>
	    <tbody>
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
	    </tbody>
  </table>
	<a href="addCompany"> Add a company</a>
</div>
<%@ include file="../footer.jspf"%>