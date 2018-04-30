<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/login.css">


</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<form:form method="POST" id="loginInputFormId" class="form-login"
					modelAttribute="loginForm" action="/login">
					<div class="message">
						<c:if test="${not empty errorMsg}">
							<div class="alert alert-danger">${errorMsg}</div>
						</c:if>
					</div>
					<h2 class="form-signin-heading">Login Form</h2>
					<form:input path="username" class="field"
						placeholder="Email address" />
					<form:password path="password" class="field" placeholder="Password" />
					<button>Sign In</button>
					<p class="message">
						Not registered? <a href="/signup/">Create an account</a>
					</p>
					<a id="forgotPasswordBtnId" class="btn" href="/forgotPassword">Forgot
						your password?</a>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
