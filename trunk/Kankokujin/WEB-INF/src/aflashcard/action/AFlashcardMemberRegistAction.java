package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.category.MCategoryUtil;
import aflashcard.handle.AFlashcardDBHandler;


import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class AFlashcardMemberRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberRegistAction.START");
		Connection con = null;
		String forward = null;
		HttpSession session = request.getSession();
		MemberBean memberBean = setMemberBean(request);
		
		String initCategoryName = request.getParameter("categoryName");
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		boolean isExistUserId = false;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			isExistUserId = commonHandler.isExistUserId(con, memberBean.getUserid());
			//存在する場合
			if (isExistUserId) {
				session.setAttribute("Msg", "DuplicateIDError");
				session.setAttribute("tempMemberBean", memberBean);
				forward = "/memberregistopen";
			} else {
				commonHandler.insertUserInfo(con, memberBean);
				MCategoryUtil.insertNewCategory(memberBean.getUserid(), "0000", initCategoryName);
				forward = (String)session.getAttribute("action");
			}
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"SYE0009", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		
		response.sendRedirect(forward);

	}

	

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		bean.setName(Util.changeNullStr(request.getParameter("name")));
		return bean;
	}
}
