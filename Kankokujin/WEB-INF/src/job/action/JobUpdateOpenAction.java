package job.action;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.bean.JobBean;
import job.bean.JobSearchBean;
import job.handler.JobDetailHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class JobUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug(
					"JobUpdateOpenAction.start");
			JobBean jobBean = new JobBean();
			JobSearchBean jobSearchBean = new JobSearchBean();
			JobDetailHandler jobDetailHandler = JobDetailHandler.getInstance();
			SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
			SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
			SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
			SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
			SortedMap jobCategory1Map = (SortedMap) getServletContext().getAttribute("JobCategory1");
			SortedMap jobCategory2Map = (SortedMap) getServletContext().getAttribute("JobCategory2");
			
			jobBean.setAreaMap1(area1InfoMap);
			jobBean.setAreaMap2(area2InfoMap);
			jobBean.setLineMap(lineInfoMap);
			jobBean.setStationMap(stationInfoMap);
			jobBean.setCategory1Map(jobCategory1Map);
			jobBean.setCategory2Map(jobCategory2Map);
			//reload
			if(Util.isEmpty(request.getParameter("id"))){
				setJobBean(jobBean, jobSearchBean, request);
			//from detail
			} else {
				jobBean.setId(request.getParameter("id"));
				setJobSearchBean(jobSearchBean, request);				
				jobDetailHandler.getJobBean(jobBean, false, false);
			}
			
			request.setAttribute("JobBean", jobBean);		
			request.setAttribute("JobSearchBean", jobSearchBean);

		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0025", e);
		} finally {
			KankokujinLogger.getInstance().debug(
					"JobUpdateOpenAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/job/jobUpdate.jsp")
				.forward(request, response);
	}
	
	private void setJobBean(JobBean jobBean, JobSearchBean jobSearchBean, 
			HttpServletRequest request) throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

		jobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		jobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		jobBean.setCharge(Util.changeNullStr(multi.getParameter("charge")));
		jobBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
		jobBean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		jobBean.setCompany_name_k(Util.changeNullStr(multi.getParameter("company_name_k")));
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
		jobBean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		jobBean.setCate_code_2(Util.changeNullStr(multi.getParameter("cate_code_2")));
		jobBean.setArea_code_1(Util.changeNullStr(multi.getParameter("area_code_1")));
		jobBean.setArea_code_2(Util.changeNullStr(multi.getParameter("area_code_2")));
		jobBean.setArea_code_3(Util.changeNullStr(multi.getParameter("area_code_3")));
		jobBean.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
		jobBean.setStation_code(Util.changeNullStr(multi.getParameter("station_code")));
		jobBean.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
		jobBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		jobBean.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
		
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
		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				jobBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				jobBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				jobBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				jobBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				jobBean.setPhoto_name5("");
			}
		}
		jobBean.setAppeal_point(Util.changeNullStr(multi.getParameter("appeal_point")));
		jobBean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		jobBean.setSex(Util.changeNullStr(multi.getParameter("sex")));

		jobSearchBean.setSex(Util.changeNullStr(multi.getParameter("search_sex")));
		jobSearchBean.setBefore(multi.getParameter("before"));
		jobSearchBean.setSearch_range(multi.getParameter("search_range"));
		jobSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		jobSearchBean.setSearch(Util.changeNullStr(multi.getParameter("search")));
		jobSearchBean.setDecodedSearch(EnDecoding.decoding(multi.getParameter("search")));
		
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

	private void setJobSearchBean(JobSearchBean jobSearchBean,
			HttpServletRequest request) {
		
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
}
