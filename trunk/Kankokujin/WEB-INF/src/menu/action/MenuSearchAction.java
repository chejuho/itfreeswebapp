package menu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.Constant.KEYConst;
import menu.Constant.VALUEConst;
import menu.bean.MenuBean;
import menu.handler.MenuHandler;


import common.bean.PageBean;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class MenuSearchAction extends HttpServlet {
	
	/**
	 * MenuActionを開く
	 * 
	 * @param request,response
	 * @return StoreBean、StoreSortBean、PageBean、StoreBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		KankokujinLogger.getInstance().debug("MenuSearchAction.start");
			
		HttpSession session = request.getSession();
		
		MenuHandler handler = MenuHandler.getInstance();

		/** RequestをメニューBeanに変換 */
		MenuBean requestBean = handler.changeRequestToMenuBean(request);		
		MenuBean searchBean = createSearchBean(requestBean, session);
		/** ページ処理共通 */
		PageBean pageBean = (PageBean) session.getAttribute("PageBean");
		pageBean = setPageBean(pageBean, request);
		
		
		List menuBeanList = null;
		try {
			/** 分岐処理　固有ロジック実装 */
			String path = (String) requestBean.get(KEYConst.MENU);
			//日本語学校
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				menuBeanList = handler.select01(pageBean, searchBean);
			//住所検索・経路検索
			} else if (VALUEConst.ADDRESSMENU.equals(path)) {
				menuBeanList = handler.select02(pageBean, searchBean);
			} else if ("menu03".equals(path)) {
				menuBeanList = handler.select03(pageBean, requestBean);
			} else if ("menu04".equals(path)) {
				menuBeanList = handler.select04(pageBean, requestBean);
			}
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreListAction.end");
		}
		
		/** 結果をRequestにセット */
		//pageBean.setSearchBean(searchBean);
		session.setAttribute("searchBean", searchBean);
		session.setAttribute("PageBean", pageBean);
		//request.setAttribute("searchBean", searchBean);
		request.setAttribute("menuBeanList", menuBeanList);
		
		/** 処理別ページ決定　*/
		String url = getNextPage(requestBean);
		this.getServletContext().getRequestDispatcher(url).forward(request, response);

	}
	/**
	 * 
	 * @param requestBean 
	 * @param session 
	 * @return
	 */
	private MenuBean createSearchBean(MenuBean requestBean, HttpSession session) {
		
		MenuBean searchBean = (MenuBean) session.getAttribute("searchBean");
		
		if (searchBean == null) {
			searchBean = new MenuBean();
		}
		/** 分岐処理　固有ロジック実装 */
		String path = (String) requestBean.get(KEYConst.MENU);
		//日本語学校
		if (VALUEConst.NIHONGOMENU.equals(path)) {
			if (VALUEConst.SEARCH_EVENT.equals(requestBean.get(KEYConst.EVENT))) {
				searchBean.put("search_user_id", (String) requestBean.get("search_user_id"));
				searchBean.put("searchArea1", (String) requestBean.get("searchArea1"));
				searchBean.put("searchArea2", (String) requestBean.get("searchArea2"));
				searchBean.put("searchLine", (String) requestBean.get("searchLine"));
				searchBean.put("searchStation", (String) requestBean.get("searchStation"));
				searchBean.put("search_dormitoryflg", (String) requestBean.get("search_dormitoryflg"));
				searchBean.put("search_range", (String) requestBean.get("search_range"));
				searchBean.put("search",  EnDecoding.decoding((String) requestBean.get("search")));
				searchBean.put("sortPattern", (String) requestBean.get("sortPattern"));
			}
		} else if (VALUEConst.ADDRESSMENU.equals(path)) {
			if (VALUEConst.SEARCH_EVENT.equals(requestBean.get(KEYConst.EVENT))) {
				searchBean.put("sign", (String) requestBean.get("sign"));
				searchBean.put("address_name", EnDecoding.decoding((String) requestBean.get("address_name")));
				searchBean.put("zip_code1", (String) requestBean.get("zip_code1"));
				searchBean.put("zip_code2", (String) requestBean.get("zip_code2"));
				searchBean.put("station_name", EnDecoding.decoding((String) requestBean.get("station_name")));
			}
		}
		
		
		
		return searchBean;
	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private PageBean setPageBean(PageBean bean, HttpServletRequest request) {
		
		String pageNum = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		
		int pageSize = 10;
		
		if (!Util.isEmpty(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		if (bean == null || Util.isEmpty(request.getParameter("pageNum"))) {
			bean = new PageBean();
			bean.setPageSize(pageSize);		
			bean.setPagingSign("init");
		}
		
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
		
		return bean;
		
	}
	
	
	/**
	 * 
	 * @param path
	 * @param request
	 */
	private void setSessionInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("action", "Search");
		//session.setAttribute("topmenu", path);
		
	}
	
	private String getNextPage(MenuBean bean) {
		String url = "";
		String key = (String) bean.get(KEYConst.MENU);
		if (VALUEConst.NIHONGOMENU.equals(key)) {
			return "/jsp/nihongo/nihongoSearchList.jsp";
		} else if (VALUEConst.ADDRESSMENU.equals(key)) {
			return "/jsp/address/addressStationSearchList.jsp";
		}
		return "/MenuRegistOpen";	
	}

}