<%@ include file="../header.jspf"%>

<div class="container">
<h1>Edit Skill</h1>
	<form modelAttribute="skill" action="../editSkill/${skill.id}" method="post">
		<table width="100%">
			<tr> 
	 			<td width="20%">Title:</td>
	 			<td><input type="text" class="form-control" name="title" id="title"  value="${skill.title}"></td>
	 		</tr>
	 		<tr> 
	 			<td>Description:</td>
	 			<td><textarea class="form-control" rows="5" name="description" id="description" >${skill.description}</textarea> </td>
	 		</tr>
	 		
	 		
		</table>
		<div><button  type="submit" class="btn btn-primary">Save</button></div> 
	</form>

</div>

<%@ include file="../footer.jspf"%>