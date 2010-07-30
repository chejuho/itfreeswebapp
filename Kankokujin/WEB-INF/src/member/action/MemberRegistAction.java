package member.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.handler.MemberRegistHandler;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;
import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class MemberRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberRegistAction.START");
		MemberBean memberBean = setMemberBean(request);
		String userName = memberBean.getName();
		MemberRegistHandler memberRegistHandler = new MemberRegistHandler();
		boolean registChk = false;
		boolean result = false;
		try {

			registChk = memberRegistHandler.isExistIdMail(memberBean.getUserid(), memberBean
					.getEmail1(), memberBean.getEmail2());
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"SYE0009", e);
		} finally {
		}
		if (registChk) {
			try {
				result = memberRegistHandler.insert(memberBean);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0010", e);
			} finally {
			}
			if (result) {

				request.setAttribute("userName", EnDecoding.decoding(userName));
				this.getServletContext().getRequestDispatcher(
						"/jsp/member/member_regist_result.jsp").forward(
						request, response);
			} else {
				throw new KankokujinException("ERR0005");
			}
		} else {
			request.setAttribute("Message", "WAR0002");
			memberBean.setName(EnDecoding.decoding(memberBean.getName()));
			request.setAttribute("MemberBean", memberBean);			
			this.getServletContext().getRequestDispatcher("/jsp/member/memberRegist.jsp")
					.forward(request, response);
		}

	}

	private EmailBean setEmailBean(MemberBean bean)
			throws AppException {

		SendMailHandler handler = new SendMailHandler();
		HashMap mailMap = handler.getFileContents(Const.REGIST_MAIL_FILENAME);

		String subject = (String) mailMap.get("subject");
		String contents = (String) mailMap.get("contents");

		contents = contents.replace("USERID_X", bean.getUserid());
		contents = contents.replace("PASSWORD_X", bean.getPassword());
		contents = contents.replace("REGISTNUM_X", bean.getRegistnum());
		contents = contents.replace("SERVER_DOMAIN", Const.SERVER_DOMAIN);

		EmailBean emailBean = new EmailBean();
		emailBean.setToId(bean.getUserid());
		emailBean.setFromId(Const.ADMIN_ID);
		emailBean.setSubject(subject);
		emailBean.setContents(contents);
		return emailBean;
	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		bean.setEmail1(Util.changeNullStr(request.getParameter("email1")));
		bean.setEmail2(Util.changeNullStr(request.getParameter("email2")));
		bean.setName(Util.changeNullStr(request
				.getParameter("name")));
		bean.setTelephone1(Util.changeNullStr(request
				.getParameter("telephone1")));
		bean.setTelephone2(Util.changeNullStr(request
				.getParameter("telephone2")));
		bean.setTelephone3(Util.changeNullStr(request
				.getParameter("telephone3")));
		bean.setMobile1(Util.changeNullStr(request.getParameter("mobile1")));
		bean.setMobile2(Util.changeNullStr(request.getParameter("mobile2")));
		bean.setMobile3(Util.changeNullStr(request.getParameter("mobile3")));
		bean.setAddress(Util.changeNullStr(request
				.getParameter("address")));
		bean.setAgree_check(Util.changeNullStr(request.getParameter("agree_check")));
		String StartChar = "I";
		String registnum = Util.getRND(StartChar);
		bean.setRegistnum(registnum);
		return bean;
	}
}
