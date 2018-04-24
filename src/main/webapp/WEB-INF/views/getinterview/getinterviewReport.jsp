<%@ include file="../header.jspf"%>
<%@ include file="./nav.jspf"%>


<%@ page import="java.util.Date"%>
<div class="container">

	<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="label.sn" /></th>
					<th><spring:message code="label.company" /></th>
					<th><spring:message code="label.send_date" /></th>
					<th><spring:message code="label.feedback" /></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${candidateCompanies}" var="candidateCompany">
				<tr>
					<td>1</td>
					<td>
						${candidateCompany.company.name}<br/>
						<i class="fas fa-link">${candidateCompany.company.website}</i>
					</td>
					<td>${candidateCompany.createdAt}</td>
					<td>${candidateCompany.visited}</td>
				</c:forEach>
				
			</tbody>
	</table>
	
<div id="chartContainer" style="height: 300px; width: 100%;"></div>	

<script type="text/javascript">
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: true, // change to true		
	title:{
		text: "<spring:message code="label.company_and_num_resume_sent" />"
	},
	data: [
	{
		// Change type to "column","bar", "area", "spline", "pie",etc.
		type: "bar",
		dataPoints: [
			<c:forEach items="${candidateCompanyCount.keySet()}" var="candidateCompany">
				{ label: "${candidateCompany}",  y: ${candidateCompanyCount.get(candidateCompany)}  },
			</c:forEach>
		]
	}
	]
});
chart.render();

}
</script>

</div>
<%@ include file="../footer.jspf"%>