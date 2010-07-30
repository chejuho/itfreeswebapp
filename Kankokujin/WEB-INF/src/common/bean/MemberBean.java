package common.bean;

public class MemberBean {
	private int idkey;
	private String userid = "";
	private String password = "";	
	private String email1 = "";
	private String email2 = "";
	private String name = "";
	private String telephone1 = "";
	private String telephone2 = "";
	private String telephone3 = "";
	private String mobile1 = "";
	private String mobile2 = "";
	private String mobile3 = "";
	private String address = "";
	private String user_level = "";
	private String newPassword = "";
	private String registnum = "";	
	private String registflg = "";	
	private String agree_check = "";	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getMobile3() {
		return mobile3;
	}
	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getTelephone3() {
		return telephone3;
	}
	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public int getIdkey() {
		return idkey;
	}
	public void setIdkey(int idkey) {
		this.idkey = idkey;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUser_level() {
		return user_level;
	}
	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRegistnum() {
		return registnum;
	}
	public void setRegistnum(String registnum) {
		this.registnum = registnum;
	}
	public String getRegistflg() {
		return registflg;
	}
	public void setRegistflg(String registflg) {
		this.registflg = registflg;
	}
	public String getAgree_check() {
		if ("on".equals(agree_check)) {
			return "checked";
		} else {
			return "";
		}
	}
	public void setAgree_check(String agree_check) {
		this.agree_check = agree_check;
	}

}