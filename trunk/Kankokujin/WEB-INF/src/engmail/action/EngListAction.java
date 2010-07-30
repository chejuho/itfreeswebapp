package engmail.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import engmail.handler.EngListHandler;

public class EngListAction extends HttpServlet {
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
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			try {

				KankokujinLogger.getInstance().debug("EngListAction.start");
				String title = (String) request.getParameter("title");
				String content = (String) request.getParameter("content");

				EngListHandler engListHandler = new EngListHandler();

				List engList = engListHandler.getEngList();

				request.setAttribute("engList", engList);
				request.setAttribute("title", title);
				request.setAttribute("content", content);
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				throw new KankokujinException(
						"EngListAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug("EngListAction.end");
			}
			this.getServletContext().getRequestDispatcher(
					"/jsp/engmail/engList.jsp").forward(request, response);
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}

	}

}