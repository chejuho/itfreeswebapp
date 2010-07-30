package job.bean;

import common.bean.Bean;

public class JobBean extends Bean {
	private String company_name_k = "";
	private String company_name_j = "";	
	private String search_word = "";
	private String title = "";
	private String charge = "";
	private String pay = "";
	private String work_time = "";
	private String sex = "";
	private String url = "";
	private String area_fast = "";
	private String sort_code = "";
	private String view_code = "";
	private String appeal_point="";
	private String detail_info="";
	private String main_area="";
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

	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getAppeal_point() {
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
	public String getCompany_name_j() {
		return company_name_j;
	}
	public void setCompany_name_j(String company_name_j) {
		this.company_name_j = company_name_j;
	}
	public String getCompany_name_k() {
		return company_name_k;
	}
	public void setCompany_name_k(String company_name_k) {
		this.company_name_k = company_name_k;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public String getSex() {
		return sex;
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
	public void setSex(String sex) {
		this.sex = sex;
	}
}
