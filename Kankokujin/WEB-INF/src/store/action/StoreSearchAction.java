package store.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.bean.StoreSearchBean;
import store.handler.StoreSearchHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.PageBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;

public class StoreSearchAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request response
	 * @return StoreBean、StoreSortBean、PageBean、StoreBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Connection con = null;
		session.setAttribute("action", "StoreSearch");
		session.setAttribute("topmenu", "store");
		KankokujinLogger.getInstance().debug("StoreListAction.start");
		
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		if(!Util.isEmpty(request.getParameter("search_all"))){
			setStoreSearchBean(storeSearchBean, request);
			storeSearchBean.setSearch(request.getParameter("search_all"));
			storeSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search_all")));
			storeSearchBean.setSearch_range("0");			
		} else if(!Util.isEmpty(request.getParameter("all_search"))) {	
			setStoreSearchBean(storeSearchBean, request);
			storeSearchBean.setSearch(EnDecoding.decoding(request.getParameter("all_search")));
			storeSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("all_search")));
			storeSearchBean.setSearch_range("0");
		} else if("-".equals(request.getParameter("user_id"))) {	
			setStoreSearchBean(storeSearchBean, request);
			session.setAttribute("action", "StoreSearch?re=9&search_cate_code_1="+storeSearchBean.getCate_code_1()+"&search_cate_code_2="+storeSearchBean.getCate_code_2()+"&pageSize="+storeSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);	
		} else if("b".equals(request.getParameter("f"))) {		
			setMulStoreSearchBean(storeSearchBean, request);			
		} else {			
			setStoreSearchBean(storeSearchBean, request);
		}
		
		/** Contextからプロパティ情報を取得 & storeSearchBeanにセット*/
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		SortedMap storeCategory1Map = (SortedMap) getServletContext().getAttribute("StoreCategory1");
		SortedMap storeCategory2Map = (SortedMap) getServletContext().getAttribute("StoreCategory2");
			
		storeSearchBean.setAreaMap1(area1InfoMap);
		storeSearchBean.setAreaMap2(area2InfoMap);
		storeSearchBean.setLineMap(lineInfoMap);
		storeSearchBean.setStationMap(stationInfoMap);
	
	
		//ページ情報
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, storeSearchBean.getPageSize());
	

		List storeBeanList = null;
		List category1List = null;
		List category2List = null;
		Map category1Count = null;
		Map category2Count = null;
		 
		
		 try {
			 con = DBConnectionMgr.getInstance().getConnection();
		} catch (AppException e1) {
			e1.printStackTrace();
		}
		
		category1List = UtilHandler.getCategory1ListFromMap(storeCategory1Map);
		category2List = UtilHandler.getCategory2ListFromMap(storeSearchBean.getCate_code_1(), storeCategory2Map);
		
		
		StoreSearchHandler storeSearchHandler = StoreSearchHandler.getInstance();
		
		try {
			storeBeanList = storeSearchHandler.getSearchStoreListTotal(con, pageBean, storeSearchBean);
			category1Count = storeSearchHandler.getCategory1Count(con, storeSearchBean);
			category2Count = storeSearchHandler.getCategory2Count(con, storeSearchBean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("StoreListAction.end");
		}
		
		session.setAttribute("PageBean", pageBean);
		
		request.setAttribute("StoreBeanList", storeBeanList);
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		request.setAttribute("Category1Count", category1Count);
		request.setAttribute("Category2Count", category2Count);
		request.setAttribute("StoreSearchBean", storeSearchBean);
		
		this.getServletContext().getRequestDispatcher("/jsp/store/storeSearchList.jsp").forward(request, response);
	//}

	}
	private void setMulStoreSearchBean(StoreSearchBean bean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());		
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			bean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			bean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			bean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			bean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}		
		bean.setBefore(multi.getParameter("before"));
		bean.setSearch_range(multi.getParameter("search_range"));
		bean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		bean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		if("00".equals(bean.getArea_code_1())){
			bean.setArea_code_2("0000");
		} else {
			bean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		}		
		bean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		bean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));
		bean.setSearch(Util.changeNullStr(multi.getParameter("search")));
		bean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		if(!Util.isEmpty(bean.getUser_id())){
			bean.setSearch(bean.getDecodedSearch());
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			bean.setCate_code_1(Util.changeNullStr(multi.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_1"))){
			bean.setCate_code_1(Util.changeNullStr(multi.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			bean.setCate_code_2(Util.changeNullStr(multi.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_2"))){
			bean.setCate_code_2(Util.changeNullStr(multi.getParameter("before_cate_code_2")));
		}
		if("0".equals(multi.getParameter("re"))){
			bean.setArea_code_2("0000");
		} else if ("1".equals(multi.getParameter("re"))){
			bean.setStation_code("0000");
		}		
	}
	
	private StoreSearchBean setStoreSearchBean(StoreSearchBean bean,
			HttpServletRequest request) {
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			bean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			bean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			bean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			bean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}		
		bean.setBefore(request.getParameter("before"));
		bean.setSearch_range(request.getParameter("search_range"));
		bean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		bean.setArea_code_1(Util.changeNullStr(request.getParameter("search_area_code_1")));
		if("00".equals(bean.getArea_code_1())){
			bean.setArea_code_2("0000");
		} else {
			bean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		}		
		bean.setLine_code(Util.changeNullStr(request.getParameter("search_line_code")));
		bean.setStation_code(Util.changeNullStr(request.getParameter("search_station_code")));
		bean.setSearch(EnDecoding.decoding(request.getParameter("search")));
		bean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
/*		if(!Util.isEmpty(bean.getUser_id())){
			bean.setSearch(bean.getDecodedSearch());
		}*/
		if(!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			bean.setCate_code_1(Util.changeNullStr(request.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_1"))){
			bean.setCate_code_1(Util.changeNullStr(request.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			bean.setCate_code_2(Util.changeNullStr(request.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_2"))){
			bean.setCate_code_2(Util.changeNullStr(request.getParameter("before_cate_code_2")));
		}
		if("0".equals(request.getParameter("re"))){
			bean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))){
			bean.setStation_code("0000");
		}		
		return bean;
	}
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = "";
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			pageNumStr = Util.changeNullStr(request.getParameter("before_pageNum"));
		}
		if (!Util.isEmpty(pageNumStr)) {
			if (!"sprev".equals(pageNumStr) && !"bprev".equals(pageNumStr)
					&& !"snext".equals(pageNumStr)
					&& !"bnext".equals(pageNumStr)) {
				bean.setPageNum((Integer.parseInt(pageNumStr)));
			} else {
				bean.setPagingSign(pageNumStr);
			}
		}
	}
}