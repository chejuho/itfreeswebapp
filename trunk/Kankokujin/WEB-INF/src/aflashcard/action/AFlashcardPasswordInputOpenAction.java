package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AFlashcardPasswordInputOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String group_id = request.getParameter("group_id");
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("group_id", group_id);
		
		this.getServletContext().getRequestDispatcher("/jsp/aflashcard/aflashcardPasswordOpen.jsp").forward(request, response);
		
	}
}