package bean;

import java.sql.Date;

public class RoomInfo {
	int id;
    String title = "";  
	String user_id = "";   
	String room_name = "";
	String email = "";
	String telephone = "";
	String detail_info = ""; 
	String room_fee = "";
	String fee_unit;
	String equipment_fee;
	String deposit_fee;
	String entrance_fee;
	int flgDomitory;
	int flgOneroom;
	int flgMansion;
	int flgRoomshare;
	int flgHomestay;
	int flgHighlevelDomi;
	int flgMonthlyMansion;
	int flgGuesthouse;
	int flgMinbak;
	int flgBusinessHotel;
	int flgHotel;
	String main_area = "";
	String region_3 = "";
	String line_code = "";
	String station_code = "";
	String time_from_station ="";
	String sex = "";
	String buil_sort = "";
	String room_type = "";
	String detailInfo = "";
	String photo_name1 = "";
	String photo_name2 = "";
	String photo_name3 = "";
	String photo_name4 = "";
	String photo_name5 = "";
	String region_1= "";
	String region_2= "";
	Date regist_date;
	Date update_date;
	int read_count;
	public String getBuil_sort() {
		return buil_sort;
	}
	public void setBuil_sort(String buil_sort) {
		this.buil_sort = buil_sort;
	}
	public String getDeposit_fee() {
		return deposit_fee;
	}
	public void setDeposit_fee(String deposit_fee) {
		this.deposit_fee = deposit_fee;
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEntrance_fee() {
		return entrance_fee;
	}
	public void setEntrance_fee(String entrance_fee) {
		this.entrance_fee = entrance_fee;
	}
	public String getEquipment_fee() {
		return equipment_fee;
	}
	public void setEquipment_fee(String equipment_fee) {
		this.equipment_fee = equipment_fee;
	}
	public String getFee_unit() {
		return fee_unit;
	}
	public void setFee_unit(String fee_unit) {
		this.fee_unit = fee_unit;
	}
	public int getFlgBusinessHotel() {
		return flgBusinessHotel;
	}
	public void setFlgBusinessHotel(int flgBusinessHotel) {
		this.flgBusinessHotel = flgBusinessHotel;
	}
	public int getFlgDomitory() {
		return flgDomitory;
	}
	public void setFlgDomitory(int flgDomitory) {
		this.flgDomitory = flgDomitory;
	}
	public int getFlgGuesthouse() {
		return flgGuesthouse;
	}
	public void setFlgGuesthouse(int flgGuesthouse) {
		this.flgGuesthouse = flgGuesthouse;
	}
	public int getFlgHighlevelDomi() {
		return flgHighlevelDomi;
	}
	public void setFlgHighlevelDomi(int flgHighlevelDomi) {
		this.flgHighlevelDomi = flgHighlevelDomi;
	}
	public int getFlgHomestay() {
		return flgHomestay;
	}
	public void setFlgHomestay(int flgHomestay) {
		this.flgHomestay = flgHomestay;
	}
	public int getFlgHotel() {
		return flgHotel;
	}
	public void setFlgHotel(int flgHotel) {
		this.flgHotel = flgHotel;
	}
	public int getFlgMansion() {
		return flgMansion;
	}
	public void setFlgMansion(int flgMansion) {
		this.flgMansion = flgMansion;
	}
	public int getFlgMinbak() {
		return flgMinbak;
	}
	public void setFlgMinbak(int flgMinbak) {
		this.flgMinbak = flgMinbak;
	}
	public int getFlgMonthlyMansion() {
		return flgMonthlyMansion;
	}
	public void setFlgMonthlyMansion(int flgMonthlyMansion) {
		this.flgMonthlyMansion = flgMonthlyMansion;
	}
	public int getFlgOneroom() {
		return flgOneroom;
	}
	public void setFlgOneroom(int flgOneroom) {
		this.flgOneroom = flgOneroom;
	}
	public int getFlgRoomshare() {
		return flgRoomshare;
	}
	public void setFlgRoomshare(int flgRoomshare) {
		this.flgRoomshare = flgRoomshare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMain_area() {
		return main_area;
	}
	public void setMain_area(String main_area) {
		this.main_area = main_area;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getRegion_1() {
		return region_1;
	}
	public void setRegion_1(String region_1) {
		this.region_1 = region_1;
	}
	public String getRegion_2() {
		return region_2;
	}
	public void setRegion_2(String region_2) {
		this.region_2 = region_2;
	}
	public String getRegion_3() {
		return region_3;
	}
	public void setRegion_3(String region_3) {
		this.region_3 = region_3;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public String getRoom_fee() {
		return room_fee;
	}
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public void setRoom_fee(String room_fee) {
		this.room_fee = room_fee;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getTime_from_station() {
		return time_from_station;
	}
	public void setTime_from_station(String time_from_station) {
		this.time_from_station = time_from_station;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPhoto_name1() {
		return photo_name1;
	}
	public void setPhoto_name1(String photo_name1) {
		this.photo_name1 = photo_name1;
	}
	public String getPhoto_name2() {
		return photo_name2;
	}
	public void setPhoto_name2(String photo_name2) {
		this.photo_name2 = photo_name2;
	}
	public String getPhoto_name3() {
		return photo_name3;
	}
	public void setPhoto_name3(String photo_name3) {
		this.photo_name3 = photo_name3;
	}
	public String getPhoto_name4() {
		return photo_name4;
	}
	public void setPhoto_name4(String photo_name4) {
		this.photo_name4 = photo_name4;
	}
	public String getPhoto_name5() {
		return photo_name5;
	}
	public void setPhoto_name5(String photo_name5) {
		this.photo_name5 = photo_name5;
	}
	
	
}
