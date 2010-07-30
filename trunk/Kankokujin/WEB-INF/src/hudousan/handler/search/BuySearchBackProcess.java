package hudousan.handler.search;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.exception.AppException;

import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;
import hudousan.common.HudousanUtil;
import hudousan.handler.HudousanSearchHandler;
import hudousan.handler.RequestProcess;

public class BuySearchBackProcess extends RequestProcess {



	@Override
	public String execute(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession(false);
		HudousanSearchBean searchBean = (HudousanSearchBean) session.getAttribute("HudousanSearchBean");
		HudousanSortBean sortBean = (HudousanSortBean) session.getAttribute("HudousanSortBean");
		PageBean pageBean = (PageBean) session.getAttribute("PageBean");
		//åüçıèåèÇBeanÇ…ì¸ÇÍÇÈ
		HudousanUtil.changeSort(sortBean, request);

		List hudousanBeanList = null;
		HudousanSearchHandler hudousanSearchHandler = HudousanSearchHandler.getInstance();
		try {
			hudousanBeanList = hudousanSearchHandler.getHudousanBeanListTotal(pageBean, searchBean, sortBean, "0");
		} catch (AppException e) {
			e.printStackTrace();
			//throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			//throw new KankokujinException("HouseSellListAction", e);
		}
		request.setAttribute("mode", "SearchMode");
		request.setAttribute("leaseSign", "0");
		session.setAttribute("HudousanSearchBean", searchBean);
		request.setAttribute("HudousanBeanList", hudousanBeanList);
		
		return "/jsp/hudousan/leaseBuySearch.jsp";
	}


}
