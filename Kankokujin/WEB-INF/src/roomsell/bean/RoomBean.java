package roomsell.bean;

import common.bean.Bean;
import common.util.Util;

public class RoomBean extends Bean{
	
	private String pageSize  = "";
	private String manage_fee = "";
	private String title = "";
	private String room_name = "";
	private String detail_info = "";		
	private String room_fee = "";
	private String[] dimension = {"",""};
	private String fee_unit = "";
	private String equipment_fee = "";
	private String deposit_fee = "";
	private String entrance_fee = "";
	private String area_fast = "";	
	private String main_area = "";	
	private String walk_time = "";
	private String sex = "";
	private String url = "";
	private String room_type = "";
	private String room_sort = "";
	private String[] room_mate_type = {"",""};
	private String come_dock = "";
	private String come_dock_name = "";
	private String come_dock_year = "";
	private String come_dock_month = "";
	private String come_dock_day = "";
	private String build_sort = "";
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getArea_fast() {
		return area_fast;
	}

	public void setArea_fast(String area_fast) {
		this.area_fast = area_fast;
	}

	public String getCome_dock() {
		return come_dock;
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

	public String getCome_dock_name() {
		return come_dock_name;
	}

	public void setCome_dock_name(String come_dock_name) {
		this.come_dock_name = come_dock_name;
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

	public String getMain_area() {
		return main_area;
	}

	public void setMain_area(String main_area) {
		this.main_area = main_area;
	}

	public String[] getRoom_mate_type() {
		return room_mate_type;
	}

	public void setRoom_mate_type(String[] room_mate_type) {
		this.room_mate_type = room_mate_type;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_sort() {
		return room_sort;
	}

	public void setRoom_sort(String room_sort) {
		this.room_sort = room_sort;
	}
	public String getRoom_type_checked(String index) {
		if(index.equals(room_type)){
			return " checked";
		} else {
			return "";
		}
	}

	public String getSex_checked(String index) {
		if(!Util.isEmpty(index) && index.equals(sex)){
			return " checked ";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWalk_time() {
		return walk_time;
	}

	public void setWalk_time(String walk_time) {
		this.walk_time = walk_time;
	}

	public String[] getMain_area_checked() {
		String[] mainAreaArray = {"","","",""};
		if ("1".equals(main_area)) {
			mainAreaArray[0] = " checked";
		} else if ("2".equals(main_area)) {
			mainAreaArray[1] = " checked";
		}
		return mainAreaArray;
	}
	public String[] getMain_area_disabled() {
		String[] mainAreaArray = {"","","",""};
		if ("1".equals(main_area)) {
			mainAreaArray[0] = " disabled=true ";
		} else if ("2".equals(main_area)) {
			mainAreaArray[1] = " disabled=true ";
		}
		return mainAreaArray;
	}
	public String[] getAreaFast_Selected() {
		String[] areaFastArray = {"","","",""};
		if ("".equals(area_fast)) {
			areaFastArray[0]="selected";
		} else if ("okubo_area".equals(area_fast)) {
			areaFastArray[1]="selected";
		} else if ("nakano_area".equals(area_fast)) {
			areaFastArray[2]="selected";
		} else if ("nippori_area".equals(area_fast)) {
			areaFastArray[3]="selected";
		}
		return areaFastArray;
	}	
	public String getCome_dock_day() {
		return come_dock_day;
	}

	public void setCome_dock_day(String come_dock_day) {
		this.come_dock_day = come_dock_day;
	}	
	public String getCome_dockChecked(int index) {
		
		if("1".equals(come_dock) && index == 1){
			return " checked ";
		} else if("0".equals(come_dock) && index == 0){
			return " checked ";
		} else {
			return "";
		}
	}	
	public String getCome_dock_disabled() {

		if ("1".equals(come_dock)) {
			return "";
		} else {
			return " disabled ";
		}		
	}
	public String getRoom_sort_checked(String index) {
		
		if(index.equals(room_sort)){
			return " checked";
		} else {
			return "";
		}		
	}

	public String getManage_fee() {
		return manage_fee;
	}

	public void setManage_fee(String manage_fee) {
		this.manage_fee = manage_fee;
	}

	public String[] getDimension() {
		return dimension;
	}

	public void setDimension(String[] dimension) {
		this.dimension = dimension;
	}

	public String getDeposit_fee() {
		return deposit_fee;
	}

	public void setDeposit_fee(String deposit_fee) {
		this.deposit_fee = deposit_fee;
	}

	public String getRoom_fee() {
		return room_fee;
	}

	public void setRoom_fee(String room_fee) {
		this.room_fee = room_fee;
	}

	public void setFee_unit(String fee_unit) {
		this.fee_unit = fee_unit;
	}

	public String getFee_unit() {
		return fee_unit;
	}
	public String getFee_unit_checked(String input) {
		if(!Util.isEmpty(input) && input.equals(fee_unit)){
			return " checked ";
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

	public String getBuild_sort() {
		return build_sort;
	}
	public String getBuild_sort_checked(String index) {
		if(index.equals(build_sort)){
			return " checked ";
		} else {
			return "";
		}
	}	
	public void setBuild_sort(String build_sort) {
		this.build_sort = build_sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
