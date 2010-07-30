package gourmet.action;

import gourmet.handler.GourmetDeleteHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class GourmetDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("GourmetDeleteAction.start");
			GourmetDeleteHandler handler = GourmetDeleteHandler.getInstance();
			
			result = handler.deleteGourmetInfo(request.getParameter("id"));
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0014", e);
		} finally {
			KankokujinLogger.getInstance().debug("GourmetDeleteAction.end");
		}
		if (result) {
			String forwardUrl = "/GourmetSearch?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				forwardUrl = "/MyWrite?sort=4";
			}
			request.setAttribute("Message", "Success to Delete Gourmet info");
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
			
		} else {

			request.setAttribute("Message", "Fail to Delete Gourmet info");
			this.getServletContext().getRequestDispatcher("/GourmetDetail")
					.forward(request, response);
		}
	}
}