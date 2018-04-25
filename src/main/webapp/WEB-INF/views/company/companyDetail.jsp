<%@ include file="../header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Company Details</h1>
	<form:form modelAttribute="company"
		action="../companies/${company.getId()}" method="post">
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input type="text" class="form-control" id="name" path="name"
				placeholder="Enter Company name" />
			<form:errors path="name" cssClass="error" />
		</div>

		<div class="form-group">
			<label for="name">Email Address:</label>
			<form:input type="text" class="form-control" path="emailAddress"
				placeholder="Enter email address" />
			<form:errors path="emailAddress" cssClass="error" />
		</div>

		<div class="form-group">
			<label for="name">Web site:</label>
			<form:input type="text" class="form-control" path="website"
				placeholder="Enter webstie " />
			<form:errors path="website" cssClass="error" />
		</div>
		<fieldset>
			<legend>Address</legend>
			<div class="form-group">

				<label for="name">Street:</label>
				<form:input type="text" class="form-control" path="address.street"
					placeholder="Enter street" />
				<form:errors path="address.street" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="name">City:</label>
				<form:input type="text" class="form-control" path="address.city"
					placeholder="Enter city" />
				<form:errors path="address.city" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="name">State:</label>
				<form:input type="text" class="form-control" path="address.state"
					placeholder="Enter state" />
				<form:errors path="address.state" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="name">Country:</label>
				<form:input type="text" class="form-control" path="address.country"
					placeholder="Enter country" />
				<form:errors path="address.country" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="name">Zip code:</label>
				<form:input type="text" class="form-control" path="address.zipcode"
					placeholder="Enter zipcode" />
				<form:errors path="address.zipcode" cssClass="error" />
			</div>
		</fieldset>
		<input type="submit" value="update" id="update" name="_eventId_next" />
		<button type="submit" id="cancel" name="_eventId_cancel">Cancel</button>
	</form:form>
	<form:form action="../deleteCompany/${company.getId()}" method="get">
		<button type="submit">Delete</button>
	</form:form>

</div>
<%@ include file="../footer.jspf"%>