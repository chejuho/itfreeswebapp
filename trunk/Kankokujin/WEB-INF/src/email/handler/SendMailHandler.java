package email.handler;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
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
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

import email.bean.EmailBean;

public class SendMailHandler{
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean、InterpretSortBean、PageBean、InterpretBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	Properties prop = new Properties();
	public EmailBean getEmailInfo(String email_sort) throws SysException {
		KankokujinLogger.getInstance().debug("BuySellDetailHandler.getBuySellBean.start");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmailBean bean = new EmailBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
            
	
			StringBuffer sb = new StringBuffer("select * from email where email_sort = ?");
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, email_sort);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setSubject(rs.getString("title"));
				bean.setContents(rs.getString("contents"));
				
			}
		} catch (SQLException e) {
			throw new SysException("SQLException", e);

		} catch (Exception e) {
			throw new SysException("Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}
	public HashMap getFileContents(String filename){
		
		Properties prop = new Properties();
		FileInputStream fis;
		String fileForder = Const.MAIL_FOLDER_PATH;
		HashMap map = new HashMap();
		try {
			fis = new FileInputStream(fileForder+filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			prop.loadFromXML(bis);
			map.put("subject", prop.get("subject"));
			map.put("contents", prop.get("contents"));
			System.out.println("title=" + prop.get("subject"));
			System.out.println("contents=" + prop.get("contents"));
	//		prop.storeToXML(bos, "comment", "UTF-8");
			
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return map;
	}
/*	public boolean sendmail(EmailBean bean) throws SysException {

		try {
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			send("itfreessales@gmail.com", "itfrees747",bean.getToId(),bean.getSubject(),bean.getContents());

		} catch (Exception e){
			throw new SysException("SYE0005", e);
		}
		return true;
	}*/
	public boolean sendmail(EmailBean bean) throws SysException{
		boolean result = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", Const.SMTP_HOST);
		props.put("mail.smtp.auth","true");

		Authenticator auth = new MyAuthentication();
		Session sess = Session.getInstance(props, auth);

		try {
				MimeMessage msg = new MimeMessage(sess);
		        msg.setFrom(new InternetAddress(Const.SENDER_EMAIL, Const.SENDER_NAME));
		        InternetAddress[] address = {new InternetAddress(bean.getToId())};
		        msg.setRecipients(Message.RecipientType.TO, address);
		        msg.setSubject(bean.getSubject(), Const.EMAIL_LANG_CODE);
		        msg.setSentDate(new Date());
		        msg.setContent(bean.getContents() + "\r\n", "text/html; charset="+Const.EMAIL_LANG_CODE);
		        Transport.send(msg);
		        result =true;
		} catch (MessagingException e) {
			throw new SysException("Exception" , e);
		} catch (Exception e){
			throw new SysException("Exception" , e);
		}
		return result;
	}
	class MyAuthentication extends Authenticator {
	    PasswordAuthentication pa;
	    public MyAuthentication(){
	        pa = new PasswordAuthentication(Const.SMTP_USER_ID, Const.SMTP_PWD);
	    }

	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }
	}
	
	public boolean sendmailFromWeb(EmailBean bean) throws SysException{
		boolean result = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", Const.SMTP_HOST);
		props.put("mail.smtp.auth","true");

		Authenticator auth = new MyAuthentication();
		Session sess = Session.getInstance(props, auth);

		try {
				MimeMessage msg = new MimeMessage(sess);
		        msg.setFrom(new InternetAddress(bean.getFromId(), bean.getFromName(), Const.EMAIL_LANG_CODE));
		        InternetAddress[] address = {new InternetAddress(bean.getToId())};
		        msg.setRecipients(Message.RecipientType.TO, address);
		        msg.setSubject(bean.getSubject(), Const.EMAIL_LANG_CODE);
		        msg.setSentDate(new Date());
		        msg.setContent(bean.getContents() + "\r\n", "text/html; charset="+Const.EMAIL_LANG_CODE);
		        Transport.send(msg);
		        result =true;
		} catch (MessagingException e) {
			throw new SysException("Exception" , e);
		} catch (Exception e){
			throw new SysException("Exception" , e);
		}
		return result;
	}
	
	private void send(String user, String password, String to, String subject,
			String body) throws AppException {

		Transport transport = null;

		try {
			Session sess = Session.getInstance(prop);
			MimeMessage mm = new MimeMessage(sess);
			InternetAddress from = new InternetAddress("sales@itfrees.com",
					Const.SENDER_NAME);
			from.setPersonal(Const.SENDER_NAME, Const.EMAIL_LANG_CODE);
			mm.setFrom(from);
			mm.setSubject(subject, Const.EMAIL_LANG_CODE);
			mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mm.setHeader("Content-Transfer-Encoding", "7bit");
            mm.setContent(body + "\r\n", "text/html; charset="+Const.EMAIL_LANG_CODE);
			transport = sess.getTransport("smtp");
			transport.connect(user, password);
			transport.sendMessage(mm, mm.getAllRecipients());			
			KankokujinLogger.getInstance().info("mail send successed " + to);
		} catch (MessagingException e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
			throw new AppException("BackSendMailHandler.send.MessagingException", e);
		} catch (UnsupportedEncodingException e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
			throw new AppException("BackSendMailHandler.send.UnsupportedEncodingException", e);
		} catch (Exception e) {
			KankokujinLogger.getInstance().info("mail send failed " + to);
			throw new AppException("BackSendMailHandler.send.Exception", e);
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