<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">
  	LOGO   
  </a>
</nav>
<div class="container-fluid pt-5 pb-5">
	<div class="row">
	<div class="col-3"></div>
	<div class="col-6">
	<h3>User Information</h3>
	<form method="post" action="register">
		<div class="form-group">
			<label for="username">User name</label> 
			<input type="text" class="form-control" id="username" placeholder="Username" value="${user.username }"> 
		</div>
		<div class="form-group">
			<label for="firstname">First name</label> 
			<input	type="text" class="form-control" id="firstname"
				placeholder="First name"  value="${user.firstname }">
		</div>
		<div class="form-group">
			<label for="lastname">Last name</label> 
			<input	type="text" class="form-control" id="lastname"
				placeholder="Last name"  value="${user.lastname }">
		</div>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="text" class="form-control" id="password"
				placeholder="Password"  value="${user.password }">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			 <input	type="email" class="form-control" id="email"
				placeholder="Email"  value="${user.email }">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	<div class="col-3"></div>
	</div>
</div>
<nav class="navbar bottom navbar-dark bg-dark">
	<a class="navbar-brand" href="#">company name</a>
</nav>

</body>
</html>