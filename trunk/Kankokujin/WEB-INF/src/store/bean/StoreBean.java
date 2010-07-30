package store.bean;

import common.bean.Bean;
import common.util.Util;

public class StoreBean extends Bean{
	private String store_name_k = "";
	private String store_name_j = "";
	private String search_word = "";
	private String url = "";
	private String area_fast = "";
	private String sort_code = "";
	private String view_code = "";
	private String appeal_point= "";
	private String detail_info= "";
	private String regist_date= "";	
	private String page_size= "";
	private String main_area= "";
	private String work_time= "";
	private String rest_day= "";
	public String getMain_area() {
		return main_area;
	}
	public void setMain_area(String main_area) {
		this.main_area = main_area;
	}
	public String getArea_fast() {
		return area_fast;
	}
	public void setArea_fast(String area_fast) {
		this.area_fast = area_fast;
	}

	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public String getSort_code() {
		return sort_code;
	}
	public void setSort_code(String sort_code) {
		this.sort_code = sort_code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getView_code() {
		return view_code;
	}
	public void setView_code(String view_code) {
		this.view_code = view_code;
	}
	public String getPage_size() {
		return page_size;
	}
	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}
	public String[] getMain_area_checked() {
		String[] mainAreaArray = {"","","",""};
		if ("1".equals(main_area)) {
			mainAreaArray[0] = " checked";
		} else if ("2".equals(main_area)) {
			mainAreaArray[1] = " checked";
		}
		return mainAreaArray;
	}
	public String[] getMain_area_disabled() {
		String[] mainAreaArray = {"","","",""};
		if ("1".equals(main_area)) {
			mainAreaArray[0] = " disabled=true ";
		} else if ("2".equals(main_area)) {
			mainAreaArray[1] = " disabled=true ";
		}
		return mainAreaArray;
	}

	public String[] getAreaFast_Selected() {
		String[] areaFastArray = {"","","",""};
		if ("".equals(area_fast)) {
			areaFastArray[0]="selected";
		} else if ("okubo_area".equals(area_fast)) {
			areaFastArray[1]="selected";
		} else if ("nakano_area".equals(area_fast)) {
			areaFastArray[2]="selected";
		} else if ("nippori_area".equals(area_fast)) {
			areaFastArray[3]="selected";
		}
		return areaFastArray;
	}
	public String getStore_name_j() {
		return store_name_j;
	}
	public void setStore_name_j(String store_name_j) {
		this.store_name_j = store_name_j;
	}
	public String getStore_name_k() {
		return store_name_k;
	}
	public void setStore_name_k(String store_name_k) {
		this.store_name_k = store_name_k;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getAppeal_point() {
		if(Util.isEmpty(appeal_point)) {
			appeal_point = "";
		}
		return appeal_point;
	}
	public void setAppeal_point(String appeal_point) {
		this.appeal_point = appeal_point;
	}
	public String getSearch_word() {
		return search_word;
	}
	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	public String getStore_full_name() {
		if(!Util.isEmpty(store_name_k) && !Util.isEmpty(store_name_j)){
			
			return store_name_k + "Åi" +  store_name_j + "Åj";
		}
		if(Util.isEmpty(store_name_k)) {
			store_name_k = "";
		}
		if(Util.isEmpty(store_name_j)) {
			store_name_j = "";
		}
		return store_name_k + store_name_j;
	}
	public String getRest_day() {
		return rest_day;
	}
	public void setRest_day(String rest_day) {
		this.rest_day = rest_day;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
}
