package job.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.bean.JobBean;
import job.bean.JobSearchBean;
import job.handler.JobDetailHandler;
import job.handler.JobUpdateHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class JobUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("JobUpdateAction.start");
		JobBean jobBean = new JobBean();
		JobSearchBean jobSearchBean = new JobSearchBean();
		setJobBean(jobBean, jobSearchBean, request);		
		JobUpdateHandler updateHandler = JobUpdateHandler.getInstance();
		boolean result = false;
		try {
			result = updateHandler.updateJobBean(jobBean);
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0024", e);
		} finally {
		}
		JobDetailHandler detailHandler = JobDetailHandler.getInstance();
		if (result) {
			try {
				 imageProcess(jobBean);
				jobBean = detailHandler.getJobBean(jobBean, false, true);
			
			} catch (SysException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException("SYE0015", e);
			}
			request.setAttribute("JobBean", jobBean);
			request.setAttribute("JobSearchBean", jobSearchBean);
			this.getServletContext().getRequestDispatcher(
					"/jsp/job/jobDetail.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/JobList")
					.forward(request, response);
		}
	}
	
	/**
	 * 
	 * @param requestBean
	 */
	private void imageProcess(JobBean jobBean) {
		
		Util.processMakeResize(
				jobBean.getPhoto_name1(),
				jobBean.getPhoto_name2(),
				jobBean.getPhoto_name3(),
				jobBean.getPhoto_name4(), 
				jobBean.getPhoto_name5());
	}

	private void setJobBean(JobBean jobBean, JobSearchBean jobSearchBean, HttpServletRequest request)
			throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

		jobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		jobBean.setCompany_name_k(Util.changeNullStr(multi
				.getParameter("company_name_k")));
		jobBean.setSearch_word(Util.changeNullStr(multi.getParameter("search_word")));
		jobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		jobBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		jobBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		jobBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		jobBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		jobBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		jobBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		jobBean.setFax_no_1(Util.changeNullStr(multi.getParameter("fax_no_1")));
		jobBean.setFax_no_2(Util.changeNullStr(multi.getParameter("fax_no_2")));
		jobBean.setFax_no_3(Util.changeNullStr(multi.getParameter("fax_no_3")));
		jobBean.setUrl(Util.changeNullStr(multi.getParameter("url")));
		jobBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
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
		jobBean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		jobBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
		jobBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		jobBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		jobBean.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
		jobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		jobBean.setCharge(Util.changeNullStr(multi.getParameter("charge")));
		jobBean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		jobBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		jobBean.setSex(Util.changeNullStr(multi.getParameter("sex")));
	
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name1")))){
			jobBean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			jobBean.setPhoto_name1(Util.changePhotoPath(multi.getFilesystemName("photo_name1")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name2")))){
			jobBean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			jobBean.setPhoto_name2(Util.changePhotoPath(multi.getFilesystemName("photo_name2")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name3")))){
			jobBean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			jobBean.setPhoto_name3(Util.changePhotoPath(multi.getFilesystemName("photo_name3")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name4")))){
			jobBean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			jobBean.setPhoto_name4(Util.changePhotoPath(multi.getFilesystemName("photo_name4")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name5")))){
			jobBean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			jobBean.setPhoto_name5(Util.changePhotoPath(multi.getFilesystemName("photo_name5")));
		}
		jobBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		jobBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		
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
