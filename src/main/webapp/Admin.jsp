<%@page import="org.simplilearn.app.entities.Airlines"%>
<%@page import="org.simplilearn.app.entities.User"%>
<%@ page import =  "java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
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

<h2>Admin Dashboard</h2>
<%List<Airlines> airlinesList=(List<Airlines>)request.getAttribute("airlinesList");
 System.out.println(airlinesList);
 User user = (User)request.getAttribute("userDetails");
 System.out.println(user); %>

<div class="bg-img">
<form action="${pageContext.request.contextPath}/LoginController" method="post">

<input type="submit" name="changePassword" value="Change Password">
<br></br>

<input type="submit" name="logout" value="Logout">
<br></br>
<table>
  <tr>
    <th>Id</th>
    <th>Airline Name</th>
    <th>Flight No.</th>
     <th>Source</th>
     <th>Destination</th>
      <th>Departure Time</th>
       <th>Arrival Time</th>
     <th>Ticket Price<th>
  </tr>
         <% for(Airlines a:airlinesList)
        {%>
  <tr>
    <td><%= a.getAirlineId()%></td>
    <td><%= a.getAirlineName()%></td>
        <td><%= a.getFlightNo()%></td>
        <td><%= a.getSource()%></td>
    <td><%= a.getDestination()%></td>
    <td><%= a.getDepartureTime()%></td>
    <td><%= a.getArrivalTime()%></td>
    <td><%= a.getTicketPrice()%></td>
  </tr>
  <%} %>
 
</table>
</form>
</div>
</body>
</html>
