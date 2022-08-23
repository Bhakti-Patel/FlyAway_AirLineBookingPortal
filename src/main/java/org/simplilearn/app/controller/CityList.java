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
import org.simplilearn.app.entities.City;

/**
 * Servlet implementation class CityList
 */
@WebServlet("/CityList")
public class CityList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		listCity(request,response);
		System.out.println("Inside CityList servlet doGet..........");
	}
	
	private void listCity(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		
		CityDao dao =new CityDaoImpl();
		try {
			System.out.println("Inside CityList Servlet............");
			List<City> sourceList = dao.getSourceList();
			List<City> destinationList = dao.getDestinationList();
			request.setAttribute("sourceList", sourceList);
			request.setAttribute("destinationList", destinationList);
			
			RequestDispatcher rd =request.getRequestDispatcher("FlightSearch.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * 
	 * 
	 * }
	 */

}
