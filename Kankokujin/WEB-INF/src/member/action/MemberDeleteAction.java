package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.handler.MemberDeleteHandler;
import member.handler.MemberUpdateHandler;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MemberDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("MemberDeleteAction.START");
		// 権限チェック
		if (Util.isLogin(request)) {
			MemberBean bean = setMemberBean(request);
			MemberUpdateHandler uHandler = new MemberUpdateHandler();
			MemberDeleteHandler dHandler = new MemberDeleteHandler();
			String userid = bean.getUserid();
			boolean pwCheck = false;
			boolean result = false;
			try {
				pwCheck = uHandler.pwCheck(bean, false);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0001", e);
			}
			// パスワードのチェック
			if (pwCheck) {
				// パスワードのチェックでOK
				try {
					result = dHandler.deleteMemberBean(userid);
				} catch (SysException e) {
					throw new KankokujinException(e.getMessage(), e);
				} catch (Exception e) {
					throw new KankokujinException(
							"SYE0002", e);
				}
				if (result) {
					HttpSession session = request.getSession();
					session.invalidate();
					request.setAttribute("Message", "MSG0019");
					this.getServletContext().getRequestDispatcher(
							Const.INDEX_PATH).forward(request, response);
				} else {
					throw new KankokujinException("ERR0007");
				}
			} else {
				// パスワードのチェックでNG
				request.setAttribute("Message", "WAR0005");
				this.getServletContext().getRequestDispatcher(
						"/MemberDeleteOpen").forward(request, response);
			}
		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		return bean;

	}

}
