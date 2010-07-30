package gourmet.action;

import gourmet.bean.GourmetBean;
import gourmet.bean.GourmetSearchBean;
import gourmet.handler.GourmetDetailHandler;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class GourmetDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("GourmetDetailAction.start");
		String numId = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("topmenu", "gourmet");
		GourmetBean gourmetBean = new GourmetBean();
		gourmetBean.setId(numId);
		GourmetSearchBean gourmetSearchBean = new GourmetSearchBean();
		GourmetDetailHandler handler = GourmetDetailHandler.getInstance();
		try {
			//from list
			if (!Util.isEmpty(numId)) {
				setGourmetBean(gourmetBean, gourmetSearchBean, request);
				
			//back
			} else {
				setBackGourmetBean(gourmetBean, gourmetSearchBean, request);
			}			
			gourmetBean = handler.getGourmetBean(gourmetBean, true, true);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
		}
		SortedMap buysellCategory1Map = (SortedMap) getServletContext().getAttribute("GourmetCategory1");
		SortedMap buysellCategory2Map = (SortedMap) getServletContext().getAttribute("GourmetCategory2");
		List category1List = UtilHandler.getCategory1ListFromMap(buysellCategory1Map);
		List category2List = UtilHandler.getCategory2ListFromMap(gourmetBean.getCate_code_1(), buysellCategory2Map);
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		session.setAttribute("action", "GourmetDetail?id=" +numId +"&before="+gourmetSearchBean.getBefore());
		request.setAttribute("GourmetBean", gourmetBean);
		request.setAttribute("GourmetSearchBean", gourmetSearchBean);
		this.getServletContext().getRequestDispatcher(
				"/jsp/gourmet/gourmetDetail.jsp").forward(request, response);
	}

	private void setGourmetBean(GourmetBean gourmetBean,
			GourmetSearchBean gourmetSearchBean, HttpServletRequest request)
			{
		gourmetBean.setId(Util.changeNullStr(request.getParameter("id")));
		gourmetBean.setStore_name_k(Util.changeNullStr(request
				.getParameter("store_name_k")));
		gourmetBean.setSearch_word(Util.changeNullStr(request.getParameter("search_word")));
		gourmetBean.setEmail(Util.changeNullStr(request.getParameter("email")));
		gourmetBean.setTel_no1_1(Util.changeNullStr(request
				.getParameter("tel_no1_1")));
		gourmetBean.setTel_no1_2(Util.changeNullStr(request
				.getParameter("tel_no1_2")));
		gourmetBean.setTel_no1_3(Util.changeNullStr(request
				.getParameter("tel_no1_3")));
		gourmetBean.setTel_no2_1(Util.changeNullStr(request
				.getParameter("tel_no2_1")));
		gourmetBean.setTel_no2_2(Util.changeNullStr(request
				.getParameter("tel_no2_2")));
		gourmetBean.setTel_no2_3(Util.changeNullStr(request
				.getParameter("tel_no2_3")));
		gourmetBean.setFax_no_1(Util
				.changeNullStr(request.getParameter("fax_no_1")));
		gourmetBean.setFax_no_2(Util
				.changeNullStr(request.getParameter("fax_no_2")));
		gourmetBean.setFax_no_3(Util
				.changeNullStr(request.getParameter("fax_no_3")));
		gourmetBean.setWork_time(Util.changeNullStr(request.getParameter("work_time")));
		gourmetBean.setRest_day(Util.changeNullStr(request.getParameter("rest_day")));
		gourmetBean.setUrl(Util.changeNullStr(request.getParameter("url")));
		gourmetBean.setMain_area(Util.changeNullStr(request
				.getParameter("main_area")));
		gourmetBean.setCate_code_1(Util.changeNullStr(request
				.getParameter("cate_code_1")));
		gourmetBean.setCate_code_2(Util.changeNullStr(request
				.getParameter("cate_code_2")));
		gourmetBean.setArea_code_1(Util.changeNullStr(request
				.getParameter("area_code_1")));
		gourmetBean.setArea_code_2(Util.changeNullStr(request
				.getParameter("area_code_2")));
		gourmetBean.setArea_code_3(Util.changeNullStr(request
				.getParameter("area_code_3")));
		gourmetBean.setLine_code(Util.changeNullStr(request
				.getParameter("line_code")));
		gourmetBean.setStation_code(Util.changeNullStr(request
				.getParameter("station_code")));
		gourmetBean.setMain_area(Util.changeNullStr(request
				.getParameter("main_area")));
		gourmetBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		gourmetBean.setArea_fast(Util.changeNullStr(request
				.getParameter("area_fast")));

		gourmetBean.setAppeal_point(Util.changeNullStr(request
				.getParameter("appeal_point")));
		gourmetBean.setDetail_info(Util.changeNullStr(request
				.getParameter("detail_info")));

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
		gourmetSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));		
		gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));		
		
		gourmetBean.setCate_code_1(gourmetSearchBean.getCate_code_1());
		gourmetBean.setCate_code_2(gourmetSearchBean.getCate_code_2());
		gourmetBean.setArea_code_1(gourmetSearchBean.getArea_code_1());
		gourmetBean.setArea_code_2(gourmetSearchBean.getArea_code_2());
		gourmetBean.setStation_code(gourmetSearchBean.getStation_code());
		gourmetBean.setLine_code(gourmetSearchBean.getLine_code());
		gourmetSearchBean.setAll_search(request.getParameter("all_search"));
		gourmetSearchBean.setAll_search_range(request.getParameter("all_search_range"));

	}
	private void setBackGourmetBean(GourmetBean gourmetBean,
			GourmetSearchBean gourmetSearchBean, HttpServletRequest request)
	throws ServletException, IOException {

		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		gourmetBean.setId(Util.changeNullStr(multi.getParameter("id")));
		gourmetBean.setStore_name_k(Util.changeNullStr(multi
				.getParameter("store_name_k")));
		gourmetBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		gourmetBean.setTel_no1_1(Util.changeNullStr(multi
				.getParameter("tel_no1_1")));
		gourmetBean.setTel_no1_2(Util.changeNullStr(multi
				.getParameter("tel_no1_2")));
		gourmetBean.setTel_no1_3(Util.changeNullStr(multi
				.getParameter("tel_no1_3")));
		gourmetBean.setTel_no2_1(Util.changeNullStr(multi
				.getParameter("tel_no2_1")));
		gourmetBean.setTel_no2_2(Util.changeNullStr(multi
				.getParameter("tel_no2_2")));
		gourmetBean.setTel_no2_3(Util.changeNullStr(multi
				.getParameter("tel_no2_3")));
		gourmetBean.setFax_no_1(Util
				.changeNullStr(multi.getParameter("fax_no_1")));
		gourmetBean.setFax_no_2(Util
				.changeNullStr(multi.getParameter("fax_no_2")));
		gourmetBean.setFax_no_3(Util
				.changeNullStr(multi.getParameter("fax_no_3")));
		gourmetBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		gourmetBean.setRest_day(Util.changeNullStr(multi.getParameter("rest_day")));		
		gourmetBean.setUrl(Util.changeNullStr(multi.getParameter("url")));
		gourmetBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		gourmetBean.setCate_code_1(Util.changeNullStr(multi
				.getParameter("cate_code_1")));
		gourmetBean.setCate_code_2(Util.changeNullStr(multi
				.getParameter("cate_code_2")));
		gourmetBean.setArea_code_1(Util.changeNullStr(multi
				.getParameter("area_code_1")));
		gourmetBean.setArea_code_2(Util.changeNullStr(multi
				.getParameter("area_code_2")));
		gourmetBean.setArea_code_3(Util.changeNullStr(multi
				.getParameter("area_code_3")));
		gourmetBean.setLine_code(Util.changeNullStr(multi
				.getParameter("line_code")));
		gourmetBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
		gourmetBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		gourmetBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		gourmetBean.setArea_fast(Util.changeNullStr(multi
				.getParameter("area_fast")));

		gourmetBean.setAppeal_point(Util.changeNullStr(multi
				.getParameter("appeal_point")));
		gourmetBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));

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
		gourmetSearchBean.setAll_search(multi.getParameter("all_search"));
		gourmetSearchBean.setAll_search_range(multi.getParameter("all_search_range"));
	}
}
