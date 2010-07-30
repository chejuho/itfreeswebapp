package engmail.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import engmail.bean.EngmailBean;
import engmail.handler.EngMailDetailHandler;

public class EngMailDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			EngmailBean bean = new EngmailBean();
			try {
				KankokujinLogger.getInstance().debug(
						"EngMailDetailAction.start");

				String mailId = request.getParameter("id");
				EngMailDetailHandler engMailDetailHandler = new EngMailDetailHandler();
				bean = engMailDetailHandler.getEngmailBean(mailId);
				// System.out.println("subject=" + bean.getSubject());
				printChar(bean.getContents());
				// System.out.println("contents=" + bean.getContents());
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"EngMailDetailAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug("EngMailDetailAction.end");
			}
			request.setAttribute("EngmailBean", bean);
			this.getServletContext().getRequestDispatcher(
					"/jsp/engmail/engMailDetail.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}
	}

	private void printChar(String input) {
		int size = input.length();
		for (int i = 0; i < size; i++) {
			System.out.print(input.charAt(i));
			;
		}
	}
}
