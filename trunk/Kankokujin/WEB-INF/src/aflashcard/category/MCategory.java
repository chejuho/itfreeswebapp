package aflashcard.category;

import java.util.ArrayList;
import java.util.List;

public class MCategory  {
	
	private boolean rootSign_ = false;
	private List<MCategory> childCategory_ = new ArrayList<MCategory>();
	private String name_ = null;
	private String cateCode_ = null;
	boolean open_ = false;
	
	public MCategory(String name, String cateCode) {
		this.name_ = name;
		this.cateCode_ = cateCode;
	}
	
	public void addCategory(MCategory category) {
		childCategory_.add(category);
	}
	
	public List<MCategory> getChildCategory() {
		return childCategory_;
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
