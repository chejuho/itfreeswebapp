package buysell.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.bean.StoreBean;

import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;
import buysell.handler.BuySellRegistHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class BuySellRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("BuySellRegistAction.start");
		
		boolean result = false;
		BuySellBean buySellBean = new BuySellBean();
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		if (Util.isLogin(request)) {
			HttpSession session = request.getSession();
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			buySellBean.setUser_id(memberBean.getUserid());
			try {
				BuySellRegistHandler buySellRegistHandler = BuySellRegistHandler.getInstance();
				setBuySellBean(buySellBean, buySellSearchBean, request);
				result = buySellRegistHandler.insertBuySellBean(buySellBean);
				buySellSearchBean.setPageNum("");
			} catch (AppException e) {
				throw new KankokujinException("BuySellRegistAction", e);
			} catch (Exception e) {
				throw new KankokujinException("BuySellRegistAction", e);
			} finally {
				KankokujinLogger.getInstance().debug("BuySellRegistAction.end");
			}
			if (result) {
				imageProcess(buySellBean);
				request.setAttribute("BuySellSearchBean", buySellSearchBean);
				this.getServletContext().getRequestDispatcher("/jsp/buysell/buysellRegistResult.jsp")
						.forward(request, response);

			} else {
				this.getServletContext().getRequestDispatcher(
						"/BuySellRegistOpen").forward(request, response);
			}
		} else {
			this.getServletContext().getRequestDispatcher(
					"/BuySellRegistOpen").forward(request, response);
		}


	}
	
	/**
	 * 
	 * @param requestBean
	 */
	private void imageProcess(BuySellBean buySellBean) {
		
		Util.processMakeResize(
				buySellBean.getPhoto_name1(),
				buySellBean.getPhoto_name2(),
				buySellBean.getPhoto_name3(),
				buySellBean.getPhoto_name4(), 
				buySellBean.getPhoto_name5());
	}
 
	private void setBuySellBean(BuySellBean bean, BuySellSearchBean buySellSearchBean,
			HttpServletRequest request)
			throws ServletException, IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		bean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		bean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		bean.setCate_code_2(Util.changeNullStr(multi.getParameter("cate_code_2")));		
		bean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		bean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		bean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));		
		bean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		bean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		bean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		bean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		String free_price = Util.changeNullStr(multi.getParameter("free_price"));
		bean.setFree_price(free_price);
		String price = Util.changeNullStr(multi.getParameter("price"));
		bean.setPrice(price);
		if("0".equals(free_price) && (Util.isEmpty(price) || "0".equals(price))){
			bean.setFree_price("1");
		}		
		bean.setPrice_unit(Util.changeNullStr(multi.getParameter("price_unit")));
		bean.setSell_place(Util.changeNullStr(multi.getParameter("sell_place")));
		bean.setSend_method(Util.changeNullStr(multi.getParameter("send_method")));
		bean.setPro_status(Util.changeNullStr(multi.getParameter("pro_status")));
		bean.setMember_sort(Util.changeNullStr(multi.getParameter("member_sort")));
		bean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		bean.setPhoto_name1(Util.changePhotoPath(multi.getFilesystemName("photo_name1")));
		bean.setPhoto_name2(Util.changePhotoPath(multi.getFilesystemName("photo_name2")));
		bean.setPhoto_name3(Util.changePhotoPath(multi.getFilesystemName("photo_name3")));
		bean.setPhoto_name4(Util.changePhotoPath(multi.getFilesystemName("photo_name4")));
		bean.setPhoto_name5(Util.changePhotoPath(multi.getFilesystemName("photo_name5")));
		
		buySellSearchBean.setBefore(multi.getParameter("before"));
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			buySellSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			buySellSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			buySellSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			buySellSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			buySellSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_1"))){
			buySellSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			buySellSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_2"))){
			buySellSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("before_cate_code_2")));
		}	
		if(!Util.isEmpty(multi.getParameter("list_view"))) {
			buySellSearchBean.setList_view(Util.changeNullStr(multi.getParameter("list_view")));
		} else if(!Util.isEmpty(multi.getParameter("before_list_view"))){
			buySellSearchBean.setList_view(Util.changeNullStr(multi.getParameter("before_list_view")));
		}	
		buySellSearchBean.setPro_status(Util.changeNullStr(multi
				.getParameter("search_pro_status")));		
		buySellSearchBean.setMember_sort(Util.changeNullStr(multi
				.getParameter("search_member_sort")));
		buySellSearchBean.setFree_price(Util.changeNullStr(multi
				.getParameter("search_free_price")));
		buySellSearchBean.setSend_method(multi.getParameter("search_send_method"));
		buySellSearchBean.setSold_out(multi.getParameter("search_sold_out"));
		buySellSearchBean.setSearch_range(multi.getParameter("search_range"));
		buySellSearchBean.setUser_id(Util.changeNullStr(multi
				.getParameter("user_id")));
		buySellSearchBean.setSearch(EnDecoding.decoding(multi.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		bean.setCate_code_1(buySellSearchBean.getCate_code_1());
	}
}