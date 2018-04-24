<%@ include file="../header.jspf"%>

<div class="container">
<h1>Edit Profile Pict </h1>
	<form modelAttribute="candidate" action="../editProfilePict/${candidate.id}" method="POST" enctype="multipart/form-data">
		<table width="100%">
			<tr> 
	 			<td width="20%">File:</td>
	 			<td><input type="file" name="file" /></td>
	 		</tr>
		</table>
		<div><button  type="submit" class="btn btn-primary">Save</button></div> 
	</form>

</div>

<%@ include file="../footer.jspf"%>