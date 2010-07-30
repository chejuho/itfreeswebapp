package menu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.bean.MenuBean;
import menu.handler.MenuHandler;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class MenuDeleteAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug("MenuDeleteAction.start");
		//セッション情報にパス情報を設定
		setSessionInfo(request);

		boolean result = false;
		MenuBean requestBean = null;
		
		MenuHandler handler = MenuHandler.getInstance();
		
		try {
			
			/** RequestをメニューBeanに変換 */
			requestBean = handler.changeRequestToMenuBean(request);
			
			/** 分岐処理　固有ロジック実装 */
			String path = (String) requestBean.get("key01");
			if ("menu01".equals(path)) {
				result = handler.delete01(requestBean);
			} else if ("menu02".equals(path)) {
				result = handler.delete02(requestBean);
			} else if ("menu03".equals(path)) {
				result = handler.delete03(requestBean);
			} else if ("menu04".equals(path)) {
				result = handler.delete04(requestBean);
			} 
			
		} catch (Exception e) {
			throw new KankokujinException("SYE0014", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreDeleteAction.end");
		}
		/** 処理別ページ決定　*/
		String url = getNextPage(requestBean, result);
		/** メッセージセット*/
		setMessage(result, request);
		
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * @param path
	 * @param request
	 */
	private void setSessionInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("action", "Search");
		//session.setAttribute("topmenu", path);
		String numId = request.getParameter("id");
		String before = request.getParameter("before");
		session.setAttribute("action", "StoreDetail?before=" +before+ "&id="+numId);
	}

	private String getNextPage(MenuBean bean, boolean result) {
		String url = "";
		String key = (String) bean.get("key01");
		
		if ("menu01".equals(key)) {
			url = "/MenuSearchAction";
		} else if ("Menu02".equals(key)) {
			url = "/jsp/store/storeDetail.jsp";
		}
			
		return url;
	}
	
	private void setMessage(boolean result, HttpServletRequest request) {
		if (result) {
			request.setAttribute("Message", "Success to Delete info");
		} else {
			request.setAttribute("Message", "Fail to Delete info");
		}
	}

}