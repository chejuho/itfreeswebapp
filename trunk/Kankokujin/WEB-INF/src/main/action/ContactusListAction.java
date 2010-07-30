package main.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.handler.ContactusListHandler;

import common.bean.PageBean;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class ContactusListAction extends HttpServlet {
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

		ContactusListHandler contactusListHandler = new ContactusListHandler();
		int maxInfoCount = 0;
		try {
			maxInfoCount = contactusListHandler.getInfoCount();
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0021", e);
		}
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("PageBean");
		if (pageBean == null) {
			pageBean = new PageBean();
		}
		int pageSize;
		if (Util.isEmpty(request.getParameter("pageSize"))) {
			pageSize = 10;
		} else if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} else {
			pageSize = 10;
		}

		if (pageBean == null || request.getParameter("pageNum") == null) {
			pageBean = new PageBean();
			pageBean.setPageSize(pageSize);
			pageBean.setPagingSort("FindjobSearch");
			//pageBean.setCate_code_2(findjobSearchBean.getDecodedSearch());
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

		session.setAttribute("PageBean", pageBean);

		List contactusList = null;

		try {
			contactusList = contactusListHandler.getContactusList(pageBean.getStartCount(), pageBean.getPageSize());
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			KankokujinLogger.getInstance().debug("ContactusListAction.end");
		}
		request.setAttribute("ContactusList", contactusList);
		this.getServletContext().getRequestDispatcher(
				"/jsp/main/contactusList.jsp")
				.forward(request, response);
	}
}