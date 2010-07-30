package inform.action;

import inform.bean.InformBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.logger.KankokujinLogger;

public class InformRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug(
				"InformRegistOpenAction.start");
		HttpSession session = request.getSession();
		InformBean bean = (InformBean)session.getAttribute("InformBean");
		session.setAttribute("InformBean", bean);
			this.getServletContext().getRequestDispatcher("/jsp/inform/informRegist.jsp")
					.forward(request, response);
	}
}