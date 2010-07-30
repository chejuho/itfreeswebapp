package roomsell.bean;

import common.bean.SearchBean;
import common.handler.UtilHandler;

public class RoomSearchBean extends SearchBean {
	private String room_fee_from = "";
	private String room_fee_to = "";
	private String[] room_sort = {"","","","","","","","","","",""};
	private String area_fast = "";
	private String sex;
	private String build_sort;
	private String room_type;
	private String regist_date = "";
	
	private String before = "";
	private String user_id = "";
	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHouse_fee1Tag() {		
		return UtilHandler.getHouseFee1Tag(room_fee_from);
	}
	public String getHouse_fee2Tag() {		
		return UtilHandler.getHouseFee2Tag(room_fee_from, room_fee_to);
	}	
	public String getRoom_fee1Tag() {		
		return UtilHandler.getRoomFee1Tag(room_fee_from);
	}
	public String getRoom_fee2Tag() {		
		return UtilHandler.getRoomFee2Tag(room_fee_from, room_fee_to);
	}		
	public String getRoom_fee_from() {
		return room_fee_from;
	}
	public void setRoom_fee_from(String room_fee_from) {
		this.room_fee_from = room_fee_from;
	}
	public String getRoom_fee_to() {
		return room_fee_to;
	}
	public void setRoom_fee_to(String room_fee_to) {
		this.room_fee_to = room_fee_to;
	}
	public String getArea_fast() {
		return area_fast;
	}
	public void setArea_fast(String area_fast) {
		this.area_fast = area_fast;
	}

	public String getRegist_date() {
		return regist_date;
	}
	public String getRegist_date_selected(String index) {
		if(index.equals(regist_date)){
			return " checked";
		} else {
			return "";
		}
	}	
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	

	public String getSex_checked(String index) {
		if(index.equals(sex)){
			return " checked";
		} else {
			return "";
		}
	}
	public String getBuild_sort() {
		return build_sort;
	}
	public String getBuild_sort_checked(String index) {
		if(index.equals(build_sort)){
			return " checked";
		} else {
			return "";
		}
	}	
	public void setBuild_sort(String build_sort) {
		this.build_sort = build_sort;
	}
	public String[] getRoom_sort() {
		return room_sort;
	}
	public void setRoom_sort(int index , String room_sort) {
		this.room_sort[index] = room_sort;
	}
	public String getRoom_sort_checked(String index) {
		//System.out.println("room_sort=" + room_sort + ", room_sort.length=" + room_sort.length);
		/*System.out.println("room_sort=" + room_sort);
		if (room_sort != null){
			System.out.println("room_sort.length=" + room_sort.length);
		}*/
		if(index.equals(room_sort[Integer.parseInt(index)])){
			return " checked";
		} else {
			return "";
		}
	}	
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_type_checked(String index) {
		if(index.equals(room_type)){
			return " checked";
		} else {
			return "";
		}
	}	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}	
}
