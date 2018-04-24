<%@ include file="../header.jspf"%>

<div class="container">
<!-- <div><img src="C:\Temp\ea_final_project\smile.jpg" class="rounded" alt="Cinque Terre" width="304" height="236"></div> -->
<div><img src="smile.jpg" alt="Cinque Terre" /></div>

<h1>Candidate Profile</h1>
<div style="color:red">${message }</div>
		<fieldset>
 			<!-- <legend> Basic Info</legend> -->
 			<!-- <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#basicInfo">Basic Info</button> 	 -->		
 			<div id="basicInfo" class="collapse  show" >
 				<div> <a href="../editBasicInfo/${candidate.id}">Edit Basic Info</a> </div>
 				<div><a href="../editProfilePict/${candidate.id}">Change Profile Picture</a> </div>
 				
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
 			<a href="../editAddress/${candidate.id}">Edit Address</a>
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
 			<a href="../addSkill/${candidate.id}">Add Skill</a>
 			<div id="skills" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="skill" items="${candidate.skills}">
 						<tr>
 							<td>
 								<div>${skill.title }</div>
 								<div>Description: ${skill.description }</div>
 								<div><a href="../editSkill/${skill.id }">Edit</a></div>
 							</td>
 						</tr>
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Interests</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#interests">Interests</button> 			
 			<a href="../addInterest/${candidate.id}">Add Interest</a>
 			<div id="interests" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="interest" items="${candidate.interests}">
 						<tr>
 							<td>
 								<div>${interest.title }</div>
 								<div>Description: ${interest.description }</div>
 								<div><a href="../editInterest/${interest.id }">Edit</a></div>
 							</td>
 						</tr>
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<!-- <legend>Accomplishments</legend> -->
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#accomplishments">Accomplishments</button> 			
 			<a href="../addAccomplishment/${candidate.id}">Add Accomplishment</a>
 			<div id="accomplishments" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="accomplishment" items="${candidate.accomplishments}">
 						<tr>
 							<td>
 								<div>${accomplishment.title }</div>
 								<div>Description: ${accomplishment.description }</div>
 								<div><a href="../editAccomplishment/${accomplishment.id }">Edit</a></div>
 							</td>
 						</tr>
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
		
</div>

<%@ include file="../footer.jspf"%>