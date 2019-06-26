package com.cinguetter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinguetter.model.User;
import com.cinguetter.model.UserFactory;

/**
 * Servlet implementation class UserManager
 */
@WebServlet("/usermanager.html")
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		
		String error = (String) session.getAttribute("error");
		session.removeAttribute("error");
		
		
		if (email != null && password != null && !email.isEmpty() && !password.isEmpty()
				&& UserFactory.getInstance().login(email, password) == true) {
			User user = UserFactory.getInstance().getUser(email);
			request.setAttribute("user", user);
			request.setAttribute("error", error);
		}
		request.getRequestDispatcher("WEB-INF/JSP/user_data.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		
		// Recuperiamo i parametri dal form
		String newName = request.getParameter("name");
		String newSurname = request.getParameter("surname");
		String newEmail = request.getParameter("email");
		String newPassword = request.getParameter("password");
		String newUrlImageProfile = request.getParameter("urlImageProfile");
		String newBirthday = request.getParameter("birthday");
	

		// Se l'utente � loggato
		if (email != null && password != null && !email.isEmpty() && !password.isEmpty()
				&& UserFactory.getInstance().login(email, password) == true) {
			

			// Se la password non � stata inserita recupero la vecchia dalla sessione
			if (newPassword == null || newPassword.isEmpty()) {
				newPassword = password;
			}

			// Aggiorno i dettagli utente 
			// Se la modifica non va a buon fine
			String resultOfEdit=UserFactory.getInstance().editDetails(newName, newSurname, newEmail, newPassword, newUrlImageProfile,
					newBirthday, email);
			if (resultOfEdit.equals("Error, changes not applied, data entry verification") || resultOfEdit.equals("Email is not avaible")) {
				// Mando l'errore al jsp
				session.setAttribute("error", resultOfEdit);
				response.sendRedirect("usermanager.html");
				//request.getRequestDispatcher("WEB-INF/JSP/user_data.jsp").forward(request, response);
			} else {
				
				// Modifche a buon fine: reimposto email e password nella sessione
				session.removeAttribute("email");
				session.removeAttribute("password");

				session.setAttribute("email", newEmail);
				session.setAttribute("password", newPassword);
				
				response.sendRedirect("usermanager.html");
			}
		}else {
			// Dobbiamo registrare un nuovo utente

			// Se la creazione non va a buon fine
			if(UserFactory.getInstance().addUser(newName, newSurname, newEmail, newPassword, newUrlImageProfile, newBirthday) == false) {
				
				// Mando l'errore al jsp
				
				session.setAttribute("error", "User registration failed: email exists");
				response.sendRedirect("usermanager.html");
				
				//request.setAttribute("error", "User registration failed");
				//request.getRequestDispatcher("WEB-INF/JSP/user_data.jsp").forward(request, response);
			}else{
				// La registrazione e andata a buon fine e lo mando al login
				response.sendRedirect("index.html");
			}
		}
	}

}
