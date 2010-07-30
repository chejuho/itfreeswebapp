package eigyoumail.action;

import interpret.bean.InterpretBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.logger.KankokujinLogger;

public class EigyouMailRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug(
				"EigyouMailRegistOpenAction.start");
		HttpSession session = request.getSession();
		//InterpretBean bean = (InterpretBean)session.getAttribute("InterpretBean");
		//session.setAttribute("InterpretBean", bean);
			this.getServletContext().getRequestDispatcher("/jsp/eigyoumail/eigyouMailRegist.jsp")
					.forward(request, response);
	}
}