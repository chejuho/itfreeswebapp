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
import common.util.Util;

public class MemberDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberDetailAction.START");
		HttpSession session = request.getSession();
		session.setAttribute("topmenu", "");
		// 権限チェック
		if (Util.isLogin(request)) {
			MemberLoginHandler handler = new MemberLoginHandler();

			MemberBean memberInfo = new MemberBean();

			memberInfo = (MemberBean) session.getAttribute("memberInfo");

			try {
				memberInfo = handler.getMemberInfo(memberInfo.getUserid());
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0003", e);
			} finally {
				KankokujinLogger.getInstance().debug("MemberDeleteAction.END");
			}
			request.setAttribute("memberInfo", memberInfo);
			this.getServletContext().getRequestDispatcher(
					"/jsp/member/memberDetail.jsp").forward(request, response);
		} else {
			session.setAttribute("action", "MemberDetail");			
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		}
	}

}
