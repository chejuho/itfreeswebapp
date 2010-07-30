package common.category;

import java.util.ArrayList;
import java.util.List;

public class Category  {
	
	private boolean rootSign_ = false;
	private List childCategory_ = new ArrayList();
	private List childBookmark_ = new ArrayList();
	private String name_ = null;
	private String cateCode_ = null;
	boolean open_ = false;
	
	public Category(String name, String cateCode) {
		this.name_ = name;
		this.cateCode_ = cateCode;
	}
	
	public void addCategory(Category category) {
		childCategory_.add(category);
	}
	public void addBookMark(BookMark bookmark) {
		childBookmark_.add(bookmark);
	}
	public List getChildCategory() {
		return childCategory_;
	}
	public List getChildBookmark() {
		return childBookmark_;
	}
	public String getName() {
		return name_;
	}
	public void setName(String name) {
		name_ = name;
	}
	public String getCateCode() {
		return cateCode_;
	}
	public void setCateCode(String cateCode) {
		cateCode_ = cateCode;
	}
	public boolean isOpen() {
		return open_;
	}
	public boolean setOpenClose(boolean sign) {
		return open_ = sign;
	}
	public void rootSet() {
		rootSign_ = true;
		open_ = true;
	}
	
}
