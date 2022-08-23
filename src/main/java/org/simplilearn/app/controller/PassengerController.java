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
 * Servlet implementation class PassengerController
 */
@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		if(request.getParameter("book")!= null) {
		
			System.out.print("Indside PassengerController................");
			
			RequestDispatcher rd = request.getRequestDispatcher("Passenjer.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("submit")!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Passenjer.jsp");
			rd.forward(request, response);
		}
		else {
			
			
		}
		
		
	}

}
