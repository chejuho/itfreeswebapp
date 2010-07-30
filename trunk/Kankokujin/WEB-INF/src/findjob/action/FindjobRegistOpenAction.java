package findjob.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import findjob.bean.FindjobBean;
import findjob.bean.FindjobSearchBean;

public class FindjobRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("FindjobRegistOpenAction.START");
		HttpSession session = request.getSession();
		session.setAttribute("action", "FindjobRegistOpen?before=search&f=search");
		session.setAttribute("topmenu", "findjob");
		FindjobBean findjobBean = new FindjobBean();
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();		
		if (Util.isLogin(request)) {
			try {

				//reload
				if(Util.isEmpty(request.getParameter("f"))){
					setFindjobBean(findjobBean, findjobSearchBean, request);
				//from search
				} else {

					setFindjobSearchBean(findjobSearchBean, request);
					MemberBean memberBean= (MemberBean)session.getAttribute("memberInfo");
					findjobBean.setUser_id(memberBean.getUserid());
					findjobBean.setTel_no1_1(memberBean.getTelephone1());
					findjobBean.setTel_no1_2(memberBean.getTelephone2());
					findjobBean.setTel_no1_3(memberBean.getTelephone3());
					findjobBean.setTel_no2_1(memberBean.getMobile1());
					findjobBean.setTel_no2_2(memberBean.getMobile2());
					findjobBean.setTel_no2_3(memberBean.getMobile3());
					findjobBean.setEmail(memberBean.getEmail1() + "@" + memberBean.getEmail2());					
				}
				request.setAttribute("FindjobBean", findjobBean);
				request.setAttribute("FindjobSearchBean", findjobSearchBean);
			} catch (Exception e) {
				throw new KankokujinException("SYE0016", e);
			} finally {
			}
		
			this.getServletContext().getRequestDispatcher(
					"/jsp/findjob/findjobRegist.jsp").forward(request, response);

		} else {
			setFindjobSearchBean(findjobSearchBean, request);
			session.setAttribute("action", "FindjobRegistOpen?before=search&f=search&search_cate_code_1="+findjobSearchBean.getCate_code_1()+"&search_cate_code_2="+findjobSearchBean.getCate_code_2()+"&pageSize="+findjobSearchBean.getPageSize()+"&userFlag=0&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		}

	}

	private void setFindjobBean(FindjobBean findjobBean, FindjobSearchBean findjobSearchBean, 
			HttpServletRequest request) throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		findjobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		findjobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		findjobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		findjobBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		findjobBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		findjobBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		findjobBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		findjobBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		findjobBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));		
		findjobBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		findjobBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		findjobBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		
		findjobSearchBean.setBefore(multi.getParameter("before"));
		findjobSearchBean.setSearch_range(multi.getParameter("search_range"));
		findjobSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		findjobSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));
		findjobSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			findjobSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			findjobSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			findjobSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			findjobSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}		

	}

	private void setFindjobSearchBean(FindjobSearchBean findjobSearchBean,
			HttpServletRequest request) {
		findjobSearchBean.setBefore(request.getParameter("before"));
		findjobSearchBean.setSearch_range(request.getParameter("search_range"));
		if(!"0".equals(request.getParameter("userFlag"))){
			findjobSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		}
		findjobSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));
		findjobSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
	
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			findjobSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			findjobSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			findjobSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			findjobSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}		
	}


}