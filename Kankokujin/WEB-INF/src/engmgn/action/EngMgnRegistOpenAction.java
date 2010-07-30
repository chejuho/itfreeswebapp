package engmgn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.logger.KankokujinLogger;

public class EngMgnRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("EngMgnRegistOpenAction.start");
		
		this.getServletContext().getRequestDispatcher("/jsp/engmgn/engmgnRegist.jsp")
					.forward(request, response);
		}

	

}