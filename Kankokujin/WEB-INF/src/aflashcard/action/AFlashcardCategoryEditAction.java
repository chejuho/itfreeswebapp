package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.category.MCategory;
import aflashcard.category.MCategoryUtil;


import common.exception.SysException;
import common.util.EnDecoding;

public class AFlashcardCategoryEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String editCategoryName = EnDecoding.decoding(request.getParameter("editCategoryName"));
		
		String code = (String) session.getAttribute("code");
		
		updateCategory(session, editCategoryName, code, userId);
		
		String actionName = (String)session.getAttribute("action");
		response.sendRedirect(actionName);
	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 */
	private void updateCategory(HttpSession session, String categoryName, String code, String userid) {
		try {
			MCategoryUtil.updateCategory(userid, code, categoryName);
			MCategory category = MCategoryUtil.getTreeMenu(session, userid);
			MCategoryUtil.updateCategoryToObject(category, code, categoryName);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}
}