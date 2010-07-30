package housefind.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.page.PageUtil;

import housefind.handler.HouseFindHandler;

public class HouseFindListAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
//		SearchHouseBean searchHouseBean = (SearchHouseBean) session
//				.getAttribute("SearchHouseBean");
//		if (searchHouseBean == null) {
//			searchHouseBean = new SearchHouseBean();
//		}
//		// SearchHouseBeanにrequestからもらった情報を格納する
//		setSearchHouseBean(searchHouseBean, request);
//		// セッションに最新SearchHouseBeanをセットする
//		session.setAttribute("SearchHouseBean", searchHouseBean);
//
//		SortBean sortBean = (SortBean) session.getAttribute("SortBean");
//		if (sortBean == null) {
//			sortBean = new SortBean();
//		}
		//HouseUtil houseUtil = new HouseUtil();
		//sortBean = houseUtil.getChangeSort(sortBean,searchHouseBean);
		// セッションに最新SortBeanをセットする
		//session.setAttribute("SortBean", sortBean);

		PageBean pageBean = (PageBean) session.getAttribute("PageBean");
		
		//setPageInfo(pageInfo, request);

		HouseFindHandler houseFindHandler = new HouseFindHandler();
		int maxInfoCount = houseFindHandler.getInfoCount();
		
		int pageSize = 10;
		if(request.getParameter("pageSize") != null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} 
//		else {
//			pageSize = Integer.parseInt(searchHouseBean.getPageSize());
//		}

		if (pageBean == null||request.getParameter("pageNum")==null) {
			pageBean = new PageBean();
			pageBean.setPageSize(pageSize);
			pageBean.setPagingSort("houseFind");
			PageUtil.getInstance().init(pageBean, maxInfoCount);
		} else if ("sprev".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().sprev(pageBean, maxInfoCount);
		} else if ("bprev".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().bprev(pageBean, maxInfoCount);
		} else if ("snext".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().snext(pageBean, maxInfoCount);
		} else if ("bnext".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().bnext(pageBean, maxInfoCount);
		} else {
			pageBean = (PageBean) session.getAttribute("PageBean");
			pageBean.setPageSize(pageSize);
			PageUtil.getInstance().jump(pageBean, pageBean.getPageNum(), maxInfoCount);
		}
		
		String pageType="1";
		if(request.getParameter("pageType") != null){
			pageType = request.getParameter("pageType");
		}else if(pageBean.getPageType()!=null){
			pageType = (pageBean.getPageType());
		}

		pageBean.setPageType(pageType);
		System.out.println("pageType="+pageBean.getPageType());
		System.out.println("pageNum="+pageBean.getPageNum());
	//	String pageType = request.getParameter("pageType");
	//	pageInfo.setPageType(pageType);
		String currentPage = pageBean.getCurrentPage()+"";
		pageBean.setPagingSign(currentPage);
		session.setAttribute("PageBean", pageBean);
		List houseInfoList = houseFindHandler.getList(pageBean
				.getStartCount(), pageBean.getPageSize());

		request.setAttribute("HouseFindList", houseInfoList);
		this.getServletContext().getRequestDispatcher(
				"/jsp/housefind/houseFindList.jsp").forward(request, response);

	}

}