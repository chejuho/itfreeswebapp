package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class MemberLoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberLoginAction.start");
		HttpSession session = request.getSession();
		MemberBean userBean = new MemberBean();
		MemberLoginHandler memberLoginHandler = new MemberLoginHandler();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		userBean.setUserid(id);
		userBean.setPassword(pw);

		boolean result;

		try {
			result = memberLoginHandler.loginPro(id, pw);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0026", e);
		} finally {
			KankokujinLogger.getInstance().debug("MemberLoginAction.end");
		}
		if (result) {
			MemberBean memberInfo = new MemberBean();
			try {
				memberInfo = memberLoginHandler.getMemberInfo(id);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0003", e);
			} finally {
				KankokujinLogger.getInstance().debug("MemberLoginAction.end");
			}
			session.setAttribute("memberInfo", memberInfo);
			this.getServletContext().getRequestDispatcher("/jsp/member/login_result.jsp")
			.forward(request, response);			

		} else {
			request.setAttribute("Message", "WAR0003");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		}
	}
}
