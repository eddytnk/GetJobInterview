<%@ include file="../header.jspf"%>

<div class="container">
<div><img src="${candidate.pictureLocalURL}" class="img-thumbnail" alt="${candidate.name}" width="304" height="236" /></div>
<security:authorize access="hasRole('ROLE_CANDIDATE')">
	<c:if test="${candidate.id == userCandidate.id}">
		<div><a href="../editProfilePict/${candidate.id}">Change Profile Picture</a> </div>
	</c:if>
</security:authorize>
<h1>Candidate Profile</h1>
<div style="color:red">${message }</div>
		<fieldset> 					
 			<div id="basicInfo" class="collapse  show" >
 				<security:authorize access="hasRole('ROLE_CANDIDATE')">
 					<c:if test="${candidate.id == userCandidate.id}">
 						<div> <a href="../editBasicInfo/${candidate.id}">Edit Basic Info</a> </div>
					</c:if>
				</security:authorize>				 				 				
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
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}">
 					<a href="../editAddress/${candidate.id}">Edit Address</a>
				</c:if>
			</security:authorize>
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
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#workExperiences">Work Experiences</button> 			
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}"> 					
 					<a href="../addExperience/${candidate.id}">Add Work Experience</a>
				</c:if>
			</security:authorize> 			
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
	 							<security:authorize access="hasRole('ROLE_CANDIDATE')">
	 								<c:if test="${candidate.id == userCandidate.id}">
		 								<div class="row">
		 									<div class="col">
		 										<a href="../editExperience/${experience.id }">
		 												<button class="btn btn-link btn-sm">Edit</button>
		 										</a>
		 									</div>
		  									<div class="col">
		  										<form:form action="../deleteExperience/${experience.id }" method="POST">
													<button type="submit" class="btn btn-link btn-sm">Remove</button>
												</form:form>
											</div>
											<div class="col"></div>  <div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div><div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div> 									
		 								</div> 			
									</c:if>					
								</security:authorize>	 							
	 						</td>
	 					</tr>

 					</c:forEach>
 				</table>
 			
 			</div>
 		</fieldset>
 		<br>
 		<fieldset> 
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#educations">Educations</button>
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}">
 					<a href="../addEducation/${candidate.id}">Add Education</a>
				</c:if>
			</security:authorize> 			
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
	 							<security:authorize access="hasRole('ROLE_CANDIDATE')">
	 								<c:if test="${candidate.id == userCandidate.id}">
		 								<div class="row">
		 									<div class="col">
		 										<a href="../editEducation/${education.id }">
		 												<button class="btn btn-link btn-sm">Edit</button>
		 										</a>
		 									</div>
		  									<div class="col">
		  										<form:form action="../deleteEducation/${education.id }" method="POST">
													<button type="submit" class="btn btn-link btn-sm">Remove</button>
												</form:form>
											</div>
											<div class="col"></div>  <div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div><div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div> 									
		 								</div> 	
									</c:if>							
								</security:authorize>	 							
 							</td>
 						</tr> 					
 					</c:forEach>
 				</table> 			
 			</div> 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#skills">Skills</button>
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}">
 					<a href="../addSkill/${candidate.id}">Add Skill</a>
				</c:if>
			</security:authorize> 			
 			<div id="skills" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="skill" items="${candidate.skills}">
 						<tr>
 							<td>
 								<div>${skill.title }</div>
 								<div>Description: ${skill.description }</div>
 								<security:authorize access="hasRole('ROLE_CANDIDATE')">
 									<c:if test="${candidate.id == userCandidate.id}">
	 									<div class="row">
		 									<div class="col">
		 										<a href="../editSkill/${skill.id }">
		 												<button class="btn btn-link btn-sm">Edit</button>
		 										</a>
		 									</div>
		  									<div class="col">
		  										<form:form action="../deleteSkill/${skill.id }" method="POST">
													<button type="submit" class="btn btn-link btn-sm">Remove</button>
												</form:form>
											</div>
											<div class="col"></div>  <div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div><div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div> 									
		 								</div>
									</c:if>
								</security:authorize>
 							</td>
 						</tr>
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#interests">Interests</button> 			
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}"> 			
 					<a href="../addInterest/${candidate.id}">Add Interest</a>
				</c:if>
			</security:authorize>
 			<div id="interests" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="interest" items="${candidate.interests}">
 						<tr>
 							<td>
 								<div>${interest.title }</div>
 								<div>Description: ${interest.description }</div>
 								<security:authorize access="hasRole('ROLE_CANDIDATE')">
 									<c:if test="${candidate.id == userCandidate.id}">
	 									<div class="row">
		 									<div class="col">
		 										<a href="../editInterest/${interest.id }">
		 												<button class="btn btn-link btn-sm">Edit</button>
		 										</a>
		 									</div>
		  									<div class="col">
		  										<form:form action="../deleteInterest/${interest.id }" method="POST">
													<button type="submit" class="btn btn-link btn-sm">Remove</button>
												</form:form>
											</div>
											<div class="col"></div>  <div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div><div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div> 									
		 								</div>
									</c:if>
								</security:authorize>
 							</td>
 						</tr>
 					</c:forEach>
 				</table> 			
 			</div>
 			
 		</fieldset>
 		<br>
 		<fieldset> 
 			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#accomplishments">Accomplishments</button> 			
 			<security:authorize access="hasRole('ROLE_CANDIDATE')">
 				<c:if test="${candidate.id == userCandidate.id}">
 					<a href="../addAccomplishment/${candidate.id}">Add Accomplishment</a>
				</c:if>
			</security:authorize> 			
 			<div id="accomplishments" class="collapse  show" >
 				<table class="table">
 					<c:forEach var="accomplishment" items="${candidate.accomplishments}">
 						<tr>
 							<td>
 								<div>${accomplishment.title }</div>
 								<div>Description: ${accomplishment.description }</div>
 								<security:authorize access="hasRole('ROLE_CANDIDATE')">
 									<c:if test="${candidate.id == userCandidate.id}">
	 									<div class="row">
		 									<div class="col">
		 										<a href="../editAccomplishment/${accomplishment.id }">
		 												<button class="btn btn-link btn-sm">Edit</button>
		 										</a>
		 									</div>
		  									<div class="col">
		  										<form:form action="../deleteAccomplishment/${accomplishment.id }" method="POST">
													<button type="submit" class="btn btn-link btn-sm">Remove</button>
												</form:form>
											</div>
											<div class="col"></div>  <div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div><div class="col"></div> <div class="col"></div> <div class="col"></div> <div class="col"></div> 									
		 								</div>
									</c:if>
								</security:authorize> 								
 							</td>
 						</tr>
 					</c:forEach>
 				</table>
 			
 			</div>
 			
 		</fieldset>
		
</div>

<%@ include file="../footer.jspf"%>