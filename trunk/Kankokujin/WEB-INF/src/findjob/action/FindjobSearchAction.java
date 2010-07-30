package findjob.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.PageBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;

import findjob.bean.FindjobSearchBean;
import findjob.handler.FindjobSearchHandler;

public class FindjobSearchAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、FindjobSortBean、PageBean、FindjobBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("FindjobListAction.start");
		HttpSession session = request.getSession();
		FindjobSearchBean findjobSearchBean = new FindjobSearchBean();
		if(!Util.isEmpty(request.getParameter("search_all"))){
			findjobSearchBean.setSearch(request.getParameter("search_all"));
			findjobSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search_all")));
			findjobSearchBean.setSearch_range("0");
		} else if(!Util.isEmpty(request.getParameter("all_search"))) {	
			setFindjobSearchBean(findjobSearchBean, request);
			findjobSearchBean.setSearch(EnDecoding.decoding(request.getParameter("all_search")));
			findjobSearchBean.setDecodedSearch(EnDecoding.decoding(EnDecoding.decoding(request.getParameter("all_search"))));
			findjobSearchBean.setSearch_range("0");			
		} else if("-".equals(request.getParameter("user_id"))) {	
			setFindjobSearchBean(findjobSearchBean, request);
			session.setAttribute("action", "FindjobSearch?re=9&pageSize="+findjobSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);	
		} else if("b".equals(request.getParameter("f"))) {		
			setMulFindjobSearchBean(findjobSearchBean, request);				
		} else {
			setFindjobSearchBean(findjobSearchBean, request);
		}
		session.setAttribute("action", "FindjobSearch?re=9&pageSize="+findjobSearchBean.getPageSize()+"&user_id=");
		session.setAttribute("topmenu", "findjob");		
		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, findjobSearchBean.getPageSize());

		List findjobBeanList = null;
		FindjobSearchHandler findjobSearchHandler = FindjobSearchHandler.getInstance();
		try {
			findjobBeanList = findjobSearchHandler.getSearchFindjobListTotal(pageBean, findjobSearchBean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			KankokujinLogger.getInstance().debug("FindjobListAction.end");
		}
		
		
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("FindjobBeanList", findjobBeanList);
		request.setAttribute("FindjobSearchBean", findjobSearchBean);
		this.getServletContext().getRequestDispatcher("/jsp/findjob/findjobSearchList.jsp").forward(request, response);
		//}

	}
	private void setFindjobSearchBean(FindjobSearchBean findjobSearchBean,
			HttpServletRequest request) {
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
	}
	private void setMulFindjobSearchBean(FindjobSearchBean findjobSearchBean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
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
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = request.getParameter("pageNum");
		if (!Util.isEmpty(pageNumStr)) {
			if (!"sprev".equals(pageNumStr) && !"bprev".equals(pageNumStr)
					&& !"snext".equals(pageNumStr)
					&& !"bnext".equals(pageNumStr)) {
				bean.setPageNum((Integer.parseInt(pageNumStr)));
			} else {
				bean.setPagingSign(pageNumStr);
			}
		}
	}
}