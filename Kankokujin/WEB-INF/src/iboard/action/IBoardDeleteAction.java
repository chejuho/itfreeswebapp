package iboard.action;

import iboard.handler.IBoardCommonHandler;
import iboard.handler.IBoardDeleteHandler;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class IBoardDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection con = null;
		boolean result = false;
		String board_id = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			KankokujinLogger.getInstance().debug("IBoardDeleteAction.start");
			IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
			IBoardDeleteHandler deleteHandler = IBoardDeleteHandler.getInstance();
			String password = request.getParameter("pass_word");
			int id = Integer.parseInt(request.getParameter("id"));
			
			boolean isAuthority = commonHandler.isEditAuthority(con, id, password);
			
			if (isAuthority) {
				board_id = commonHandler.getFromRequestBoardId(request);
				result = deleteHandler.delete(con, id);
			}
			
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HouseSellDeleteAction", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("HouseSellDeleteAction.end");
		}
		if (result) {
			response.sendRedirect("IBoardList?board_id=" + board_id);
		} else {
			this.getServletContext().getRequestDispatcher("/IBoardDetail?msg=psdError&noReadSign=ok").forward(request, response);
		}
	}
}