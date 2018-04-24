<%@ include file="../header.jspf"%>

<div class="container">
<h1>Candidate Profile</h1>
		<fieldset>
 			<!-- <legend> Basic Info</legend> -->
 			<!-- <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#basicInfo">Basic Info</button> 	 -->		
 			<div id="basicInfo" class="collapse  show" >
 				<a href="../editCandidate/${candidate.id}">Edit Basic Info</a>
 				<table width="100%"> 
	 				<tr > 
	 					<td width="20%">Name:</td>
	 					<td><input type="text" class="form-control" name="name" id="name" value ="${candidate.name }" readonly  ></td>
	 				</tr>
	 				<tr>
	 					<td>E-mail:</td>
	 					<td><input type="text" class="form-control" name="emailAddress"  id="emailAddress" value ="${candidate.emailAddress }" readonly  ></td>
 					</tr>
 					<tr>
	 					<td>Title:</td>
	 					<td><input type="text" class="form-control"  name="title" id="title" value ="${candidate.title}" readonly ></td>
 					</tr>
 					<tr>
	 					<td>Summary:</td>
	 					<td><textarea class="form-control" rows="5" name="summary" id="summary" readonly>${candidate.summary}</textarea></td>
 					</tr>
 					
 				</table>
 			</div>	 			
 		</fieldset>
 		<br>
 		<fieldset> 

 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#address">Address</button> 			
 			<a href="">Edit Address</a>
 			<div id="address" class="collapse  show" >
	 			<table width="100%">
	 				<tr>
	 					<td>Country:</td>
	 					<td><input type="text" class="form-control" value ="${candidate.address.country }" readonly  ></td>
 					</tr>
 					<tr>
	 					<td>State:</td>
	 					<td><input type="text" class="form-control" value ="${candidate.address.state }" readonly  ></td>
 					</tr>
	 				<tr > 
	 					<td width="20%">City:</td>
	 					<td><input type="text" class="form-control" value ="${candidate.address.city }" readonly  ></td>
	 				</tr>
	 				<tr > 
	 					<td width="20%">Street:</td>
	 					<td><input type="text" class="form-control" value ="${candidate.address.street}" readonly  ></td>
	 				</tr>
	 				
 					<tr>
	 					<td>Zip Code:</td>
	 					<td><input type="text" class="form-control"  value ="${candidate.address.zip}" readonly ></td>
 					</tr>
	 			</table> 			
 			</div>
 		</fieldset>
 		 <br>		
 		<fieldset> 
 			<!-- <legend>Work Experiences</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#workExperiences">Work Experiences</button> 			
 			<a href="../addExperience/${candidate.id}">Add Work Experience</a>
 			<div id="workExperiences" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="experience" items="${candidate.experiences}">
	 					<tr>
	 						<td>
	 							<div>${experience.position}</div>
	 							<div>${experience.companyName}</div>
	 							<div>${mapMonths[experience.fromMonth]} ${experience.fromYear} - ${mapMonths[experience.toMonth]} ${experience.toYear}</div>
	 							<div>${experience.companyAddress.city}, ${experience.companyAddress.state}</div>
	 							<br>
	 							<div>Summary: ${experience.description}</div>
	 							<div><a href="../editExperience/${experience.id }">Edit</a></div>
	 						</td>
	 					</tr>
	 					<!-- <tr>
	 						<td></td>
	 					</tr> -->
 					</c:forEach>
 				</table>
 			
 			</div>
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Educations</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#educations">Educations</button> 			
 			<a href="../addEducation/${candidate.id}">Add Education</a>
 			<div id="educations" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="education" items="${candidate.educations}">
 						<tr>
 							<td>
 								<div>${education.schoolName }</div>
 								<div>${education.degree } , ${education.fieldStudy }  </div>
 								<div>${education.yearFrom } - ${education.yearTo }</div>
 								<br>
	 							<div>Description: ${education.description}</div>
	 							<div><a href="../editEducation/${education.id }">Edit</a></div>
 							</td>
 						</tr>
 					
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Skills</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#skills">Skills</button> 			
 			<a href="">Add Skill</a>
 			<div id="skills" class="collapse  show" >
 				
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Interests</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#interests">Interests</button> 			
 			<a href="">Add Interest</a>
 			<div id="interests" class="collapse  show" >
 				
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Accomplishments</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#accomplishments">Accomplishments</button> 			
 			<a href="">Add Accomplishment</a>
 			<div id="accomplishments" class="collapse  show" >
 				
 			
 			</div>
 			
 		</fieldset>
		<!-- <form modelAttribute="candidate" action="addCandidate" method="post"> -->
 				<%-- <div class="form-group">
 					<label>Name:</label> 
		 			<input type="text" class="form-control" name="name" id="name" value ="${candidate.name }" readonly  >
 				</div> --%>
 				<%-- <div class="form-group">
		 			<label>E-mail:</label> 
		 			<input type="text" class="form-control" name="emailAddress"  id="emailAddress" value ="${candidate.emailAddress }" readonly  >
	 			</div> --%>
	 			<%-- <div class="form-group">
		 			<label>Title:</label> 
		 			<input type="text" class="form-control"  name="title" id="title" value ="${candidate.title}" readonly >
	 			</div> --%>
	 			<%-- <div class="form-group">
		 			<label for="summary">Summary:</label> 
		 			<textarea class="form-control" rows="5" name="summary" id="summary" readonly>${candidate.summary}</textarea>
	 			</div> --%>
</div>

<%@ include file="../footer.jspf"%>