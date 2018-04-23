<%@ include file="../header.jspf"%>

<div class="container">
<h1>Candidates</h1>
	<a href="addCandidate"> Add Candidate</a>
	<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Name</th>        
	        <th>Email</th>
	        <th>Title</th>
	        <th>Summary</th>
	        <th>City</th>
	        <th>State</th>
	        <th>Zip</th>
	        <th>Actions</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="candidate" items="${candidates}">
	    		<tr>
	    			<td>${candidate.name}</td>        
			        <td>${candidate.emailAddress}</td>
			        <td>${candidate.title}</td>
			        <td>${candidate.summary}</td>
			        <td>${candidate.address.city}</td>
			        <td>${candidate.address.state}</td>
			        <td>${candidate.address.zip}</td>
			        <td>
			        	<a href="../candidates/${candidate.id}">detail</a> &nbsp;
			        	<%-- <a href="../editCandidate/${candidate.id}">edit</a> --%>
			        </td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
  </table>
  

</div>

<%@ include file="../footer.jspf"%>