package job.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.bean.JobSearchBean;
import job.handler.JobSearchHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.PageBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;

public class JobSearchAction extends HttpServlet {
	/**
	 * StoreListを開く
	 * 
	 * @param request
	 *            response
	 * @return StoreBean、JobSortBean、PageBean、JobBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("JobListAction.start");
		HttpSession session = request.getSession();
		JobSearchBean jobSearchBean = new JobSearchBean();
		Connection con = null;
		if (!Util.isEmpty(request.getParameter("search_all"))) {
			jobSearchBean.setSearch(request.getParameter("search_all"));
			jobSearchBean.setDecodedSearch(EnDecoding.decoding(request
					.getParameter("search_all")));
			jobSearchBean.setSearch_range("0");
		} else if (!Util.isEmpty(request.getParameter("all_search"))) {
			setJobSearchBean(jobSearchBean, request);
			jobSearchBean.setSearch(EnDecoding.decoding(request
					.getParameter("all_search")));
			jobSearchBean.setDecodedSearch(EnDecoding.decoding(EnDecoding
					.decoding(request.getParameter("all_search"))));
			jobSearchBean.setSearch_range("0");
		} else if ("-".equals(request.getParameter("user_id"))) {
			setJobSearchBean(jobSearchBean, request);
			session.setAttribute("action", "JobSearch?re=9&search_cate_code_1="
					+ jobSearchBean.getCate_code_1() + "&search_cate_code_2="
					+ jobSearchBean.getCate_code_2() + "&pageSize="
					+ jobSearchBean.getPageSize() + "&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		} else if ("b".equals(request.getParameter("f"))) {
			setMulJobSearchBean(jobSearchBean, request);
		} else {
			setJobSearchBean(jobSearchBean, request);
		}

		session.setAttribute("action", "JobSearch?re=9&search_cate_code_1="
				+ jobSearchBean.getCate_code_1() + "&search_cate_code_2="
				+ jobSearchBean.getCate_code_2() + "&pageSize="
				+ jobSearchBean.getPageSize() + "&user_id=");
		session.setAttribute("topmenu", "job");
		SortedMap jobCategory1Map = (SortedMap) getServletContext().getAttribute("JobCategory1");
		SortedMap jobCategory2Map = (SortedMap) getServletContext().getAttribute("JobCategory2");
		
		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, jobSearchBean.getPageSize());

		List jobBeanList = null;
		List category1List = null;
		List category2List = null;
		Map category1Count = null;
		Map category2Count = null;
		
		 try {
			 con = DBConnectionMgr.getInstance().getConnection();
		} catch (AppException e1) {
			e1.printStackTrace();
		}
		
		category1List = UtilHandler.getCategory1ListFromMap(jobCategory1Map);
		category2List = UtilHandler.getCategory2ListFromMap(jobSearchBean.getCate_code_1(), jobCategory2Map);

		JobSearchHandler jobSearchHandler = JobSearchHandler.getInstance();
		try {
			jobBeanList = jobSearchHandler.getSearchJobListTotal(con, pageBean, jobSearchBean);
			category1Count = jobSearchHandler.getCategory1Count(con,jobSearchBean);
			category2Count = jobSearchHandler.getCategory2Count(con, jobSearchBean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("JobListAction.end");
		}
		
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("JobBeanList", jobBeanList);
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		request.setAttribute("Category1Count", category1Count);
		request.setAttribute("Category2Count", category2Count);

		request.setAttribute("JobSearchBean", jobSearchBean);
		this.getServletContext().getRequestDispatcher(
				"/jsp/job/jobSearchList.jsp").forward(request, response);
		// }

	}

	private void setJobSearchBean(JobSearchBean jobSearchBean,
			HttpServletRequest request) {

		jobSearchBean.setBefore(request.getParameter("before"));
		jobSearchBean.setSearch_range(request.getParameter("search_range"));
		jobSearchBean.setUser_id(Util.changeNullStr(request
				.getParameter("user_id")));
		jobSearchBean.setSearch(EnDecoding.decoding(request
				.getParameter("search")));
		jobSearchBean.setDecodedSearch(EnDecoding.decoding(request
				.getParameter("search")));
		if (!Util.isEmpty(request.getParameter("search_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(request
					.getParameter("search_sex")));
		} else if (!Util.isEmpty(request.getParameter("before_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(request
					.getParameter("before_sex")));
		}
		if (!Util.isEmpty(request.getParameter("pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(request
					.getParameter("pageSize")));
		} else if (!Util.isEmpty(request.getParameter("before_pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(request
					.getParameter("before_pageSize")));
		}
		if (!Util.isEmpty(request.getParameter("pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(request
					.getParameter("pageNum")));
		} else if (!Util.isEmpty(request.getParameter("before_pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(request
					.getParameter("before_pageNum")));
		}
		if (!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(request
					.getParameter("search_cate_code_1")));
		} else if (!Util.isEmpty(request.getParameter("before_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(request
					.getParameter("before_cate_code_1")));
		}
		if (!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(request
					.getParameter("search_cate_code_2")));
		} else if (!Util.isEmpty(request.getParameter("before_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(request
					.getParameter("before_cate_code_2")));
		}
	}

	private void setMulJobSearchBean(JobSearchBean jobSearchBean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		jobSearchBean.setBefore(multi.getParameter("before"));
		jobSearchBean.setSearch_range(multi.getParameter("search_range"));
		jobSearchBean.setUser_id(Util.changeNullStr(multi
				.getParameter("user_id")));
		jobSearchBean.setSearch(Util
				.changeNullStr(multi.getParameter("search")));
		jobSearchBean.setDecodedSearch(EnDecoding.decoding(multi
				.getParameter("search")));
		if (!Util.isEmpty(multi.getParameter("search_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(multi
					.getParameter("search_sex")));
		} else if (!Util.isEmpty(multi.getParameter("before_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(multi
					.getParameter("before_sex")));
		}
		if (!Util.isEmpty(multi.getParameter("pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(multi
					.getParameter("pageSize")));
		} else if (!Util.isEmpty(multi.getParameter("before_pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(multi
					.getParameter("before_pageSize")));
		}
		if (!Util.isEmpty(multi.getParameter("pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(multi
					.getParameter("pageNum")));
		} else if (!Util.isEmpty(multi.getParameter("before_pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(multi
					.getParameter("before_pageNum")));
		}
		if (!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(multi
					.getParameter("search_cate_code_1")));
		} else if (!Util.isEmpty(multi.getParameter("before_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(multi
					.getParameter("before_cate_code_1")));
		}
		if (!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(multi
					.getParameter("search_cate_code_2")));
		} else if (!Util.isEmpty(multi.getParameter("before_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(multi
					.getParameter("before_cate_code_2")));
		}
	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = "";
		if (!Util.isEmpty(request.getParameter("pageNum"))) {
			pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
		} else if (!Util.isEmpty(request.getParameter("before_pageNum"))) {
			pageNumStr = Util.changeNullStr(request
					.getParameter("before_pageNum"));
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