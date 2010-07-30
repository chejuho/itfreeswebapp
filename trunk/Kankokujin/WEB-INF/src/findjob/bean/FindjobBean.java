package findjob.bean;

import common.bean.Bean;

public class FindjobBean extends Bean {
	private String title = "";
	private String work_sort="";
	private String birthday="";
	private String sex="";		
	private String appeal_point="";
	private String detail_info="";
	public String getAppeal_point() {
		return appeal_point;
	}
	public void setAppeal_point(String appeal_point) {
		this.appeal_point = appeal_point;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getWork_sort() {
		return work_sort;
	}
	public String getWork_sort_selected(int input) {
		String[] work_sort_selected = {"","",""};
		if("0".equals(work_sort)){
			work_sort_selected[0] = "selected";
		} else if("1".equals(work_sort)){
			work_sort_selected[1] = "selected";
		} else if("2".equals(work_sort)){
			work_sort_selected[2] = "selected";
		}
		return work_sort_selected[input];
	}	
	public void setWork_sort(String work_sort) {
		this.work_sort = work_sort;
	}
}
