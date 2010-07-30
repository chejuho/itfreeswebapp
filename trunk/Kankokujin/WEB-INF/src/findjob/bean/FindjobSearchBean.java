package findjob.bean;

import common.exception.AppException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.util.Util;
import common.bean.SearchBean;

public class FindjobSearchBean extends SearchBean{

	private String area_code_1 = "";
	private String area_code_2 = "";
	private String before = "";
	private String line_code = "";
	private String station_code = "";
	private String cate_code_1 = "";
	private String cate_code_2 = "";
	private String appeal_point="";
	private String detail_info="";
	private String search="";
	private String decodedSearch="";
	private String search_range="";
	private String search_all="";
	private String search_title="";
	private String search_com_name="";
	private String search_detail="";
	private String user_id = "";
	private String pageNum = "";
	private String regist_date = "";
	public String getArea_1Tag() throws SysException {
		
		return UtilHandler.getArea1Tag(area_code_1);
	}
	public String getArea_2Tag() throws SysException {
		
		return UtilHandler.getArea2Tag(area_code_1, area_code_2);
	}
	public String getLineTag() throws AppException {
		return UtilHandler.getTrainLineTag(line_code);
	}
	public String getStationTag() throws AppException {
		return UtilHandler.getStationTag(line_code, station_code);
	}
	public String getAppeal_point() {
		return appeal_point;
	}
	public void setAppeal_point(String appeal_point) {
		this.appeal_point = appeal_point;
	}
	public String getArea_code_1() {
		return area_code_1;
	}
	public void setArea_code_1(String area_code_1) {
		this.area_code_1 = area_code_1;
	}
	public String getArea_code_2() {
		return area_code_2;
	}
	public void setArea_code_2(String area_code_2) {
		this.area_code_2 = area_code_2;
	}
	public String getCate_code_1() {
		return cate_code_1;
	}
	public void setCate_code_1(String cate_code_1) {
		this.cate_code_1 = cate_code_1;
	}
	public String getCate_code_2() {
		return cate_code_2;
	}
	public void setCate_code_2(String cate_code_2) {
		this.cate_code_2 = cate_code_2;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
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
			search_title = "selected";			
		} else if ("2".equals(search_range)){
			search_com_name = "selected";
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
