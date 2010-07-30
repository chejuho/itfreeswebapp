package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.handle.AFlashcardDBHandler;


import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class AFlashcardDeleteDeckAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;

		boolean result = false;
		
		HttpSession session = request.getSession();
		String groupId = request.getParameter("id"); 
		String categoryCode = request.getParameter("categoryCode"); 
		String actionName = (String) session.getAttribute("action");
		if (!Util.isLogin(request, "M_memberInfo")) {
			session.setAttribute("Msg", "NO_LOGIN");
			response.sendRedirect(actionName);
			return;
		}
		
		MemberBean memberBean = (MemberBean) session.getAttribute("M_memberInfo");
		
		if (categoryCode == null) {
			categoryCode = "0000";
		}
		
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			result = commonHandler.deleteUserQuestionGroupsByGroupId(
					con, memberBean.getUserid(), Integer.valueOf(groupId));
			session.setAttribute("Msg", "GroupDeleteSuccess");
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug(this.getClass().getName() + ".end");
		}
		
		
		response.sendRedirect(actionName);
		
	}

}
