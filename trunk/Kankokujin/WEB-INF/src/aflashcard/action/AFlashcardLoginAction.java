package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.handle.AFlashcardDBHandler;


import common.bean.MemberBean;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class AFlashcardLoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberLoginAction.start");
		String actionName = "list";
		HttpSession session = request.getSession();
		MemberBean userBean = null;
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			userBean = commonHandler.loginPro(id, pw);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0026", e);
		} finally {
			KankokujinLogger.getInstance().debug("MemberLoginAction.end");
		}
		if (userBean != null) {
			session.setAttribute("M_memberInfo", userBean);
		} else {
			session.setAttribute("Msg", "LOGIN_ERROR");
		}
		actionName = (String)session.getAttribute("action");
		response.sendRedirect(actionName);
	}
}
