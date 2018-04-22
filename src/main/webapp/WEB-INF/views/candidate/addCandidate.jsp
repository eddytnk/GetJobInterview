<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Candidate</h1>
 
 	<form>
 		<fieldset> 
 			<legend> Basic Info</legend>
 			<table>
 				<tr>
 					<td>Name:</td>
 					<td><input type="text" name="name"/></td>
 				</tr>
 				<tr>
 					<td>Email Address:</td>
 					<td><input type="text" name="emailAddress"/></td>
 				</tr>
 				<tr>
 					<td>Title:</td>
 					<td><input type="text" name="title"/></td>
 				</tr>
 				<tr>
 					<td>Summary:</td>
 					<td><input type="text" name="summary"/></td>
 				</tr>
 			</table>
 			<!-- <div>Name: <input type="text" name="name"/></div>
 			<div>Email Address: <input type="text" name="emailAddress"/></div>
 			<div>Title: <input type="text" name="title"/></div>
 			<div>Summary: <input type="text" name="summary"/></div> -->
 			
 		</fieldset>
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
 		
 		<div><input type="submit" /></div>
 
	</form>
 
</div>

<%@ include file="../footer.jspf"%>