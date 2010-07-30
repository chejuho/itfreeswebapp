package stock.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.handler.CategoryHandler;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class StockListAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean、InterpretSortBean、PageBean、InterpretBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String date_from = request.getParameter("date_from");
			String date_to = request.getParameter("date_to");

		} catch (Exception e) {
			throw new KankokujinException("CategoryListAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("CategoryListAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/stock/categoryList.jsp").forward(request, response);

	}
}