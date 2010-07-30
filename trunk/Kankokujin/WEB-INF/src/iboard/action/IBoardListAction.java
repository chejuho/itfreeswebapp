package iboard.action;

import iboard.bean.IBoardBean;
import iboard.bean.IBoardSearchBean;
import iboard.handler.IBoardCommonHandler;
import iboard.handler.IBoardListHandler;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;

public class IBoardListAction extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		KankokujinLogger.getInstance().debug("IBoardListAction.start");
		HttpSession session = request.getSession();
		session.setAttribute("action", "IBoardList");
		Connection con = null;
		List<IBoardBean> boardBeanList = null;
		String boardName = null;
		
		IBoardSearchBean searchBean = searchBeanProcess(session, request);
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, searchBean.getPageSize());
		
		 try {
			 con = DBConnectionMgr.getInstance().getConnection();
			 IBoardListHandler listHandler = IBoardListHandler.getInstance();
			 IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
			 boardBeanList = listHandler.getIBoardBeanList(con, pageBean, searchBean);
			 boardName = commonHandler.getBoardName(con, searchBean.getIboard_id());
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
		
		session.setAttribute("PageBean", pageBean);
		session.setAttribute("searchBean", searchBean);
		request.setAttribute("boardBeanList", boardBeanList);
		request.setAttribute("boardName", boardName);
		request.setAttribute("board_id", searchBean.getIboard_id());
		
		this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardList.jsp").forward(request, response);

	}
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	private IBoardSearchBean searchBeanProcess(HttpSession session, HttpServletRequest request) {
		
		IBoardSearchBean searchBean = null;
		IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
		searchBean = (IBoardSearchBean) session.getAttribute("searchBean");
		
		if (searchBean == null) {
			searchBean = new IBoardSearchBean();
		}
		
		if (!"ok".equals(request.getParameter("modoru"))) {
			//サーチ
			if (!Util.isEmpty(request.getParameter("pageSize"))) {
				searchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
			} 
			searchBean.setSearch_range(Util.changeNullStr(request.getParameter("search_range")));
			searchBean.setSearch(EnDecoding.decoding(Util.changeNullStr(request.getParameter("search"))));
			
		}
		searchBean.setIboard_id(commonHandler.getFromRequestBoardId(request));
		
		return searchBean;
	}
}