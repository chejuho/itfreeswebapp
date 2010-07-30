package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.bean.MemberBean;
import common.util.Util;

public class RegistKankokujinOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		bean.setRegistnum(Util.changeNullStr(request.getParameter("registnum")));
		request.setAttribute("MemberBean", bean);
		this.getServletContext().getRequestDispatcher("/jsp/member/registKankokujin.jsp").forward(request, response);

	}

}
