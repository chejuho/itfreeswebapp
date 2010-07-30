package job.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.bean.JobBean;
import job.bean.JobSearchBean;
import job.handler.JobDetailHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class JobDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		KankokujinLogger.getInstance().debug("JobDetailAction.start");
		JobBean jobBean = new JobBean();
		jobBean.setId(request.getParameter("id"));
		JobSearchBean jobSearchBean = new JobSearchBean();
		JobDetailHandler handler = JobDetailHandler.getInstance();
		try {
			//from list
			if (!Util.isEmpty(jobBean.getId())) {
				setJobBean(jobBean, jobSearchBean, request);
				jobBean = handler.getJobBean(jobBean, true, true);
			//back
			} else {
				setBackJobBean(jobBean, jobSearchBean, request);
				jobBean = handler.getJobBean(jobBean, false, true);
			}			
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0015", e);
		} finally {
		}
		
		SortedMap buysellCategory1Map = (SortedMap) getServletContext().getAttribute("JobCategory1");
		SortedMap buysellCategory2Map = (SortedMap) getServletContext().getAttribute("JobCategory2");
		List category1List = UtilHandler.getCategory1ListFromMap(buysellCategory1Map);
		List category2List = UtilHandler.getCategory2ListFromMap(jobBean.getCate_code_1(), buysellCategory2Map);
		
		request.setAttribute("Category1List", category1List);
		request.setAttribute("Category2List", category2List);
		session.setAttribute("action", "JobDetail?id=" +jobBean.getId() +"&before="+jobSearchBean.getBefore());
		session.setAttribute("topmenu", "job");		
		request.setAttribute("JobBean", jobBean);
		request.setAttribute("JobSearchBean", jobSearchBean);
		this.getServletContext().getRequestDispatcher(
				"/jsp/job/jobDetail.jsp").forward(request, response);
	}

	private void setJobBean(JobBean jobBean,
			JobSearchBean jobSearchBean, HttpServletRequest request)
			{
		jobBean.setId(Util.changeNullStr(request.getParameter("id")));
		jobBean.setCompany_name_k(Util.changeNullStr(request
				.getParameter("company_name_k")));
		jobBean.setSearch_word(Util.changeNullStr(request.getParameter("search_word")));
		jobBean.setEmail(Util.changeNullStr(request.getParameter("email")));
		jobBean.setTel_no1_1(Util.changeNullStr(request
				.getParameter("tel_no1_1")));
		jobBean.setTel_no1_2(Util.changeNullStr(request
				.getParameter("tel_no1_2")));
		jobBean.setTel_no1_3(Util.changeNullStr(request
				.getParameter("tel_no1_3")));
		jobBean.setTel_no2_1(Util.changeNullStr(request
				.getParameter("tel_no2_1")));
		jobBean.setTel_no2_2(Util.changeNullStr(request
				.getParameter("tel_no2_2")));
		jobBean.setTel_no2_3(Util.changeNullStr(request
				.getParameter("tel_no2_3")));
		jobBean.setFax_no_1(Util
				.changeNullStr(request.getParameter("fax_no_1")));
		jobBean.setFax_no_2(Util
				.changeNullStr(request.getParameter("fax_no_2")));
		jobBean.setFax_no_3(Util
				.changeNullStr(request.getParameter("fax_no_3")));
		jobBean.setUrl(Util.changeNullStr(request.getParameter("url")));
		jobBean.setMain_area(Util.changeNullStr(request
				.getParameter("main_area")));
		jobBean.setCate_code_1(Util.changeNullStr(request
				.getParameter("cate_code_1")));
		jobBean.setCate_code_2(Util.changeNullStr(request
				.getParameter("cate_code_2")));
		jobBean.setArea_code_1(Util.changeNullStr(request
				.getParameter("area_code_1")));
		jobBean.setArea_code_2(Util.changeNullStr(request
				.getParameter("area_code_2")));
		jobBean.setArea_code_3(Util.changeNullStr(request
				.getParameter("area_code_3")));
		jobBean.setLine_code(Util.changeNullStr(request
				.getParameter("line_code")));
		jobBean.setStation_code(Util.changeNullStr(request
				.getParameter("station_code")));
		jobBean.setMain_area(Util.changeNullStr(request
				.getParameter("main_area")));
		jobBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		jobBean.setArea_fast(Util.changeNullStr(request
				.getParameter("area_fast")));
		jobBean.setTitle(Util.changeNullStr(request.getParameter("title")));
		jobBean.setCharge(Util.changeNullStr(request.getParameter("charge")));
		jobBean.setPay(Util.changeNullStr(request.getParameter("pay")));
		jobBean.setWork_time(Util.changeNullStr(request.getParameter("work_time")));
		jobBean.setAppeal_point(Util.changeNullStr(request
				.getParameter("appeal_point")));
		jobBean.setDetail_info(Util.changeNullStr(request
				.getParameter("detail_info")));

		jobSearchBean.setBefore(request.getParameter("before"));
		jobSearchBean.setSearch_range(request.getParameter("search_range"));
		jobSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		jobSearchBean.setSearch(EnDecoding.decoding(request.getParameter("search")));
		jobSearchBean.setDecodedSearch(EnDecoding.decoding(request.getParameter("search")));
		if(!Util.isEmpty(request.getParameter("search_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(request.getParameter("search_sex")));
		} else if(!Util.isEmpty(request.getParameter("before_sex"))){
			jobSearchBean.setSex(Util.changeNullStr(request.getParameter("before_sex")));
		}		
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			jobSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			jobSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}				
		if(!Util.isEmpty(request.getParameter("search_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_1"))){
			jobSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(request.getParameter("search_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(request.getParameter("before_cate_code_2"))){
			jobSearchBean.setCate_code_2(Util.changeNullStr(request.getParameter("before_cate_code_2")));
		}
		jobSearchBean.setAll_search(Util.changeNullStr(request.getParameter("all_search")));
		jobSearchBean.setAll_search_range(Util.changeNullStr(request.getParameter("all_search_range")));
	}
	private void setBackJobBean(JobBean jobBean,
			JobSearchBean jobSearchBean, HttpServletRequest request)
	throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		jobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		jobBean.setCompany_name_k(Util.changeNullStr(multi
				.getParameter("company_name_k")));
		jobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		jobBean.setTel_no1_1(Util.changeNullStr(multi
				.getParameter("tel_no1_1")));
		jobBean.setTel_no1_2(Util.changeNullStr(multi
				.getParameter("tel_no1_2")));
		jobBean.setTel_no1_3(Util.changeNullStr(multi
				.getParameter("tel_no1_3")));
		jobBean.setTel_no2_1(Util.changeNullStr(multi
				.getParameter("tel_no2_1")));
		jobBean.setTel_no2_2(Util.changeNullStr(multi
				.getParameter("tel_no2_2")));
		jobBean.setTel_no2_3(Util.changeNullStr(multi
				.getParameter("tel_no2_3")));
		jobBean.setFax_no_1(Util
				.changeNullStr(multi.getParameter("fax_no_1")));
		jobBean.setFax_no_2(Util
				.changeNullStr(multi.getParameter("fax_no_2")));
		jobBean.setFax_no_3(Util
				.changeNullStr(multi.getParameter("fax_no_3")));
		jobBean.setUrl(Util.changeNullStr(multi.getParameter("url")));
		jobBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		jobBean.setCate_code_1(Util.changeNullStr(multi
				.getParameter("cate_code_1")));
		jobBean.setCate_code_2(Util.changeNullStr(multi
				.getParameter("cate_code_2")));
		jobBean.setArea_code_1(Util.changeNullStr(multi
				.getParameter("area_code_1")));
		jobBean.setArea_code_2(Util.changeNullStr(multi
				.getParameter("area_code_2")));
		jobBean.setArea_code_3(Util.changeNullStr(multi
				.getParameter("area_code_3")));
		jobBean.setLine_code(Util.changeNullStr(multi
				.getParameter("line_code")));
		jobBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
		jobBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		jobBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		jobBean.setArea_fast(Util.changeNullStr(multi
				.getParameter("area_fast")));

		jobBean.setAppeal_point(Util.changeNullStr(multi
				.getParameter("appeal_point")));
		jobBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));
		jobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		jobBean.setCharge(Util.changeNullStr(multi.getParameter("charge")));
		jobBean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		jobBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));

		jobSearchBean.setBefore(multi.getParameter("before"));
		jobSearchBean.setSearch_range(multi.getParameter("search_range"));
		jobSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		jobSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));
		jobSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		if(!Util.isEmpty(multi.getParameter("search_sex"))) {
			jobSearchBean.setSex(Util.changeNullStr(multi.getParameter("search_sex")));
		} else if(!Util.isEmpty(multi.getParameter("before_sex"))){
			jobSearchBean.setSex(Util.changeNullStr(multi.getParameter("before_sex")));
		}	
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			jobSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			jobSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			jobSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			jobSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}				
		if(!Util.isEmpty(multi.getParameter("search_cate_code_1"))) {
			jobSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("search_cate_code_1")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_1"))){
			jobSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("before_cate_code_1")));
		}
		if(!Util.isEmpty(multi.getParameter("search_cate_code_2"))) {
			jobSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("search_cate_code_2")));
		} else if(!Util.isEmpty(multi.getParameter("before_cate_code_2"))){
			jobSearchBean.setCate_code_2(Util.changeNullStr(multi.getParameter("before_cate_code_2")));
		}

		jobSearchBean.setAll_search(Util.changeNullStr(multi.getParameter("all_search")));
		jobSearchBean.setAll_search_range(Util.changeNullStr(multi.getParameter("all_search_range")));
	}
}
