package store.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.bean.StoreBean;
import store.bean.StoreSearchBean;
import store.handler.StoreRegistHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class StoreRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		StoreBean storeBean = new StoreBean();
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		HttpSession session = request.getSession();
		MemberBean memberBean= (MemberBean)session.getAttribute("memberInfo");
		storeBean.setUser_id(memberBean.getUserid());			
		try {
			KankokujinLogger.getInstance().debug("StoreRegistAction.start");
			
			StoreRegistHandler storeRegistHandler = new StoreRegistHandler();
			
			setStoreBean(storeBean, storeSearchBean, request);
			
		    result = storeRegistHandler.insertStoreBean(storeBean);
		    
		    imageProcess(storeBean);
		    
		    storeSearchBean.setPageNum("");
			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0020", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreRegistAction.end");
		}
		if (result) {
			request.setAttribute("StoreSearchBean", storeSearchBean);
			this.getServletContext().getRequestDispatcher("/jsp/store/storeRegistResult.jsp").forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/StoreRegistOpen").forward(request, response);
		}

	}
	
	
	/**
	 * 
	 * @param requestBean
	 */
	private void imageProcess(StoreBean storeBean) {
		
		Util.processMakeResize(
				storeBean.getPhoto_name1(),
				storeBean.getPhoto_name2(),
				storeBean.getPhoto_name3(),
				storeBean.getPhoto_name4(), 
				storeBean.getPhoto_name5());
	}
	

	private void setStoreBean(StoreBean bean, StoreSearchBean storeSearchBean, HttpServletRequest request)
			throws ServletException, IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize,
				"UTF-8", new DefaultFileRenamePolicy());

		bean.setStore_name_k(Util.changeNullStr(multi.getParameter("store_name_k")));
		bean.setStore_name_j(Util.changeNullStr(multi.getParameter("store_name_j")));
		bean.setSearch_word(Util.changeNullStr(multi.getParameter("search_word")));
		bean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		bean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		bean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		bean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		bean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		bean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		bean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		bean.setFax_no_1(Util.changeNullStr(multi.getParameter("fax_no_1")));
		bean.setFax_no_2(Util.changeNullStr(multi.getParameter("fax_no_2")));
		bean.setFax_no_3(Util.changeNullStr(multi.getParameter("fax_no_3")));
		
		bean.setUrl(Util.changeNullStr(multi.getParameter("url")));		
		bean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		bean.setArea_code_1(Util.changeNullStr(multi.getParameter("area_code_1")));
		bean.setArea_code_2(Util.changeNullStr(multi.getParameter("area_code_2")));
		bean.setArea_code_3(Util.changeNullStr(multi.getParameter("area_code_3")));
		bean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		bean.setStation_code(Util.changeNullStr(multi.getParameter("station_code")));
		bean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		bean.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
		bean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		bean.setCate_code_2(Util.changeNullStr(multi.getParameter("cate_code_2")));
		bean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		bean.setRest_day(Util.changeNullStr(multi.getParameter("rest_day")));
		String photo_name1 = Util.changePhotoPath(multi.getFilesystemName("photo_name1"));
		String photo_name2 = Util.changePhotoPath(multi.getFilesystemName("photo_name2"));
		String photo_name3 = Util.changePhotoPath(multi.getFilesystemName("photo_name3"));
		String photo_name4 = Util.changePhotoPath(multi.getFilesystemName("photo_name4"));
		String photo_name5 = Util.changePhotoPath(multi.getFilesystemName("photo_name5"));
		
		if(Util.isEmpty(photo_name1)){
			bean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			bean.setPhoto_name1(photo_name1);
		}
		if(Util.isEmpty(photo_name2)){
			bean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			bean.setPhoto_name2(photo_name2);
		}
		if(Util.isEmpty(photo_name3)){
			bean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			bean.setPhoto_name3(photo_name3);
		}
		if(Util.isEmpty(photo_name4)){
			bean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			bean.setPhoto_name4(photo_name4);
		}
		if(Util.isEmpty(photo_name5)){
			bean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			bean.setPhoto_name5(photo_name5);
		}
		
		bean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		bean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
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
	}
}