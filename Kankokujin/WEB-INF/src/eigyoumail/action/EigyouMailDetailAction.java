package eigyoumail.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.handler.EigyouMailDetailHandler;

public class EigyouMailDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EigyoumailBean bean = new EigyoumailBean();
		try {
			KankokujinLogger.getInstance().debug("EigyouMailDetailAction.start");

			String mailId = request.getParameter("id");
			EigyouMailDetailHandler eigyouMailDetailHandler = new EigyouMailDetailHandler();
			bean = eigyouMailDetailHandler.getEigyoumailBean(mailId);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"EigyouMailDetailAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("EigyouMailDetailAction.end");
		}
		request.setAttribute("EigyoumailBean", bean);
		this.getServletContext().getRequestDispatcher("/jsp/eigyoumail/eigyouMailDetail.jsp")
				.forward(request, response);

	}
}
