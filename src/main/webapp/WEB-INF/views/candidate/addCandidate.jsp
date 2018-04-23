<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Candidate</h1>
 
 		<form modelAttribute="candidate" action="addCandidate" method="post">
	 		<fieldset>
	 			<legend> Basic Info</legend>
 			
	 			<div class="form-group">
		 			<label for="name">Name:</label> 
		 			<input type="text" class="form-control" name="name" id="name" placeholder="Enter official name"  >
	 			</div>
	 			<div class="form-group">
		 			<label for="emailAddress">E-mail:</label> 
		 			<input type="text" class="form-control" name="emailAddress"  id="emailAddress" placeholder="Enter official e-mail address" >
	 			</div>
	 			<div class="form-group">
		 			<label for="title">Title:</label> 
		 			<input type="text" class="form-control"  name="title" id="title" placeholder="Enter current job title" >
	 			</div>
	 			<div class="form-group">
		 			<label for="summary">Summary:</label> 
		 			<!-- <input type="text" class="form-control"  name="summary" id="summary" placeholder="Enter your summary" > -->
		 			<textarea class="form-control" rows="5" name="summary" id="summary" placeholder="Enter work experience summary"></textarea>
	 			</div>			
 			
 			</fieldset>
 			<fieldset>
 				<legend>Address</legend>
 				<div class="form-group">
		 			<label for="city">City:</label> 
		 			<input type="text" class="form-control" name="address.city" id="city" placeholder="Enter city"  >
	 			</div>
	 			<div class="form-group">
		 			<label for="state">State:</label> 
		 			<input type="text" class="form-control" name="address.state" id="state" placeholder="Enter state"  >
	 			</div>
	 			<div class="form-group">
		 			<label for="zip">ZIP:</label> 
		 			<input type="text" class="form-control" name="address.zip" id="zip" placeholder="Enter ZIP code"  >
	 			</div>
	 			
 			</fieldset>
 			<div><button  type="submit" class="btn btn-primary">Save</button></div>
 		</form>
 		 		
 		<fieldset> 
 			<legend>Work Experiences</legend>
 			<button>Add Work Experience</button>
 			
 		</fieldset>
 		<fieldset> 
 			<legend>Educations</legend>
 			<button>Add Education</button>
 			
 		</fieldset>
 		<fieldset> 
 			<legend>Skills</legend>
 			<button>Add Skill</button>
 			
 		</fieldset>
 		<fieldset> 
 			<legend>Interests</legend>
 			<button>Add Interest</button>
 			
 		</fieldset>
 		<fieldset> 
 			<legend>Accomplishments</legend>
 			<button>Add Accomplishment</button>
 			
 		</fieldset>
 		
 		
 
	
 
</div>

<%@ include file="../footer.jspf"%>