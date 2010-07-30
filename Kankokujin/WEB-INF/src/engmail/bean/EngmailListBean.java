package engmail.bean;



public class EngmailListBean {
	private int id;
	private String to_mail = "";
	private String initial = "";
	private String to_mobile_mail = "";
	private String to_name = "";
	private String insert_date = "";
	private String update_date = "";	
	private String pageSize  = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getTo_mail() {
		return to_mail;
	}
	public void setTo_mail(String to_mail) {
		this.to_mail = to_mail;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	public String getTo_mobile_mail() {
		return to_mobile_mail;
	}
	public void setTo_mobile_mail(String to_mobile_mail) {
		this.to_mobile_mail = to_mobile_mail;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	      
}
