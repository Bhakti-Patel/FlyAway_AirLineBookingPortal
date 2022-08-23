<%@page import="org.simplilearn.app.entities.City"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import =  "java.util.*"%>
 
 
 
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Search Flights </h1>

 <%List<City> sourceList=(List<City>)request.getAttribute("sourceList");
 System.out.println(sourceList);

List<City> destinationList=(List<City>)request.getAttribute("destinationList");
 System.out.println(destinationList);
%>
        
    <form class="form-inline" action="${pageContext.request.contextPath}/FlightController" method="post">
            <label for="source">Source</label>
            <select name="source" id="source">
       <% for(int i=0;i<sourceList.size();i++)
        {%>
     
 		
                      <option value="<%= sourceList.get(i)%>"><%= sourceList.get(i)%></option>
<%}%>
        </select>

          	  <label for="destination">Destination</label>
		<select name="destination" id="destination">

<% for(int j=0;j<destinationList.size();j++)
        {%>
                      <option value="<%= destinationList.get(j)%>"><%= destinationList.get(j)%></option>
        <%}%>
                </select> 	
        
         <label for="departure">Departure</label>
	<input type="date" id="departureDate" name="departureDate">
	
  		
  		<label for="arrival">Arrival</label>
	<input type="date" id="arrivalDate" name="arrivalDate">
  		
 		 <button type="submit" name="book">Book</button>
 		 
 		 <label for="totalNoOfSeats">Seats</label>
 		 <input type="text" id="totalNoOfSeats" name="totalNoOfSeats">
 		 
        
               
    </form>


</body>
</html>