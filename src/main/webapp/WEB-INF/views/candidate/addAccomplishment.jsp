<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Accomplishment</h1>
	<form modelAttribute="accomplishment" action="../addAccomplishment/${candidate.id}" method="post">
		<table width="100%">
			<tr> 
	 			<td width="20%">Title:</td>
	 			<td><input type="text" class="form-control" name="title" id="title"  placeholder="Ex: Best Programmer of the Month Award, Outstanding Project Award "></td>
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