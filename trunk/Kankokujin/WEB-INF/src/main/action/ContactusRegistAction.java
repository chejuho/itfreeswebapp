package main.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.constant.Const;
import common.exception.SysException;
import common.util.Util;

import main.bean.ContactusBean;
import main.handler.ContactusRegistHandler;

public class ContactusRegistAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

			ContactusBean contactusBean = new ContactusBean();
			setBean(request, contactusBean);
			ContactusRegistHandler contactusRegistHandler = new ContactusRegistHandler();
			try {
				contactusRegistHandler.insertContactusBean(contactusBean);
			} catch (SysException e) {
				// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
				e.printStackTrace();
			}
			request.setAttribute("Message", "MSG0020");		
			this.getServletContext().getRequestDispatcher(
					Const.INDEX_PATH).forward(request, response);
	}
	
	private void setBean(HttpServletRequest request, ContactusBean contactusBean){
		contactusBean.setName(Util.changeNullStr(request.getParameter("name")));
		contactusBean.setEmail(Util.changeNullStr(request.getParameter("email1") + "@" + request.getParameter("email2")));
		contactusBean.setTel_no1_1(Util.changeNullStr(request.getParameter("telephone1")));
		contactusBean.setTel_no1_2(Util.changeNullStr(request.getParameter("telephone2")));
		contactusBean.setTel_no1_3(Util.changeNullStr(request.getParameter("telephone3")));
		contactusBean.setTel_no2_1(Util.changeNullStr(request.getParameter("mobile1")));
		contactusBean.setTel_no2_2(Util.changeNullStr(request.getParameter("mobile2")));
		contactusBean.setTel_no2_3(Util.changeNullStr(request.getParameter("mobile3")));
		contactusBean.setTitle(Util.changeNullStr(request.getParameter("title")));
		contactusBean.setDetail_info(Util.changeNullStr(request.getParameter("detail_info")));
	}
}