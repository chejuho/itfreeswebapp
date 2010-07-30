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

public class AFlashcardCategoryRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String editCategoryName = EnDecoding.decoding(request.getParameter("editCategoryName"));
		
		String code = (String) session.getAttribute("code");
		
		insertCategory(session, editCategoryName, code, userId);
		
		String actionName = (String)session.getAttribute("action");
		response.sendRedirect(actionName);
	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 */
	private void insertCategory(HttpSession session, String categoryName, String oyacode, String userid) {
		
		try {
			String newcode = MCategoryUtil.insertCategory(userid, oyacode, categoryName);
			MCategory category = MCategoryUtil.getTreeMenu(session, userid);
			MCategoryUtil.insertCategoryToObject(category, oyacode, newcode, categoryName, true);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}
}