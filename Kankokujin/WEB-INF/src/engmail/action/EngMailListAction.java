package engmail.action;

import interpret.bean.InterpretBean;

import java.io.IOException;
import java.util.Iterator;
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
import common.util.EnDecoding;
import common.util.Util;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;
import eigyoumail.handler.EigyouMailListHandler;
import engmail.bean.EngmailBean;
import engmail.handler.EngMailListHandler;

public class EngMailListAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean、InterpretSortBean、PageBean、InterpretBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			try {
				KankokujinLogger.getInstance().debug("EngMailListAction.start");
				HttpSession session = request.getSession();

				EngmailBean engmailBean = new EngmailBean();

				PageBean pageBean = (PageBean) session.getAttribute("PageBean");

				if (pageBean == null) {
					pageBean = new PageBean();
				}
				// setPageBean(pageBean, request);

				EngMailListHandler engMailListHandler = new EngMailListHandler();
				int maxInfoCount = engMailListHandler.getInfoCount(engmailBean);

				int pageSize;
				if (Util.isEmpty(request.getParameter("pageSize"))) {
					pageSize = 10;
				} else if (request.getParameter("pageSize") != null) {
					pageSize = Integer.parseInt(request
							.getParameter("pageSize"));
				} else {
					pageSize = Integer.parseInt(engmailBean.getPageSize());
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
					PageUtil.getInstance().jump(pageBean,
							pageBean.getPageNum(), maxInfoCount);
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

				List engMailList = engMailListHandler.getEngmailList();
				request.setAttribute("engMailList", engMailList);
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				throw new KankokujinException(
						"EngMailListAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug("EngMailListAction.end");
			}
			this.getServletContext().getRequestDispatcher(
					"/jsp/engmail/engMailList.jsp").forward(request, response);
		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}

	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	// private void setPageBean(PageBean bean, HttpServletRequest request) {
	// String pageNumStr = request.getParameter("pageNum");
	// if (!Util.isEmpty(pageNumStr)) {
	// if (!"sprev".equals(pageNumStr) && !"bprev".equals(pageNumStr)
	// && !"snext".equals(pageNumStr)
	// && !"bnext".equals(pageNumStr)) {
	// bean.setPageNum((Integer.parseInt(pageNumStr)));
	// } else {
	// bean.setPagingSign(pageNumStr);
	// }
	// }
	// }
	/**
	 * InterpretBeanに関してnull及び“”の値がなければ値を入力する
	 * 
	 * @param bean,houseSellSortBean,request
	 * @return beanの値
	 */

	private void setInterpretBean(InterpretBean bean, HttpServletRequest request) {

		String[] interpret = new String[] { "", "", "", "", "" };
		if (!Util.isEmpty(request.getParameter("language1"))) {
			interpret[0] = (request.getParameter("language1"));
		}
		if (!Util.isEmpty(request.getParameter("language2"))) {
			interpret[1] = (request.getParameter("language2"));
		}
		if (!Util.isEmpty(request.getParameter("language3"))) {
			interpret[2] = (request.getParameter("language3"));
		}
		if (!Util.isEmpty(request.getParameter("language4"))) {
			interpret[3] = (request.getParameter("language4"));
		}
		if (!Util.isEmpty(request.getParameter("language5"))) {
			interpret[4] = (request.getParameter("language5"));
		}
		bean.setInterpret(interpret);
		if (!Util.isEmpty(request.getParameter("language_etc"))) {
			bean.setLanguage_etc(EnDecoding.decoding(request
					.getParameter("language_etc")));
		}
		if (!Util.isEmpty(request.getParameter("service_area_1"))) {
			bean.setService_area_1(request.getParameter("service_area_1"));
		}
		if (!Util.isEmpty(request.getParameter("service_area_etc"))) {
			bean.setService_area_1_etc(EnDecoding.decoding(request
					.getParameter("service_area_etc")));
		}
		if (!Util.isEmpty(request.getParameter("sex"))) {
			bean.setSex(request.getParameter("sex"));
		}
		if (!Util.isEmpty(request.getParameter("nation"))) {
			bean.setNation(request.getParameter("nation"));
		}
		if (!Util.isEmpty(request.getParameter("nation_etc"))) {
			bean.setNation_etc(EnDecoding.decoding(request
					.getParameter("nation_etc")));
		}
		if (!Util.isEmpty(request.getParameter("resumeChecked"))) {
			bean.setResume(request.getParameter("resumeChecked"));
		}

		String[] age = new String[] { "", "" };
		if (!Util.isEmpty(request.getParameter("age_from"))) {
			age[0] = request.getParameter("age_from");
		}
		if (!Util.isEmpty(request.getParameter("age_to"))) {
			age[1] = request.getParameter("age_to");
		}
		bean.setAges(age);
	}

}