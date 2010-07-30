package iboard.action;

import iboard.handler.IBoardCommonHandler;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.database.DBConnectionMgr;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class IBoardRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//      Login方式
//		HttpSession session = request.getSession();
//		if (Util.isLogin(request)) {
//			this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardRegist.jsp").forward(request, response);
//		} else {
//			session.setAttribute("action", "IBoardRegistOpen");
//			request.setAttribute("Message", "WAR0004");
//			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);
//		}
		Connection con = null;
		 IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
		String boardName = null;
		
		String board_id = commonHandler.getFromRequestBoardId(request);
		 try {
			 con = DBConnectionMgr.getInstance().getConnection();
			
			 boardName = commonHandler.getBoardName(con, board_id);
		 } catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0023", e);
			} finally {
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
				KankokujinLogger.getInstance().debug("IBoardListAction.end");
			}
		request.setAttribute("boardName", boardName);
		request.setAttribute("board_id", board_id);
		this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardRegist.jsp").forward(request, response);
	}
}