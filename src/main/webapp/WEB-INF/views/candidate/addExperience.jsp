<%@ include file="../header.jspf"%>

<div class="container">
<h1>Add Experience</h1>
	<form modelAttribute="experience" action="../addExperience/${candidate.id}" method="post">
		<table width="100%">
			<tr> 
	 			<td>Title:</td>
	 			<td><input type="text" class="form-control" name="position" id="position"  placeholder="Ex: Manager"></td>
	 		</tr>
			<tr> 
	 			<td width="20%">Company Name:</td>
	 			<td><input type="text" class="form-control" name="companyName" id="companyName"  placeholder="Ex: Microsoft"></td>
	 		</tr>
	 		
	 		<tr> 
	 			<td>Address:</td>
	 			<td>
	 				<table>
	 					<tr>
	 						<td>City:</td> <td><input type="text" class="form-control" name="companyAddress.city" id="companyAddress.city"  placeholder="Ex: California"></td>
	 					</tr>
	 					<tr>
	 						<td>State:</td> <td><input type="text" class="form-control" name="companyAddress.state" id="companyAddress.state"  placeholder="Ex: Iowa"></td>
	 					</tr>
	 					<tr>
	 						<td>Zip:</td> <td><input type="text" class="form-control" name="companyAddress.zip" id="companyAddress.zip"  placeholder="Ex: 52557"></td>
	 					</tr>
	 				</table>
	 			</td>
	 		</tr>
	 		<tr> 
	 			<td>Description:</td>
	 			<td><textarea class="form-control" rows="5" name="description" id="description" placeholder="Enter description of the work" ></textarea> </td>
	 		</tr>
	 		<tr> 
	 			<td>Time Period:</td>
	 			<td>
	 				<table>
	 					<tr>
	 						<td>
	 							<div>From</div>
	 							<div>
	 								<select name="fromMonth">
	 									<option value="">Month</option>
	 									<c:forEach var="monthInt" items="${months}">
	 										<option value="${monthInt}">${mapMonths[monthInt]}</option>
	 									</c:forEach>
									</select>
	 							</div>
	 							<div>	 							
	 								<select name="fromYear">
	 									<option value="">Year</option>
	 									<c:forEach var="year" items="${years}">
	 										<c:choose>
	 											<c:when test="${year == selectedYear }">
	 												<option value="${year}" selected>${year}</option>
	 											</c:when>
	 											<c:otherwise>
	 												<option value="${year}">${year}</option>
	 											</c:otherwise>
	 										</c:choose>
	 										
	 										
	 									</c:forEach>
									</select>
	 							</div>	 							
	 						</td>
	 						<td>&nbsp;</td>
	 						<td>
	 							<div>To</div>
	 							<div>
	 								<select name="toMonth">
	 									<option value="">Month</option>
	 									<c:forEach var="monthInt" items="${months}">
	 										<option value="${monthInt}">${mapMonths[monthInt]}</option>
	 									</c:forEach>
									</select>
	 							</div>
	 							<div>	 							
	 								<select name="toYear">
	 									<option value="">Year</option>
	 									<c:forEach var="year" items="${years}">
	 										<c:choose>
	 											<c:when test="${year == selectedYear }">
	 												<option value="${year}" selected>${year}</option>
	 											</c:when>
	 											<c:otherwise>
	 												<option value="${year}">${year}</option>
	 											</c:otherwise>
	 										</c:choose>
	 										
	 										
	 									</c:forEach>
									</select>
	 							</div>
	 						
	 						</td>
	 					</tr>
	 				</table>
	 				<div class="form-check">
						<label class="form-check-label">
							<input class="form-check-input" type="checkbox" name="isCurrentlyWorkHere"> I currently work here
						</label>
					</div>
					<div>
						
					</div>
								 
	 				<!-- <table>
	 					<tr>
	 						<td>
	 							 <div class="form-check">
								    <label class="form-check-label">
								      <input class="form-check-input" type="checkbox"> I currently work here
								    </label>
								 </div>
	 						</td> 
	 					</tr>
	 					<tr>
	 						<td>State:</td> <td><input type="text" class="form-control" name="companyAddress.state" id="companyAddress.state"  placeholder="Enter company's state"></td>
	 					</tr>
	 					<tr>
	 						<td>Zip:</td> <td><input type="text" class="form-control" name="companyAddress.zip" id="companyAddress.zip"  placeholder="Enter company's zip"></td>
	 					</tr>
	 				</table> -->
	 			</td>
	 		</tr>
	 		
		</table>
		<div><button  type="submit" class="btn btn-primary">Save</button></div> 
	</form>

</div>

<%@ include file="../footer.jspf"%>