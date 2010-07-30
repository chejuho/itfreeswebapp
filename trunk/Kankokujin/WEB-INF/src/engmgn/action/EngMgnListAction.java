package engmgn.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;
import common.bean.PageBean;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

import engmgn.bean.EngMgnBean;
import engmgn.handler.EngMgnListHandler;

public class EngMgnListAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		MemberBean userInfo = new MemberBean();
		EngMgnBean engMgnBean =new EngMgnBean();
		EngMgnListHandler handler = new EngMgnListHandler();
		KankokujinLogger.getInstance().debug("EngMgnListAction start");
		HttpSession session = request.getSession();
		String session_id = request.getParameter("session_id");
		String s_position = request.getParameter("s_position");
		String userlevel = "";
		try{
			if(session.getAttribute("memberInfo")!= null){
				userInfo = (MemberBean) session.getAttribute("memberInfo");	
				userlevel = userInfo.getUser_level();
			}
			
			String s_initial = request.getParameter("s_initial");
			String s_language = request.getParameter("s_language");
			KankokujinLogger.getInstance().debug("EngMgnListAction posotion initial language = "
					+ s_position + s_initial + s_language);
			KankokujinLogger.getInstance().debug("EngMgnListAction session_id= " + session_id);
	
			ArrayList<EngMgnBean> list = handler.getList(s_position, s_initial, s_language, userlevel);
			PageBean pageBean = (PageBean) session.getAttribute("PageBean");

			setPageBean(pageBean, request);
			
			int maxInfoCount = list.size();

			int pageSize;
			if (Util.isEmpty(request.getParameter("pageSize"))) {
				pageSize = 10;
			} else if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = Integer.parseInt(engMgnBean.getPage_size());
			}

			if (pageBean == null || request.getParameter("pageNum") == null) {
				pageBean = new PageBean();
				pageBean.setPageSize(pageSize);
				pageBean.setPagingSort("EngMgnList");
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
			// System.out.println("pageType="+pageBean.getPageType());
			// System.out.println("pageNum="+pageBean.getPageNum());
			// String pageType = request.getParameter("pageType");
			// pageBean.setPageType(pageType);
			String currentPage = pageBean.getCurrentPage() + "";
			pageBean.setPagingSign(currentPage);
			session.setAttribute("PageBean", pageBean);
			request.setAttribute("list", list);
			request.setAttribute("s_position", s_position);
			request.setAttribute("s_initial", s_initial);
			request.setAttribute("s_language", s_language);
			
		} catch (AppException e) {
			throw new KankokujinException("EngMgnListAction", e);
		} catch (Exception e) {
			throw new KankokujinException("EngMgnListAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("EngMgnListAction.end");
		}

		this.getServletContext().getRequestDispatcher(
				"/jsp/engmgn/engmgnList.jsp").forward(request, response);

	}
	/**
	 * pageÇÃèÓïÒÇì¸óÕÇ∑ÇÈ
	 * 
	 * @param beanÅArequest
	 * @return beanÇÃíl
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