package store.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.bean.StoreBean;
import store.bean.StoreSearchBean;
import store.handler.StoreDetailHandler;
import store.handler.StoreUpdateHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class StoreUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("StoreUpdateAction.start");
		StoreBean storeBean = new StoreBean();
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		setStoreBean(storeBean, storeSearchBean, request);		

		StoreUpdateHandler updateHandler = new StoreUpdateHandler();

		boolean result = false;
		try {
			result = updateHandler.updateStoreBean(storeBean);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0024", e);
		} finally {
		}
		if (result) {
			try {
				imageProcess(storeBean);
				storeBean = StoreDetailHandler.getInstance().getStoreBean(storeBean, false, true);
			
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0015", e);
			}
			request.setAttribute("Message", "Success to Regist Store info");
			request.setAttribute("StoreBean", storeBean);
			request.setAttribute("StoreSearchBean", storeSearchBean);
			this.getServletContext().getRequestDispatcher(
					"/jsp/store/storeDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("Message", "Fail to Update Store info");
			this.getServletContext().getRequestDispatcher("/StoreList")
					.forward(request, response);
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

	private void setStoreBean(StoreBean storeBean, StoreSearchBean storeSearchBean, HttpServletRequest request)
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
		storeBean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		storeBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
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

		storeBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		storeBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));	

		String cate_code_1 = multi.getParameter("search_cate_code_1");
		String cate_code_2 = multi.getParameter("search_cate_code_2");
		String before_cate_code_1 = multi.getParameter("before_cate_code_1");
		String before_cate_code_2 = multi.getParameter("before_cate_code_2");

		String search_range = multi.getParameter("search_range");
		storeSearchBean.setBefore(multi.getParameter("before"));
		
		storeSearchBean.setSearch_range(search_range);
		storeSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		storeSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		storeSearchBean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		storeSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		storeSearchBean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		storeSearchBean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));
		storeSearchBean.setSearch(EnDecoding.decoding(multi.getParameter("search")));		
		storeSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		storeSearchBean.setCate_code_1(cate_code_1);
		storeSearchBean.setCate_code_2(cate_code_2);
		if(Util.isEmpty(cate_code_1) && !Util.isEmpty(before_cate_code_1)) {
			storeSearchBean.setCate_code_1(before_cate_code_1);
		} 
		if (Util.isEmpty(cate_code_2) && !Util.isEmpty(before_cate_code_2)){
			storeSearchBean.setCate_code_2(before_cate_code_2);
		}
		storeSearchBean.setAll_search(Util.changeNullStr(multi.getParameter("all_search")));
		storeSearchBean.setAll_search_range(Util.changeNullStr(multi.getParameter("all_search_range")));
		
	}
}
