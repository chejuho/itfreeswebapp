package main.action;

import findjob.bean.FindjobSearchBean;
import findjob.handler.FindjobSearchHandler;
import gourmet.bean.GourmetSearchBean;
import gourmet.handler.GourmetSearchHandler;
import housesell.bean.HouseSearchBean;
import housesell.bean.HouseSellSortBean;
import housesell.handler.HouseSellListHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.bean.JobSearchBean;
import job.handler.JobSearchHandler;
import main.bean.AllSearchCountBean;
import main.handler.MyWriteHandler;
import roomsell.bean.RoomSearchBean;
import roomsell.handler.RoomSellListHandler;
import store.bean.StoreSearchBean;
import store.handler.StoreSearchHandler;
import buysell.bean.BuySellSearchBean;
import buysell.handler.BuySellListHandler;

import common.bean.MemberBean;
import common.bean.PageBean;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class MyWriteAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、JobSortBean、PageBean、JobBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	private static final int START_NO = 1;

	private static final int COUNT = 10;

	private static final String BUY_CODE = "C10100";

	private static final String SELL_CODE = "C10200";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.setAttribute("topmenu", "");
		if (Util.isLogin(request)) {
			session.setAttribute("action", "MyWrite");
			KankokujinLogger.getInstance().debug("JobListAction.start");

			
			List buyBeanList = new ArrayList();
			List sellBeanList = new ArrayList();
			List storeBeanList = new ArrayList();
			List gourmetBeanList = new ArrayList();
			List roomBean1List = new ArrayList();
			List roomBean2List = new ArrayList();
			List houseBeanList = new ArrayList();
			List jobBeanList = new ArrayList();
			List findjobBeanList = new ArrayList();

			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			String user_id = "";
			if (memberBean != null) {
				user_id = memberBean.getUserid();
			}
			/** ページ情報 */
			PageBean pageBean = PageUtil.getInstance().pagingProcess(request, "10");
			
			String sort = request.getParameter("sort");
			String pageNum = request.getParameter("pageNum");
			if (!Util.isEmpty(pageNum) && Util.isEmpty(sort)) {
				sort = request.getParameter("before_sort");
			}

			MyWriteHandler myWriteHandler = MyWriteHandler.getInstance();
			AllSearchCountBean allSearchCountBean;
			try {
				allSearchCountBean = myWriteHandler.getAllSearchCount(user_id);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			}

			int maxInfoCount1 = allSearchCountBean.getBuy_count();
			int maxInfoCount2 = allSearchCountBean.getSell_count();
			int maxInfoCount3 = allSearchCountBean.getStore_count();
			int maxInfoCount4 = allSearchCountBean.getGourmet_count();
			int maxInfoCount5 = allSearchCountBean.getHotel_count();
			int maxInfoCount6 = allSearchCountBean.getBoardingHouse_count();
			int maxInfoCount7 = allSearchCountBean.getHouseSell_count();
			int maxInfoCount8 = allSearchCountBean.getJobSearch_count();
			int maxInfoCount9 = allSearchCountBean.getFindjobSearch_count();

			if ("1".equals(sort) || Util.isEmpty(sort)) {

				//(pageBean, request, session, maxInfoCount1);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount1);
				buyBeanList = getBuyBeanList(pageBean.getStartCount(), pageBean.getPageCount(), buyBeanList, user_id);
			} else if ("2".equals(sort)) {

				//(pageBean, request, session, maxInfoCount2);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount2);
				sellBeanList = getSellBeanList(pageBean.getStartCount(), pageBean.getPageCount(), sellBeanList, user_id);
			} else if ("3".equals(sort)) {

				//(pageBean, request, session, maxInfoCount3);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount3);
				storeBeanList = getStoreBeanList(pageBean.getStartCount(), pageBean.getPageCount(), storeBeanList, user_id);
			} else if ("4".equals(sort)) {

				//(pageBean, request, session, maxInfoCount4);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount4);
				gourmetBeanList = getGourmetBeanList(pageBean.getStartCount(), pageBean.getPageCount(), gourmetBeanList, user_id);
			} else if ("5".equals(sort)) {

				//(pageBean, request, session, maxInfoCount5);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount5);
				roomBean1List = getRoomBeanList(pageBean.getStartCount(), pageBean.getPageCount(), roomBean1List, user_id, "C10001");
			} else if ("6".equals(sort)) {

				//(pageBean, request, session, maxInfoCount6);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount6);
				roomBean2List = getRoomBeanList(pageBean.getStartCount(), pageBean.getPageCount(), roomBean2List, user_id, "C10002");
			} else if ("7".equals(sort)) {

				//(pageBean, request, session, maxInfoCount7);
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount7);
				houseBeanList = getHouseBeanList(pageBean.getStartCount(), pageBean.getPageCount(), houseBeanList, user_id);
			} else if ("8".equals(sort)) {

				//setPageInfo(pageBean, request, session, maxInfoCount8);
				//ページ処理
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount8);
				jobBeanList = getJobBeanList(pageBean.getStartCount(), pageBean .getPageCount(), jobBeanList, user_id);
			} else if ("9".equals(sort)) {
				//setPageInfo(pageBean, request, session, maxInfoCount9);
				//ページ処理
				PageUtil.getInstance().nextPage(pageBean, maxInfoCount9);
				findjobBeanList = getFindJobBeanList(pageBean.getStartCount(), pageBean.getPageCount(), findjobBeanList, user_id);
			} else {
				buyBeanList = getBuyBeanList(START_NO, COUNT, buyBeanList, user_id);
				sellBeanList = getSellBeanList(START_NO, COUNT, sellBeanList, user_id);
				storeBeanList = getStoreBeanList(START_NO, COUNT, storeBeanList, user_id);
				gourmetBeanList = getGourmetBeanList(START_NO, COUNT, gourmetBeanList, user_id);
				jobBeanList = getJobBeanList(START_NO, COUNT, jobBeanList, user_id);
				findjobBeanList = getFindJobBeanList(START_NO, COUNT, findjobBeanList, user_id);
			}
			
			session.setAttribute("PageBean", pageBean);
			request.setAttribute("sort", sort);
			request.setAttribute("maxInfoCount1", String.valueOf(maxInfoCount1));
			request.setAttribute("maxInfoCount2", String.valueOf(maxInfoCount2));
			request.setAttribute("maxInfoCount3", String.valueOf(maxInfoCount3));
			request.setAttribute("maxInfoCount4", String.valueOf(maxInfoCount4));
			request.setAttribute("maxInfoCount5", String.valueOf(maxInfoCount5));
			request.setAttribute("maxInfoCount6", String.valueOf(maxInfoCount6));
			request.setAttribute("maxInfoCount7", String.valueOf(maxInfoCount7));
			request.setAttribute("maxInfoCount8", String.valueOf(maxInfoCount8));
			request.setAttribute("maxInfoCount9", String.valueOf(maxInfoCount9));
			request.setAttribute("BuyBeanList", buyBeanList);
			request.setAttribute("SellBeanList", sellBeanList);
			request.setAttribute("StoreBeanList", storeBeanList);
			request.setAttribute("GourmetBeanList", gourmetBeanList);
			request.setAttribute("RoomBean1List", roomBean1List);
			request.setAttribute("RoomBean2List", roomBean2List);
			request.setAttribute("HouseBeanList", houseBeanList);
			request.setAttribute("JobBeanList", jobBeanList);
			request.setAttribute("FindjobBeanList", findjobBeanList);
			this.getServletContext().getRequestDispatcher("/jsp/main/my_write.jsp").forward(request, response);
		} else {
			session.setAttribute("action", "MyWrite");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);
		}
	}

	private void setPageInfo(PageBean pageBean, HttpServletRequest request,
			HttpSession session, int maxInfoCount) {
		if (pageBean == null || request.getParameter("pageNum") == null) {
			pageBean.setPageSize(10);
			PageUtil.getInstance().init(pageBean, maxInfoCount);
		} else if ("sprev".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().sprev(pageBean, maxInfoCount);

		} else if ("bprev".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().bprev(pageBean, maxInfoCount);
		} else if ("snext".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().snext(pageBean, maxInfoCount);
		} else if ("bnext".equals(pageBean.getPagingSign())) {
			pageBean = (PageBean) session.getAttribute("PageBean");
			PageUtil.getInstance().bnext(pageBean, maxInfoCount);
		} else {
			// pageBean = (PageBean) session.getAttribute("PageBean");
			// pageBean.setPageSize(pageSize);
			PageUtil.getInstance().jump(pageBean, pageBean.getPageNum(),
					maxInfoCount);
		}
	}

	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = request.getParameter("pageNum");
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

	private List getBuyBeanList(int startCount, int pageCount,
			List buyBeanList, String user_id) {

		BuySellListHandler buySellListHandler = BuySellListHandler
				.getInstance();
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		buySellSearchBean.setUser_id(user_id);
		buySellSearchBean.setCate_code_1(BUY_CODE);
		try {
			buyBeanList = buySellListHandler.getBuySellList(startCount, pageCount, buySellSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return buyBeanList;
	}

	private List getSellBeanList(int startCount, int pageCount,
			List sellBeanList, String user_id) {
		BuySellListHandler buySellListHandler = BuySellListHandler.getInstance();
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		buySellSearchBean.setUser_id(user_id);
		buySellSearchBean.setCate_code_1(SELL_CODE);
		buySellSearchBean.setUserFlag("1");
		try {
			sellBeanList = buySellListHandler.getBuySellList(startCount, pageCount, buySellSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return sellBeanList;
	}

	private List getStoreBeanList(int startCount, int pageCount,
			List storeBeanList, String user_id) {
		StoreSearchHandler storeSearchHandler = StoreSearchHandler
				.getInstance();
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		storeSearchBean.setUser_id(user_id);
		try {
			storeBeanList = storeSearchHandler.getSearchStoreList(startCount,
					pageCount, storeSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return storeBeanList;
	}

	private List getGourmetBeanList(int startCount, int pageCount,
			List gourmetBeanList, String user_id) {
		GourmetSearchHandler gourmetSearchHandler = GourmetSearchHandler
				.getInstance();
		GourmetSearchBean gourmetSearchBean = new GourmetSearchBean();
		gourmetSearchBean.setUser_id(user_id);

		try {
			gourmetBeanList = gourmetSearchHandler.getSearchGourmetList(
					startCount, pageCount, gourmetSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return gourmetBeanList;
	}

	private List getRoomBeanList(int startCount, int pageCount,
			List roomBeanList, String user_id, String cate_code_1) {
		RoomSellListHandler roomSellListHandler = RoomSellListHandler
				.getInstance();
		RoomSearchBean roomSearchBean = new RoomSearchBean();
		roomSearchBean.setUser_id(user_id);
		roomSearchBean.setCate_code_1(cate_code_1);
		try {
			roomBeanList = roomSellListHandler.getRoomBeanList(roomSearchBean,
					startCount, pageCount);
		} catch (AppException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return roomBeanList;
	}

	private List getHouseBeanList(int startCount, int pageCount,
			List houseBeanList, String user_id) {
		HouseSellListHandler houseSellListHandler = HouseSellListHandler
				.getInstance();
		HouseSearchBean houseSearchBean = new HouseSearchBean();
		houseSearchBean.setUser_id(user_id);
		HouseSellSortBean houseSellSortBean = new HouseSellSortBean();
		try {
			houseBeanList = houseSellListHandler.getHouseBeanList(houseSearchBean, houseSellSortBean, startCount, pageCount);
		} catch (AppException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return houseBeanList;
	}

	private List getJobBeanList(int startCount, int pageCount,
			List jobBeanList, String user_id) {
		JobSearchHandler jobSearchHandler = JobSearchHandler.getInstance();
		JobSearchBean jobSearchBean = new JobSearchBean();
		jobSearchBean.setUser_id(user_id);
		try {
			jobBeanList = jobSearchHandler.getSearchJobList(startCount, pageCount, jobSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return jobBeanList;
	}

	private List getFindJobBeanList(int startCount, int pageCount,
			List findJobBeanList, String user_id) {
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		findjobSearchBean.setUser_id(user_id);
		FindjobSearchHandler findjobSearchHandler = FindjobSearchHandler
				.getInstance();
		try {
			findJobBeanList = findjobSearchHandler.getSearchFindjobList(startCount, pageCount, findjobSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return findJobBeanList;
	}
}