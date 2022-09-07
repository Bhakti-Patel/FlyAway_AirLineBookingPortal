<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="org.simplilearn.app.entities.TicketSummary" %>
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
  max-width: 700px;
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
.form > label
{
  float: left;
  clear: right;
}

.form > input
{
  float: right;
}
</style>
</head>
<body>
    
    <%List<TicketSummary> flightDetails =(List<TicketSummary>)request.getAttribute("flightDetails");
    System.out.println("Flight Details in TicketSummary.jsp.................."+flightDetails);
   
    ArrayList<TicketSummary> tktDetails= (ArrayList)request.getAttribute("flightDetails");
    for(int i=0;i<tktDetails.size();i++){
    %>
    
<div class="bg-img">

  <form action="${pageContext.request.contextPath}/LoginController" method="post"  class="container">
  <h3>Your Ticket is booked Successfully!!!</h3>
  <h4>Ticket Summary</h4>
  <div style="float:left;">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstName" size="20"  value="<%= flightDetails.get(i).getFirstName() %>" readonly>
</div>
<div style="float:right;">
    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastName" size="20" value="<%= flightDetails.get(i).getLastName() %>" readonly>
</div>
<div style="clear:both;">&nbsp;</div>
 <div style="float:left;">
     <label for="flightName">Flight Name</label>
    <input type="text" id="flightName" name="flightName"  size="20" value="<%= flightDetails.get(i).getAirlineName() %>" readonly>
 </div>
 <div style="float:right;">
    <label for="flightNo">Flight No.</label>
    <input type="text" id="flightNo" name="flightNo" size="20" value="<%= flightDetails.get(i).getFlightNo() %>" readonly>
  </div>
    <div style="clear:both;">&nbsp;</div>
 <div style="float:left;">
    <label for="source">From</label>
    <input type="text" id="source" name="source" size="30" value="<%= flightDetails.get(i).getSource() %>" readonly>
  </div>
  <div style="float:right;">
    <label for="destination">To      </label>
    <input type="text" id="destination" name="destination" size="30" value="<%= flightDetails.get(i).getDestination() %>" readonly>
  </div>
    <div style="clear:both;">&nbsp;</div>
    <div style="float:left;">
     <label for="departureDate">Departure Date</label>
    <input type="text" id="departureDate" name="departureDate" size="20" value="<%= flightDetails.get(i).getDepartureDate() %>" readonly>
    </div>
    <div style="float:right;">
     <label for="departureTime">Departure Time</label>
    <input type="text" id="departureTime" name="departureTime"  size="15" value="<%= flightDetails.get(i).getDepartureTime() %>"  readonly>
    </div>
    <div style="clear:both;">&nbsp;</div>
    <div style="float:left;">
    <label for="totalSeats">Total Seats</label>
    <input type="text" id="totalSeats" name="totalSeats" value="<%= flightDetails.get(i).getTotalSeats() %>" readonly>
    </div>
    <div style="float:right;">
    <label for="ticketPrice">Total Price</label>
    <input type="text" id="ticketPrice" name="ticketPrice" value="<%= flightDetails.get(i).getTicketPrice() %>" readonly>
    </div>
    <div style="clear:both;">&nbsp;</div>
     
<% }%>
        <input type="submit" value="Home" name="logout">
  </form>
</div>
</body>
</html>
