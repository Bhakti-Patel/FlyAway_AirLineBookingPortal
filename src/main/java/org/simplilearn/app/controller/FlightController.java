package org.simplilearn.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.app.entities.Flight;

/**
 * Servlet implementation class FlightController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		if(request.getParameter("book")!= null) {
			
			Flight flt = new Flight();
			
			flt.setFromLocation("fromLocation");
			flt.setToLocation("toLocation");
			flt.setDepartureDate(null);
			flt.setArrivalDate(null);
			flt.setTotalSeats(0);
			
			System.out.print("Indside FLightController................");
			
			RequestDispatcher rd = request.getRequestDispatcher("Passenger.jsp");
			rd.forward(request, response);
		}
		
	}

}
