package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.handler.AdminLoginHandler;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class AdminLoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("AdminLoginAction.start");
		HttpSession session = request.getSession();
		MemberBean userBean = new MemberBean();
		AdminLoginHandler adminLoginHandler = new AdminLoginHandler();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		userBean.setUserid(id);
		userBean.setPassword(Util.password(pw));

		boolean result;

		try {
			result = adminLoginHandler.loginPro(id, Util.password(pw));
		} catch (AppException e) {
			throw new KankokujinException("AdminLoginAction", e);
		} catch (Exception e) {
			throw new KankokujinException("AdminLoginAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("AdminLoginAction.end");
		}
		if (result) {
			MemberBean memberInfo = new MemberBean();
			try {
				memberInfo = adminLoginHandler.getMemberInfo(id);
			} catch (AppException e) {
				throw new KankokujinException("MemberLoginAction", e);
			} catch (Exception e) {
				throw new KankokujinException("MemberLoginAction", e);
			} finally {
				KankokujinLogger.getInstance().debug("MemberLoginAction.end");
			}
			session.setAttribute("memberInfo", memberInfo);
			this.getServletContext().getRequestDispatcher(Const.ADMIN_INDEX_PATH)
					.forward(request, response);
		} else {
			request.setAttribute("Message", "WAR0003");
			this.getServletContext().getRequestDispatcher(Const.ADMIN_INDEX_PATH)
					.forward(request, response);
		}
	}
}
