package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.handle.AFlashcardDBHandler;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class AFlashcardUserGroupDeleteAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;
		String actionName = "";
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		HttpSession session = request.getSession();
		boolean result = false;
		
		String fromPage = request.getParameter("fromPage");
		String userId = request.getParameter("userId");
		String categoryCode = request.getParameter("categoryCode");
		
		String delUserId = request.getParameter("delUserId");
		String delGroupId = request.getParameter("delGroupId");
		String pass_word = request.getParameter("pass_word");
	
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			if (Util.isLogin(request, "M_memberInfo")) {
				result = commonHandler.deleteUserQuestionGroupsByGroupId(con, delUserId, Integer.valueOf(delGroupId));
			} else {
				result = commonHandler.deleteUserQuestionGroupsByPassword(con, delUserId, Integer.valueOf(delGroupId), pass_word);
			}
			
			
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("MemorizerListAction.end");
		}
		
		
		//MemorizerList?categoryCode=0000&userId=k_admin&categoryClick=ok
		if (result) {
			session.setAttribute("Msg", "DeleteSuccess");
			actionName = fromPage + "?categoryCode=" + categoryCode + "&userId=" + userId;
		} else {
			session.setAttribute("Msg", "DeleteFailForPassError");
			actionName = "detail?userId=" + userId + "&id=" + delGroupId + "&fromPage=" 
				+ fromPage + "&categoryCode=" + categoryCode;
		}
		
		response.sendRedirect(actionName);

	}
}
