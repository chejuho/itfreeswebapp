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

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MenuUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug("MenuUpdateOpenAction.start");

		int result = 0;
		MenuBean requestBean = null;
		
		MenuHandler menuHandler = MenuHandler.getInstance();
	
		try {
			/** Request�����j���[Bean�ɕϊ� */
			requestBean = menuHandler.changeRequestToMenuBean(request);
			
			/** ���򏈗��@�ŗL���W�b�N���� */
			String path = (String) requestBean.get(KEYConst.MENU);
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				result = menuHandler.update01(requestBean);
				
			} else if ("menu02".equals(path)) {
				//result = menuHandler.update02(requestBean);
			} else if ("menu03".equals(path)) {
				//result = menuHandler.update03(requestBean);
			} else if ("menu04".equals(path)) {
				//result = menuHandler.update04(requestBean);
			}

		} catch (Exception e) {
			throw new KankokujinException("SYE0024", e);
		} finally {
		}
		
		/** resize */
		imageProcess(requestBean);
		/** ���b�Z�[�W�Z�b�g*/
		setMessage(result, request);
		/** �����ʃy�[�W����@*/
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


	private String getNextPage(MenuBean bean, int result) {
		String url = "";
		
		/** Path */
		String path = (String) bean.get(KEYConst.MENU);
		String id = (String) bean.get("id");
		if (result == 1) {
			if (VALUEConst.NIHONGOMENU.equals(path)) {
				url = "MenuDetail?" + KEYConst.MENU + "="+ VALUEConst.NIHONGOMENU + "&id="+ id;
			} else if ("Menu02".equals(path)) {
				url = "/jsp/store/storeDetail.jsp";
			}
		} else {
			if ("menu01".equals(path)) {
				url = "/jsp/store/storeDetail.jsp";
			} else if ("Menu02".equals(path)) {
				url = "/jsp/store/storeDetail.jsp";
			}
		}
		return url;
	}
	
	
	
	private void setMessage(int result, HttpServletRequest request) {
		if (result == 0) {
			request.setAttribute("Message", "Success to Regist Store info");
			
		} else {
			request.setAttribute("Message", "Fail to Update Store info");
		}
	}
}
