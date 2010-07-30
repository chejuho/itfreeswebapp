package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.category.MCategory;
import aflashcard.category.MCategoryUtil;
import aflashcard.handle.AFlashcardDBHandler;


import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class AFlashcardCategoryDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection con = null;
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String code = (String) session.getAttribute("code");
		
		if ("0000".equals(code)) {
			session.setAttribute("Msg", "DELETE_ERROR");
			String actionName = (String)session.getAttribute("action");
			response.sendRedirect(actionName);
			return;
		}
		
		MCategory category = MCategoryUtil.getTreeMenu(session, userId);
		
		List<String> codeList = MCategoryUtil.getEqualLowLevelCategotyCodeList(category, code);
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			deleteCategory(con, codeList, userId);
			MCategoryUtil.removeCategoryToObject(category, code);
		}  catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("MemorizerListAction.end");
		}
	
		String actionName = (String)session.getAttribute("action");
		response.sendRedirect(actionName);
	}
	
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @throws SysException 
	 */
	private void deleteCategory(Connection con, List<String> codeList, String userid) throws SysException {
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		for (String categoryCode : codeList) {
			MCategoryUtil.removeCategory(con, userid, categoryCode);
			commonHandler.deleteUserQuestionGroupsByCategoryCode(con, userid, categoryCode);
		}
	}
}