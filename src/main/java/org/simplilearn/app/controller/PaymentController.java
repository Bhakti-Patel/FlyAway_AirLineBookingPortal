package org.simplilearn.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.app.dao.PassengerDao;
import org.simplilearn.app.dao.PassengerDaoImpl;
import org.simplilearn.app.entities.Flight;
import org.simplilearn.app.entities.TicketSummary;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String cardName=request.getParameter("cardName");
		String cardNo = request.getParameter("cardNo");
		String nameOnCard = request.getParameter("nameOnCard");
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		//String flightDetails = request.getParameter("flightDetails1");
		 //System.out.println("Flight Details in Payment controller............."+flightDetails);
		
		System.out.println("booking Id in Payment controller............."+bookingId);
		
		/*
		 * List<String> card = new ArrayList(); card.set(0, cardName); card.set(1,
		 * cardNo); card.set(2, nameOnCard);
		 */
		
		 PassengerDao dao = new PassengerDaoImpl();
		 System.out.println("Inside Payment Controller before.........");
		 List flightDetails = dao.getFlightDetails(bookingId);
		 System.out.println();
	
		 request.setAttribute("flightDetails", flightDetails);
			request.setAttribute("bookingId", bookingId);
		System.out.println("Inside Payment Controller after.........");
		RequestDispatcher rd =request.getRequestDispatcher("TicketSummary.jsp");
		//request.setAttribute("cardDetails", card);
		
		rd.forward(request, response);
		
}
}
