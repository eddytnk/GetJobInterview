<%@ include file="../header.jspf"%>

<div class="container">
<h1>Edit Accomplishment</h1>
	<form modelAttribute="accomplishment" action="../editAccomplishment/${accomplishment.id}" method="post">
		<table width="100%">
			<tr> 
	 			<td width="20%">Title:</td>
	 			<td><input type="text" class="form-control" name="title" id="title"  value="${accomplishment.title}"></td>
	 		</tr>
	 		<tr> 
	 			<td>Description:</td>
	 			<td><textarea class="form-control" rows="5" name="description" id="description" >${accomplishment.description}</textarea> </td>
	 		</tr>
	 		
	 		
		</table>
		<div><button  type="submit" class="btn btn-primary">Save Changes</button></div> 
	</form>

</div>

<%@ include file="../footer.jspf"%>