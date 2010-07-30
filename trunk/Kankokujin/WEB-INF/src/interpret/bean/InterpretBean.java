package interpret.bean;

import common.constant.Const;
import common.handler.UtilHandler;
import common.util.Util;

public class InterpretBean {
	private String id = "";
	private String user_id = "";
	private String user_name = "";
	private String password = "";
	private String name_open = "1";
	private String language = "";
	private String language_name = "";
	private String language_etc = "";
	private String service_area_1 = "";
	private String service_area_1_name = "";
	private String service_area_1_etc = "";
	private String service_area_2 = "";
	private String sex = "";
	private String sex_name = "";
	private String birthday = "";
	private String year = "";
	private String month = "";
	private String nation = "";
	private String nation_name = "";
	private String nation_etc = "";
	private String photo = "";
	private String photo_path = "";
	private String photo_path_open = "1";
	private String nation_no = "";
	private String tel_no_1 = "";
	private String tel_no_2 = "";
	private String tel_no_1_open = "1";
	private String tel_no_2_open = "1";
	private String pay = "";
	private String pay_unit = "";
	private String pay_unit_name = "";
	private String pay_unit_etc = "";
	private String service_day = "";
	private String service_day_open = "1";
	private String certification = "";
	private String certification_open = "1";
	private String skill = "";
	private String skill_open = "1";
	private String introduction = "";
	private String introduction_open = "1";
	private String pageSize  = "";
	private String resume="";
	private String resume_path="";
	private String resume_path_open="1";
	private String email1="";
	private String email2="";
	private String regist_date="";
	private String update_date="";
	private String age="";
	private String etc="";
	private String etc_open="1";
	private String viewflg="";
	private String[] interpret={"","","",""};

