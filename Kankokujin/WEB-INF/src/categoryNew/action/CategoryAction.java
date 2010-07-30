package categoryNew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;
import common.category.Category;
import common.category.CategoryUtil;
import common.exception.SysException;
import common.util.Util;

public class CategoryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FORWARDURL = "/jsp/bookmark/categoryNavi.jsp";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (!Util.isLogin(request)) {
			session.setAttribute("action", "CategoryManager");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);	
		}
		MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		init(request, session, memberBean.getUserid());
		
		this.getServletContext().getRequestDispatcher(FORWARDURL).forward(request, response);
		
	}

	private void init(HttpServletRequest request, HttpSession session, String userid) {
		try {
			Category treeMenu = CategoryUtil.createTreeCategory(userid);
			session.setAttribute("treeMenu", treeMenu);
			session.setAttribute("code", "0000");
		} catch (SysException e) {
			e.printStackTrace();
		}
		
	}
}
