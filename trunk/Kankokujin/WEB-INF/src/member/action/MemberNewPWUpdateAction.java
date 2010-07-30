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
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MemberNewPWUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("MemberNewPWUpdateAction.START");
		HttpSession session = request.getSession();
		MemberBean bean = setMemberBean(request);
		MemberUpdateHandler handler = new MemberUpdateHandler();
		MemberLoginHandler member = new MemberLoginHandler();
		MemberBean mBean = new MemberBean();
		String userName = "";
		boolean pwCheck = false;
		boolean result = false;
		try {
			pwCheck = handler.pwCheck(bean, true);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0001", e);
		} finally {
			KankokujinLogger.getInstance().debug("MemberNewPWUpdateAction.END");
		}
		if (pwCheck) {
			try {
				result = handler.updateNewPW(bean);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0008", e);

			}
			try {
				mBean = member.getMemberInfo(bean.getUserid());
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0003", e);

			} finally {
				KankokujinLogger.getInstance().debug(
						"MemberNewPWUpdateAction.END");
			}
			if (result) {
				session.setAttribute("memberInfo", mBean);
				userName = mBean.getName();
				request.setAttribute("userName", userName);
				this.getServletContext().getRequestDispatcher(
						"/jsp/member/memberNewPWUpdate_result.jsp").forward(
						request, response);
			} else {
				throw new KankokujinException("");
			}
		} else {
			request.setAttribute("Message", "WAR0007");
			this.getServletContext().getRequestDispatcher(
					"/MemberNewPWUpdateOpen").forward(request, response);
		}
	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("tmppassword")));
		bean.setNewPassword(Util.changeNullStr(request
				.getParameter("newPassword")));
		return bean;

	}

}
