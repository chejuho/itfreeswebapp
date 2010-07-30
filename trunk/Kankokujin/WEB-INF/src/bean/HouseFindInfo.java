package bean;

import javax.servlet.http.HttpServletRequest;

import common.exception.AppException;
import common.util.Util;

//import util.HouseUtil;


public class HouseFindInfo {
	String id = "";
	String title="";
	String user_id="";	
	String email="";
	String telephone="";	
	String detail_info="";
	String come_dock="";
	String come_dock_year="";
	String come_dock_month="";
	String house_fee_from="";
	String house_fee_to="";
	String area_code_1="";
	String area_code_2="";
	String area_fast="";
	String main_area="";	
	String line_code="";
	String station_code="";	
	String walk_time="";
	String[] house_sort={"","","","","","","","",""};
	String dimension_from="";
	String dimension_to="";
	String regist_date="";	
	String update_date="";
	String read_count="";
	String[] madori={"","","","","","","","","","","",""};

	public String getArea_code_1() {
		return area_code_1;
	}
	public void setArea_code_1(String area_code_1) {
		this.area_code_1 = area_code_1;
	}
	public String getArea_code_2() {
		return area_code_2;
	}
	public void setArea_code_2(String area_code_2) {
		this.area_code_2 = area_code_2;
	}
	public String getArea_fast() {
		return area_fast;
	}
	public String getArea_Name(HttpServletRequest request) throws AppException {
		String result = "";
		if ("1".equals(main_area)) {
			if ("okubo_area".equals(area_fast)){
				result = Util.getConstantValue(request, "okubo_area");
			} else if ("nakano_area".equals(area_fast)) {
				result = Util.getConstantValue(request, "nakano_area");
			} else if ("nippori_area".equals(area_fast)) {
				result = Util.getConstantValue(request, "nippori_area");
			} 
		} else if ("2".equals(main_area)) {
			//result = HouseUtil.getAreaName(area_code_1, area_code_2,"");
		}
		return result;
	}
	public void setArea_fast(String area_fast) {
		this.area_fast = area_fast;
	}
	public String getCome_dock() {
		return come_dock;
	}
	public String getCome_dock_Name(HttpServletRequest request) throws AppException {
		String result = "";		
		if ("1".equals(come_dock)) {
			result = Util.getConstantValue(request, "immediately_k");
		} else if ("2".equals(come_dock)) {
			result = getCome_dock_year() + "/"+ getCome_dock_month();
		}
		return result;
	}
	public String getCome_dock_ime_checked() {
		String checked = "";
		if ("1".equals(come_dock)) {
			checked = " checked";
		}
		return checked;
	}
	public String getCome_dock_not_ime_checked() {
		String checked = "";
		if ("2".equals(come_dock)) {
			checked = " checked";
		}
		return checked;
	}
	public String getMain_area_checked() {
		String checked = "";
		if ("1".equals(main_area)) {
			checked = " checked";
		}
		return checked;
	}
	public String getMain_area_not_checked() {
		String checked = "";
		if ("2".equals(main_area)) {
			checked = " checked";
		}
		return checked;
	}
	public void setCome_dock(String come_dock) {
		this.come_dock = come_dock;
	}
	public String getCome_dock_month() {
		return come_dock_month;
	}
	public void setCome_dock_month(String come_dock_month) {
		this.come_dock_month = come_dock_month;
	}
	public String getCome_dock_year() {
		return come_dock_year;
	}
	public void setCome_dock_year(String come_dock_year) {
		this.come_dock_year = come_dock_year;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getDimension_from() {
		return dimension_from;
	}
	public void setDimension_from(String dimension_from) {
		this.dimension_from = dimension_from;
	}
	public String getDimension_to() {
		return dimension_to;
	}
	public void setDimension_to(String dimension_to) {
		this.dimension_to = dimension_to;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHouse_fee_from() {
		return house_fee_from;
	}
	public void setHouse_fee_from(String house_fee_from) {
		this.house_fee_from = house_fee_from;
	}
	public String getHouse_fee_to() {
		return house_fee_to;
	}
	public void setHouse_fee_to(String house_fee_to) {
		this.house_fee_to = house_fee_to;
	}
	public String[] getHouse_sort() {
		return house_sort;
	}
	public String getMadori_Name(HttpServletRequest request) throws AppException {
		StringBuffer sb = new StringBuffer();
		if ("checked".equals(madori[0])){
			sb.append("/" + "1R");
		}
		if ("checked".equals(madori[1])){
			sb.append("/" + "1K");
		}
		if ("checked".equals(madori[2])){
			sb.append("/" + "1DK");
		}
		if ("checked".equals(madori[3])){
			sb.append("/" + "1LDK");
		}
		if ("checked".equals(madori[4])){
			sb.append("/" + "2K");
		}
		if ("checked".equals(madori[5])){
			sb.append("/" + "2DK");
		}
		if ("checked".equals(madori[6])){
			sb.append("/" + "2LDK");
		}
		if ("checked".equals(madori[7])){
			sb.append("/" + "3DK");
		}
		if ("checked".equals(madori[8])){
			sb.append("/" + "3LDK");
		}
		if ("checked".equals(madori[9])){
			sb.append("/" + "4DK");
		}
		if ("checked".equals(madori[10])){
			sb.append("/" + "4LDK");
		}
		if ("checked".equals(madori[11])){
			sb.append("/" + Util.getConstantValue(request, "etc"));
		}
		return sb.toString();
	}
	public String getHouse_sort_Name(HttpServletRequest request) throws AppException {
		StringBuffer sb = new StringBuffer();
		if ("checked".equals(house_sort[0])){
			sb.append("/" + Util.getConstantValue(request, "apt_type"));
		}
		if ("checked".equals(house_sort[1])){
			sb.append("/" + Util.getConstantValue(request, "house_type"));
		}
		if ("checked".equals(house_sort[2])){
			sb.append("/" + Util.getConstantValue(request, "house_type"));
		}
		if ("checked".equals(house_sort[3])){
			sb.append("/" + Util.getConstantValue(request, "park_type"));
		}
		if ("checked".equals(house_sort[4])){
			sb.append("/" + Util.getConstantValue(request, "shop_type"));
		}
		if ("checked".equals(house_sort[5])){
			sb.append("/" + Util.getConstantValue(request, "office_type"));
		}
		if ("checked".equals(house_sort[6])){
			sb.append("/" + Util.getConstantValue(request, "land_type"));
		}
		if ("checked".equals(house_sort[7])){
			sb.append("/" + Util.getConstantValue(request, "etc"));
		}
		return sb.toString();
	}
	public void setHouse_sort(String[] house_sort) {
		this.house_sort = house_sort;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTraffic_Name() {		
		//return HouseUtil.getLineName(line_code, station_code);
		return "";
	}
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public String getMain_area() {
		return main_area;
	}
	public void setMain_area(String main_area) {
		this.main_area = main_area;
	}
	public String getRead_count() {
		return read_count;
	}
	public void setRead_count(String read_count) {
		this.read_count = read_count;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWalk_time() {
		return walk_time;
	}
	public void setWalk_time(String walk_time) {
		this.walk_time = walk_time;
	}
	public String[] getMadori() {
		return madori;
	}
	public void setMadori(String[] madori) {
		this.madori = madori;
	}	
}
