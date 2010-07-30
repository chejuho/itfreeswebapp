package iboard.action;

import iboard.bean.IBoardBean;
import iboard.handler.IBoardCommonHandler;
import iboard.handler.IBoardDetailHandler;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.database.DBConnectionMgr;
import common.exception.KankokujinException;
import common.exception.SysException;

public class IBoardUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection con = null;
		String id = request.getParameter("id");
		IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
		IBoardDetailHandler handler = IBoardDetailHandler.getInstance();
		String password = request.getParameter("pass_word");
		boolean isAuthority = false;
		IBoardBean bean = null;
		String boardName = null;
		String board_id = commonHandler.getFromRequestBoardId(request);
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			isAuthority = commonHandler.isEditAuthority(con, Integer.valueOf(id), password);
			boardName = commonHandler.getBoardName(con, board_id);
			if (isAuthority) {
				bean = handler.getIBoardBean(con, id, false);
			}
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		if (!isAuthority) {
			this.getServletContext().getRequestDispatcher("/IBoardDetail?msg=psdError&noReadSign=ok").forward(request, response);
		} else {
			request.setAttribute("boardName", boardName);
			request.setAttribute("board_id", board_id);
			request.setAttribute("iboardBean", bean);
			this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardUpdate.jsp").forward(request, response);
		}
		
	}
}
