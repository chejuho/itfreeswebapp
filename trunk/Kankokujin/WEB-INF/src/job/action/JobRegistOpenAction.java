package job.action;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.bean.JobBean;
import job.bean.JobSearchBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.MemberBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class JobRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("JobRegistOpenAction.START");
		HttpSession session = request.getSession();
		JobBean jobBean = new JobBean();
		JobSearchBean jobSearchBean = new JobSearchBean();
		if (Util.isLogin(request)) {
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
			try {
				//reload
				if(Util.isEmpty(request.getParameter("f"))){
					setJobBean(jobBean, jobSearchBean, request);
				//from search
				} else {
					setJobSearchBean(jobBean, jobSearchBean, request);
					MemberBean memberBean= (MemberBean)session.getAttribute("memberInfo");
					jobBean.setUser_id(memberBean.getUserid());
					jobBean.setEmail(memberBean.getEmail1() + "@"
							+ memberBean.getEmail2());
					jobBean.setTel_no1_1(memberBean.getTelephone1());
					jobBean.setTel_no1_2(memberBean.getTelephone2());
					jobBean.setTel_no1_3(memberBean.getTelephone3());
					jobBean.setTel_no2_1(memberBean.getMobile1());
					jobBean.setTel_no2_2(memberBean.getMobile2());
					jobBean.setTel_no2_3(memberBean.getMobile3());						
				}
				session.setAttribute("topmenu", "job");	
				request.setAttribute("JobBean", jobBean);
				request.setAttribute("JobSearchBean", jobSearchBean);
				session.setAttribute("action", "JobRegistOpen?before=search&f=search&cate_code_1="+jobSearchBean.getCate_code_1());
			} catch (Exception e) {
				throw new KankokujinException("SYE0016", e);
			} finally {
			}
			
			this.getServletContext().getRequestDispatcher(
					"/jsp/job/jobRegist.jsp").forward(request, response);

		} else {
			setJobSearchBean(jobBean, jobSearchBean, request);
			session.setAttribute("action", "JobRegistOpen?before=search&f=search&search_cate_code_1="+jobSearchBean.getCate_code_1()+"&search_cate_code_2="+jobSearchBean.getCate_code_2()+"&cate_code_1="+jobBean.getCate_code_1()+"&pageSize="+jobSearchBean.getPageSize()+"&userFlag=0&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);
		}

	}

	private void setJobBean(JobBean jobBean, JobSearchBean jobSearchBean, 
			HttpServletRequest request) throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		jobBean.setId(Util.changeNullStr(multi.getParameter("id")));
		jobBean.setCompany_name_k(Util.changeNullStr(multi.getParameter("company_name_k")));
		jobBean.setSearch_word(Util.changeNullStr(multi.getParameter("search_word")));
		jobBean.setEmail(Util.changeNullStr(multi.getParameter("email")));
		jobBean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		jobBean.setCharge(Util.changeNullStr(multi.getParameter("charge")));
		jobBean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		jobBean.setSex(Util.changeNullStr(multi.getParameter("sex")));
		jobBean.setWork_time(Util.changeNullStr(multi.getParameter("work_time")));
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
		if ("-".equals(request.getParameter("cate_code_2"))){
			jobBean.setCate_code_2("");			
		}
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
	}

	private void setJobSearchBean(JobBean jobBean, JobSearchBean jobSearchBean,
			HttpServletRequest request) {
		
		jobSearchBean.setBefore(request.getParameter("before"));
		jobSearchBean.setSearch_range(request.getParameter("search_range"));
		if(!"0".equals(request.getParameter("userFlag"))){
			jobSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		}
		jobSearchBean.setSearch(Util.changeNullStr(request.getParameter("search")));
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
		if(!Util.isEmpty(request.getParameter("cate_code_1")) && request.getParameter("cate_code_1").equals(jobSearchBean.getCate_code_1())){
			jobBean.setCate_code_1(jobSearchBean.getCate_code_1());
			jobBean.setCate_code_2(jobSearchBean.getCate_code_2());
		} else {
			jobBean.setCate_code_1(request.getParameter("cate_code_1"));
		}
		jobBean.setSex(jobSearchBean.getSex());
	}
}