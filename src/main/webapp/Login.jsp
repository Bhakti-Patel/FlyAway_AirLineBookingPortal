<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="org.simplilearn.app.entities.User"%>
<%@ page import =  "java.util.*"%>

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

  min-height: 1000px;

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
select {
  width: 100%;
  padding: 16px 20px;
  border: none;
  border-radius: 4px;
  background-color: #f1f1f1;
}

</style>

</head>
<body>

<div class="bg-img">
<h1>Welcome to FlyAway - Airline Booking Portal</h1>
<% User user = (User)request.getAttribute("userDetails");
 System.out.println(user);%>
<form action="${pageContext.request.contextPath}/LoginController" method="post" class="container">

<h1>Login</h1>
    <label for="username"><b>UserName</b></label>
    <input type="text" placeholder="Enter UserName" name="username" required>

 	<label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

	<label for="userType"><b>User Type</b></label>
	 <select name="userType" placeholder="Enter UserType" required>
		<option value ="user">User</option>
		<option value="admin">Admin</option>
		
	</select>
		</br>
		</br>
		
    <button type="submit" name="submitLoginForm" class="btn">Login</button>
    <br></br>
     <button type="submit" name="register" class="btn">Register</button>
    <p style="color: red">${requestScope.msg}</p>
</form>
 </div>

</body>
</html>