package hudousan.handler.search;

import java.util.SortedMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;
import hudousan.common.HudousanUtil;
import hudousan.handler.RequestProcess;

public class BuySearchInitProcess extends RequestProcess {



	@Override
	public String execute(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		

		HttpSession session = HudousanUtil.newCreateSession(request);
		
		HudousanSearchBean searchBean = new HudousanSearchBean();
		HudousanSortBean sortBean = new HudousanSortBean();
		
		SortedMap area1InfoMap = (SortedMap) context.getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) context.getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) context.getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) context.getAttribute("Station");
		
		searchBean.setAreaMap1(area1InfoMap);
		searchBean.setAreaMap2(area2InfoMap);
		searchBean.setLineMap(lineInfoMap);
		searchBean.setStationMap(stationInfoMap);
		
		searchBean.setRegist_date("3");
		searchBean.setBuild_year("4");
		searchBean.setToilet("1");
		searchBean.setWalk_time("3");
		searchBean.setFlg_tadami("2");
		
		request.setAttribute("mode", "SearchInitMode");
		request.setAttribute("leaseSign", "0");
		session.setAttribute("HudousanSearchBean", searchBean);
		session.setAttribute("HudousanSortBean", sortBean);
		
		return "/jsp/hudousan/leaseBuySearch.jsp";
	}

}
