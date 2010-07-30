package engmail.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import engmail.bean.EngmailBean;
import engmail.bean.EngmailListBean;
import engmail.handler.EngMailDetailHandler;
import engmail.handler.EngMailSendHandler;

public class EngMailTogetherSendAction extends HttpServlet {
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
				String mail_id = request.getParameter("mail_id");

				EngMailSendHandler engMailSendHandler = new EngMailSendHandler();
				EngmailBean engmailBean = engMailSendHandler
						.getEngmailBean(mail_id);
				List engMailSendList = engMailSendHandler.getEngMailSendList();
				sendMail(engMailSendList, engmailBean);

			} catch (Exception e) {
				throw new KankokujinException(
						"EngMailSendAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug("EngMailSendAction.end");
			}
			this.getServletContext().getRequestDispatcher("/EngMailList")
					.forward(request, response);
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}

	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 * @throws MessagingException
	 */
	private void sendMail(List engMailSendList, EngmailBean engmailBean) {
		Iterator it = engMailSendList.iterator();
		while (it.hasNext()) {
			EngmailListBean engmailListBean = (EngmailListBean) it.next();
			send("itfreessales@gmail.com", "itfrees747", engmailListBean
					.getTo_mail(), engmailBean.getSubject(), engmailBean
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
			mm.setContent(body, "text/plain; charset=iso-2022-jp");
			// mm.setContent(body, "text/html; charset=iso-2022-jp");
			// mm.setHeader("Content-Transfer-Encoding", "7bit");

			transport = sess.getTransport("smtp");
			transport.connect(user, password);
			transport.sendMessage(mm, mm.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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