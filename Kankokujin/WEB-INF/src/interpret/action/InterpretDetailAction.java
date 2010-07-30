package interpret.action;

import interpret.bean.InterpretBean;
import interpret.handler.InterpretDetailHandler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class InterpretDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InterpretBean interpretBean = new InterpretBean();
		InterpretDetailHandler interpretDetailHandler = new InterpretDetailHandler();
		try {
			KankokujinLogger.getInstance().debug("InterpretDetailAction.start");

			String numId = request.getParameter("id");
			interpretBean = interpretDetailHandler.getInterpretBean(request,
					numId);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"InterpretDetailAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("InterpretDetailAction.end");
		}
		request.setAttribute("interpretBean", interpretBean);
		this.getServletContext().getRequestDispatcher("/jsp/interpret/interpretDetail.jsp")
				.forward(request, response);

	}
}
