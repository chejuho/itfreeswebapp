package roomsell.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roomsell.handler.RoomSellDeleteHandler;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class RoomSellDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("RoomSellDeleteAction.start");
			RoomSellDeleteHandler roomSellDeleteHandler = RoomSellDeleteHandler.getInstance();
			int id = Integer.parseInt(request.getParameter("id"));

			result = roomSellDeleteHandler.deleteRoomSellInfo(id);
		} catch (AppException e) {
			throw new KankokujinException("RoomSellDeleteAction", e);
		} catch (Exception e) {
			throw new KankokujinException("RoomSellDeleteAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("RoomSellDeleteAction.end");
		}
		if (result) {
			String cate_code = request.getParameter("search_cate_code_1");
			String forwardUrl = "/RoomSellList?re=9";
			String action = (String) request.getParameter("before");
			
			if ("my_write".equals(action)) {
				if ("C10001".equals(cate_code)) {
					forwardUrl = "/MyWrite?sort=5";
				} else {
					forwardUrl = "/MyWrite?sort=6";
				}
			}
			this.getServletContext().getRequestDispatcher(forwardUrl).forward(request, response);
		} else {

			this.getServletContext().getRequestDispatcher("/RoomSellDetail")
					.forward(request, response);
		}
	}
}