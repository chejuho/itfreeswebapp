package inform.action;

import inform.bean.InformBean;
import inform.handler.InformUpdateOpenHandler;

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

public class InformUpdateOpenAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("InterpretUpdateOpenAction.start");
		// ���`�F�b�N
		if (Util.isLogin(request)) {
			try {
				InformUpdateOpenHandler informUpdateOpenHandler = new InformUpdateOpenHandler();

				String id = request.getParameter("id");

				InformBean informBean = informUpdateOpenHandler
						.getInformBean(Integer.parseInt(id));
				if (informBean != null) {
					request.setAttribute("informBean", informBean);
				} else {
					request.setAttribute("Message", "ERR0002");
				}
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InformUpdateOpenAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InformUpdateOpenAction.end");
			}
			this.getServletContext().getRequestDispatcher(
					"/jsp/inform/informUpdate.jsp").forward(request,
					response);
		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}
}
