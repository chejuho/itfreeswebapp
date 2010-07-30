package job.bean;

import common.bean.SearchBean;
import common.util.Util;

public class JobSearchBean extends SearchBean{

	private String before = "";
	private String appeal_point="";
	private String detail_info="";
	private String search="";
	private String decodedSearch="";
	private String search_range="";
	private String search_all="";
	private String search_com_name="";
	private String search_title="";
	private String search_detail="";
	private String user_id = "";
	private String pageNum = "";
	private String sex = "";
	private String regist_date = "";
	public String getAppeal_point() {
		return appeal_point;
	}
	public void setAppeal_point(String appeal_point) {
		this.appeal_point = appeal_point;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getDecodedSearch() {
		return decodedSearch;
	}
	public void setDecodedSearch(String decodedSearch) {
		this.decodedSearch = decodedSearch;
	}
	public String getSearch_all() {
		return search_all;
	}
	public void setSearch_all(String search_all) {
		this.search_all = search_all;
	}
	public String getSearch_com_name() {
		return search_com_name;
	}
	public void setSearch_com_name(String search_com_name) {
		this.search_com_name = search_com_name;
	}
	public String getSearch_detail() {
		return search_detail;
	}
	public void setSearch_detail(String search_detail) {
		this.search_detail = search_detail;
	}
	public String getSearch_range() {
		return search_range;
	}
	public void setSearch_range(String search_range) {
		if (Util.isEmpty(search_range) || "0".equals(search_range)) {
			search_all = "selected";
		} else if ("1".equals(search_range)){
			search_com_name = "selected";
		} else if ("2".equals(search_range)){
			search_title = "selected";	
		} else if ("3".equals(search_range)){
			search_detail = "selected";			
		}	
		this.search_range = search_range;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex_selected(int input) {
		String[] sex_selected = {"","",""};
		if("0".equals(sex)){
			sex_selected[0] = "selected";
		} else if("1".equals(sex)){
			sex_selected[1] = "selected";
		} else if("2".equals(sex)){
			sex_selected[2] = "selected";
		}
		return sex_selected[input];
	}
	public String getSearch_title() {
		return search_title;
	}
	public void setSearch_title(String search_title) {
		this.search_title = search_title;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
}
