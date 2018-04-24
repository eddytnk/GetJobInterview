<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Company Details</h1>
	<form:form modelAttribute="company"
		action="../companies/${company.getId()}" method="post">
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
				<td>Street:</td>
				<td><input type="text" name="address.street"
					value="${company.address.street}" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city"
					value="${company.address.city}" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="address.state"
					value="${company.address.state}" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="address.country"
					value="${company.address.country}" /></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><input type="text" name="address.zipcode"
					value="${company.address.zipcode}" /></td>
			</tr>
		</table>
		<input type="submit" value="update" />
	</form:form>
	<form:form action="../deleteCompany/${company.getId()}" method="get">
		<button type="submit">Delete</button>
		<button id="cancel" name="_eventId_cancel">Cancel</button>
	</form:form>
</div>
<%@ include file="../footer.jspf"%>