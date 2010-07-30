package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.category.MCategoryUtil;

import common.bean.MemberBean;
import common.exception.SysException;
import common.util.Util;


public class AFlashcardCategoryEditOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categoryName = "";
		HttpSession session = request.getSession();
		
		if (!Util.isLogin(request, "M_memberInfo")) {
			session.setAttribute("Msg", "NO_LOGIN");
			this.getServletContext().getRequestDispatcher("/jsp/aflashcard/aflashcardCateInputOpen.jsp").forward(request, response);
			return;
		}
		String sign = request.getParameter("sign");
		
		MemberBean memberBean = (MemberBean) session.getAttribute("M_memberInfo");
		
		String userId = memberBean.getUserid();
		String code = (String) session.getAttribute("code");
		
		if ("edit".equals(sign)) {
			try {
				categoryName = MCategoryUtil.getCategoryName(userId, code);
			} catch (SysException e) {
				e.printStackTrace();
			} 
		} 
		
		
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("sign", sign);
		
		this.getServletContext().getRequestDispatcher("/jsp/aflashcard/aflashcardCateInputOpen.jsp").forward(request, response);
		
	}
}