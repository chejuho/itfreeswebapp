package housesell.bean;

import common.bean.SearchBean;
import common.handler.UtilHandler;
import common.util.Util;


public class HouseSearchBean extends SearchBean {
	private String manage_fee = "";
	private String[] house_sort={"","","","","","","","",""};
	private String[] dimension = {"",""};
	private String[] house_fee = {"",""};
	private String deposit = "";
	private String reikin = "";
	private String walk_time = "";
	private String build_year = "";
	
	private String[] madori= {"","","","","","","","","","","",""};
	private String all_stairs = "";
	private String stairs = "";
	private String flg_tadami = "";
	
	private String toilet = "";
	private String[] toilet_checked = {"", ""};
	private String area_code_3 = "";
	private String area_fast = "";
	private String main_area = "";
	private String point_compass = "";
	private String come_dock = "";
	private String come_dock_name = "";
	private String come_dock_year = "";
	private String come_dock_month = "";
	private String build_month = "";
	private String guaranty_money = "";
	private String[] house_option={"","","",""};	
	private String house_option_name="";
	private String madori_info = "";
	private String user_id = "";
	private String regist_date = "";
	private String update_date = "";
	private String read_count = "";
	private String before  = "";
	public String getDimension1Tag() {
		return UtilHandler.getDimension1Tag(dimension[0]);
	}
	public String getDimension2Tag() {
		return UtilHandler.getDimension2Tag(dimension[0],dimension[1]);
	}	
	public String getHouse_fee1Tag() {		
		return UtilHandler.getHouseFee1Tag(house_fee[0]);
	}
	public String getHouse_fee2Tag() {		
		return UtilHandler.getHouseFee2Tag(house_fee[0], house_fee[1]);
	}	
	public String getAll_stairs() {
		return all_stairs;
	}
	public void setAll_stairs(String all_stairs) {
		this.all_stairs = all_stairs;
	}
	public String getArea_code_3() {
		return area_code_3;
	}
	public void setArea_code_3(String area_code_3) {
		this.area_code_3 = area_code_3;
	}
	public String getArea_fast() {
		return area_fast;
	}
	public void setArea_fast(String area_fast) {
		this.area_fast = area_fast;
	}
	public String getBuild_month() {
		return build_month;
	}
	public void setBuild_month(String build_month) {
		this.build_month = build_month;
	}
	public String getBuild_year() {
		return build_year;
	}
	public String getBuild_year_checked(String index) {
		if (build_year.equals(index)) {
			return " checked ";
		} else {
			return "";
		}	
	}
	public void setBuild_year(String build_year) {
		this.build_year = build_year;
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
	public String getCome_dock_year() {
		return come_dock_year;
	}
	public void setCome_dock_year(String come_dock_year) {
		this.come_dock_year = come_dock_year;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getFlg_tadami() {
		return flg_tadami;
	}
	public String getFlg_tadami_checked(String index) {
		if (flg_tadami.equals(index)) {
			return " checked ";
		} else {
			return "";
		}			
	}

	public void setFlg_tadami(String flg_tadami) {
		this.flg_tadami = flg_tadami;
	}
	public String getGuaranty_money() {
		return guaranty_money;
	}
	public void setGuaranty_money(String guaranty_money) {
		this.guaranty_money = guaranty_money;
	}
	public String getHouse_option_checked(int index) {
		
		if(!Util.isEmpty(house_option[index]) && "1".equals(house_option[index])){
			return " checked ";
		} else {
			return "";
		}		
	}
/*	public String[] getHouse_option() {
		return house_option;
	}
	public void setHouse_option(String[] house_option) {
		this.house_option = house_option;
	}*/
	
	public String getHouse_sort(int index) {
		
		return house_sort[index];	
	}
	public void setHouse_sort(int index, String house_sort) {
		this.house_sort[index] = house_sort;		
	}	
	public String getHouse_sort_checked(int index) {
		if(!Util.isEmpty(house_sort[index]) && String.valueOf(index).equals(house_sort[index])){
			return " checked ";
		} else {
			return "";
		}	
			
	}	
	public String getHouse_option(int index) {
		
		return house_option[index];	
	}	
	public void setDimension(int index, String dimension) {
		this.dimension[index] = dimension;		
	}	
	public String getDimension(int index) {
		
		return dimension[index];	
	}	
	public void setMadori(int index, String madori) {
		this.madori[index] = madori;		
	}	
	public String getMadori(int index) {
		
		return madori[index];	
	}	
	public void setHouse_fee(int index, String house_fee) {
		this.house_fee[index] = house_fee;		
	}	
	public String getHouse_fee(int index) {
		
		return house_fee[index];	
	}
	public void setHouse_option(int index, String house_option) {
		this.house_option[index] = house_option;	
	}
	public void setToilet(String toilet) {
		if("0".equals(toilet)){
			this.toilet_checked[0] = "1";
		} else if ("1".equals(toilet)){
			this.toilet_checked[1] = "1";
		}		
		this.toilet = toilet;
	}	
	public String getToilet_checked(int index) {
		
		if(!Util.isEmpty(toilet_checked[index]) && "1".equals(toilet_checked[index])){
			return " checked ";
		} else {
			return "";
		}		
	}	
	public String getToilet() {
		return toilet;	
	}	
	public String getMadori_checked(int index) {
		if(Util.isEmpty(madori[index])){
			return "";
		} else {
			return " checked ";
		}			
	}

	public String getMadori_info() {
		return madori_info;
	}
	public void setMadori_info(String madori_info) {
		this.madori_info = madori_info;
	}
	public String getMain_area() {
		return main_area;
	}
	public void setMain_area(String main_area) {
		this.main_area = main_area;
	}
	public String getManage_fee() {
		return manage_fee;
	}
	public void setManage_fee(String manage_fee) {
		this.manage_fee = manage_fee;
	}
	public String getPoint_compass() {
		return point_compass;
	}
	public void setPoint_compass(String point_compass) {
		this.point_compass = point_compass;
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
	public String getRegist_date_selected(String index) {
		if (regist_date.equals(index)) {
			return " checked ";
		} else {
			return "";
		}
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public String getReikin() {
		return reikin;
	}
	public void setReikin(String reikin) {
		this.reikin = reikin;
	}
	public String getStairs() {
		return stairs;
	}
	public String getStairs_selected(String index) {
		if (stairs.equals(index)) {
			return " selected ";
		} else {
			return "";
		}		
	}	
	public void setStairs(String stairs) {
		this.stairs = stairs;
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
	public String getWalk_time_checked(String index) {
		if (walk_time.equals(index)) {
			return " checked ";
		} else {
			return "";
		}			
	}
	public void setWalk_time(String walk_time) {
		this.walk_time = walk_time;
	}
	
	public String getCome_dock_disabled() {

		if ("1".equals(come_dock)) {
			return "";
		} else {
			return " disabled ";
		}		
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

	public String[] getFlgTadamiChecked() {
		String[] flgTadamiArray = {"","",""};		
		if("0".equals(flg_tadami)){
			flgTadamiArray[0]=" checked ";
		} else if ("1".equals(flg_tadami)) {
			flgTadamiArray[1]=" checked ";
		} else if ("2".equals(flg_tadami)) {
			flgTadamiArray[2]=" checked ";			
		} 		
		return flgTadamiArray;
	}
	
	public String[] getHouseSortChecked() {
		String[] house_sortArray = {"","","","","","","",""};		
		if("0".equals(house_sort)){
			house_sortArray[0]=" checked ";
		} else if ("1".equals(house_sort)) {
			house_sortArray[1]=" checked ";
		} else if ("2".equals(house_sort)) {
			house_sortArray[2]=" checked ";
		} else if ("3".equals(house_sort)) {
			house_sortArray[3]=" checked ";
		} else if ("4".equals(house_sort)) {
			house_sortArray[4]=" checked ";
		} else if ("5".equals(house_sort)) {
			house_sortArray[5]=" checked ";
		} else if ("6".equals(house_sort)) {
			house_sortArray[6]=" checked ";
		} else if ("7".equals(house_sort)) {
			house_sortArray[7]=" checked ";
		}
		
		return house_sortArray;
	}

	public String[] getMadoriChecked() {
		String[] madoriArray = {"","","","","","","","","","","",""};		
		if("0".equals(madori)){
			madoriArray[0]=" checked ";
		} else if ("1".equals(madori)) {
			madoriArray[1]=" checked ";
		} else if ("2".equals(madori)) {
			madoriArray[2]=" checked ";
		} else if ("3".equals(madori)) {
			madoriArray[3]=" checked ";
		} else if ("4".equals(madori)) {
			madoriArray[4]=" checked ";
		} else if ("5".equals(madori)) {
			madoriArray[5]=" checked ";
		} else if ("6".equals(madori)) {
			madoriArray[6]=" checked ";
		} else if ("7".equals(madori)) {
			madoriArray[7]=" checked ";
		} else if ("8".equals(madori)) {
			madoriArray[7]=" checked ";
		} else if ("9".equals(madori)) {
			madoriArray[9]=" checked ";
		} else if ("10".equals(madori)) {
			madoriArray[10]=" checked ";
		} else if ("11".equals(madori)) {
			madoriArray[11]=" checked ";
		}
		
		return madoriArray;
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


	public String[] getPoint_compass_selected() {
		String[] point_compassArray = {"","","","",""};
		if ("0".equals(point_compass)) {
			point_compassArray[0]="selected";
		} else if ("1".equals(point_compass)) {
			point_compassArray[1]="selected";
		} else if ("2".equals(point_compass)) {
			point_compassArray[2]="selected";
		} else if ("3".equals(point_compass)) {
			point_compassArray[3]="selected";
		} else if ("4".equals(point_compass)) {
			point_compassArray[4]="selected";
		}
		return point_compassArray;
	}
	public String getHouse_option_name() {
		return house_option_name;
	}
	public void setHouse_option_name(String house_option_name) {
		this.house_option_name = house_option_name;
	}
	public String getCome_dock_name() {
		return come_dock_name;
	}
	public void setCome_dock_name(String come_dock_name) {
		this.come_dock_name = come_dock_name;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}

}
