package com.cinguetter.controller;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinguetter.model.CinguettFactory;
import com.cinguetter.model.Comment;
import com.cinguetter.model.CommentFactory;
import com.cinguetter.model.PostedMessage;
import com.cinguetter.model.UserFactory;

@WebServlet("/home.html")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");


		if (email != null && password != null && !email.isEmpty() && !password.isEmpty()
				&& UserFactory.getInstance().login(email, password) == true) {
			
			List<PostedMessage> cinguetts = CinguettFactory.getInstance().getCinguetts(10);
			request.setAttribute("cinguettList", cinguetts);
			
			HashMap<Integer, List<Comment>> commentsMap = CommentFactory.getInstance().getCommentsMap(cinguetts);
			request.setAttribute("commentsMap", commentsMap);

			request.setAttribute("cinguettList", cinguetts);
			request.setAttribute("userMap", UserFactory.getInstance().getUsersMap(cinguetts));
			request.getRequestDispatcher("WEB-INF/JSP/home.jsp").forward(request, response);

		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String cinguettText = request.getParameter("cinguett_text");
		String commentText = request.getParameter("comment_text");
		
		if(cinguettText != null) {
			CinguettFactory.getInstance().addCinguett(cinguettText, (String) session.getAttribute("email"));
			
		} else if(commentText != null) {
			CommentFactory.getInstance().addComment(commentText, Integer.parseInt(request.getParameter("cinguettId")) , (String) session.getAttribute("email"));
		}
		doGet(request, response);
	}

}
