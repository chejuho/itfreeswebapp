package engmail.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;
import eigyoumail.handler.EigyouMailDetailHandler;
import eigyoumail.handler.EigyouMailSendHandler;
import email.bean.EmailBean;
import engmail.bean.EngmailBean;
import engmail.bean.EngmailListBean;
import engmail.handler.EngMailRegistHandler;

public class EngMailSendAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean、InterpretSortBean、PageBean、InterpretBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	Properties prop = new Properties();

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			try {
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true");
				String title = request.getParameter("title");
				String contents = request.getParameter("content");
				StringBuffer emailSB = new StringBuffer(request
						.getParameter("email"));

				String count = (String) request.getParameter("count");
				List selectedMailList = new ArrayList();
				if (!"0".equals(count) && !Util.isEmpty(count)) {
					for (int i = 1; i < Integer.parseInt(count) + 1; i++) {
						String tempWebmail = (String) request
								.getParameter("web_mail_" + i);
						String tempMobilemail = (String) request
								.getParameter("mobile_mail_" + i);
						if (!Util.isEmpty(tempWebmail)
								|| !Util.isEmpty(tempMobilemail)) {
							EngmailListBean bean = new EngmailListBean();
							if (!Util.isEmpty(tempWebmail)) {
								bean.setTo_mail(tempWebmail);
							}
							if (!Util.isEmpty(tempMobilemail)) {
								bean.setTo_mobile_mail(tempMobilemail);
							}
							selectedMailList.add(bean);
						}
					}
				}
				EmailBean emailBean = new EmailBean();
				emailBean.setSubject(EnDecoding.decoding(title));
				emailBean.setContents(EnDecoding.decoding(contents).trim());				
				String to_mail_list = changeEngmailListBeanListToAddress(selectedMailList, emailSB);
				sendMail(
						changeToAddressMailList(to_mail_list), emailBean);

				EngmailBean bean = new EngmailBean();
				bean.setSubject(title);
				bean.setTo_mail_list(to_mail_list);
				bean.setContents(contents);
				bean.setUpdate_by_user_id("jeong");

				EngMailRegistHandler engMailRegistHandler = new EngMailRegistHandler();
				if (engMailRegistHandler.insertEng_email(bean)) {
					this.getServletContext().getRequestDispatcher(
							"/EngMailList").forward(request, response);
				} else {
					System.out.println("insert error");
				}
			} catch (Exception e) {
				throw new KankokujinException(
						"MailSendAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug("MailSendAction.end");
			}
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}

	}

	private List changeToAddressMailList(String inputStr) {
		StringTokenizer st = new StringTokenizer(inputStr, ";");
		List list = new ArrayList();

		while (st.hasMoreTokens()) {
			EigyoumailListBean bean = new EigyoumailListBean();
			bean.setTo_mail(st.nextToken());
			list.add(bean);
		}
		return list;
	}

	private String changeEngmailListBeanListToAddress(List engmailListBeanList,
			StringBuffer inputStr) {
		Iterator it = engmailListBeanList.iterator();
		while (it.hasNext()) {
			EngmailListBean bean = (EngmailListBean) it.next();
			if (!Util.isEmpty(bean.getTo_mail())) {
				inputStr.append(";");
				inputStr.append(bean.getTo_mail());
			}
			if (!Util.isEmpty(bean.getTo_mobile_mail())) {
				inputStr.append(";");
				inputStr.append(bean.getTo_mobile_mail());
			}
		}
		return inputStr.toString();
	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 * @throws MessagingException
	 */
	private void sendMail(List eigyouMailSendList, EmailBean emailBean) {
		Iterator it = eigyouMailSendList.iterator();
		while (it.hasNext()) {
			EigyoumailListBean eigyoumailListBean = (EigyoumailListBean) it
					.next();
			send("itfreessales@gmail.com", "itfrees747", eigyoumailListBean
					.getTo_mail(), emailBean.getSubject(), emailBean
					.getContents());
		}
	}

	private void send(String user, String password, String to, String subject,
			String body) {

		Transport transport = null;

		try {
			Session sess = Session.getInstance(prop);
			MimeMessage mm = new MimeMessage(sess);
			InternetAddress from = new InternetAddress("sales@itfrees.com",
					"（株）ITフリーズ_金珍");
			from.setPersonal("（株）ITフリーズ_金珍", "iso-2022-jp");
			// message.setFrom(from);
			// mm.setFrom(new InternetAddress(user));
			mm.setFrom(from);
			mm.setSubject(subject, "iso-2022-jp");
			mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//String encodedBody  = MimeUtility.encodeText(body, "iso-2022-jp", "B");
			//mm.setContent(encodedBody, "text/plain; charset=iso-2022-jp");
            mm.setHeader("Content-Transfer-Encoding", "7bit");
			mm.setContent(body + "\r\n", "text/plain; charset=iso-2022-jp");
			// mm.setHeader("Content-Transfer-Encoding", "7bit");			
			//mm.setText(body);


			transport = sess.getTransport("smtp");
			transport.connect(user, password);
			transport.sendMessage(mm, mm.getAllRecipients());			
			KankokujinLogger.getInstance().info("mail send successed " + to);
		} catch (MessagingException e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
		} catch (UnsupportedEncodingException e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
		} catch (Exception e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

}