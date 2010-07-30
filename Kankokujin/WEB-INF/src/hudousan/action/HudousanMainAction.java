package hudousan.action;

import hudousan.handler.HudousanMainHandler;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class HudousanMainAction extends HttpServlet {
	/**
	 * HouseSellListを開く
	 * 
	 * @param request、response
	 * @return HouseBean、HouseSellSortBean、PageBean、HouseBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("HudousanMainAction.Start");
		
		
		Connection con = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
		} catch (AppException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} 
		
		List leaseList = null;
		List buyList = null;
		HudousanMainHandler hudousanMainHandler = HudousanMainHandler.getInstance();
		try {
			leaseList = hudousanMainHandler.getMainInfo(con, "1");
			buyList = hudousanMainHandler.getMainInfo(con, "0");
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HudousanMainAction.End", e);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con);
		}
		request.setAttribute("leaseList", leaseList);
		request.setAttribute("buyList", buyList);
		this.getServletContext().getRequestDispatcher("/jsp/hudousan/main.jsp").forward(request, response);
	}
}