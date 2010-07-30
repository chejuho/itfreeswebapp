package email.action;

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;
import eigyoumail.handler.EigyouMailDetailHandler;
import eigyoumail.handler.EigyouMailSendHandler;
import email.bean.EmailBean;
import engmail.bean.EngmailBean;
import engmail.handler.EngMailRegistHandler;

public class MailSendAction extends HttpServlet {
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
		try {
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			String title = request.getParameter("title");
			String contents = request.getParameter("content");
			String email = request.getParameter("email");

			EmailBean emailBean = new EmailBean();
			emailBean.setSubject(EnDecoding.decoding(title));
			emailBean.setContents(EnDecoding.decoding(contents).trim());
			sendMail(changeToAddressMailList(email),emailBean);
			
			EngmailBean bean = new EngmailBean();
			bean.setSubject(title);
			bean.setContents(contents);
			bean.setUpdate_by_user_id("jeong");
			
			EngMailRegistHandler engMailRegistHandler = new EngMailRegistHandler();
			if (engMailRegistHandler.insertEng_email(bean)) {
				this.getServletContext().getRequestDispatcher(
				"/EngMailList").forward(request,
				response);
			} else {
				System.out.println("insert error");
			}
		} catch (Exception e) {
			throw new KankokujinException("MailSendAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("MailSendAction.end");
		}

	}
	private List changeToAddressMailList(String inputStr){
		StringTokenizer st = new StringTokenizer(inputStr, ";");
		List list = new ArrayList();
		
		while (st.hasMoreTokens()) {
			EigyoumailListBean bean = new EigyoumailListBean();
			bean.setTo_mail(st.nextToken());
			list.add(bean);
		}
		return list;
	}
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 * @throws MessagingException 
	 */
	private void sendMail(List eigyouMailSendList, EmailBean emailBean){
		Iterator it = eigyouMailSendList.iterator();
		while (it.hasNext()) {
			EigyoumailListBean eigyoumailListBean = (EigyoumailListBean)it.next();
			send("itfreessales@gmail.com", "itfrees747", eigyoumailListBean.getTo_mail(), emailBean.getSubject(), emailBean.getContents());
		}
	}
	
	private void send(
            String user,
            String password,
            String to,
            String subject,
            String body){


            Transport transport = null;


            try {
                Session sess = Session.getInstance(prop);
                MimeMessage mm = new MimeMessage(sess);
    			InternetAddress from = new InternetAddress(
    					"sales@itfrees.com", "（株）ITフリーズ_金珍");
    			from.setPersonal("（株）ITフリーズ_金珍", "iso-2022-jp");
    			//message.setFrom(from);            
                //mm.setFrom(new InternetAddress(user));
    			mm.setFrom(from);
                mm.setSubject(subject, "iso-2022-jp");
                mm.setRecipient(
                    Message.RecipientType.TO, new InternetAddress(to));
                mm.setContent(body, "text/plain; charset=iso-2022-jp");
                //mm.setContent(body, "text/html; charset=iso-2022-jp");
                //mm.setHeader("Content-Transfer-Encoding", "7bit");


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