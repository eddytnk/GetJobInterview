<%@ include file="../header.jspf"%>
<%@ include file="./nav.jspf"%>


<div class="container">

<form action="./getinterview" method="post">
		<div id="accordion">
			<c:forEach items ="${categories}" var="category">
			<div class="card">
				<div class="card-header" id="heading${category.id}">
					<h5 class="mb-0">
						<button class="btn btn-link" data-toggle="collapse"
							data-target="#collapse${category.id}" aria-expanded="true"
							aria-controls="collapse${category.id}">${category.name}</button>
					</h5>
				</div>
				<div id="collapse${category.id}" class="collapse show"
					aria-labelledby="heading${category.id}" data-parent="#accordion">
					<div class="card-body">
						<div class="row">
							<c:forEach items ="${category.companies}" var="company">
							<div class="col-md-2">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" name="company"
										value='${company.id}' id="defaultCheck${company.id}"> <label
										class="form-check-label" for="defaultCheck${company.id}"> 
										${company.name}<br /> 
										${company.address.street}
										${company.address.city},
										${company.address.state}, 
										${company.address.country}
									</label>
								</div>
							</div>
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<input type="submit" value="Send Resume" class="btn btn-primary">	
	</form>

</div>
<%@ include file="../footer.jspf"%>