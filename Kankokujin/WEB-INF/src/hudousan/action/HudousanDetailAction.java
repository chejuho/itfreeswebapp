package hudousan.action;

import hudousan.bean.HudousanBean;
import hudousan.handler.HudousanDetailHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.logger.KankokujinLogger;
public class HudousanDetailAction extends HttpServlet {
	/**
	 * HouseSellListを開く
	 * 
	 * @param request、response
	 * @return HouseBean、HouseSellSortBean、PageBean、HouseBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("HudousanDetailAction.Start");
		
		String id = request.getParameter("id");
		String leaseSign = request.getParameter("leaseSign");
		HudousanBean bean = null;
		try {
			bean = HudousanDetailHandler.getInstance().getHudousanBean(id, leaseSign, true, true);
		} catch (AppException e) {
			e.printStackTrace();
		}
		request.setAttribute("HudousanBean", bean);
		request.setAttribute("leaseSign", leaseSign);
		this.getServletContext().getRequestDispatcher("/jsp/hudousan/leaseBuyDetail.jsp").forward(request, response);
	}
}