package main.bean;

import common.bean.Bean;
public class ContactusBean extends Bean{
	private String id = "";
	private String name = "";
	private String email = "";
	private String tel_no1_1 = "";
	private String tel_no1_2 = "";
	private String tel_no1_3 = "";
	private String tel_no2_1 = "";
	private String tel_no2_2 = "";
	private String tel_no2_3 = "";	
	private String title = "";
	private String detail_info = "";
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel_no1_1() {
		return tel_no1_1;
	}
	public void setTel_no1_1(String tel_no1_1) {
		this.tel_no1_1 = tel_no1_1;
	}
	public String getTel_no1_2() {
		return tel_no1_2;
	}
	public void setTel_no1_2(String tel_no1_2) {
		this.tel_no1_2 = tel_no1_2;
	}
	public String getTel_no1_3() {
		return tel_no1_3;
	}
	public void setTel_no1_3(String tel_no1_3) {
		this.tel_no1_3 = tel_no1_3;
	}
	public String getTel_no2_1() {
		return tel_no2_1;
	}
	public void setTel_no2_1(String tel_no2_1) {
		this.tel_no2_1 = tel_no2_1;
	}
	public String getTel_no2_2() {
		return tel_no2_2;
	}
	public void setTel_no2_2(String tel_no2_2) {
		this.tel_no2_2 = tel_no2_2;
	}
	public String getTel_no2_3() {
		return tel_no2_3;
	}
	public void setTel_no2_3(String tel_no2_3) {
		this.tel_no2_3 = tel_no2_3;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
