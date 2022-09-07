package org.simplilearn.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.app.dao.CityDao;
import org.simplilearn.app.dao.CityDaoImpl;
import org.simplilearn.app.dao.FlightDao;
import org.simplilearn.app.dao.FlightDaoImpl;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.entities.Flight;

/**
 * Servlet implementation class FlightController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Date departureDate = null;
		if (request.getParameter("search") != null) {

			try {
				System.out.print("Inside FlightController................");
				
				
				FlightDao dao= new FlightDaoImpl();
				CityDao cityDao =new CityDaoImpl();
				List<City> sourceList = cityDao.getSourceList();
				List<City> destinationList = cityDao.getDestinationList();

				request.setAttribute("sourceList", sourceList);
				request.setAttribute("destinationList", destinationList);
				String  source= request.getParameter("source");
				System.out.println("Source......................"+request.getParameter("source"));
				String destination = request.getParameter("destination");
				System.out.println("Destination....................."+request.getParameter("destination"));
				if(request.getParameter("departureDate")!=null)
				departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("departureDate"));
				//System.out.println("departureDate...................."+departureDate);
				//Date arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("arrivalDate"));
				
				
				List<Airlines> airlineDetails = dao.getAirlineDetails(source,destination,departureDate);
				
				
				request.setAttribute("airlineDetails", airlineDetails);
				request.setAttribute("source", source);
				request.setAttribute("destination", destination);
				request.setAttribute("departureDate", departureDate);

				RequestDispatcher rd = request.getRequestDispatcher("FlightSearch.jsp");
				rd.forward(request, response);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

	}

}
