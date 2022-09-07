package org.simplilearn.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.internal.build.AllowSysOut;
import org.simplilearn.app.dao.PassengerDao;
import org.simplilearn.app.dao.PassengerDaoImpl;
import org.simplilearn.app.entities.Flight;
import org.simplilearn.app.entities.Passenger;
import org.simplilearn.app.entities.TicketSummary;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		System.out.print("Indside PassengerController................");
		int airlineId = (Integer.parseInt(request.getParameter("airlineId")));
		Date departureDate = new Date();
		try {
			if(request.getParameter("departureDatehidden")!=null)
			{
			//departureDate = new SimpleDateFormat("mm-dd-yyyy").parse(request.getParameter("departureDateHidden"));
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				departureDate = df.parse(request.getParameter("departureDatehidden"));
			}
		System.out.println("airlineId Inside PaasengerController................"+airlineId);
		
		
		if(request.getParameter("submit")!= null) {
			
			System.out.println("Inside passenger submit condition.....");
			PassengerDao dao = new PassengerDaoImpl();
			
			Passenger psg =new Passenger();
						
			psg.setFirstName(request.getParameter("firstName"));
			psg.setLastName(request.getParameter("lastName"));
			psg.setEmailId(request.getParameter("emailId"));
			psg.setMobileNo(request.getParameter("mobileNo"));
			psg.setAddress(request.getParameter("address"));
			psg.setIsAdmin(request.getParameter("isAdmin"));
			psg.setTotalSeats(Integer.parseInt(request.getParameter("totalSeats")));
			  
			 
			 
			 int passengerId = dao.savePassengerDetails(psg);
			 System.out.println("airlineId............"+airlineId);
			 System.out.println("passengerId.........."+passengerId);
			 
		
			 int bookingId= dao.saveFlightDetails(passengerId,airlineId,departureDate);
			 System.out.println("bookingId............."+bookingId);
			
			 request.setAttribute("airlineId", airlineId);
			 request.setAttribute("passengerId", passengerId);
			 request.setAttribute("bookingId", bookingId);
			 
			 
			 List<TicketSummary> flightDetails = dao.getFlightDetails(bookingId);
			 System.out.println("Flight Details in Passenger controller............."+flightDetails);
			RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
			request.setAttribute("flightDetails", flightDetails);
			rd.forward(request, response);
		}
		}
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		
		if(request.getParameter("bookFlight")!=null) {
			
			System.out.println("Inside Book Flight condition.....");
			int airlineId1 = (Integer.parseInt(request.getParameter("airlineId")));
			try {
				if(request.getParameter("departureDatehidden")!=null) {
				//departureDate = new SimpleDateFormat("mm-dd-yyyy").parse(request.getParameter("departureDatehidden"));
				
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				departureDate = df.parse(request.getParameter("departureDatehidden"));
				}
			
			RequestDispatcher rd = request.getRequestDispatcher("Passenger.jsp");
			request.setAttribute("airlineId", airlineId1);
			request.setAttribute("departureDate", departureDate);
				
			rd.forward(request, response);
			}
			 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}
