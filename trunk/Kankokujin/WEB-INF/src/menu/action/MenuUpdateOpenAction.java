package menu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.Constant.KEYConst;
import menu.Constant.VALUEConst;
import menu.bean.MenuBean;
import menu.handler.MenuHandler;

import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class MenuUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MenuUpdateOpenAction.start");
		
		//セッション情報にパス情報を設定
		//setSessionInfo(path, request);
		MenuHandler menuHandler = MenuHandler.getInstance();
		
		MenuBean result = null;
		MenuBean requestBean = null;
		try {
			/** RequestをメニューBeanに変換 */
			requestBean = menuHandler.changeRequestToMenuBean(request);
		
			/** 分岐処理　固有ロジック実装 */
			String path = (String) requestBean.get(KEYConst.MENU);
			
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				result = menuHandler.selectDetail01(requestBean, false);
			} else if ("menu02".equals(path)) {
				result = menuHandler.selectDetail02(requestBean);
			} else if ("menu03".equals(path)) {
				result = menuHandler.selectDetail03(requestBean);
			} else if ("menu04".equals(path)) {
				result = menuHandler.selectDetail04(requestBean);
			}
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			KankokujinLogger.getInstance().debug("MenuDetailAction.end");
		}
		/** 処理別ページ決定　*/
		String url = getNextPage(requestBean);
		/** 結果をRequestにセット */
		request.setAttribute("menuBean", result);
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	
	private String getNextPage(MenuBean menuBean) {
		String key1 = (String) menuBean.get(KEYConst.MENU);
		String url = "";
		if (VALUEConst.NIHONGOMENU.equals(key1)) {
			url = "/jsp/nihongo/nihongoUpdate.jsp";
		} else if ("menu02".equals(key1)) {
			url = "/jsp/nihongoSchool2/update.jsp";
		}
		
		return url;
	}

	private void setSessionInfo(String path, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("action", "StoreUpdateOpen");
		session.setAttribute("topmenu", path);
		
	}

}
