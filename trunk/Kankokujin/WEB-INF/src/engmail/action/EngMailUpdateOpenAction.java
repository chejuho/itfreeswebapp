package engmail.action;

import interpret.bean.InterpretBean;
import interpret.handler.InterpretUpdateOpenHandler;

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

public class EngMailUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("InterpretUpdateOpenAction.start");
		// 権限チェック
		if (Util.isLogin(request)) {
			try {
				InterpretUpdateOpenHandler interpretUpdateOpenHandler = new InterpretUpdateOpenHandler();

				String id = request.getParameter("id");

				InterpretBean interpretBean = interpretUpdateOpenHandler
						.getInterpretBean(id);
				request.setAttribute("InterpretBean", interpretBean);
				request.setAttribute("Message", "ERR0002");
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InterpretUpdateOpenAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InterpretUpdateOpenAction.end");
			}
			this.getServletContext().getRequestDispatcher(
					"/jsp/interpret/interpretUpdate.jsp").forward(request,
					response);
		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}
}
