package main.action;

import findjob.bean.FindjobSearchBean;
import findjob.handler.FindjobSearchHandler;
import gourmet.bean.GourmetSearchBean;
import gourmet.handler.GourmetSearchHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.bean.JobSearchBean;
import job.handler.JobSearchHandler;
import store.bean.StoreSearchBean;
import store.handler.StoreSearchHandler;
import buysell.bean.BuySellSearchBean;
import buysell.handler.BuySellListHandler;

import common.bean.SearchBean;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;


public class AllSearchAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、JobSortBean、PageBean、JobBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;
	private static final int START_NO = 1;
	private static final int COUNT = 5;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("JobListAction.start");

		SearchBean searchBean = new SearchBean();
		searchBean.setAll_search(EnDecoding.decoding(request.getParameter("all_search")));
		searchBean.setAll_search_decoded(Util.changeNullStr(request.getParameter("all_search")));
		searchBean.setAll_search_range(Util.changeNullStr(request.getParameter("all_search_range")));
	
		List buyBeanList = new ArrayList();
		List sellBeanList = new ArrayList();
		List storeBeanList = new ArrayList();
		List gourmetBeanList = new ArrayList();
		List jobBeanList = new ArrayList();
		List findjobBeanList = new ArrayList();
		
		if("0".equals(searchBean.getAll_search_range())){
			buyBeanList = getBuyBeanList(buyBeanList, searchBean.getAll_search());
			sellBeanList = getSellBeanList(sellBeanList, searchBean.getAll_search());
			storeBeanList = getStoreBeanList(storeBeanList, searchBean.getAll_search());
			gourmetBeanList = getGourmetBeanList(gourmetBeanList, searchBean.getAll_search());
			jobBeanList = getJobBeanList(jobBeanList, searchBean.getAll_search());
			findjobBeanList = getFindJobBeanList(findjobBeanList, searchBean.getAll_search());
			
		} else if ("1".equals(searchBean.getAll_search_range())){
			buyBeanList = getBuyBeanList(buyBeanList, searchBean.getAll_search());	
			
		} else if ("2".equals(searchBean.getAll_search_range())){
			sellBeanList = getSellBeanList(sellBeanList, searchBean.getAll_search());
			
		} else if ("3".equals(searchBean.getAll_search_range())){			
			storeBeanList = getStoreBeanList(storeBeanList, searchBean.getAll_search());
			
		} else if ("4".equals(searchBean.getAll_search_range())){
			gourmetBeanList = getGourmetBeanList(gourmetBeanList, searchBean.getAll_search());
			
		} else if ("5".equals(searchBean.getAll_search_range())){
			
		} else if ("6".equals(searchBean.getAll_search_range())){
			
		} else if ("7".equals(searchBean.getAll_search_range())){
			jobBeanList = getJobBeanList(jobBeanList, searchBean.getAll_search());
			
		} else if ("8".equals(searchBean.getAll_search_range())){
			findjobBeanList = getFindJobBeanList(findjobBeanList, searchBean.getAll_search());
		} 
		
		request.setAttribute("BuyBeanList", buyBeanList);
		request.setAttribute("SellBeanList", sellBeanList);
		request.setAttribute("StoreBeanList", storeBeanList);
		request.setAttribute("GourmetBeanList", gourmetBeanList);
		request.setAttribute("JobBeanList", jobBeanList);
		request.setAttribute("FindjobBeanList", findjobBeanList);
		request.setAttribute("SearchBean", searchBean);

		this.getServletContext().getRequestDispatcher(
				"/jsp/main/allSearchList.jsp")
				.forward(request, response);				
	}

	private List getBuyBeanList(List buyBeanList, String search_all){
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		buySellSearchBean.setCate_code_1("C10100");
		buySellSearchBean.setSearch(search_all);
		buySellSearchBean.setSearch_range("0");
		BuySellListHandler buySellListHandler = BuySellListHandler.getInstance();
		try {
			buyBeanList = buySellListHandler.getBuySellList(START_NO,
					COUNT, buySellSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return buyBeanList;
	}
	private List getSellBeanList(List sellBeanList, String search_all){
		BuySellSearchBean buySellSearchBean = new BuySellSearchBean();
		buySellSearchBean.setCate_code_1("C10200");
		buySellSearchBean.setSearch(search_all);
		buySellSearchBean.setSearch_range("0");
		BuySellListHandler buySellListHandler = BuySellListHandler.getInstance();
		try {
			sellBeanList = buySellListHandler.getBuySellList(START_NO,
					COUNT, buySellSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
		return sellBeanList;
	}

	private List getStoreBeanList(List storeBeanList, String search_all){
		StoreSearchBean storeSearchBean = new StoreSearchBean();
		storeSearchBean.setSearch(search_all);
		storeSearchBean.setSearch_range("0");
		StoreSearchHandler storeSearchHandler = StoreSearchHandler.getInstance();
		try {
			storeBeanList = storeSearchHandler.getSearchStoreList(START_NO, COUNT, storeSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
		return storeBeanList;
	}
	private List getGourmetBeanList(List gourmetBeanList, String search_all){
		GourmetSearchBean gourmetSearchBean = new GourmetSearchBean();
		gourmetSearchBean.setSearch(search_all);
		gourmetSearchBean.setSearch_range("0");
		GourmetSearchHandler gourmetSearchHandler = GourmetSearchHandler.getInstance();
		try {
			gourmetBeanList = gourmetSearchHandler.getSearchGourmetList(START_NO, COUNT, gourmetSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
		return gourmetBeanList;
	}
	private List getJobBeanList(List jobBeanList, String search_all){
		JobSearchBean jobSearchBean = new JobSearchBean();
		jobSearchBean.setSearch(search_all);
		jobSearchBean.setSearch_range("0");
		JobSearchHandler jobSearchHandler = JobSearchHandler.getInstance();
		try {
			jobBeanList = jobSearchHandler.getSearchJobList(START_NO, COUNT, jobSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
		return jobBeanList;
	}
	private List getFindJobBeanList(List findJobBeanList, String search_all){
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		findjobSearchBean.setSearch(search_all);
		findjobSearchBean.setSearch_range("0");
		FindjobSearchHandler findjobSearchHandler = FindjobSearchHandler.getInstance();
		try {
			findJobBeanList = findjobSearchHandler.getSearchFindjobList(START_NO,
					COUNT, findjobSearchBean);
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return findJobBeanList;
	}	
}