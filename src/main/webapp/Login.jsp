<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("images/flight.jpg");

  min-height: 500px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>

</head>
<body>
<div class="bg-img">
<h1>Welcome to FlyAway - Airline Booking Portal</h1>
<form action="${pageContext.request.contextPath}/AdminController" method="get" class="container">
<h1>Login</h1>
    <label for="username"><b>UserName</b></label>
    <input type="text" placeholder="Enter UserName" name="username" required>

 	<label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

	<label for="userType"><b>User Type</b></label>
	 <select name="type" placeholder="Enter UserType" name="userType" required>
		<option value ="user">User</option>
		<option value="admin">Admin</option></select></br>
		
    <button type="submit" class="btn">Login</button>
</form>
 </div>
<p style="color: red">${requestScope.msg}</p>
</body>
</html>