package gourmet.action;

import gourmet.bean.GourmetSearchBean;
import gourmet.handler.GourmetSearchHandler;

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

import category.bean.CategoryBean;

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

public class GourmetSearchAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、GourmetSortBean、PageBean、GourmetBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("GourmetListAction.start");
		HttpSession session = request.getSession();
		Connection con = null;
		session.setAttribute("action", "GourmetSearch");
		session.setAttribute("topmenu", "gourmet");
		GourmetSearchBean gourmetSearchBean = new GourmetSearchBean();
		if(!Util.isEmpty(request.getParameter("search_all"))){
			gourmetSearchBean.setSearch(request.getParameter("search_all"));
			gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search_all")));
			gourmetSearchBean.setSearch_range("0");
		} else if(!Util.isEmpty(request.getParameter("all_search"))) {	
			setGourmetSearchBean(gourmetSearchBean, request);
			gourmetSearchBean.setSearch(EnDecoding.decoding(request.getParameter("all_search")));
			gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(EnDecoding.decoding(request.getParameter("all_search"))));
			gourmetSearchBean.setSearch_range("0");	
		} else if("-".equals(request.getParameter("user_id"))) {	
			setGourmetSearchBean(gourmetSearchBean, request);
			session.setAttribute("action", "GourmetSearch?search_cate_code_1="+gourmetSearchBean.getCate_code_1()+"&search_cate_code_2="+gourmetSearchBean.getCate_code_2()+ "&search_area_code_1=" + gourmetSearchBean.getArea_code_1()+ "&search_area_code_2=" + gourmetSearchBean.getArea_code_2() + "&search_line_code=" + gourmetSearchBean.getLine_code() + "&search_station_code=" + gourmetSearchBean.getStation_code()+"&pageSize="+gourmetSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);	
		} else if("b".equals(request.getParameter("f"))) {		
			setMulGourmetSearchBean(gourmetSearchBean, request);			
		} else {
			setGourmetSearchBean(gourmetSearchBean, request);
		}
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		SortedMap gourmetCategory1Map = (SortedMap) getServletContext().getAttribute("GourmetCategory1");
		SortedMap gourmetCategory2Map = (SortedMap) getServletContext().getAttribute("GourmetCategory2");
			
		gourmetSearchBean.setAreaMap1(area1InfoMap);
		gourmetSearchBean.setAreaMap2(area2InfoMap);
		gourmetSearchBean.setLineMap(lineInfoMap);
		gourmetSearchBean.setStationMap(stationInfoMap);

		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, gourmetSearchBean.getPageSize());

		GourmetSearchHandler gourmetSearchHandler = GourmetSearchHandler.getInstance();

		List gourmetBeanList = null;
		List category1List = null;
		List category2List = null;
		Map category1Count = null;
		Map category2Count = null;
		
		try {
			 con = DBConnectionMgr.getInstance().getConnection();
		} catch (AppException e) {
			KankokujinLogger.getInstance().debug(e.toString());
		}
		
		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setCate_code(gourmetSearchBean.getCate_code_1());
		categoryBean.setCate_code_2(gourmetSearchBean.getCate_code_1());
		category1List = UtilHandler.getCategory1ListFromMap(gourmetCategory1Map);
		category2List = UtilHandler.getCategory2ListFromMap(gourmetSearchBean.getCate_code_1(), gourmetCategory2Map);
		try {
			gourmetBeanList = gourmetSearchHandler.getSearchGourmetListTotal(con, pageBean, gourmetSearchBean);
			category1Count = gourmetSearchHandler.getCategory1Count(con, gourmetSearchBean);
			category2Count = gourmetSearchHandler.getCategory2Count(con, gourmetSearchBean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("GourmetSearchAction.end");
			
		}
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("GourmetBeanList", gourmetBeanList);
		request.setAttribute("Category1Count", category1Count);
		request.setAttribute("Category2Count", category2Count);
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		
		//gourmetSearchBean.setSearch(gourmetSearchBean.getDecodedSearch());
		request.setAttribute("GourmetSearchBean", gourmetSearchBean);
		this.getServletContext().getRequestDispatcher("/jsp/gourmet/gourmetSearchList.jsp").forward(request, response);

	}
	private void setMulGourmetSearchBean(GourmetSearchBean gourmetSearchBean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());	
		gourmetSearchBean.setBefore(multi.getParameter("before"));
		gourmetSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		if(!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			gourmetSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_1"))){
			gourmetSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			gourmetSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_2"))){
			gourmetSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("before_cate_code_2")));
		}
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			gourmetSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			gourmetSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			gourmetSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			gourmetSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}		
		gourmetSearchBean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		gourmetSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		gourmetSearchBean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		gourmetSearchBean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));		
		gourmetSearchBean.setSearch_range(multi.getParameter("search_range"));
		gourmetSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));		
		gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));	
	}
	private void setGourmetSearchBean(GourmetSearchBean gourmetSearchBean,
			HttpServletRequest request) {
		
		gourmetSearchBean.setBefore(request.getParameter("before"));
		gourmetSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		if(!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			gourmetSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_1"))){
			gourmetSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			gourmetSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_2"))){
			gourmetSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("before_cate_code_2")));
		}
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			gourmetSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			gourmetSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			gourmetSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			gourmetSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}		
		gourmetSearchBean.setArea_code_1(Util.changeNullStr(request.getParameter("search_area_code_1")));
		gourmetSearchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		gourmetSearchBean.setLine_code(Util.changeNullStr(request.getParameter("search_line_code")));
		gourmetSearchBean.setStation_code(Util.changeNullStr(request.getParameter("search_station_code")));		
		gourmetSearchBean.setSearch_range(request.getParameter("search_range"));
		gourmetSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));		
		gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
	
		if("0".equals(request.getParameter("re"))){
			gourmetSearchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))){
			gourmetSearchBean.setStation_code("0000");
		}
	}

	
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = request.getParameter("pageNum");
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