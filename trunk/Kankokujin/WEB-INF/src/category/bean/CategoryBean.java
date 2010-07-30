package category.bean;

import java.util.ArrayList;
import java.util.List;


import common.util.Util;


public class CategoryBean implements Comparable {
	
	private String cate_code = "";
	private String cate_name = "";
	private String cate_code_2 = "";
	private String cate_name_2 = "";	
	private String view_sort = "";
	private List childBeanList = new ArrayList();
	
	public String getCate_code() {
		return cate_code;
	}
	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public String getView_sort() {
		return view_sort;
	}
	public void setView_sort(String view_sort) {
		this.view_sort = view_sort;
	}
	public List getChildBeanList() {
		return childBeanList;
	}
	public void setChildBeanList(List childBeanList) {
		this.childBeanList = childBeanList;
	}
	public String getCate_code_2() {
		return cate_code_2;
	}
	public void setCate_code_2(String cate_code_2) {
		this.cate_code_2 = cate_code_2;
	}
	public String getCate_name_2() {
		return cate_name_2;
	}
	public void setCate_name_2(String cate_name_2) {
		this.cate_name_2 = cate_name_2;
	}
	public int compareTo(Object o) {
		
		CategoryBean bean = (CategoryBean) o;
		
		if (0 < cate_code.compareTo(bean.getCate_code())) {
			return 1;
		}
		
		if (Util.isEmpty(cate_code)) {
			if (0 < cate_code_2.compareTo(bean.getCate_code_2())) {
				return 1;
			}
		}
		
		return 0;
	}

}

