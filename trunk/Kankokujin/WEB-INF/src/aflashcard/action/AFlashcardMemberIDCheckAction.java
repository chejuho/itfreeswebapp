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
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class AFlashcardMemberIDCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemorizerMemberIDCheckAction.START");
		Connection con = null;
		String id = request.getParameter("userid");
		MemberBean memberBean = setMemberBean(request);
		HttpSession session = request.getSession();
		boolean isExist = true;
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		try {
			 con = DBConnectionMgr.getInstance().getConnection();
			isExist = commonHandler.isExistUserId(con, id);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		}finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("MemorizerListAction.end");
		}
		if (isExist) {
			session.setAttribute("Msg", "DuplicateIDError");
		} else {
			session.setAttribute("Msg", "DuplicateCheckOk");
		}
		session.setAttribute("tempMemberBean", memberBean);
		this.getServletContext().getRequestDispatcher("/memberregistopen").forward(request, response);
	}
	
	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		return bean;
	}
}