package job.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.handler.JobDeleteHandler;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class JobDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("JobDeleteAction.start");
			JobDeleteHandler handler = JobDeleteHandler.getInstance();
			
			result = handler.deleteJobInfo(request.getParameter("id"));
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0014", e);
		} finally {
			KankokujinLogger.getInstance().debug("JobDeleteAction.end");
		}
		if (result) {
			String forwardUrl = "/JobSearch?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				forwardUrl = "/MyWrite?sort=8";
			}
			request.setAttribute("Message", "Success to Delete Job info");
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {

			request.setAttribute("Message", "Fail to Delete Job info");
			this.getServletContext().getRequestDispatcher("/JobDetail")
					.forward(request, response);
		}
	}
}