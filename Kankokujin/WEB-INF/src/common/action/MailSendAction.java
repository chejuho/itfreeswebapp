package common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.bean.JobBean;
import job.handler.JobDetailHandler;

import roomsell.bean.RoomBean;
import roomsell.handler.RoomSellDetailHandler;
import store.bean.StoreBean;
import store.handler.StoreDetailHandler;

import buysell.bean.BuySellBean;
import buysell.handler.BuySellDetailHandler;

import member.handler.MemberLoginHandler;
import menu.bean.MenuBean;

import common.bean.Bean;
import common.bean.MemberBean;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;
import email.bean.EmailBean;
import email.handler.SendMailHandler;
import findjob.bean.FindjobBean;
import findjob.handler.FindjobDetailHandler;
import gourmet.bean.GourmetBean;
import gourmet.handler.GourmetDetailHandler;
import housesell.bean.HouseBean;
import housesell.handler.HouseSellDetailHandler;

public class MailSendAction extends HttpServlet {
	
	/**
	 * MenuActionを開く
	 * 
	 * @param request,response
	 * @return StoreBean、StoreSortBean、PageBean、StoreBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		KankokujinLogger.getInstance().debug("MailSendOpenAction.start");

		boolean sendSucess = false;
		MenuBean menuBean = new MenuBean();
		String subject = (String) request.getParameter("subject");
		String fromEmailAddr = (String) request.getParameter("fromEmail");
		String fromName = (String) request.getParameter("fromName");
		String contents = (String) request.getParameter("contents");
		String toId = (String) request.getParameter("toId");
		String sort = (String) request.getParameter("sort");
		
		String toEmailAddr = null;
		try {
			toEmailAddr = getInfoBean(toId, sort);
		} catch (SysException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (AppException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		SendMailHandler sendmail = new SendMailHandler();
		
		EmailBean bean = new EmailBean();
		//タイトル
		bean.setSubject(EnDecoding.decoding(subject));
		//メール内容
		bean.setContents(EnDecoding.decoding(Util.changeRnToBrTag(contents)));
		//送信者　Eメールアドレス
		bean.setFromId(fromEmailAddr);
		//送信者名前
		bean.setFromName(EnDecoding.decoding(fromName));
		//宛先
		bean.setToId(toEmailAddr);
		
		try {
			
			sendSucess = sendmail.sendmailFromWeb(bean);
		} catch (SysException e) {
			sendSucess = false;
		}
		if (sendSucess) {
			 menuBean.put("mailsendResult", "SUCCESS");
		} else {
			 menuBean.put("mailsendResult", "FLASE");
		}
		 request.setAttribute("menuBean", menuBean);
		/** 処理別ページ決定　*/
		String url = "/jsp/email/sendEmailResult.jsp";
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	/**
	* @param id
	* @return
	* @throws SysException
	*/
	private String getEmail(String id) throws SysException {

		StringBuffer emailBuff = new StringBuffer();
		MemberLoginHandler handler = new MemberLoginHandler();
		
		MemberBean member = handler.getMemberInfo(id);
		
		emailBuff.append(member.getEmail1());
		emailBuff.append("@");
		emailBuff.append(member.getEmail2());
		return emailBuff.toString();
	}
	/**
	 * 
	 * @param id
	 * @param sort:1(Buysell) sort:2(Store) sort:3(Gourmet) sort:4(RoomSell) sort:5(HouseSell) sort:6(JobSearch) sort:7(FindJob)
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	private String getInfoBean(String id, String sort) throws SysException, AppException {
		Bean bean = null;
		if ("1".equals(sort)) {
			BuySellBean buySellBean = new BuySellBean();
			buySellBean.setId(id);
			bean = BuySellDetailHandler.getInstance().getBuySellBean(buySellBean, false, false);
		}
		if ("2".equals(sort)) {
			StoreBean storeBean = new StoreBean();
			storeBean.setId(id);
			bean = StoreDetailHandler.getInstance().getStoreBean(storeBean, true, true);

		}
		if ("3".equals(sort)) {
			GourmetBean gourmetBean = new GourmetBean();
			gourmetBean.setId(id);
			bean = GourmetDetailHandler.getInstance().getGourmetBean(gourmetBean, true, true);

		}		
		if ("4".equals(sort)) {
			RoomBean roomBean = new RoomBean();
			roomBean.setId(id);
			bean = RoomSellDetailHandler.getInstance().getRoomBean(roomBean, true, true);

		}
		if ("5".equals(sort)) {
			HouseBean houseBean = new HouseBean();
			houseBean.setId(id);
			bean = HouseSellDetailHandler.getInstance().getHouseBean(houseBean, true, true);

		}		
		if ("6".equals(sort)) {
			JobBean jobBean = new JobBean();
			jobBean.setId(id);
			bean = JobDetailHandler.getInstance().getJobBean(jobBean, true, true);
		}
		if ("7".equals(sort)) {
			FindjobBean findjobBean = new FindjobBean();
			findjobBean.setId(id);
			bean = FindjobDetailHandler.getInstance().getFindjobBean(findjobBean, true, true);
		}
		return bean.getEmail();
	}

}