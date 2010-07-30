package store.action;

import java.io.IOException;
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
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class StoreUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("action", "StoreUpdateOpen");
		try {
			KankokujinLogger.getInstance().debug(
					"StoreUpdateOpenAction.start");
			StoreBean storeBean = new StoreBean();
			StoreSearchBean storeSearchBean = new StoreSearchBean();
			SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
			SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
			SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
			SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
			SortedMap storeCategory1Map = (SortedMap) getServletContext().getAttribute("StoreCategory1");
			SortedMap storeCategory2Map = (SortedMap) getServletContext().getAttribute("StoreCategory2");
			
			storeSearchBean.setAreaMap1(area1InfoMap);
			storeSearchBean.setAreaMap2(area1InfoMap);
			storeSearchBean.setLineMap(lineInfoMap);
			storeSearchBean.setStationMap(stationInfoMap);
			storeBean.setAreaMap1(area1InfoMap);
			storeBean.setAreaMap2(area2InfoMap);
			storeBean.setLineMap(lineInfoMap);
			storeBean.setStationMap(stationInfoMap);
			storeBean.setCategory1Map(storeCategory1Map);
			storeBean.setCategory2Map(storeCategory2Map);			
			//reload
			if(Util.isEmpty(request.getParameter("id"))){
				setStoreBean(storeBean, storeSearchBean, request);
			//from detail
			} else {
				storeBean.setId(request.getParameter("id"));
				StoreDetailHandler.getInstance().getStoreBean(storeBean, false, false);
				setStoreSearchBean(storeSearchBean, request);
			}
			request.setAttribute("StoreBean", storeBean);		
			request.setAttribute("StoreSearchBean", storeSearchBean);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0025", e);
		} finally {
			KankokujinLogger.getInstance().debug(
					"StoreUpdateOpenAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/store/storeUpdate.jsp")
				.forward(request, response);
	}
	
	private void setStoreBean(StoreBean storeBean, StoreSearchBean storeSearchBean, 
			HttpServletRequest request) throws ServletException, IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());

		storeBean.setId(Util.changeNullStr(multi.getParameter("id")));
		storeBean.setStore_name_k(Util.changeNullStr(multi.getParameter("store_name_k")));
		storeBean.setStore_name_j(Util.changeNullStr(multi.getParameter("store_name_j")));
		storeBean.setSearch_word(Util.changeNullStr(multi.getParameter("search_word")));
		storeBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		storeBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		storeBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		storeBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		storeBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		storeBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		storeBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));		
		storeBean.setFax_no_1(Util.changeNullStr(multi.getParameter("fax_no_1")));
		storeBean.setFax_no_2(Util.changeNullStr(multi.getParameter("fax_no_2")));
		storeBean.setFax_no_3(Util.changeNullStr(multi.getParameter("fax_no_3")));
		storeBean.setUrl(Util.changeNullStr(multi.getParameter("url")));		
		storeBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		storeBean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		storeBean.setCate_code_2(Util.changeNullStr(multi.getParameter("cate_code_2")));
		if ("-".equals(request.getParameter("cate_code_2"))){
			storeBean.setCate_code_2("");			
		}		
		storeBean.setArea_code_1(Util.changeNullStr(multi.getParameter("area_code_1")));
		storeBean.setArea_code_2(Util.changeNullStr(multi.getParameter("area_code_2")));
		storeBean.setArea_code_3(Util.changeNullStr(multi.getParameter("area_code_3")));
		storeBean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		storeBean.setStation_code(Util.changeNullStr(multi.getParameter("station_code")));
		storeBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		storeBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		storeBean.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
		storeBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		storeBean.setRest_day(Util.changeNullStr(multi.getParameter("rest_day")));
		String photo_name1 = Util.changePhotoPath(multi.getFilesystemName("photo_name1"));
		String photo_name2 = Util.changePhotoPath(multi.getFilesystemName("photo_name2"));
		String photo_name3 = Util.changePhotoPath(multi.getFilesystemName("photo_name3"));
		String photo_name4 = Util.changePhotoPath(multi.getFilesystemName("photo_name4"));
		String photo_name5 = Util.changePhotoPath(multi.getFilesystemName("photo_name5"));
		
		if(Util.isEmpty(photo_name1)){
			storeBean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			storeBean.setPhoto_name1(photo_name1);
		}
		if(Util.isEmpty(photo_name2)){
			storeBean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			storeBean.setPhoto_name2(photo_name2);
		}
		if(Util.isEmpty(photo_name3)){
			storeBean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			storeBean.setPhoto_name3(photo_name3);
		}
		if(Util.isEmpty(photo_name4)){
			storeBean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			storeBean.setPhoto_name4(photo_name4);
		}
		if(Util.isEmpty(photo_name5)){
			storeBean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			storeBean.setPhoto_name5(photo_name5);
		}
		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				storeBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				storeBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				storeBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				storeBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				storeBean.setPhoto_name5("");
			}
		}
		storeBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		storeBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));	
		
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
		storeSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));		
		storeSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		storeSearchBean.setAll_search(multi.getParameter("all_search"));
		storeSearchBean.setAll_search_range(multi.getParameter("all_search_range"));
	}

	private void setStoreSearchBean(StoreSearchBean storeSearchBean,
			HttpServletRequest request) {
		
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
		storeSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));		
		storeSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));	
		storeSearchBean.setAll_search(request.getParameter("all_search"));
		storeSearchBean.setAll_search_range(request.getParameter("all_search_range"));
	}
}
