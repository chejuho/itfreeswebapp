package eigyoumail.action;

import interpret.handler.InterpretDeleteHandler;

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
import eigyoumail.handler.EigyouMailDeleteHandler;

public class EigyouMailDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		KankokujinLogger.getInstance().debug("EigyouMailDeleteAction.start");
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			try {
				EigyouMailDeleteHandler eigyouMailDeleteHandler = new EigyouMailDeleteHandler();
				String id = request.getParameter("id");

				result = eigyouMailDeleteHandler.deleteEigyouMailInfo(id);
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"EigyouMailDeleteAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"EigyouMailDeleteAction.end");
			}
			if (result) {
				request.setAttribute("Message", "MSG0016");
				this.getServletContext().getRequestDispatcher("/EigyouMailList")
						.forward(request, response);
			} else {
				throw new KankokujinException("ERR0011");
			}

		} else {
			request.setAttribute("Message", "WAR0010");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}

}