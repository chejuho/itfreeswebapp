package common.batch;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import common.constant.Const;
import common.exception.SysException;
import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class SendEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SendEmail sendEmail = new SendEmail();
		try {
			System.out.println("sendmail1="+sendEmail.sendmail1());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("sendmail2="+sendEmail.sendmail2());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("sendmail3="+sendEmail.sendmail3());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("sendmail4="+sendEmail.sendmail4());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("sendmail5="+sendEmail.sendmail5());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		

	}

	public boolean sendmail1() throws SysException {
		boolean result = false;
		String subject = "Test"; // subject
		String msgText = "Test test\ntest\ntest"; // message
		String host = "mw-001.cafe24.com"; // smtp mail server
		String from = "info@kankokujin.com"; // sender email address
		String to = "jeong@itfrees.com"; // receiver email address

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new MyAuthentication1();
		Session sess = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(sess);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject, Const.EMAIL_LANG_CODE);
			msg.setSentDate(new Date());
			msg.setContent(msgText + "\r\n", "text/html; charset="
					+ Const.EMAIL_LANG_CODE);
			Transport.send(msg);
			result = true;
		} catch (MessagingException e) {
			throw new SysException("SYE0038", e);
		} catch (Exception e) {
			throw new SysException("SYE0038", e);
		}
		return result;
	}

	public boolean sendmail2() throws SysException {
		boolean result = false;
		String subject = "Test"; // subject
		String msgText = "Test test\ntest\ntest"; // message
		String host = "smtp.gmail.com"; // smtp mail server
		String from = "jeong@kankokujin.com"; // sender email address
		String to = "jjaekwan@hotmail.com"; // receiver email address

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.starttls.enable", "true");
		Authenticator auth = new MyAuthentication2();
		Session sess = Session.getInstance(props, auth);

		try {
			Message msg = new MimeMessage(sess);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(msgText);

			Transport.send(msg);
			result = true;
		} catch (MessagingException e) {
			throw new SysException("SYE0038", e);
		} catch (Exception e) {
			throw new SysException("SYE0038", e);
		}
		return result;
	}

	public boolean sendmail3() throws SysException {
		SendMailHandler backSendMailHandler = new SendMailHandler();
		EmailBean emailBean = null;
		try {
			emailBean = backSendMailHandler.getEmailInfo("1");
		} catch (SysException e) {
			throw e;
		}
		boolean result = false;
		String subject = emailBean.getSubject(); // subject
		String msgText = emailBean.getContents(); // message
		String host = "smtp.gmail.com"; // smtp mail server
		String to = "jjaekwan@hotmail.com"; // receiver email address

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
/*		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");*/
		Authenticator auth = new MyAuthentication2();
		Session sess = Session.getInstance(props, auth);

		try {
			Message msg = new MimeMessage(sess);
			InternetAddress fromInternetAddress = new InternetAddress(
					"sales@itfrees.com", Const.SENDER_NAME);
			fromInternetAddress.setPersonal("（株）ITフリーズ_金珍",
					Const.EMAIL_LANG_CODE);
			msg.setFrom(fromInternetAddress);
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(msgText);

			Transport.send(msg);
			result = true;
		} catch (MessagingException e) {
			throw new SysException("SYE0038", e);
		} catch (Exception e) {
			throw new SysException("SYE0038", e);
		}
		return result;
	}

	public boolean sendmail4() throws SysException {
		SendMailHandler sendMailHandler = new SendMailHandler();
		EmailBean emailBean = null;
		try {
			emailBean = sendMailHandler.getEmailInfo("1");
		} catch (SysException e) {
			throw new SysException("SYE0038", e);
		}

		boolean result = false;
		String to = "jjaekwan@hotmail.com"; // receiver email address
		emailBean.setToId(to);
		result = sendMailHandler.sendmail(emailBean);
		return result;
	}
	public boolean sendmail5() throws SysException {
		boolean result = false;
		String host = "mw-001.cafe24.com"; // smtp mail server
		String from = "info@kankokujin.com"; // sender email address
		String to = "jeong@itfrees.com"; // receiver email address
		SendMailHandler sendMailHandler = new SendMailHandler();
		EmailBean emailBean = null;
		try {
			emailBean = sendMailHandler.getEmailInfo("1");
		} catch (SysException e) {
			throw new SysException("SYE0038", e);
		}
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new MyAuthentication1();
		Session sess = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(sess);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(emailBean.getSubject(), Const.EMAIL_LANG_CODE);
			msg.setSentDate(new Date());
			msg.setContent(emailBean.getContents() + "\r\n", "text/html; charset="
					+ Const.EMAIL_LANG_CODE);
			Transport.send(msg);
			result = true;
		} catch (MessagingException e) {
			throw new SysException("SYE0038", e);
		} catch (Exception e) {
			throw new SysException("SYE0038", e);
		}
		return result;
	}
}

class MyAuthentication1 extends Authenticator {
	PasswordAuthentication pa;

	public MyAuthentication1() {
		pa = new PasswordAuthentication("info@kankokujin.com", "itfrees747"); // ex)
																				// ID:cafe24@cafe24.com
																				// PASSWD:1234
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}

class MyAuthentication2 extends Authenticator {
	PasswordAuthentication pa;

	public MyAuthentication2() {
		pa = new PasswordAuthentication("itfreessales@gmail.com", "itfrees747"); // ex)
																					// ID:cafe24@cafe24.com
																					// PASSWD:1234
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
