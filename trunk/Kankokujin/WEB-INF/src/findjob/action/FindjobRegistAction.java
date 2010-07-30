package findjob.action;

import housesell.bean.HouseBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import findjob.bean.FindjobBean;
import findjob.bean.FindjobSearchBean;
import findjob.handler.FindjobRegistHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class FindjobRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		FindjobBean findjobBean = new FindjobBean();
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		HttpSession session = request.getSession();
		MemberBean memberBean= (MemberBean)session.getAttribute("memberInfo");
		findjobBean.setUser_id(memberBean.getUserid());			
		try {
			KankokujinLogger.getInstance().debug("FindjobRegistAction.start");
			FindjobRegistHandler findjobRegistHandler = FindjobRegistHandler.getInstance();
			setFindjobBean(findjobBean, findjobSearchBean, request);
		    result = findjobRegistHandler.insertFindjobBean(findjobBean);
		    findjobSearchBean.setPageNum("");
		   
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0020", e);
		} finally {
			KankokujinLogger.getInstance().debug("FindjobRegistAction.end");
		}
		if (result) {
			request.setAttribute("FindjobSearchBean", findjobSearchBean);
			this.getServletContext().getRequestDispatcher("/jsp/findjob/findjobRegistResult.jsp").forward(request, response);
		} else {
			request.setAttribute("Message", "Fail to DRegistelete Findjob info");
			this.getServletContext().getRequestDispatcher(
					"/FindjobRegistOpen").forward(request, response);
		}
	}
	
	
	private void setFindjobBean(FindjobBean bean, FindjobSearchBean findjobSearchBean, HttpServletRequest request)
			throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH, 10 * 1024 * 1024,
				"UTF-8", new DefaultFileRenamePolicy());
		bean.setTitle(Util.changeNullStr(multi.getParameter("title")));		
		bean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		bean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		bean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		bean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		bean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		bean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		bean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		bean.setWork_sort(Util.changeNullStr(multi.getParameter("work_sort")));
		bean.setBirthday(Util.changeNullStr(multi.getParameter("birthday")));
		bean.setSex(Util.changeNullStr(multi.getParameter("sex")));
		bean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		bean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		
		findjobSearchBean.setBefore(multi.getParameter("before"));
		findjobSearchBean.setSearch_range(multi.getParameter("search_range"));
		findjobSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		findjobSearchBean.setSearch(EnDecoding.decoding(multi.getParameter("search")));
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
}