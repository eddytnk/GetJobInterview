<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Candidate</h1>
 
 		<form:form modelAttribute="candidate" action="addCandidate" method="post">
 			<%-- <form:errors path="*" cssClass="errorBlock" element="div"/> --%>
	 		<fieldset>
	 			<legend> Basic Info</legend>
 			
	 			<div class="form-group">
		 			<label for="name">Name:</label> 
		 			<form:input type="text" class="form-control" path="name" placeholder="Enter official name" />
		 			<form:errors path="name" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="emailAddress">E-mail:</label> 
		 			<form:input type="text" class="form-control" path="emailAddress" placeholder="Enter official e-mail address" />
	 				<form:errors path="emailAddress" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="title">Title:</label> 
		 			<form:input type="text" class="form-control"  path="title" placeholder="Enter current job title" />
		 			<form:errors path="title" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="summary">Summary:</label> 		 			
		 			<form:textarea class="form-control" rows="5" path="summary" placeholder="Enter work experience summary"></form:textarea>
	 				<form:errors path="summary" style="color:red" cssClass="error"/>
	 			</div>			
 			
 			</fieldset>
 			<fieldset>
 				<legend>Address</legend>
 				<div class="form-group">
		 			<label for="city">Country:</label> 
		 			<form:input type="text" class="form-control" path="address.country" id="country" placeholder="Ex: USA" />
		 			<form:errors path="address.country" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="state">State:</label> 
		 			<form:input type="text" class="form-control" path="address.state" id="state" placeholder="Ex: Iowa" />
		 			<form:errors path="address.state" style="color:red" cssClass="error"/>
	 			</div>
 				<div class="form-group">
		 			<label for="city">City:</label> 
		 			<form:input type="text" class="form-control" path="address.city" id="city" placeholder="Ex: Fairfield" />
		 			<form:errors path="address.city" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="state">Street:</label> 
		 			<form:input type="text" class="form-control" path="address.street" id="street" placeholder="Ex: Burlington Ave" />
		 			<form:errors path="address.street" style="color:red" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="zip">ZIP:</label> 
		 			<form:input type="text" class="form-control" path="address.zip" id="zip" placeholder="Ex: 52557" />
		 			<form:errors path="address.zip" style="color:red" cssClass="error"/>
	 			</div>	 			
 			</fieldset>
 			<div><button  type="submit" class="btn btn-primary">Save</button></div>
 		</form:form> 
</div>

<%@ include file="../footer.jspf"%>