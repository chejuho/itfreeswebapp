package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberNewPWUpdateOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid= (String)request.getParameter("userid");
		String password = (String)request.getParameter("password");
		request.setAttribute("userid", userid);
		request.setAttribute("password", password);
		this.getServletContext().getRequestDispatcher("/jsp/member/memberNewPWUpdate.jsp").forward(request, response);

	}

}
