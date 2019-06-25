package com.cinguetter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinguetter.model.Cinguett;
import com.cinguetter.model.CinguettFactory;
import com.cinguetter.model.UserFactory;


@WebServlet("/home.html")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Home() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cinguettList",CinguettFactory.getInstance().getCinguetts(10));
		request.setAttribute("userMap",UserFactory.getInstance().getUsersMap(CinguettFactory.getInstance().getCinguetts(10)));
		request.getRequestDispatcher("WEB-INF/JSP/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
