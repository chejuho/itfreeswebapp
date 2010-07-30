package buysell.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buysell.handler.BuySellDeleteHandler;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class BuySellDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("BuySellDeleteAction.start");
			BuySellDeleteHandler handler = new BuySellDeleteHandler();
			String id = request.getParameter("id");
			String flg = request.getParameter("flg");
			result = handler.deleteBuySellInfo(id, flg);
		} catch (AppException e) {
			throw new KankokujinException("BuySellDeleteAction", e);
		} catch (Exception e) {
			throw new KankokujinException("BuySellDeleteAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("BuySellDeleteAction.end");
		}
		if (result) {
			
			String cate_code = request.getParameter("search_cate_code_1");
			String forwardUrl = "/BuySellList?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				if ("C10100".equals(cate_code)) {
					forwardUrl = "/MyWrite?sort=1";
				} else {
					forwardUrl = "/MyWrite?sort=2";
				}
			}
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/BuySellDetail").forward(request, response);
		}
	}
}