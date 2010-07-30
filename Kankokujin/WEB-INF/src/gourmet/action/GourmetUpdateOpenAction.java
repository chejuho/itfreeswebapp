package gourmet.action;

import gourmet.bean.GourmetBean;
import gourmet.bean.GourmetSearchBean;
import gourmet.handler.GourmetDetailHandler;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class GourmetUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug(
					"GourmetUpdateOpenAction.start");
			GourmetBean gourmetBean = new GourmetBean();
			GourmetSearchBean gourmetSearchBean = new GourmetSearchBean();
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
			gourmetBean.setAreaMap1(area1InfoMap);
			gourmetBean.setAreaMap2(area2InfoMap);
			gourmetBean.setLineMap(lineInfoMap);
			gourmetBean.setStationMap(stationInfoMap);
			gourmetBean.setCategory1Map(gourmetCategory1Map);
			gourmetBean.setCategory2Map(gourmetCategory2Map);			
			GourmetDetailHandler gourmetDetailHandler = GourmetDetailHandler.getInstance();
			//reload
			if(Util.isEmpty(request.getParameter("id"))){
				setGourmetBean(gourmetBean, gourmetSearchBean, request);
			//from detail
			} else {
				gourmetBean.setId(request.getParameter("id"));
				gourmetDetailHandler.getGourmetBean(gourmetBean, false, false);
				setGourmetSearchBean(gourmetSearchBean, request);
			}
			
			request.setAttribute("GourmetBean", gourmetBean);		
			request.setAttribute("GourmetSearchBean", gourmetSearchBean);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0025", e);
		} finally {
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/gourmet/gourmetUpdate.jsp")
				.forward(request, response);
	}
	
	private void setGourmetBean(GourmetBean gourmetBean, GourmetSearchBean gourmetSearchBean, 
			HttpServletRequest request) throws ServletException, IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		gourmetBean.setId(Util.changeNullStr(multi.getParameter("id")));
		gourmetBean.setStore_name_k(Util.changeNullStr(multi.getParameter("store_name_k")));
		gourmetBean.setStore_name_j(Util.changeNullStr(multi.getParameter("store_name_j")));
		gourmetBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));		
		gourmetBean.setSearch_word(Util.changeNullStr(multi.getParameter("search_word")));
		gourmetBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		gourmetBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		gourmetBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		gourmetBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		gourmetBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		gourmetBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		gourmetBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));		
		gourmetBean.setFax_no_1(Util.changeNullStr(multi.getParameter("fax_no_1")));
		gourmetBean.setFax_no_2(Util.changeNullStr(multi.getParameter("fax_no_2")));
		gourmetBean.setFax_no_3(Util.changeNullStr(multi.getParameter("fax_no_3")));
		gourmetBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		gourmetBean.setRest_day(Util.changeNullStr(multi.getParameter("rest_day")));
		gourmetBean.setUrl(Util.changeNullStr(multi.getParameter("url")));		
		gourmetBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		gourmetBean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		gourmetBean.setCate_code_2(Util.changeNullStr(multi.getParameter("cate_code_2")));
		gourmetBean.setArea_code_1(Util.changeNullStr(multi.getParameter("area_code_1")));
		gourmetBean.setArea_code_2(Util.changeNullStr(multi.getParameter("area_code_2")));
		gourmetBean.setArea_code_3(Util.changeNullStr(multi.getParameter("area_code_3")));
		gourmetBean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		gourmetBean.setStation_code(Util.changeNullStr(multi.getParameter("station_code")));
		gourmetBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		gourmetBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		gourmetBean.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
		gourmetBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		String photo_name1 = Util.changePhotoPath(multi.getFilesystemName("photo_name1"));
		String photo_name2 = Util.changePhotoPath(multi.getFilesystemName("photo_name2"));
		String photo_name3 = Util.changePhotoPath(multi.getFilesystemName("photo_name3"));
		String photo_name4 = Util.changePhotoPath(multi.getFilesystemName("photo_name4"));
		String photo_name5 = Util.changePhotoPath(multi.getFilesystemName("photo_name5"));
		
		if(Util.isEmpty(photo_name1)){
			gourmetBean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			gourmetBean.setPhoto_name1(photo_name1);
		}
		if(Util.isEmpty(photo_name2)){
			gourmetBean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			gourmetBean.setPhoto_name2(photo_name2);
		}
		if(Util.isEmpty(photo_name3)){
			gourmetBean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			gourmetBean.setPhoto_name3(photo_name3);
		}
		if(Util.isEmpty(photo_name4)){
			gourmetBean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			gourmetBean.setPhoto_name4(photo_name4);
		}
		if(Util.isEmpty(photo_name5)){
			gourmetBean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			gourmetBean.setPhoto_name5(photo_name5);
		}
		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				gourmetBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				gourmetBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				gourmetBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				gourmetBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				gourmetBean.setPhoto_name5("");
			}
		}
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
		gourmetSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));		
		gourmetSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
		gourmetSearchBean.setAll_search(request.getParameter("all_search"));
		gourmetSearchBean.setAll_search_range(request.getParameter("all_search_range"));
	}
}
