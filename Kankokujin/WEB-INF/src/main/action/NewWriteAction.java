package main.action;

import inform.handler.InformMainHandler;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.bean.MainInfoBean;
import main.bean.QuickSearchCountBean;
import main.handler.NewWriteHandler;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class NewWriteAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、JobSortBean、PageBean、JobBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;
	private static final int START_NO = 1;
	private static final int COUNT = 5;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		KankokujinLogger.getInstance().debug("NewWriteAction.start");
		session.setAttribute("action", "NewWrite");
		MainInfoBean mainInfoBean = null;
		QuickSearchCountBean quickSearchCountBean = null;
		List informBeanList = null;
		Connection con = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			mainInfoBean = NewWriteHandler.getInstance().getMainInfoBean(con, 0);
			quickSearchCountBean = NewWriteHandler.getInstance().getQuickSearchCount(con);
			informBeanList = InformMainHandler.getInstance().getInformBeanList(con);

		} catch (SysException e) {
			KankokujinLogger.getInstance().debug(e.toString());
			//Connection Poolエラーの場合
			if (Util.retry(session)) {
				DBConnectionMgr.getInstance().finalize();
				response.sendRedirect("NewWrite");
				return;
			}
			throw new KankokujinException(e.getMessage(), e);
		} catch (AppException e) {
			KankokujinLogger.getInstance().debug(e.toString());
			throw new KankokujinException(e.getMessage(), e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		
		Util.errorCntInit(session);
		
		request.setAttribute("BuyBeanList", mainInfoBean.getBuyBeanList());
		request.setAttribute("SellBeanList", mainInfoBean.getSellBeanList());
		request.setAttribute("StoreBeanList", mainInfoBean.getStoreBeanList());
		request.setAttribute("GourmetBeanList", mainInfoBean.getGourmetBeanList());
		request.setAttribute("RoomBeanList1", mainInfoBean.getRoomBeanList1());
		request.setAttribute("RoomBeanList2", mainInfoBean.getRoomBeanList2());
		request.setAttribute("HouseBeanList", mainInfoBean.getHouseBeanList());
		request.setAttribute("JobBeanList", mainInfoBean.getJobBeanList());
		request.setAttribute("FindjobBeanList", mainInfoBean.getFindjobBeanList());
		request.setAttribute("QuickSearchCountBean", quickSearchCountBean);
		request.setAttribute("InformBeanList", informBeanList);

		
		this.getServletContext().getRequestDispatcher("/jsp/main/new_write.jsp").forward(request, response);				
	}
}