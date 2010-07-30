package findjob.action;

import findjob.handler.FindjobDeleteHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class FindjobDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;

		try {
			KankokujinLogger.getInstance().debug("FindjobDeleteAction.start");
			FindjobDeleteHandler handler = FindjobDeleteHandler.getInstance();
			result = handler.deleteFindjobInfo(request.getParameter("id"));
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0014", e);
		} finally {
			KankokujinLogger.getInstance().debug("FindjobDeleteAction.end");
		}
		if (result) {
			String forwardUrl = "/FindjobSearch?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				forwardUrl = "/MyWrite?sort=9";
			}
			request.setAttribute("Message", "Success to Delete Findjob info");
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {

			request.setAttribute("Message", "Fail to Delete Findjob info");
			this.getServletContext().getRequestDispatcher("/FindjobDetail")
					.forward(request, response);
		}
	}
}