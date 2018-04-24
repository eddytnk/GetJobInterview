<%@ include file="../header.jspf"%>

<div class="container">
<h1>Edit Address</h1>
		<form modelAttribute="candidate" action="../editAddress/${candidate.id}" method="POST">
 			<fieldset>
 				<table width="100%">
	 				<tr>
	 					<td>Country:</td>
	 					<td><input type="text" class="form-control" name="address.country" id="country" value ="${candidate.address.country }"  ></td>
 					</tr>
 					<tr>
	 					<td>State:</td>
	 					<td><input type="text" class="form-control"  name="address.state" id="state" value ="${candidate.address.state }"  ></td>
 					</tr>
	 				<tr > 
	 					<td width="20%">City:</td>
	 					<td><input type="text" class="form-control" name="address.city" id="city" value ="${candidate.address.city }"  ></td>
	 				</tr>
	 				<tr > 
	 					<td width="20%">Street:</td>
	 					<td><input type="text" class="form-control" name="address.street" id="street" value ="${candidate.address.street}"  ></td>
	 				</tr>
	 				
 					<tr>
	 					<td>Zip Code:</td>
	 					<td><input type="text" class="form-control"  name="address.zip" id="zip"  value ="${candidate.address.zip}"  ></td>
 					</tr>
	 			</table> 			
 			</fieldset>
 			<div><button  type="submit" class="btn btn-primary">Save Changes</button></div> 
 		</form>	
 		

</div>

<%@ include file="../footer.jspf"%>