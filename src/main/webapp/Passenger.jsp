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

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 500px;
  padding: 16px;
  background-color: white;
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
</style>
</head>
<body>
<%
System.out.println("request.getAttribute(airlineId) :-------> "+ request.getAttribute("airlineId")) ;
pageContext.setAttribute("airlineId", request.getAttribute("airlineId"));
pageContext.setAttribute("departureDate", request.getAttribute("departureDate"));
%>
<div class="bg-img">

  <form action="${pageContext.request.contextPath}/PassengerController" method="post"  class="container">
  <h3>Passenger Details</h3>
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstName" placeholder="Your First name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastName" placeholder="Your last name..">
    
     <label for="emailId">Email Id</label>
    <input type="text" id="emailId" name="emailId" placeholder="Your Email Id..">
    
     <label for="mobileNo">Mobile Number</label>
    <input type="text" id="mobileNo" name="mobileNo" placeholder="Your Mobile No..">
    
    <label for="address">Address</label>
    <input type="text" id="address" name="address" placeholder="Your Address..">
    
     <label for="address">No. Of Passengers</label>
    <input type="text" id="totalSeats" name="totalSeats" placeholder="No. of Passengers........">
    
    <input type="hidden" name="airlineId" value ="${airlineId}" >
    <input type="hidden" name="departureDate" value ="${departureDate}" >
    <input type="submit" value="Submit" name="submit">
  </form>
</div>
</body>
</html>
