package common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImagePopupOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String k = request.getParameter("title");
		//String title = EnDecoding.decoding(request.getParameter("title"));
		String photo1 = request.getParameter("photo1");
		String photo2 = request.getParameter("photo2");
		String photo3 = request.getParameter("photo3");
		String photo4 = request.getParameter("photo4");
		String photo5 = request.getParameter("photo5");
		
		request.setAttribute("photo1", photo1.replace("/M_", "/L_"));
		request.setAttribute("photo2", photo2.replace("/M_", "/L_"));
		request.setAttribute("photo3", photo3.replace("/M_", "/L_"));
		request.setAttribute("photo4", photo4.replace("/M_", "/L_"));
		request.setAttribute("photo5", photo5.replace("/M_", "/L_"));
		
		this.getServletContext().getRequestDispatcher("/jsp/include/imageViewer.jsp").forward(request, response);
	}
}
