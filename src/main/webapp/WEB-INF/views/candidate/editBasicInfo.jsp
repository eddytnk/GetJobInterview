<%@ include file="../header.jspf"%>

<div class="container">
<h1>Edit Basic Info</h1>
		<form:form modelAttribute="candidate" action="../editBasicInfo/${candidate.id}" method="POST">
			<fieldset>
 				<div class="form-group">
 					<label for="name">Name:</label> 
		 			<form:input type="text" class="form-control" path="name" id="name" value ="${candidate.name }" />
		 			<form:errors path="name" cssClass="error"/>
 				</div>
 				<div class="form-group">
		 			<label for="emailAddress">E-mail:</label> 
		 			<form:input type="text" class="form-control" path="emailAddress"  id="emailAddress" value ="${candidate.emailAddress }" />
	 				<form:errors path="emailAddress" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="title">Title:</label> 
		 			<form:input type="text" class="form-control"  path="title" id="title" value ="${candidate.title}" />
		 			<form:errors path="title" cssClass="error"/>
	 			</div>
	 			<div class="form-group">
		 			<label for="summary">Summary:</label> 
		 			<form:textarea class="form-control" rows="5" path="summary" id="summary" value ="${candidate.summary}"/>
		 			<form:errors path="summary" cssClass="error"/>
	 			</div>	 						
 			</fieldset>
 			
 			<div><button  type="submit" class="btn btn-primary">Save Changes</button></div> 
 		</form:form>
 		

</div>

<%@ include file="../footer.jspf"%>