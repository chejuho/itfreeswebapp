package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;
import common.constant.Const;
import common.util.Util;

public class MemberUpdateOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 権限チェック
		if (Util.isLogin(request)) {
			HttpSession session = request.getSession();
			MemberBean member = (MemberBean) session.getAttribute("memberInfo");
			this.getServletContext().getRequestDispatcher(
					"/jsp/member/memberUpdate.jsp").forward(request, response);

		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}
	}

}
