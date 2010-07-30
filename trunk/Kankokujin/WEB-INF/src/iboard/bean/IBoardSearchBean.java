package iboard.bean;


public class IBoardSearchBean  {
	
	private String search="";
	private String pageNum = "";
	private String pageSize = "";
	private String search_range = "";
	
	private String iboard_id = "";
	private boolean myWrite = false;
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public boolean getMyWrite() {
		return myWrite;
	}
	public void setMyWrite(String myWrite) {
		myWrite = myWrite;
	}
	public String getSearch_range() {
		return search_range;
	}
	public void setSearch_range(String searchRange) {
		search_range = searchRange;
	}
	public void setMyWrite(boolean myWrite) {
		this.myWrite = myWrite;
	}
	public String getIboard_id() {
		return iboard_id;
	}
	public void setIboard_id(String iboardId) {
		iboard_id = iboardId;
	}
}
