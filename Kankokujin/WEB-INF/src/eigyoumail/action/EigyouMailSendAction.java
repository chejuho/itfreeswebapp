package eigyoumail.action;

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
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;
import eigyoumail.handler.EigyouMailDetailHandler;
import eigyoumail.handler.EigyouMailSendHandler;

public class EigyouMailSendAction extends HttpServlet {
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
			String mail_id = request.getParameter("mail_id");
			EigyouMailSendHandler eigyouMailSendHandler = new EigyouMailSendHandler();
			EigyoumailBean eigyoumailBean = eigyouMailSendHandler.getEigyoumailBean(mail_id);
			
			List eigyouMailSendList = eigyouMailSendHandler.getEigyouMailSendList();
			sendMail(eigyouMailSendList,eigyoumailBean);
/*			KankokujinLogger.getInstance().debug("EigyouMailListAction.start");
			HttpSession session = request.getSession();
			
			EigyoumailListBean eigyoumailBean = new EigyoumailListBean();

			PageBean pageBean = (PageBean) session.getAttribute("PageBean");

			if (pageBean == null) {
				pageBean = new PageBean();
			}
			//setPageBean(pageBean, request);

			EigyouMailListHandler eigyouMailListHandler = new EigyouMailListHandler();
			int maxInfoCount = eigyouMailListHandler.getInfoCount(eigyoumailBean);

			int pageSize;			
			if (Util.isEmpty(request.getParameter("pageSize") )) {
				pageSize = 10;
			} else if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = Integer.parseInt(eigyoumailBean.getPageSize());
			}

			if (pageBean == null || request.getParameter("pageNum") == null) {
				pageBean = new PageBean();
				pageBean.setPageSize(pageSize);
				pageBean.setPagingSort("InterpretList");
				PageUtil.getInstance().init(pageBean, maxInfoCount);
			} else if ("sprev".equals(pageBean.getPagingSign())) {
				pageBean = (PageBean) session.getAttribute("PageBean");
				PageUtil.getInstance().sprev(pageBean, maxInfoCount);
			} else if ("bprev".equals(pageBean.getPagingSign())) {
				pageBean = (PageBean) session.getAttribute("PageBean");
				PageUtil.getInstance().bprev(pageBean, maxInfoCount);
			} else if ("snext".equals(pageBean.getPagingSign())) {
				pageBean = (PageBean) session.getAttribute("PageBean");
				PageUtil.getInstance().snext(pageBean, maxInfoCount);
			} else if ("bnext".equals(pageBean.getPagingSign())) {
				pageBean = (PageBean) session.getAttribute("PageBean");
				PageUtil.getInstance().bnext(pageBean, maxInfoCount);
			} else {
				pageBean = (PageBean) session.getAttribute("PageBean");
				pageBean.setPageSize(pageSize);
				PageUtil.getInstance().jump(pageBean, pageBean.getPageNum(),
						maxInfoCount);
			}

			String pageType = "1";
			if (request.getParameter("pageType") != null) {
				pageType = request.getParameter("pageType");
			} else if (pageBean.getPageType() != null) {
				pageType = (pageBean.getPageType());
			}

			pageBean.setPageType(pageType);
			String currentPage = pageBean.getCurrentPage() + "";
			pageBean.setPagingSign(currentPage);
			session.setAttribute("PageBean", pageBean);

			List eigyouMailList = eigyouMailListHandler.getEigyoumailList();

			request.setAttribute("eigyouMailList", eigyouMailList);*/
//		} catch (AppException e) {
//			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("EigyouMailListAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("EigyouMailListAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/EigyouMailList").forward(request, response);

	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 * @throws MessagingException 
	 */
	private void sendMail(List eigyouMailSendList, EigyoumailBean eigyoumailBean){
		Iterator it = eigyouMailSendList.iterator();
		while (it.hasNext()) {
			EigyoumailListBean eigyoumailListBean = (EigyoumailListBean)it.next();
			send("itfreessales@gmail.com", "itfrees747", eigyoumailListBean, eigyoumailBean);
		}
	}
	
	private void send(
            String user,
            String password,
            EigyoumailListBean eigyoumailListBean,
            EigyoumailBean eigyoumailBean){


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
                mm.setSubject(eigyoumailBean.getTitle(), "iso-2022-jp");
				InternetAddress to = new InternetAddress(eigyoumailListBean.getTo_mail(), eigyoumailListBean.getTo_name());
				to.setPersonal(eigyoumailListBean.getView_to_name(), "iso-2022-jp");
                mm.setRecipient(Message.RecipientType.TO, to);
                
                //mm.setContent(body, "text/plain; charset=iso-2022-jp");
				StringBuffer sb = new StringBuffer();
				sb.append(eigyoumailListBean.getCompany());
				sb.append("\n");
				sb.append(eigyoumailListBean.getPart_name());
				sb.append("   ");
				sb.append(eigyoumailListBean.getTo_name());
				sb.append(" 様");
				sb.append("\n");
				sb.append("\n");
				sb.append(eigyoumailBean.getContents());                
				sb.append("\r\n");

    			//String encodedBody  = MimeUtility.encodeText(sb.toString(), "iso-2022-jp", "B");
    			//mm.setContent(encodedBody, "text/html; charset=iso-2022-jp");
    			//mm.setContent(encodedBody, "text/plain; charset=iso-2022-jp");
    			//mm.setText(sb.toString());                
                mm.setContent(sb.toString(), "text/plain; charset=iso-2022-jp");
                //mm.setHeader("Content-Transfer-Encoding", "7bit");


                transport = sess.getTransport("smtp");
                transport.connect(user, password);
                transport.sendMessage(mm, mm.getAllRecipients());
                KankokujinLogger.getInstance().info("mail send successed " + eigyoumailListBean.getTo_mail());
            } catch (MessagingException e) {
    			KankokujinLogger.getInstance().info("mail send failed " + eigyoumailListBean.getTo_mail());
            } catch (UnsupportedEncodingException e) {
            	KankokujinLogger.getInstance().info("mail send failed " + eigyoumailListBean.getTo_mail());
    		} catch (Exception e) {
    			KankokujinLogger.getInstance().info("mail send failed " + eigyoumailListBean.getTo_mail());
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