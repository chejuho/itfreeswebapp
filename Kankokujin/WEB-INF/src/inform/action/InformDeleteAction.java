package inform.action;

import inform.handler.InformDeleteHandler;

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

public class InformDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		KankokujinLogger.getInstance().debug("InformDeleteAction.start");
		// ���`�F�b�N
		if (Util.isLogin(request)) {
			try {
				InformDeleteHandler informDeleteHandler = new InformDeleteHandler();
				String id = request.getParameter("id");

				result = informDeleteHandler.deleteInformInfo(Integer.parseInt(id));
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InformDeleteAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InformDeleteAction.end");
			}
			if (result) {
				request.setAttribute("Message", "MSG0001");
				this.getServletContext().getRequestDispatcher("/InformList")
						.forward(request, response);
			} else {
				throw new KankokujinException("ERR0001");
			}

		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}

}