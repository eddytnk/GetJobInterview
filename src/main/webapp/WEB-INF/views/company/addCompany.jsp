<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Add Company</h1>

	<form:form modelAttribute="company" action="companies" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="emailAddress" /></td>
			</tr>
			<tr>
				<td>Website:</td>
				<td><input type="text" name="website" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="address.street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="address.state" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="address.country" /></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><input type="text" name="address.zipcode" /></td>
			</tr>
		</table>
		<input type="submit" />

	</form:form>
</div>
<%@ include file="../footer.jspf"%>