package engmail.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import engmail.handler.EngMailDeleteHandler;

public class EngMailDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		KankokujinLogger.getInstance().debug("EngMailDeleteAction.start");
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			try {
				EngMailDeleteHandler engMailDeleteHandler = new EngMailDeleteHandler();
				String id = request.getParameter("id");

				result = engMailDeleteHandler.deleteEngMailInfo(id);
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"EngMailDeleteAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"EngMailDeleteAction.end");
			}
			if (result) {
				request.setAttribute("Message", "MSG0017");
				this.getServletContext().getRequestDispatcher("/EngMailList")
						.forward(request, response);
			} else {
				throw new KankokujinException("ERR0012");
			}

		} else {
			request.setAttribute("Message", "WAR0010");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}

}