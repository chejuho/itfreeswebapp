package menu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.Constant.KEYConst;
import menu.Constant.VALUEConst;
import menu.bean.MenuBean;
import menu.handler.MenuHandler;

import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MenuRegistAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	String SAVEFOLDER = Const.UPLOAD_FOLDER_PATH;
	int MAXSIZE = 10 * 1024 * 1024;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug("MenuRegistAction.start");
		
		boolean result = false;
		MenuBean requestBean = null;
		
		try {			
			MenuHandler handler = MenuHandler.getInstance();
			/** RequestをメニューBeanに変換 */
			requestBean = handler.changeRequestToMenuBean(request);
			
			/** 分岐処理　固有ロジック実装 */
			String path = (String) requestBean.get(KEYConst.MENU);
			
			//日本語学校
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				result = handler.insert01(requestBean);
			} else if ("menu02".equals(path)) {
				result = handler.insert02(requestBean);
			} else if ("menu03".equals(path)) {
				result = handler.insert03(requestBean);
			} else if ("menu04".equals(path)) {
				result = handler.insert04(requestBean);
			}
		} catch (Exception e) {
			throw new KankokujinException("SYE0020", e);
		} finally {
			KankokujinLogger.getInstance().debug("StoreRegistAction.end");
		}
		
		/** resize */
		imageProcess(requestBean);

		/** 処理別ページ決定　*/
		String url = getNextPage(requestBean, result);
		
		response.sendRedirect(url);
	}

	/**
	 * 
	 * @param requestBean
	 */
	private void imageProcess(MenuBean requestBean) {
		Util.makeResizeFile(requestBean);
	}

	private String getNextPage(MenuBean bean, boolean result) {
		String url = "";
		String path = (String) bean.get(KEYConst.MENU);
		if (result) {
			//日本語学校
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				url = "MenuSearch?"+ KEYConst.MENU + "=" + VALUEConst.NIHONGOMENU;
			} else if ("menu02".equals(path)) {
				//result = handler.insert02(requestBean);
			}
		} else {
			return "/MenuRegistOpen";
		}
		
		return url;
			
	}
}