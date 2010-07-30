package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

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

public class AFlashcardAddDeckAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;

		int result = 0;
		
		HttpSession session = request.getSession();
		Map<String, String> groupInfo = null;
		String fromUser_id = request.getParameter("fromUser_id");
		String toUser_id = request.getParameter("toUser_id");
		
		String groupId = request.getParameter("id"); 
		String categoryCode = request.getParameter("categoryCode"); 
		String actionName = (String) session.getAttribute("action");
		if (!Util.isLogin(request, "M_memberInfo")) {
			session.setAttribute("Msg", "NO_LOGIN");
			response.sendRedirect(actionName);
			return;
		}
		
		if (categoryCode == null) {
			categoryCode = "0000";
		}
		
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			groupInfo = commonHandler.getGroupInfo(con, groupId, fromUser_id);
			result = commonHandler.insertUserQuestionGroups(
					con, toUser_id, "",Integer.valueOf(groupId), fromUser_id,groupInfo.get("group_name"),"0000", "");
			
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
		
		if (result == 0) {
			session.setAttribute("Msg", "DuplicateError");
		} else {
			session.setAttribute("Msg", "GroupAddSuccess");
		}
		response.sendRedirect(actionName);
		
	}

}
