package engmgn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import engmgn.handler.EngMgnDeleteHandler;

public class EngMgnDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("EngMgnDeleteAction.start");
			EngMgnDeleteHandler handler = new EngMgnDeleteHandler();
			String eng_id = request.getParameter("eng_id");

			result = handler.deleteEngMgnInfo(eng_id);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("EngMgnDeleteAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("EngMgnDeleteAction.end");
		}
		if (result) {
			request.setAttribute("Message", "Success to Delete EngMgn info");
			this.getServletContext().getRequestDispatcher("/EngMgnList")
					.forward(request, response);
		} else {
			request.setAttribute("Message", "Fail to Delete EngMgn info");
			this.getServletContext().getRequestDispatcher("/EngMgnDetail")
					.forward(request, response);
		}
	}
}