package findjob.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import findjob.handler.FindjobUpdateHandler;

public class FindjobUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("FindjobUpdateAction.start");
		FindjobBean findjobBean = new FindjobBean();
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		setFindjobBean(findjobBean, findjobSearchBean, request);		

		FindjobUpdateHandler updateHandler = FindjobUpdateHandler.getInstance();
		boolean result = false;
		try {
			result = updateHandler.updateFindjobBean(findjobBean);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0024", e);
		} finally {
			KankokujinLogger.getInstance().debug("FindjobUpdateAction.end");
		}
		FindjobDetailHandler detailHandler = FindjobDetailHandler.getInstance();
		if (result) {
			try {
				findjobBean = detailHandler.getFindjobBean(findjobBean, false, true);
			
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0015", e);
			}
			request.setAttribute("FindjobBean", findjobBean);
			request.setAttribute("FindjobSearchBean", findjobSearchBean);
			this.getServletContext().getRequestDispatcher(
					"/jsp/findjob/findjobDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("Message", "Fail to Update Findjob info");
			this.getServletContext().getRequestDispatcher("/FindjobList")
					.forward(request, response);
		}

	}

	private void setFindjobBean(FindjobBean findjobBean, FindjobSearchBean findjobSearchBean, HttpServletRequest request)
			throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

		findjobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		findjobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));		
		findjobBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		findjobBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		findjobBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		findjobBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		findjobBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		findjobBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		findjobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		findjobBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		findjobBean.setWork_sort(Util.changeNullStr(multi.getParameter("work_sort")));
		findjobBean.setBirthday(Util.changeNullStr(multi.getParameter("birthday")));
		findjobBean.setSex(Util.changeNullStr(multi.getParameter("sex")));
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

		findjobSearchBean.setAll_search(Util.changeNullStr(multi.getParameter("all_search")));
		findjobSearchBean.setAll_search_range(Util.changeNullStr(multi.getParameter("all_search_range")));
	}
}
