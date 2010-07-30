package buysell.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;
import buysell.handler.BuySellDetailHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class BuySellDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("StoreDetailAction.start");
		HttpSession session = request.getSession();
		BuySellBean buySellBean = new BuySellBean();
		buySellBean.setId(request.getParameter("id"));
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		buySellSearchBean.setBefore(request.getParameter("before"));
		BuySellDetailHandler handler = BuySellDetailHandler.getInstance();

		try {
			//from list
			if (!Util.isEmpty(buySellBean.getId())) {
				setBuySellBean(buySellBean, buySellSearchBean, request);
				buySellBean = handler.getBuySellBean(buySellBean, true, true);
			//back
			} else {
				setBackBuySellBean(buySellBean, buySellSearchBean, request);
				buySellBean = handler.getBuySellBean(buySellBean, false, true);
			}			

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreDetailAction.end");
		}
		SortedMap buysellCategory1Map = (SortedMap) getServletContext().getAttribute("BuySellCategory1");
		SortedMap buysellCategory2Map = (SortedMap) getServletContext().getAttribute("BuySellCategory2");
		List category1List = UtilHandler.getCategory1ListFromMap(buysellCategory1Map);
		List category2List = UtilHandler.getCategory2ListFromMap(buySellSearchBean.getCate_code_1(), buysellCategory2Map);
		
		session.setAttribute("action", "BuySellDetail?id=" +buySellBean.getId() +"&before="+buySellSearchBean.getBefore()+"&search_cate_code_1="+buySellSearchBean.getCate_code_1());
		if("C10001".equals(buySellSearchBean.getCate_code_1())){
			session.setAttribute("topmenu", "buy");
		} else if("C10002".equals(buySellSearchBean.getCate_code_1())){
			session.setAttribute("topmenu", "sell");
		}
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		request.setAttribute("BuySellBean", buySellBean);
		request.setAttribute("BuySellSearchBean", buySellSearchBean);
		this.getServletContext().getRequestDispatcher("/jsp/buysell/buysellDetail.jsp").forward(request, response);		
	}
	private void setBuySellBean(BuySellBean buySellBean,
			BuySellSearchBean buySellSearchBean, HttpServletRequest request)
			{
		buySellSearchBean.setBefore(request.getParameter("before"));
		buySellSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
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
		if(!Util.isEmpty(request.getParameter("list_view"))) {
			buySellSearchBean.setList_view(Util.changeNullStr(request.getParameter("list_view")));
		} else if(!Util.isEmpty(request.getParameter("before_list_view"))){
			buySellSearchBean.setList_view(Util.changeNullStr(request.getParameter("before_list_view")));
		}
		buySellSearchBean.setSearch_range(request.getParameter("search_range"));
		buySellSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
		buySellSearchBean.setPro_status(Util.changeNullStr(request.getParameter("search_pro_status")));
		buySellSearchBean.setMember_sort(Util.changeNullStr(request.getParameter("search_member_sort")));
		buySellSearchBean.setFree_price(Util.changeNullStr(request.getParameter("search_free_price")));
		buySellSearchBean.setSend_method(Util.changeNullStr(request.getParameter("search_send_method")));
		buySellSearchBean.setSold_out(Util.changeNullStr(request.getParameter("search_sold_out")));
		buySellSearchBean.setAll_search(request.getParameter("all_search"));
		buySellSearchBean.setAll_search_range(request.getParameter("all_search_range"));
	}
	private void setBackBuySellBean(BuySellBean buySellBean,
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
		buySellBean.setCate_code_1(Util.changeNullStr(multi
				.getParameter("cate_code_1")));
		buySellBean.setCate_code_2(Util.changeNullStr(multi
				.getParameter("cate_code_2")));
		buySellBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		buySellBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));

		buySellSearchBean.setBefore(multi.getParameter("before"));
		buySellSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
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
		if(!Util.isEmpty(multi.getParameter("list_view"))) {
			buySellSearchBean.setList_view(Util.changeNullStr(multi.getParameter("list_view")));
		} else if(!Util.isEmpty(multi.getParameter("before_list_view"))){
			buySellSearchBean.setList_view(Util.changeNullStr(multi.getParameter("before_list_view")));
		}
		buySellSearchBean.setSearch_range(multi.getParameter("search_range"));
		buySellSearchBean.setList_view(Util.changeNullStr(multi.getParameter("list_view")));
		buySellSearchBean.setSearch(EnDecoding.decoding(multi.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		buySellSearchBean.setPro_status(Util.changeNullStr(multi.getParameter("search_pro_status")));
		buySellSearchBean.setMember_sort(Util.changeNullStr(multi.getParameter("search_member_sort")));
		buySellSearchBean.setFree_price(Util.changeNullStr(multi.getParameter("search_free_price")));
		buySellSearchBean.setSend_method(Util.changeNullStr(multi.getParameter("search_send_method")));
		buySellSearchBean.setSold_out(Util.changeNullStr(multi.getParameter("search_sold_out")));
		buySellSearchBean.setAll_search(multi.getParameter("all_search"));
		buySellSearchBean.setAll_search_range(multi.getParameter("all_search_range"));

	}
}
