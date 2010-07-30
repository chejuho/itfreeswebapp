package hudousan.action;

import hudousan.common.HudousanUtil;
import hudousan.handler.RequestProcess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.logger.KankokujinLogger;
public class CompanyIntroAction extends HttpServlet {
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
		this.getServletContext().getRequestDispatcher("/jsp/hudousan/companyIntro.jsp").forward(request, response);
	}
}