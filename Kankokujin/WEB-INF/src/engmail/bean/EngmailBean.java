package engmail.bean;

import email.bean.EmailBean;

public class EngmailBean extends EmailBean{

	private int mail_id;
	private String to_mail_list = "";
	private String update_by_user_id = "";
	private String insert_date = "";
	private String update_date = "";
	private String pageSize  = "";	
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
	public String getTo_mail_list() {
		return to_mail_list;
	}
	public void setTo_mail_list(String to_mail_list) {
		this.to_mail_list = to_mail_list;
	}

}