package org.simplilearn.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.app.dao.CityDao;
import org.simplilearn.app.dao.CityDaoImpl;
import org.simplilearn.app.dao.UserDao;
import org.simplilearn.app.dao.UserDaoImpl;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.entities.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	
	if(request.getParameter("bookFlight")!= null)
	{
		System.out.println("Inside CityList Servlet............");
		CityDao dao =new CityDaoImpl();

		List<City> sourceList = dao.getSourceList();
		List<City> destinationList = dao.getDestinationList();

		request.setAttribute("sourceList", sourceList);
		request.setAttribute("destinationList", destinationList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("FlightSearch.jsp");
		rd.forward(request, response);
	}
	if(request.getParameter("login")!=null) {
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		
	}
	
	

	/*
	 * User user = new User(); UserDao dao = new UserDaoImpl();
	 * user.setUsername(request.getParameter("username"));
	 * user.setPassword(request.getParameter("password"));
	 * System.out.println("Inside LoginServlet"); if(dao.validateUser(user)) {
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("FlightSearch.jsp");
	 * rd.forward(request, response); } {
	 * 
	 * 
	 * request.setAttribute("msg", "Invalid User");
	 * 
	 * }
	 */
}
}
