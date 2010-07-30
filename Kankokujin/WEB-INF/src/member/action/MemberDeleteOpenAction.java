package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.util.Util;

public class MemberDeleteOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 権限チェック
		if (Util.isLogin(request)) {
			this.getServletContext().getRequestDispatcher(
					"/jsp/member/memberDelete.jsp").forward(request, response);

		} else {
			session.setAttribute("action", "MemberDeleteOpen");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);			
		}
	}

}
