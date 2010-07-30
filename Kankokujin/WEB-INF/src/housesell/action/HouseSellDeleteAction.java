package housesell.action;

import housesell.handler.HouseSellDeleteHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class HouseSellDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("HouseSellDeleteAction.start");
			HouseSellDeleteHandler houseSellDeleteHandler = HouseSellDeleteHandler.getInstance();
			int id = Integer.parseInt(request.getParameter("id"));

			result = houseSellDeleteHandler.deleteHouseSellInfo(id);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HouseSellDeleteAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("HouseSellDeleteAction.end");
		}
		if (result) {
			String forwardUrl = "/HouseSellList?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				forwardUrl = "/MyWrite?sort=7";
			}
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {

			this.getServletContext().getRequestDispatcher("/HouseSellDetail")
					.forward(request, response);
		}
	}
}