package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.handler.MemberLoginHandler;
import member.handler.MemberUpdateHandler;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("MemberUpdateAction.START");
		// 権限チェック
		if (Util.isLogin(request)) {
			MemberBean memberBean = setMemberBean(request);
			MemberUpdateHandler handler = new MemberUpdateHandler();
			boolean pwCheck = false;
			boolean result = false;
			try {
				pwCheck = handler.pwCheck(memberBean, false);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0001", e);
			} finally {
				KankokujinLogger.getInstance().debug("MemberUpdateAction.END");
			}
			if (pwCheck) {
				try {
					result = handler.updateMemberBean(memberBean);
					
				} catch (SysException e) {
					throw new KankokujinException(e.getMessage(), e);
				} catch (Exception e) {
					throw new KankokujinException(
							"SYE0011", e);
				} finally {
					KankokujinLogger.getInstance().debug(
							"MemberUpdateAction.END");
				}
				if (result) {
					MemberLoginHandler memberLoginHandler = new MemberLoginHandler();
					try {
						memberBean = memberLoginHandler.getMemberInfo(memberBean.getUserid());
					} catch (SysException e) {
						throw new KankokujinException(e.getMessage(), e);
					} catch (Exception e) {
						throw new KankokujinException(
								"SYE0011", e);
					}
					HttpSession session = request.getSession();
					session.setAttribute("memberInfo", memberBean);
					this.getServletContext().getRequestDispatcher(
							"/MemberDetail").forward(request, response);
				} else {
					throw new KankokujinException("ERR0006");
				}
			} else {
				request.setAttribute("Message", "WAR0005");
				this.getServletContext().getRequestDispatcher(
						"/MemberUpdateOpen").forward(request, response);
			}
		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}

	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		bean.setNewPassword(Util.changeNullStr(request
				.getParameter("newPassword")));
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
		bean.setAddress(Util.changeNullStr(EnDecoding.decoding(request
				.getParameter("address"))));
		return bean;

	}

}
