package org.simplilearn.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.app.dao.AdminDao;
import org.simplilearn.app.dao.AdminDaoImpl;
import org.simplilearn.app.entities.Airlines;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		AdminDao dao = new AdminDaoImpl();
		
		List<Airlines> airlinesList = dao.getAirlinesList();
		
		request.setAttribute("airlinesList", airlinesList);
		
		RequestDispatcher rd =request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
		
		
	
	}

	
	
}
