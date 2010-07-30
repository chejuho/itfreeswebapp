package buysell.bean;

import common.bean.SearchBean;
import common.exception.AppException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.util.Util;


public class BuySellSearchBean extends SearchBean {
	private String user_id="";
	private String search="";
	private String decodedSearch="";
	private String search_range="";
	private String search_all="";
	private String search_title="";
	private String search_name="";
	private String search_detail="";
	private String send_method="";
	private String send_direct="";
	private String send_post="";
	private String send_no_matter="";
	private String before = "";	
	private String area_code_1 = "";
	private String area_code_2 = "";
	private String line_code = "";
	private String station_code = "";
	private String list_view = "";
	private String list_view_image = "";
	private String list_view_text = "";
	private String pro_status = "";
	private String pro_status_used = "";
	private String pro_status_free = "";
	private String pro_status_new = "";
	private String pro_status_no_matter = "";
	private String free_price = "";
	private String price_no_matter = "";
	private String price_free_price = "";
	private String member_sort = "";	
	private String member_ama = "";
	private String member_pro = "";
	private String member_no_matter = "";
	private String sold_out = "";
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
	public String getSearch_detail() {
		return search_detail;
	}
	public void setSearch_detail(String search_detail) {
		this.search_detail = search_detail;
	}

	public void setSend_method(String send_method) {
		if (Util.isEmpty(send_method) || "0".equals(send_method)) {
			send_no_matter = "selected";
		} else if ("1".equals(send_method)){
			send_direct = "selected";
		} else if ("2".equals(send_method)){
			send_post = "selected";	
		}	
		this.send_method = send_method;
	}

	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSearch_title() {
		return search_title;
	}
	public void setSearch_title(String search_title) {
		this.search_title = search_title;
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
	public String getSend_direct() {
		return send_direct;
	}
	public void setSend_direct(String send_direct) {
		this.send_direct = send_direct;
	}
	public String getSend_method() {
		return send_method;
	}
	public String getSend_no_matter() {
		return send_no_matter;
	}
	public void setSend_no_matter(String send_no_matter) {
		this.send_no_matter = send_no_matter;
	}
	public String getSend_post() {
		return send_post;
	}
	public void setSend_post(String send_post) {
		this.send_post = send_post;
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
			search_name = "selected";	
		} else if ("3".equals(search_range)){
			search_detail = "selected";			
		}			
		this.search_range = search_range;
	}
	public String getList_view() {
		return list_view;
	}
	public String getList_view_image() {
		return list_view_image;
	}
	public void setList_view(String list_view) {
		if (Util.isEmpty(list_view) || "0".equals(list_view)) {
			list_view_text = "selected";
		} else if ("1".equals(list_view)){
			list_view_image = "selected";
		}		
		this.list_view = list_view;
	}
	public String getList_view_text() {
		return list_view_text;
	}
	public void setList_view_text(String list_view_text) {
		this.list_view_text = list_view_text;
	}
	public void setList_view_image(String list_view_image) {
		this.list_view_image = list_view_image;
	}
	public String getPro_status() {
		return pro_status;
	}
	public void setPro_status(String pro_status) {
		if ("".equals(pro_status) || "0".equals(pro_status)) {
			pro_status_no_matter = "selected";
		} else if ("1".equals(pro_status)) {
			pro_status_used = "selected";
		} else if ("2".equals(pro_status)) {
			pro_status_new = "selected";	
		} else if ("3".equals(pro_status)) {
			pro_status_free = "selected";					
		} 		
		this.pro_status = pro_status;
	}
	public String getMember_sort() {
		return member_sort;
	}
	public void setMember_sort(String member_sort) {
		if ("0".equals(member_sort)) {
			member_no_matter = "selected";
		} else if ("1".equals(member_sort)) {
			member_ama = "selected";
		} else if ("2".equals(member_sort)) {
			member_pro = "selected";
		}	
		this.member_sort = member_sort;
	}	
	public String getPro_status_no_matter() {
		return pro_status_no_matter;
	}	
	public String getPro_status_new() {
		return pro_status_new;
	}
	public void setPro_status_new(String pro_status_new) {
		this.pro_status_new = pro_status_new;
	}
	public String getPro_status_used() {
		return pro_status_used;
	}
	public void setPro_status_used(String pro_status_used) {
		this.pro_status_used = pro_status_used;
	}
	public String getPro_status_free() {
		return pro_status_free;
	}
	public void setPro_status_free(String pro_status_free) {
		this.pro_status_free = pro_status_free;
	}
	public String getFree_price() {
		return free_price;
	}
	public void setFree_price(String free_price) {
		if ("0".equals(free_price)) {
			price_no_matter = "selected";
		} else if ("1".equals(free_price)) {
			price_free_price = "selected";
		} 	
		this.free_price = free_price;
	}
	public String getMember_ama() {
		return member_ama;
	}
	public void setMember_ama(String member_ama) {
		this.member_ama = member_ama;
	}
	public String getMember_no_matter() {
		return member_no_matter;
	}
	public String getMember_pro() {
		return member_pro;
	}
	public void setMember_pro(String member_pro) {
		this.member_pro = member_pro;
	}
	public String getPrice_free_price() {
		return price_free_price;
	}
	public String getPrice_no_matter() {
		return price_no_matter;
	}
	public String getSold_out() {
		return sold_out;
	}
	public String getSold_out_checked() {
		if("on".equals(sold_out)){
			return " checked ";
		}
		return "";
	}
	public void setSold_out(String sold_out) {
		this.sold_out = sold_out;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
