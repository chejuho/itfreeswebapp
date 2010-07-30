package buysell.action;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class BuySellRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("StoreRegistOpenAction.START");
		HttpSession session = request.getSession();
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		BuySellBean buySellBean = new BuySellBean();
		if (Util.isLogin(request)) {
			SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
			SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
			SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
			SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
			SortedMap buysellCategory1Map = (SortedMap) getServletContext().getAttribute("BuySellCategory1");
			SortedMap buysellCategory2Map = (SortedMap) getServletContext().getAttribute("BuySellCategory2");
			
			buySellSearchBean.setAreaMap1(area1InfoMap);
			buySellSearchBean.setAreaMap2(area2InfoMap);
			buySellSearchBean.setLineMap(lineInfoMap);
			buySellSearchBean.setStationMap(stationInfoMap);
			buySellBean.setAreaMap1(area1InfoMap);
			buySellBean.setAreaMap2(area2InfoMap);
			buySellBean.setLineMap(lineInfoMap);
			buySellBean.setStationMap(stationInfoMap);
			buySellBean.setCategory1Map(buysellCategory1Map);
			buySellBean.setCategory2Map(buysellCategory2Map);
			try {
				// reload
				if (Util.isEmpty(request.getParameter("f"))) {
					setMulBuySellBean(buySellBean, buySellSearchBean, request);
					// from search
				} else {

					setBuySellSearchBean(buySellBean, buySellSearchBean, request);
					MemberBean memberBean = (MemberBean) session
							.getAttribute("memberInfo");
					buySellBean.setUser_id(memberBean.getUserid());
					buySellBean.setTel_no1_1(memberBean.getTelephone1());
					buySellBean.setTel_no1_2(memberBean.getTelephone2());
					buySellBean.setTel_no1_3(memberBean.getTelephone3());
					buySellBean.setTel_no2_1(memberBean.getMobile1());
					buySellBean.setTel_no2_2(memberBean.getMobile2());
					buySellBean.setTel_no2_3(memberBean.getMobile3());
					buySellBean.setEmail(memberBean.getEmail1() + "@" + memberBean.getEmail2());
				}
				if("C10001".equals(buySellSearchBean.getCate_code_1())){
					session.setAttribute("topmenu", "buy");
				} else if("C10002".equals(buySellSearchBean.getCate_code_1())){
					session.setAttribute("topmenu", "sell");
				}				
			} catch (Exception e) {
				throw new KankokujinException("SYE0016", e);
			} finally {
			}
			request.setAttribute("BuySellBean", buySellBean);				
			request.setAttribute("BuySellSearchBean", buySellSearchBean);
			session.setAttribute("action", "BuySellRegistOpen?before=search&f=search&search_cate_code_1="+buySellSearchBean.getCate_code_1()+"&user_id="+buySellBean.getUser_id());
		
			this.getServletContext().getRequestDispatcher(
					"/jsp/buysell/buysellRegist.jsp").forward(request, response);

		} else {
			setBuySellSearchBean(buySellBean, buySellSearchBean, request);
			session.setAttribute("action", "BuySellRegistOpen?before=search&f=search&search_cate_code_1="+buySellSearchBean.getCate_code_1()+"&search_cate_code_2="+buySellSearchBean.getCate_code_2()+"&pageSize="+buySellSearchBean.getPageSize()+"&userFlag=0&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		}

	}

	private void setMulBuySellBean(BuySellBean buySellBean,
			BuySellSearchBean buySellSearchBean, HttpServletRequest request)
			throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

		buySellBean.setId(Util.changeNullStr(multi.getParameter("id")));
		buySellBean.setTitle(Util.changeNullStr(multi
				.getParameter("title")));

		buySellBean.setTel_no1_1(Util.changeNullStr(multi
				.getParameter("tel_no1_1")));
		buySellBean.setTel_no1_2(Util.changeNullStr(multi
				.getParameter("tel_no1_2")));
		buySellBean.setTel_no1_3(Util.changeNullStr(multi
				.getParameter("tel_no1_3")));
		buySellBean.setTel_no2_1(Util.changeNullStr(multi
				.getParameter("tel_no2_1")));
		buySellBean.setTel_no2_2(Util.changeNullStr(multi
				.getParameter("tel_no2_2")));
		buySellBean.setTel_no2_3(Util.changeNullStr(multi
				.getParameter("tel_no2_3")));
		buySellBean.setPro_status(Util.changeNullStr(multi
				.getParameter("pro_status")));
		buySellBean.setCate_code_1(Util.changeNullStr(multi
				.getParameter("cate_code_1")));
		buySellBean.setCate_code_2(Util.changeNullStr(multi
				.getParameter("cate_code_2")));
		if ("-".equals(request.getParameter("cate_code_2"))) {
			buySellBean.setCate_code_2("");
		}
		buySellBean.setPro_status(Util.changeNullStr(multi
				.getParameter("pro_status")));
		buySellBean.setMember_sort(Util.changeNullStr(multi
				.getParameter("member_sort")));
		buySellBean.setPhoto_name1(Util.changePhotoPath(multi
				.getFilesystemName("photo_name1")));
		buySellBean.setPhoto_name2(Util.changePhotoPath(multi
				.getFilesystemName("photo_name2")));
		buySellBean.setPhoto_name3(Util.changePhotoPath(multi
				.getFilesystemName("photo_name3")));
		buySellBean.setPhoto_name4(Util.changePhotoPath(multi
				.getFilesystemName("photo_name4")));
		buySellBean.setPhoto_name5(Util.changePhotoPath(multi
				.getFilesystemName("photo_name5")));

		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				buySellBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				buySellBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				buySellBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				buySellBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				buySellBean.setPhoto_name5("");
			}
		}
		
		buySellBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));

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
		buySellSearchBean.setSearch(multi.getParameter("search"));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
	}

	private void setBuySellSearchBean(BuySellBean buySellBean, BuySellSearchBean buySellSearchBean,
			HttpServletRequest request) {

		buySellSearchBean.setBefore(request.getParameter("before"));
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			buySellSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			buySellSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			buySellSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			buySellSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			buySellSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_1"))){
			buySellSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			buySellSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_2"))){
			buySellSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("before_cate_code_2")));
		}	
		if(!Util.isEmpty(request.getParameter("list_view"))) {
			buySellSearchBean.setList_view(Util.changeNullStr(request.getParameter("list_view")));
		} else if(!Util.isEmpty(request.getParameter("before_list_view"))){
			buySellSearchBean.setList_view(Util.changeNullStr(request.getParameter("before_list_view")));
		}		
		buySellSearchBean.setPro_status(Util.changeNullStr(request
				.getParameter("search_pro_status")));		
		buySellSearchBean.setMember_sort(Util.changeNullStr(request
				.getParameter("search_member_sort")));
		buySellSearchBean.setFree_price(Util.changeNullStr(request
				.getParameter("search_free_price")));
		buySellSearchBean.setSend_method(Util.changeNullStr(request.getParameter("search_send_method")));
		buySellSearchBean.setSold_out(Util.changeNullStr(request.getParameter("search_sold_out")));
		buySellSearchBean.setSearch_range(Util.changeNullStr(request.getParameter("search_range")));
		if(!"0".equals(request.getParameter("userFlag"))){
			buySellSearchBean.setUser_id(Util.changeNullStr(request
					.getParameter("user_id")));
		}
		buySellSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
		
		buySellBean.setCate_code_1(buySellSearchBean.getCate_code_1());
		buySellBean.setCate_code_2(buySellSearchBean.getCate_code_2());
		buySellBean.setPro_status(buySellSearchBean.getPro_status());
		buySellBean.setMember_sort(buySellSearchBean.getMember_sort());
		buySellBean.setFree_price(buySellSearchBean.getFree_price());
		buySellBean.setSend_method(buySellSearchBean.getSend_method());
	}


}