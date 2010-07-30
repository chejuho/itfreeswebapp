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
import javax.servlet.http.HttpSession;

import common.database.DBConnectionMgr;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class IBoardDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug("IBoardDetailAction.start");
		Connection con = null;
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String msg = request.getParameter("msg");
		session.setAttribute("action", "IBoardDetail?id="+id);
		String noReadSign = request.getParameter("noReadSign");
		IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
		IBoardDetailHandler handler = IBoardDetailHandler.getInstance();
		
		IBoardBean bean = null;
		String boardName = null;
		
		String board_id = commonHandler.getFromRequestBoardId(request);
		try {
			
			con = DBConnectionMgr.getInstance().getConnection();
			//from list
			if (Util.isEmpty(noReadSign)) {

				bean = handler.getIBoardBean(con, id, true); 
			//back
			} else {
				
				bean = handler.getIBoardBean(con, id, false);
			}
			boardName = commonHandler.getBoardName(con, board_id);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		bean.setContent(Util.changeRnToBrTag(bean.getContent()));
		request.setAttribute("boardName", boardName);
		request.setAttribute("board_id", board_id);
		request.setAttribute("msg", msg);
		request.setAttribute("iboardBean", bean);
		
		this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardDetail.jsp").forward(request, response);
	}
}
