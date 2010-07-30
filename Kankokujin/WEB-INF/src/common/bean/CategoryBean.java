package common.bean;

import java.util.ArrayList;
import java.util.List;


public class CategoryBean {
	
	private String cate_code = "";
	private String cate_name = "";
	private List<CategoryBean> childBeanList = new ArrayList<CategoryBean>();
	
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
	public List getChildBeanList() {
		return childBeanList;
	}
	public void setChildBeanList(List childBeanList_) {
		this.childBeanList = childBeanList_;
	}
	public void addChild(CategoryBean childBean) {
		childBeanList.add(childBean);
	}
}

