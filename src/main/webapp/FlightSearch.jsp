<%@page import="org.simplilearn.app.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>




<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body>
<div class="bg-img">
	<h1>Search Flights</h1>

	<%
	List<City> sourceList = (List<City>) request.getAttribute("sourceList");
	System.out.println(sourceList);

	List<City> destinationList = (List<City>) request.getAttribute("destinationList");
	System.out.println(destinationList);

	List<Airlines> airlineDetails = (List<Airlines>) request.getAttribute("airlineDetails");
	System.out.println("airlineDetails.................."+airlineDetails);
	
	Date departureDate = (Date)request.getAttribute("departureDate");
	System.out.println("departureDate.................."+departureDate);
	
	
	%>

	<form class="form-inline"	action="${pageContext.request.contextPath}/FlightController" method="post">
		<div>
			<label for="source"><b>Source</b></label>
			 <select name="source" id="source">
				<%
				for (int i = 0; i < sourceList.size(); i++) {
				%>         
				<option value="<%=sourceList.get(i)%>" ><%=sourceList.get(i)%></option>
				<%}%>
			</select> 
			<label for="destination"><b>Destination</b></label>
			 <select name="destination" id="destination">

				<%
				for (int j = 0; j < destinationList.size(); j++) {
				%>         
				<option value="<%=destinationList.get(j)%>" ><%=destinationList.get(j)%></option>
				<%}%>
			</select>
			 <label for="departure"><b>Departure</b></label>
			  <input type="date" id="departureDate" name="departureDate">
			  


			<button type="submit" name="search">Search Flights</button>


		</div>
		</form>
		<br></br>
		
			<div style="overflow-x:auto;">
			<table border="1">
				<% if(airlineDetails != null) {%>
				<tr>
					<th>Airline Name</th>
					<th>Flight No.</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Ticket Price</th>
					<th>Book Now</th>
				</tr>

				<%for(Airlines a :airlineDetails){
					//pageContext.setAttribute("airlineId",a.getAirlineId() );
				%>
				<tr>
					<td><%= a.getAirlineName() %></td>
					<td><%= a.getFlightNo() %></td>
					<td><%= a.getSource() %></td>
					<td><%= a.getDestination() %></td>
					<td><%= a.getDepartureTime() %></td>
					<td><%= a.getArrivalTime() %></td>
					<td><%= a.getTicketPrice() %></td>
					<td>
					<form action="${pageContext.request.contextPath}/PassengerController" method="post" >
  
 				 
  							<button type="submit" name="bookFlight" value ="bookFlight">Book Flight</button>
  							<input type="hidden" id="airlineId" name= "airlineId" value="<%= a.getAirlineId() %>" />
  							<input type="hidden" id="departureDate" name= "departureDatehidden" value="<%= departureDate %>" />
  					</form>
  					</td>

					
					
				</tr>
				<%}
				}%>
			</table>
		</div>
	
</body>
</html>