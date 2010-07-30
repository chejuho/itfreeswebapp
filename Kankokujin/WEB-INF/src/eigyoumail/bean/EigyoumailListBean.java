package eigyoumail.bean;



public class EigyoumailListBean {
	private int mail_id;
	private String part_name = "";
	private String to_mail = "";
	private String to_name = "";
	private String view_to_name = "";	
	private String company = "";
	private int flag_send;
	private String pageSize  = "";
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getFlag_send() {
		return flag_send;
	}
	public void setFlag_send(int flag_send) {
		this.flag_send = flag_send;
	}
	public int getMail_id() {
		return mail_id;
	}
	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
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
	public String getView_to_name() {
		return view_to_name;
	}
	public void setView_to_name(String view_to_name) {
		this.view_to_name = view_to_name;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	      
}
