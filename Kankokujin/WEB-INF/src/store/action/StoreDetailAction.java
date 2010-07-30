package store.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.bean.StoreBean;
import store.bean.StoreSearchBean;
import store.handler.StoreDetailHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class StoreDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("topmenu", "store");
		String numId = request.getParameter("id");
		String before = request.getParameter("before");
		session.setAttribute("action", "StoreDetail?before=" +before+ "&id="+numId);
		KankokujinLogger.getInstance().debug("StoreDetailAction.start");
		StoreBean storeBean = new StoreBean();
		storeBean.setId(numId);
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		try {
			//from list
			if (!Util.isEmpty(numId)) {
				setStoreSearchBean(storeSearchBean, request);
				storeBean = StoreDetailHandler.getInstance().getStoreBean(storeBean, true, true);
			//back
			} else {
				setBackStoreBean(storeBean, storeSearchBean, request);
				storeBean = StoreDetailHandler.getInstance().getStoreBean(storeBean, false, true);
			}			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreDetailAction.end");
		}
		SortedMap storeCategory1Map = (SortedMap) getServletContext().getAttribute("StoreCategory1");
		SortedMap storeCategory2Map = (SortedMap) getServletContext().getAttribute("StoreCategory2");
		List category1List = UtilHandler.getCategory1ListFromMap(storeCategory1Map);
		List category2List = UtilHandler.getCategory2ListFromMap(storeBean.getCate_code_1(), storeCategory2Map);
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		request.setAttribute("StoreBean", storeBean);
		request.setAttribute("StoreSearchBean", storeSearchBean);
		this.getServletContext().getRequestDispatcher(
				"/jsp/store/storeDetail.jsp").forward(request, response);
	}

	private void setStoreSearchBean(StoreSearchBean storeSearchBean, HttpServletRequest request)
			{
		storeSearchBean.setBefore(request.getParameter("before"));
		storeSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		if(!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			storeSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_1"))){
			storeSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			storeSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_2"))){
			storeSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("before_cate_code_2")));
		}
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			storeSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			storeSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			storeSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			storeSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}		
		storeSearchBean.setArea_code_1(Util.changeNullStr(request.getParameter("search_area_code_1")));
		storeSearchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		storeSearchBean.setLine_code(Util.changeNullStr(request.getParameter("search_line_code")));
		storeSearchBean.setStation_code(Util.changeNullStr(request.getParameter("search_station_code")));		
		storeSearchBean.setSearch_range(request.getParameter("search_range"));
		storeSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));		
		storeSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
		storeSearchBean.setAll_search(Util.changeNullStr(request.getParameter("all_search")));
		storeSearchBean.setAll_search_range(Util.changeNullStr(request.getParameter("all_search_range")));

	}
	private void setBackStoreBean(StoreBean storeBean,
			StoreSearchBean storeSearchBean, HttpServletRequest request)
	throws ServletException, IOException {

		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		storeBean.setId(Util.changeNullStr(multi.getParameter("id")));
		storeBean.setStore_name_k(Util.changeNullStr(multi
				.getParameter("store_name_k")));
		storeBean.setStore_name_j(Util.changeNullStr(multi
				.getParameter("store_name_j")));		
		storeBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		storeBean.setTel_no1_1(Util.changeNullStr(multi
				.getParameter("tel_no1_1")));
		storeBean.setTel_no1_2(Util.changeNullStr(multi
				.getParameter("tel_no1_2")));
		storeBean.setTel_no1_3(Util.changeNullStr(multi
				.getParameter("tel_no1_3")));
		storeBean.setTel_no2_1(Util.changeNullStr(multi
				.getParameter("tel_no2_1")));
		storeBean.setTel_no2_2(Util.changeNullStr(multi
				.getParameter("tel_no2_2")));
		storeBean.setTel_no2_3(Util.changeNullStr(multi
				.getParameter("tel_no2_3")));
		storeBean.setFax_no_1(Util
				.changeNullStr(multi.getParameter("fax_no_1")));
		storeBean.setFax_no_2(Util
				.changeNullStr(multi.getParameter("fax_no_2")));
		storeBean.setFax_no_3(Util
				.changeNullStr(multi.getParameter("fax_no_3")));
		storeBean.setUrl(Util.changeNullStr(multi.getParameter("url")));
		storeBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		storeBean.setCate_code_1(Util.changeNullStr(multi
				.getParameter("cate_code_1")));
		storeBean.setCate_code_2(Util.changeNullStr(multi
				.getParameter("cate_code_2")));
		storeBean.setArea_code_1(Util.changeNullStr(multi
				.getParameter("area_code_1")));
		storeBean.setArea_code_2(Util.changeNullStr(multi
				.getParameter("area_code_2")));
		storeBean.setArea_code_3(Util.changeNullStr(multi
				.getParameter("area_code_3")));
		storeBean.setLine_code(Util.changeNullStr(multi
				.getParameter("line_code")));
		storeBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
		storeBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		storeBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		storeBean.setArea_fast(Util.changeNullStr(multi
				.getParameter("area_fast")));

		storeBean.setAppeal_point(Util.changeNullStr(multi
				.getParameter("appeal_point")));
		storeBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));

		storeSearchBean.setBefore(multi.getParameter("before"));
		storeSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		if(!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			storeSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_1"))){
			storeSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			storeSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_2"))){
			storeSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("before_cate_code_2")));
		}
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			storeSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			storeSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			storeSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			storeSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}		
		storeSearchBean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		storeSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		storeSearchBean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		storeSearchBean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));		
		storeSearchBean.setSearch_range(multi.getParameter("search_range"));
		storeSearchBean.setSearch(EnDecoding.decoding(multi.getParameter("search")));		
		storeSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		storeSearchBean.setAll_search(Util.changeNullStr(multi.getParameter("all_search")));
		storeSearchBean.setAll_search_range(Util.changeNullStr(multi.getParameter("all_search_range")));
	}
}
