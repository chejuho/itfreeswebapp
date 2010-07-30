package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.handler.MemberFindInfoHandler;
import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class MemberFindInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("MemberFindInfoAction.START");
		MemberBean bean = setMemberBean(request);
		String userid = bean.getUserid();
		String username = bean.getName();
		String mail1 = bean.getEmail1();
		String mail2 = bean.getEmail2();
		MemberFindInfoHandler handler = new MemberFindInfoHandler();
		boolean result = false;
		//ユーザ名とユーザIDがない場合エラー処理
		if(!Util.isEmpty(username) && !Util.isEmpty(userid)){
			request.setAttribute("Message", "WAR0008");
			this.getServletContext().getRequestDispatcher("/MemberFindInfoOpen").forward(request, response);
		//ユーザ名がある場合ID確認する
		}else if(!Util.isEmpty(username)){
			try{
				userid = handler.isExistId(username, mail1, mail2);
			} catch (SysException e) {
				throw new KankokujinException(
						e.getMessage(), e);				
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0004", e);
			}
				
			if(!Util.isEmpty(userid)){
				try{
					EmailBean emailBean = setFindIDEmailBean(userid, bean);
					SendMailHandler sendMailHandler = new SendMailHandler();					
					sendMailHandler.sendmail(emailBean);
				} catch (SysException e) {	
					throw new KankokujinException(
							e.getMessage(), e);
				} catch (Exception e) {
					throw new KankokujinException(
							"SYE0005", e);
				}
				request.setAttribute("Message", "MSG0009");
				this.getServletContext().getRequestDispatcher(Const.INDEX_PATH).forward(request, response);
			}else{
				request.setAttribute("IDBean", bean);
				request.setAttribute("Message", "MSG0010");
				this.getServletContext().getRequestDispatcher("/MemberFindInfoOpen").forward(request, response);			
			}
		//ユーザIDがある場合パースワードを確認する			
		}else if(!Util.isEmpty(userid)){
			try{
				result = handler.isExistIdMail(userid, mail1, mail2);
			} catch (SysException e) {	
				throw new KankokujinException(
						e.getMessage(), e);				
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0006", e);
			}
			if (result) {		
				try{			
					EmailBean emailBean = setEmailBean(request, bean);
					handler.reSetMemberInfo(bean);
					SendMailHandler sendMailHandler = new SendMailHandler();
					sendMailHandler.sendmail(emailBean);
				} catch (SysException e) {	
					throw new KankokujinException(
							e.getMessage(), e);						
				} catch (Exception e) {
					throw new KankokujinException(
							"SYE0005", e);
				}
				request.setAttribute("Message", "MSG0014");
				this.getServletContext().getRequestDispatcher(Const.INDEX_PATH).forward(request, response);
			}else{
				request.setAttribute("PWBean", bean);
				request.setAttribute("Message", "MSG0010");
				this.getServletContext().getRequestDispatcher("/MemberFindInfoOpen").forward(request, response);			
			}
		}else{
			request.setAttribute("Message", "WAR0009");
			this.getServletContext().getRequestDispatcher("/MemberFindInfoOpen").forward(request, response);				
		}
		
	}

	private EmailBean setEmailBean(HttpServletRequest request, MemberBean bean) throws SysException {

		SendMailHandler handler = new SendMailHandler();
		EmailBean emailBean = handler.getEmailInfo("3");

		String subject = emailBean.getSubject();
		String contents = emailBean.getContents();

		contents = contents.replace("USERID_X",bean.getUserid());
		MemberLoginHandler memberLoginHandler = new MemberLoginHandler();
		try {
			contents = contents.replace("USERNAME_X", memberLoginHandler.getMemberInfo(bean.getUserid()).getName());
		} catch (SysException e) {
			throw e;
		}		
		contents = contents.replace("PASSWORD_X",bean.getPassword());
		contents = contents.replace("SERVER_DOMAIN",Const.SERVER_DOMAIN);
		emailBean.setToId(bean.getEmail1() + "@" + bean.getEmail2());
		emailBean.setFromId(Const.ADMIN_ID);
		emailBean.setSubject(subject);
		emailBean.setContents(contents);
		return emailBean;
	}
	private EmailBean setFindIDEmailBean(String userid, MemberBean bean) throws SysException {
		
		SendMailHandler handler = new SendMailHandler();
		EmailBean emailBean = handler.getEmailInfo("2");

		String subject = emailBean.getSubject();
		String contents = emailBean.getContents();

		contents = contents.replace("USERID_X",userid);
		contents = contents.replace("USERNAME_X", bean.getName());		
		contents = contents.replace("SERVER_DOMAIN",Const.SERVER_DOMAIN);

		emailBean.setToId(bean.getEmail1() + "@" + bean.getEmail2());
		emailBean.setFromId(Const.ADMIN_ID);
		emailBean.setSubject(subject);
		emailBean.setContents(contents);
		return emailBean;
	}

	private MemberBean setMemberBean(HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		bean.setName(EnDecoding.decoding(request.getParameter("username")));
		bean.setUserid(Util.changeNullStr(request.getParameter("userid")));
		bean.setEmail1(Util.changeNullStr(request.getParameter("email1")));
		bean.setEmail2(Util.changeNullStr(request.getParameter("email2")));
		String StartChar = "I";
		String password = Util.getRND(StartChar);
		bean.setPassword(password);
		return bean;
	}
}
