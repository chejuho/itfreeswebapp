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

import common.constant.Const;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MenuRegistOpenAction extends HttpServlet {

	String SAVEFOLDER = Const.UPLOAD_FOLDER_PATH;
	int MAXSIZE = 10 * 1024 * 1024;
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug("MenuRegistOpenAction.START");
		//セッション情報にパス情報を設定
		setSessionInfo(request);

		MenuHandler menuHandler = MenuHandler.getInstance();
		
		MenuBean requestBean = null;
		
		boolean login = Util.isLogin(request);
		
		/** RequestをメニューBeanに変換 */
		requestBean = menuHandler.changeRequestToMenuBean(request);
		
		if (login) {
			/** 分岐処理　固有ロジック実装 */
			String path = (String) requestBean.get(KEYConst.MENU);
			

		} else {
			request.setAttribute("Message", "WAR0004");
		}
		/** 処理別ページ決定　*/
		String url = getNextPage(requestBean, login);
		
		KankokujinLogger.getInstance().debug("MenuRegistOpenAction.end");
		this.getServletContext().getRequestDispatcher(url).forward(request, response);

	}
	
	/**
	 * @param path
	 * @param request
	 */
	private void setSessionInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("action", "MenuRegistOpen?ka=va");
	}
	
	private String getNextPage(MenuBean bean, boolean login) {
		String url = "";
		String key = (String) bean.get(KEYConst.MENU);
		
		if (login) {
			if (VALUEConst.NIHONGOMENU.equals(key)) {
				url = "/jsp/nihongo/nihongoRegist.jsp";
			} 
			if ("menu02".equals(key)) {
				url =  "/jsp/nihongoSchool/regist.jsp";
			} 
		} else {
			url =  "/MemberLoginOpen";
		}
		return url;
			
	}
}