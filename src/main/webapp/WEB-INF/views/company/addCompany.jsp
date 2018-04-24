<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Add Company</h1>

	<form:form modelAttribute="company" action="companies" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					placeholder="Enter Company name" /></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="emailAddress"
					placeholder="Enter email address" /></td>
			</tr>
			<tr>
				<td>Website:</td>
				<td><input type="text" name="website"
					placeholder="Enter webstie " /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="address.street"
					placeholder="Enter street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city"
					placeholder="Enter city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="address.state"
					placeholder="Enter state" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="address.country"
					placeholder="Enter country" /></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><input type="text" name="address.zipcode"
					placeholder="Enter zipcode" /></td>
			</tr>
		</table>
		<!-- <input type="submit" /> -->
		<button type="submit" id="add" name="_eventId_add">Add</button>
	</form:form>
</div>
<%@ include file="../footer.jspf"%>