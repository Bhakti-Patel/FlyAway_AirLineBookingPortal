<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<h3>Passenger Details</h3>

<div class="container">
  <form action="${pageContext.request.contextPath}/PassengerController" method="post">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your First name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">
    
     <label for="emailId">Email Id</label>
    <input type="text" id="emailId" name="emailId" placeholder="Your Email Id..">
    
     <label for="mobileNo">Mobile Number</label>
    <input type="text" id="mobileNo" name="mobileNo" placeholder="Your Mobile No..">
    
    <label for="address">Address</label>
    <input type="text" id="address" name="address" placeholder="Your Address..">
    
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