	private String[] interpret_fee = {"",""};
	private String[] ages= {"",""};
	
	
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String[] getBirth() {
		String[] birth ={"",""};
		if(!Util.isEmpty(birthday)){
			birth[0]  = birthday.substring(0,4);
			birth[1] = birthday.substring(4); 
		}else{
			birth[0] = "";
			birth[1] = "";
		}
		return birth;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getCertification_open() {
		return certification_open;
	}
	public void setCertification_open(String certification_open) {
		this.certification_open = certification_open;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getIntroduction_open() {
		return introduction_open;
	}
	public void setIntroduction_open(String introduction_open) {
		this.introduction_open = introduction_open;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguageName() {
		if(!Util.isEmpty(language_etc)){
			
			language+="/"+language_etc;
		}
		return language;
	}
	public String getName_open() {
		return name_open;
	}
	public void setName_open(String name_open) {
		this.name_open = name_open;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNation_no() {
		return nation_no;
	}
	public void setNation_no(String nation_no) {
		this.nation_no = nation_no;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getPay_unit() {
		return pay_unit;
	}
	public void setPay_unit(String pay_unit) {
		this.pay_unit = pay_unit;
	}
	public String getPay_unit_etc() {
		return pay_unit_etc;
	}
	public void setPay_unit_etc(String pay_unit_etc) {
		this.pay_unit_etc = pay_unit_etc;
	}
	public String getPhoto_path() {
		if(!Util.isEmpty(photo_path) && !"XXXXX".equals(photo_path)){
			return Const.IMAGE_FOLDER_PATH+photo_path;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public String getPhoto_path_open() {
		return photo_path_open;
	}
	public void setPhoto_path_open(String photo_path_open) {
		this.photo_path_open = photo_path_open;
	}
	public String getService_area_1() {
		return service_area_1;
	}
	public void setService_area_1(String service_area_1) {
		this.service_area_1 = service_area_1;
	}
	public String getService_area_1_etc() {
		return service_area_1_etc;
	}
	public void setService_area_1_etc(String service_area_1_etc) {
		this.service_area_1_etc = service_area_1_etc;
	}
	public String getService_area_2() {
		return service_area_2;
	}
	public void setService_area_2(String service_area_2) {
		this.service_area_2 = service_area_2;
	}
	public String getService_day() {
		return service_day;
	}
	public void setService_day(String service_day) {
		this.service_day = service_day;
	}
	public String getService_day_open() {
		return service_day_open;
	}
	public void setService_day_open(String service_day_open) {
		this.service_day_open = service_day_open;
	}
	public String getSex() {
		return sex;
	}
	public String getSex_checked(String index) {
		if (sex.equals(index)) {
			return " checked ";
		} else {
			return "";
		}			
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getSkill_open() {
		return skill_open;
	}
	public void setSkill_open(String skill_open) {
		this.skill_open = skill_open;
	}
	public String getTel_no_1() {
		return tel_no_1;
	}
	public void setTel_no_1(String tel_no_1) {
		this.tel_no_1 = tel_no_1;
	}

	public String[] getTel() {
		String[] tell={"","",""};
		if(!Util.isEmpty(tel_no_1)){
			tell = tel_no_1.split("-");
		}
		return tell;
	}
	public String[] getMobile() {
		String[] mobile={"","",""};
		if(!Util.isEmpty(tel_no_2)){
			mobile = tel_no_2.split("-");
		}
		return mobile;
	}
	
	
	public String getTel_no_1_open() {
		return tel_no_1_open;
	}
	public void setTel_no_1_open(String tel_no_1_open) {
		this.tel_no_1_open = tel_no_1_open;
	}
	public String getTel_no_2() {
		return tel_no_2;
	}
	public void setTel_no_2(String tel_no_2) {
		this.tel_no_2 = tel_no_2;
	}
	public String getTel_no_2_open() {
		return tel_no_2_open;
	}
	public void setTel_no_2_open(String tel_no_2_open) {
		this.tel_no_2_open = tel_no_2_open;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getLanguage_etc() {
		return language_etc;
	}
	public void setLanguage_etc(String language_etc) {
		this.language_etc = language_etc;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getResume_path() {
		if(!Util.isEmpty(resume_path)){
			return Const.RESUME_FOLDER_PATH+resume_path;
		}else{
			return "";
		}
	}
	public void setResume_path(String resume_path) {
		this.resume_path = resume_path;
	}
	public String getResume_path_open() {
		return resume_path_open;
	}
	public void setResume_path_open(String resume_path_open) {
		this.resume_path_open = resume_path_open;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNation_etc() {
		return nation_etc;
	}
	public void setNation_etc(String nation_etc) {
		this.nation_etc = nation_etc;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getInterpret_fee1Tag() {
		return UtilHandler.getInterpretFee1Tag(interpret_fee[0]);
	}
	public String getInterpret_fee2Tag() {
		return UtilHandler.getInterpretFee2Tag(interpret_fee[0], interpret_fee[1]);
	}
	public String[] getAges() {
		return ages;
	}
	public void setAges(String[] ages) {
		this.ages = ages;
	}
	public String getAge1Tag() {
		return UtilHandler.getAge1Tag(ages[0]);
	}
	public String getAge2Tag() {
		return UtilHandler.getAge2Tag(ages[0], ages[1]);
	}
	public String getLanguage_checked(int index) {
		if (!Util.isEmpty(interpret[index])) {
			return " checked ";
		} else {
			return "";
		}			
	}
	public String getService_area_selected(String index) {
		if (service_area_1.equals(index)) {
			return " selected ";
		} else {
			return "";
		}			
	}
	public String[] getInterpret_fee() {
		return interpret_fee;
	}
	public void setInterpret_fee(String[] interpret_fee) {
		this.interpret_fee = interpret_fee;
	}
	public String getNation_selected(String index) {
		if (nation.equals(index)) {
			return " selected ";
		} else {
			return "";
		}	
	}
	public String getResume_checked(String index) {
		if (resume.equals(index)) {
			return " checked ";
		} else {
			return "";
		}	
	}
	public String[] getInterpret() {
		return interpret;
	}
	public void setInterpret(String[] interpret) {
		this.interpret = interpret;
	}
	public String getServiceArea() {
		String service_area="";
		String split="";
		if (!Util.isEmpty(service_area_1)) {
			split="/";
			if (!Util.isEmpty(service_area_2)) { 
				service_area_1+="("+service_area_2+")";
         	}
		}
		if (!Util.isEmpty(service_area_1_etc)) {
			service_area = service_area_1+split+service_area_1_etc;
		} else {
			service_area = service_area_1;
		}	
		return service_area;
	}
	public String getLanguage_name() {
		return language_name;
	}
	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}
	public String getNation_name() {
		return nation_name;
	}
	public void setNation_name(String nation_name) {
		this.nation_name = nation_name;
	}
	public String getNationName() {
		String nationName=nation_name;
		if (!Util.isEmpty(nation_etc)) {
			nationName = nation_etc;
		} else {
			nationName = nation_name;
		}	
		return nationName;
	}
	public String getService_area_1_name() {
		return service_area_1_name;
	}
	public void setService_area_1_name(String service_area_1_name) {
		this.service_area_1_name = service_area_1_name;
	}
	public String getPay_unit_name() {
		return pay_unit_name;
	}
	public void setPay_unit_name(String pay_unit_name) {
		this.pay_unit_name = pay_unit_name;
	}
	public String getSex_name() {
		return sex_name;
	}
	public void setSex_name(String sex_name) {
		this.sex_name = sex_name;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getEtc_open() {
		return etc_open;
	}
	public void setEtc_open(String etc_open) {
		this.etc_open = etc_open;
	}
	public String getViewflg() {
		return viewflg;
	}
	public void setViewflg(String viewflg) {
		this.viewflg = viewflg;
	}
	public String[] getLanguage_Select() {
		int size = language.length();
		String language_select[] ={"","",""};
		for(int i=0;i<size;i++){	
			language_select[i]  = language.substring(i,i+1);
		}
		return language_select;
	}
	
}
