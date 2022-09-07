package org.simplilearn.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.app.dao.AdminDao;
import org.simplilearn.app.dao.AdminDaoImpl;
import org.simplilearn.app.dao.CityDao;
import org.simplilearn.app.dao.CityDaoImpl;
import org.simplilearn.app.dao.UserDao;
import org.simplilearn.app.dao.UserDaoImpl;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.entities.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		User user = new User();
		UserDao userdao = new UserDaoImpl();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setUsertype(request.getParameter("userType"));
		
		System.out.println("Inside LoginServlet");
		System.out.println(
				"username:" + user.getUsername() + "password:" + user.getPassword() + "userType:" + user.getUsertype());
		

		if (request.getParameter("bookFlight") != null) {
			System.out.println("Inside CityList Servlet............");

			CityDao dao = new CityDaoImpl();
			List<City> sourceList = dao.getSourceList();
			List<City> destinationList = dao.getDestinationList();

			request.setAttribute("sourceList", sourceList);
			request.setAttribute("destinationList", destinationList);

			RequestDispatcher rd = request.getRequestDispatcher("FlightSearch.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("login") != null) {
			
			request.setAttribute("userDetails", user);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("submitLoginForm") != null) {

			if (userdao.validateUser(user) && user.getUsertype().equals("admin")) {

				System.out.println("User is an Admin......");
				AdminDao admindao = new AdminDaoImpl();

				List<Airlines> airlinesList = admindao.getAirlinesList();

				request.setAttribute("airlinesList", airlinesList);
				request.setAttribute("userDetails", user);
				RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);

			} else if (userdao.validateUser(user) && user.getUsertype().equals("user")) {
				System.out.println("User is not an Admin....");
				CityDao citydao = new CityDaoImpl();
				List<City> sourceList = citydao.getSourceList();
				List<City> destinationList = citydao.getDestinationList();

				request.setAttribute("sourceList", sourceList);
				request.setAttribute("destinationList", destinationList);
				request.setAttribute("userDetails", user);

				RequestDispatcher rd = request.getRequestDispatcher("FlightSearch.jsp");
				rd.forward(request, response);

			} else {

				System.out.println("User is not Registered........");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("msg", "User Not Registered");
				rd.forward(request, response);

			}

		}
		if (request.getParameter("register") != null) {
			if(userdao.validateUser(user)) {
				
				System.out.println("Inside LoginController .....User already registerd");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("msg", "User is Already Registered.");
				rd.forward(request, response);
			}
			else {
				System.out.println("Inside Logi controller......Save user Details");
			userdao.saveUserDetails(user);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "User Registered Successfully.");
			request.setAttribute("userDetails", user);
			rd.forward(request, response);
			}

		}
		if (request.getParameter("changePassword") != null) {

			request.setAttribute("userDetails", user);
			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("savePassword") != null) {
			
			  String userName = request.getParameter("userName"); 
			  String oldPassword = request.getParameter("oldPassword");
			  String newPassword = request.getParameter("newPassword"); 
			  String confirmPassword = request.getParameter("confirmPassword");
			  user.setUsername(userName);
			  user.setPassword(oldPassword);
			  user.setUsertype("admin");
			  
			  if(userdao.validateUser(user) && newPassword.equals(confirmPassword)) {
				  
				  System.out.println("User is validated as an admin updating password.....");
				  
				  user.setPassword(newPassword);
				  int result = userdao.changeAdminPassword(user);
				  if (result > 0) {
					  
					  RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					  request.setAttribute("msg", "Password Changed Successfully.Re-Login with the new Password to proceed.");
					  rd.forward(request, response);
				  }
			  
			  
			  } 
			  else{
			  
			  RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			  request.setAttribute("msg", "Old Password and New Password don't Match.");
			  rd.forward(request, response);
			  
			  }
			 

		}
		if(request.getParameter("logout")!=null) {
			System.out.println("Inside logout...........");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
	}
}
