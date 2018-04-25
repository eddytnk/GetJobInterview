<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<form method="POST" action="${contextPath}/login"
							class="form-signin">
							<fieldset>
								<div class="form-group">
									<input name="username" type="text" class="form-control"
										placeholder="Username" />  <br/><input
										name="password" type="password" class="form-control"
										placeholder="Password" /><br/><input type="hidden"
										name="${_csrf.parameterName}" value="${_csrf.token}" /> 
									<button class="btn btn-lg btn-primary btn-block" type="submit">Log
										In</button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>