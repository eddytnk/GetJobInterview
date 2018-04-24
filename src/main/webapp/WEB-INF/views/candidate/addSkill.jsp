<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Skill</h1>
	<form modelAttribute="skill" action="../addSkill/${candidate.id}" method="post">
		<table width="100%">
			<tr> 
	 			<td width="20%">Title:</td>
	 			<td><input type="text" class="form-control" name="title" id="title"  placeholder="Ex: Programmming, Database Design, System Analysis, Teaching, etc"></td>
	 		</tr>
	 		<tr> 
	 			<td>Description:</td>
	 			<td><textarea class="form-control" rows="5" name="description" id="description" placeholder="Enter some description" ></textarea> </td>
	 		</tr>
	 		
	 		
		</table>
		<div><button  type="submit" class="btn btn-primary">Save</button></div> 
	</form>

</div>

<%@ include file="../footer.jspf"%>