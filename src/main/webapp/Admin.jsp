<%@page import="org.simplilearn.app.entities.Airlines"%>
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
</style>
</head>
<body>

<h2>Admin Dashboard</h2>
<%List<Airlines> airlinesList=(List<Airlines>)request.getAttribute("airlinesList");
 System.out.println(airlinesList);
 %>

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

</body>
</html>
