package main.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FAQAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			HttpSession session = request.getSession();
			session.setAttribute("topmenu", "");	
			this.getServletContext().getRequestDispatcher(
					"/jsp/main/faq.jsp").forward(request, response);
	}
}