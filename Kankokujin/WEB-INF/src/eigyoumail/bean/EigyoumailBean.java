package eigyoumail.bean;



public class EigyoumailBean {
	private int mail_id;
	private String update_by_user_id = "";
	private String title= "";
	private String contents = "";
	private String insert_date = "";
	private String update_date = "";
	private String pageSize  = "";	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public int getMail_id() {
		return mail_id;
	}
	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdate_by_user_id() {
		return update_by_user_id;
	}
	public void setUpdate_by_user_id(String update_by_user_id) {
		this.update_by_user_id = update_by_user_id;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}     
}
