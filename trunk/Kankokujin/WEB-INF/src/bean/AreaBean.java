package bean;

import common.util.Util;

public class AreaBean implements Comparable {
	private String area_code_1 = "";
	private String area_code_2 = "";
	private String area_name_1 = "";
	private String area_name_2 = "";
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
	public String getArea_name_1() {
		return area_name_1;
	}
	public void setArea_name_1(String area_name_1) {
		this.area_name_1 = area_name_1;
	}
	public String getArea_name_2() {
		return area_name_2;
	}
	public void setArea_name_2(String area_name_2) {
		this.area_name_2 = area_name_2;
	}
	public int compareTo(Object o) {
		
		AreaBean bean = (AreaBean) o;
		
		if (0 < area_code_1.compareTo(bean.getArea_code_1())) {
			return 1;
		}
		
		if (Util.isEmpty(area_code_1)) {
			if (0 < area_code_2.compareTo(bean.getArea_code_2())) {
				return 1;
			}
		}
		
		return 0;
	}
}
