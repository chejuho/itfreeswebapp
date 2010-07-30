package store.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.handler.StoreDeleteHandler;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class StoreDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("StoreDeleteAction.start");
			StoreDeleteHandler handler = new StoreDeleteHandler();
			
			String id = request.getParameter("id");
//			cate_code_1 = request.getParameter("cate_code_1");
//			cate_code_2 = request.getParameter("cate_code_2");
			result = handler.deleteStoreInfo(id);
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0014", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreDeleteAction.end");
		}
		if (result) {
			request.setAttribute("Message", "Success to Delete Store info");
			String forwardUrl = "/StoreSearch?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				forwardUrl = "/MyWrite?sort=3";
			}
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {

			request.setAttribute("Message", "Fail to Delete Store info");
			this.getServletContext().getRequestDispatcher("/StoreDetail")
					.forward(request, response);
		}
	}
}