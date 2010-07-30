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
import common.util.Util;

public class RegistKankokujinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("RegistKankokujinAction.START");
		MemberBean bean = setMemberBean(request);
		String userid = bean.getUserid();
		MemberUpdateHandler handler = new MemberUpdateHandler();
		HttpSession session = request.getSession();
		MemberLoginHandler memberLoginHandler = new MemberLoginHandler();
		MemberBean memberInfo = new MemberBean();

		boolean result = false;
		try {

			result = handler.setMemberRegistFlg(bean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"SYE0012", e);
		} finally {
			KankokujinLogger.getInstance().debug("MemberDeleteAction.END");
		}
		if (result) {
/*			try {
				handler.interpretViewOn(userid);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0013", e);
			} */
			try {
				memberInfo = memberLoginHandler.getMemberInfo(userid);
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0003", e);
			} finally {
				KankokujinLogger.getInstance().debug("MemberDeleteAction.END");
			}
			System.out.println(memberInfo.getName());
			session.setAttribute("memberInfo", memberInfo);
			this.getServletContext().getRequestDispatcher(
					"/jsp/member/regist_kankokujin_result.jsp").forward(
					request, response);
		} else {
			request.setAttribute("Message", "WAR0006");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);			
			
		}

	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setPassword(Util.changeNullStr(request.getParameter("password")));
		bean
				.setRegistnum(Util.changeNullStr(request
						.getParameter("registnum")));
		return bean;
	}

}
