package iboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordInputOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String sign = request.getParameter("sign");
		
		request.setAttribute("id", id);
		request.setAttribute("sign", sign);
		
		this.getServletContext().getRequestDispatcher("/jsp/iboard/passwordOpen.jsp").forward(request, response);
		
	}
}