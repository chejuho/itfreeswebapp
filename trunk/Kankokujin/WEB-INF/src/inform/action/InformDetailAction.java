package inform.action;

import inform.bean.InformBean;
import inform.handler.InformDetailHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class InformDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InformBean informtBean = null;
		InformDetailHandler informDetailHandler = new InformDetailHandler();
		try {
			KankokujinLogger.getInstance().debug("InformDetailAction.start");

			String numId = request.getParameter("id");
			informtBean = informDetailHandler.getInformBean(request, Integer.parseInt(numId));
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"InformDetailAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("InformDetailAction.end");
		}
		request.setAttribute("before", request.getParameter("before"));
		request.setAttribute("InformBean", informtBean);
		this.getServletContext().getRequestDispatcher("/jsp/inform/informDetail.jsp").forward(request, response);
	}
}
