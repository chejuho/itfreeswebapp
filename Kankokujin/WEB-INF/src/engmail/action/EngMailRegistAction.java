package engmail.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.EnDecoding;
import common.util.Util;

import eigyoumail.bean.EigyoumailListBean;
import engmail.bean.EngmailBean;
import engmail.bean.EngmailListBean;
import engmail.handler.EngMailRegistHandler;

public class EngMailRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			String title = (String) request.getParameter("title");
			String content = (String) request.getParameter("content");

			EngmailBean bean = new EngmailBean();
			// bean.setMail_id(mail_id);
			bean.setSubject(title);
			bean.setContents(content);
			bean.setUpdate_by_user_id("jeong");
			EngMailRegistHandler engMailRegistHandler = new EngMailRegistHandler();
			if (engMailRegistHandler.insertEng_email(bean)) {
				this.getServletContext().getRequestDispatcher("/EngMailList")
						.forward(request, response);
			} else {
				System.out.println("insert error");
			}
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}
	}
	
}