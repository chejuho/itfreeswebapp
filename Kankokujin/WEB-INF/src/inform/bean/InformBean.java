package inform.bean;

import java.sql.Timestamp;

import common.util.Util;


public class InformBean {
	private String id = "";
	private String user_id = "";
	private String user_name = "";
	
	//
	private String title = "";
	private String detail_info = "";
	private Timestamp regist_date = null;
	//
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	
	public void setRegist_date(Timestamp regist_date) {
		this.regist_date = regist_date;
	}
	public Timestamp getRegist_dateTime() {
		return regist_date;
	}
	public String getRegist_date() {
		return Util.getUpdateDate(regist_date);
	}	
	public String getRegist_dateFull() {
		return Util.getUpdateDateFull(regist_date);
	}	
}
