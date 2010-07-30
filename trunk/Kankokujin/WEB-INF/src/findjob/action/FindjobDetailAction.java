package findjob.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import findjob.bean.FindjobBean;
import findjob.bean.FindjobSearchBean;
import findjob.handler.FindjobDetailHandler;

public class FindjobDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("FindjobDetailAction.start");
		FindjobBean findjobBean = new FindjobBean();
		findjobBean.setId(request.getParameter("id"));
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		FindjobDetailHandler handler = FindjobDetailHandler.getInstance();

		try {
			//from list
			if (!Util.isEmpty(findjobBean.getId())) {
				setFindjobBean(findjobBean, findjobSearchBean, request);
				findjobBean = handler.getFindjobBean(findjobBean, true, true);
			//back
			} else {
				setBackFindjobBean(findjobBean, findjobSearchBean, request);
				findjobBean = handler.getFindjobBean(findjobBean, false, true);
			}			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
			KankokujinLogger.getInstance().debug("FindjobDetailAction.end");
		}
		HttpSession session = request.getSession();
		session.setAttribute("action", "FindjobDetail?id=" +findjobBean.getId() +"&before="+findjobSearchBean.getBefore());
		session.setAttribute("topmenu", "findjob");			
		request.setAttribute("FindjobBean", findjobBean);
		request.setAttribute("FindjobSearchBean", findjobSearchBean);
		this.getServletContext().getRequestDispatcher(
				"/jsp/findjob/findjobDetail.jsp").forward(request, response);
	}

	private void setFindjobBean(FindjobBean findjobBean,
			FindjobSearchBean findjobSearchBean, HttpServletRequest request)
			{
		findjobBean.setId(Util.changeNullStr(request.getParameter("id")));
		findjobBean.setTitle(Util.changeNullStr(request
				.getParameter("title")));
		findjobBean.setEmail(Util.changeNullStr(request.getParameter("email")));
		findjobBean.setTel_no1_1(Util.changeNullStr(request
				.getParameter("tel_no1_1")));
		findjobBean.setTel_no1_2(Util.changeNullStr(request
				.getParameter("tel_no1_2")));
		findjobBean.setTel_no1_3(Util.changeNullStr(request
				.getParameter("tel_no1_3")));
		findjobBean.setTel_no2_1(Util.changeNullStr(request
				.getParameter("tel_no2_1")));
		findjobBean.setTel_no2_2(Util.changeNullStr(request
				.getParameter("tel_no2_2")));
		findjobBean.setTel_no2_3(Util.changeNullStr(request
				.getParameter("tel_no2_3")));
		findjobBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		findjobBean.setAppeal_point(Util.changeNullStr(request
				.getParameter("appeal_point")));
		findjobBean.setDetail_info(Util.changeNullStr(request
				.getParameter("detail_info")));
		
		findjobSearchBean.setBefore(request.getParameter("before"));
		findjobSearchBean.setSearch_range(request.getParameter("search_range"));
		findjobSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		findjobSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));
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

		findjobSearchBean.setAll_search(Util.changeNullStr(request.getParameter("all_search")));
		findjobSearchBean.setAll_search_range(Util.changeNullStr(request.getParameter("all_search_range")));
	}
	private void setBackFindjobBean(FindjobBean findjobBean,
			FindjobSearchBean findjobSearchBean, HttpServletRequest request)
	throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		findjobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		findjobBean.setTitle(Util.changeNullStr(multi
				.getParameter("title")));
		findjobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));

		findjobBean.setTel_no1_1(Util.changeNullStr(multi
				.getParameter("tel_no1_1")));
		findjobBean.setTel_no1_2(Util.changeNullStr(multi
				.getParameter("tel_no1_2")));
		findjobBean.setTel_no1_3(Util.changeNullStr(multi
				.getParameter("tel_no1_3")));
		findjobBean.setTel_no2_1(Util.changeNullStr(multi
				.getParameter("tel_no2_1")));
		findjobBean.setTel_no2_2(Util.changeNullStr(multi
				.getParameter("tel_no2_2")));
		findjobBean.setTel_no2_3(Util.changeNullStr(multi
				.getParameter("tel_no2_3")));
		findjobBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		findjobBean.setAppeal_point(Util.changeNullStr(multi
				.getParameter("appeal_point")));
		findjobBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));
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
		findjobSearchBean.setAll_search(Util.changeNullStr(multi.getParameter("all_search")));
		findjobSearchBean.setAll_search_range(Util.changeNullStr(multi.getParameter("all_search_range")));
	}
}
