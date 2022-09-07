<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.simplilearn.app.entities.TicketSummary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head><style>
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
  max-width: 500px;
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
select {
  width: 100%;
  padding: 16px 20px;
  border: none;
  border-radius: 4px;
  background-color: #f1f1f1;
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
<meta charset="ISO-8859-1">


</head>
<body>
<%  List<TicketSummary> flightDetails = (List<TicketSummary>)request.getAttribute("flightDetails");
	request.setAttribute("flightDetails1", flightDetails);
	System.out.println("Flight details in Payment.jsp............."+flightDetails); 
	int bookingId = (Integer)request.getAttribute("bookingId");
%>
<div class="bg-img">
<h1>Payment Details</h1>
<form action="${pageContext.request.contextPath}/PaymentController" method="post" class="container">
<h1><p align="left" >ENTER YOUR CARD DETAILS</p></h1>

	<label for="cardName"><b>CREDIT/DEBIT CARDS</b></label>
	 <select name="type" name="userType" required>
		<option value ="hdfc">HDFC Credit Card</option>
		<option value="admin">HDFC Debit Card</option>
		<option value="admin">ICICI Debit Card</option>
		<option value="admin">ICICI Debit Card</option>
		</select></br>
		
    <label for="cardNo"><b>Card Number</b></label>
    <input type="text" placeholder="Card number" name="cardNo" required>

 	<label for="nameOnCard"><b>Name on Card</b></label>
    <input type="text" placeholder="Name on card" name="nameOnCard" required>

			
    <button type="submit" name="submit" class="btn">Submit</button>
    <input type="hidden" name="bookingId" value="<%= bookingId %>"> 
    
</form>
 </div>
</body>
</html>