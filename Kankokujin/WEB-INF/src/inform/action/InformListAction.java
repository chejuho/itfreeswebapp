package inform.action;

import inform.bean.InformBean;
import inform.handler.InformListHandler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class InformListAction extends HttpServlet {
	/**
	 * InteroretList
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		List<InformBean> informBeanList = null;
		PageBean pageBean = null;
		try {
			KankokujinLogger.getInstance().debug("InterpretListAction.start");
			
			
			//ページ情報
			pageBean = PageUtil.getInstance().pagingProcess(request, "10");
			InformListHandler informListHandler = new InformListHandler();
			informBeanList = informListHandler.getInformBeanList(pageBean);

		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("InterpretListAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("InterpretListAction.end");
		}
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("InformBeanList", informBeanList);
		this.getServletContext().getRequestDispatcher("/jsp/inform/informList.jsp").forward(request, response);

	}
	
	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = "";
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			pageNumStr = Util.changeNullStr(request.getParameter("before_pageNum"));
		}
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