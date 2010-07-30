package engmail.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import engmail.bean.EngmailListBean;

public class EngMailRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] tempCheckboxWebmail = request.getParameterValues("checkbox_web_mail");
		String[] tempCheckboxMobilemail = request.getParameterValues("checkbox_mobile_mail");
		String count = (String) request.getParameter("count");
		if(!Util.isEmpty(count)){
			tempCheckboxWebmail = changeArray(tempCheckboxWebmail, count);
			tempCheckboxMobilemail = changeArray(tempCheckboxMobilemail, count);
		}
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			KankokujinLogger.getInstance().debug(
					"EngMailRegistOpenAction.start");
			
			List selectedMailList = new ArrayList();
			if (!"0".equals(count) && !Util.isEmpty(count)) {
				for (int i = 0; i < Integer.parseInt(count); i++) {

					String tempName = EnDecoding.decoding(request
							.getParameter("name_" + i));
					// String tempCheckboxName =
					// (String)request.getParameter("checkbox_mobile_mail_" +
					// i);
					if ("1".equals(tempCheckboxWebmail[i])
							|| "1".equals(tempCheckboxMobilemail[i])) {
						EngmailListBean bean = new EngmailListBean();
						if ("1".equals(tempCheckboxWebmail[i])) {
							bean.setTo_mail((String) request
									.getParameter("web_mail_" + i));
						}
						if ("1".equals(tempCheckboxMobilemail[i])) {
							bean.setTo_mobile_mail((String) request
									.getParameter("mobile_mail_" + i));
						}
						bean.setTo_name(tempName);
						selectedMailList.add(bean);
					}

				}
			}
			request.setAttribute("selectedMailList", selectedMailList);
			this.getServletContext().getRequestDispatcher(
					"/jsp/engmail/engMailRegist.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}
	}
	public String [] changeArray(String[] array, String count){
		String[] newArray = new String[Integer.parseInt(count)];
		for (int j=0; j < newArray.length; j++) {
			newArray[j]="0";			
		}
		if (array != null) {
			int size = array.length;
			for (int i=0; i< size; i++) {
				String temp = array[i];
				int tempInt = Integer.parseInt(temp);
				newArray[tempInt]="1";
			}
		}

		return newArray;
	}
}