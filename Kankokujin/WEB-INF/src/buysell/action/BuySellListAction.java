package buysell.action;

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

import buysell.bean.BuySellSearchBean;
import buysell.handler.BuySellListHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.MemberBean;
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

public class BuySellListAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return BuySellBean、BuySellSortBean、PageBean、BuySellBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		Connection con = null;
		if(!Util.isEmpty(request.getParameter("search_all"))){
			setBuySellSearchBean(buySellSearchBean, request);
			buySellSearchBean.setSearch(request.getParameter("search_all"));
			buySellSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search_all")));
			buySellSearchBean.setSearch_range("0");
		} else if(!Util.isEmpty(request.getParameter("all_search"))) {	
			setBuySellSearchBean(buySellSearchBean, request);
			buySellSearchBean.setSearch(EnDecoding.decoding(request.getParameter("all_search")));
			buySellSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("all_search")));
			buySellSearchBean.setSearch_range("0");
		/** ログインしていないユーザが権限がないアクションを実行した場合 */	
		} else if("-".equals(request.getParameter("user_id"))) {	
			setBuySellSearchBean(buySellSearchBean, request);
			session.setAttribute("action", "BuySellList?re=9&search_cate_code_1="+buySellSearchBean.getCate_code_1()+"&search_cate_code_2="+buySellSearchBean.getCate_code_2()+"&pageSize="+buySellSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);			
		} else if("b".equals(request.getParameter("f"))) {		
			setBackBuySellSearchBean(buySellSearchBean, request);				
		} else {
			setBuySellSearchBean(buySellSearchBean, request);			
		} 
		session.setAttribute("action", "BuySellList?search_cate_code_1="+ buySellSearchBean.getCate_code_1());
		if("C10100".equals(buySellSearchBean.getCate_code_1())){
			session.setAttribute("topmenu", "buy");
		} else if("C10200".equals(buySellSearchBean.getCate_code_1())){
			session.setAttribute("topmenu", "sell");
		}
		
		/**
		 * ログインした情報とリクエスト情報を比較してフラグを設定する
		 **/
		MemberBean memberInfo = (MemberBean) session.getAttribute("memberInfo");
		if (memberInfo == null) {
			buySellSearchBean.setUserFlag("0");
		} else {
			String userid = memberInfo.getUserid();
			if (buySellSearchBean.getUser_id().equals(userid)) {
				buySellSearchBean.setUserFlag("1");
			} else {
				buySellSearchBean.setUserFlag("0");
			}
		}
		/************************************************************************/
		
		if (!Util.isEmpty(buySellSearchBean.getUser_id()) && "-".equals(buySellSearchBean.getUser_id())) {
			session.setAttribute("action", "BuySellList?search_cate_code_1="+ buySellSearchBean.getCate_code_1()+"&search_cate_code_2="+buySellSearchBean.getCate_code_2()+"&pageSize="+buySellSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);

		} else {
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
			
			/** ページ情報 */
			PageBean pageBean = PageUtil.getInstance().pagingProcess(request, buySellSearchBean.getPageSize());
			
			 try {
				 con = DBConnectionMgr.getInstance().getConnection();
			} catch (AppException e1) {
				e1.printStackTrace();
			}
			BuySellListHandler buySellListHandler = BuySellListHandler.getInstance();
			UtilHandler utilHandler = new UtilHandler();
			List buySellBeanList = null;
			Map category2Count = null;		
			
			List category1List = utilHandler.getCategory1ListFromMap(buysellCategory1Map);
			List category2List = utilHandler.getCategory2ListFromMap(buySellSearchBean.getCate_code_1(), buysellCategory2Map);

			try {
				buySellBeanList = buySellListHandler.getBuySellListTotal(con, pageBean, buySellSearchBean);
				category2Count = buySellListHandler.getCategory2Count(con, buySellSearchBean);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0023", e);
			} finally {
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
				KankokujinLogger.getInstance().debug("StoreListAction.end");
			}
			
			session.setAttribute("PageBean", pageBean);
			//画面情報設定
			request.setAttribute("BuySellBeanList", buySellBeanList);
			request.setAttribute("Category1List", category1List);
			request.setAttribute("Category2List", category2List);
			request.setAttribute("sort", "buysell");
			request.setAttribute("BuySellSearchBean", buySellSearchBean);
			request.setAttribute("Category2Count", category2Count);
			this.getServletContext().getRequestDispatcher("/jsp/buysell/buysellList.jsp").forward(request, response);
		}

	}
	
	private void setBuySellSearchBean(BuySellSearchBean buySellSearchBean,
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
		buySellSearchBean.setPro_status(Util.changeNullStr(request.getParameter("search_pro_status")));		
		buySellSearchBean.setMember_sort(Util.changeNullStr(request.getParameter("search_member_sort")));
		buySellSearchBean.setFree_price(Util.changeNullStr(request.getParameter("search_free_price")));
		buySellSearchBean.setSend_method(request.getParameter("search_send_method"));
		buySellSearchBean.setSold_out(request.getParameter("search_sold_out"));
		buySellSearchBean.setSearch_range(request.getParameter("search_range"));
		buySellSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		buySellSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));		
	}
	private void setBackBuySellSearchBean(BuySellSearchBean buySellSearchBean,
			HttpServletRequest request) throws IOException {
		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
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
		buySellSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));
		buySellSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		
	}	
	
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = "";
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			pageNumStr = Util.changeNullStr(request.getParameter("before_pageNum"));
		}
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