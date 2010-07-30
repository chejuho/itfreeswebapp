package housesell.bean;

import common.bean.Bean;
import common.handler.UtilHandler;
import common.util.Util;

public class HouseBean extends Bean {
	private String title = "";
	private String house_name = "";
	private String detail_info = "";
	private String manage_fee = "";
	private String house_sort="";
	private String[] house_sort_checked={"","","","","","","","",""};
	private String[] dimension = {"",""};
	private String[] house_fee = {"",""};
	private String deposit = "";
	private String reikin = "";
	private String walk_time = "";
	private String build_year = "";
	private String[] madori_checked={"","","","","","","","","","","",""};
	private String madori="";
	private String all_stairs = "";
	private String stairs = "";
	private String flg_tadami = "";
	private String[] toilet_checked = {"","","",""};
	private String toilet = "";
	private String area_fast = "";
	private String main_area = "";
	private String point_compass = "";
	private String come_dock = "";
	private String come_dock_name = "";
	private String come_dock_year = "";
	private String come_dock_month = "";
	private String build_month = "";
	private String guaranty_money = "";
	private String[] house_option={"","",""};
	private String house_option_name="";
	private String madori_info = "";
	
	//’Ç‰Á
	private String detail_url = "";
	private String company_name = "";
	private String license_no = "";
	private String company_address = "";
	private String company_telno = "";
	private String info_site = "";
	
	public String getInfo_site() {
		return info_site;
	}
	public void setInfo_site(String infoSite) {
		info_site = infoSite;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String companyName) {
		company_name = companyName;
	}
	public String getLicense_no() {
		return license_no;
	}
	public void setLicense_no(String licenseNo) {
		license_no = licenseNo;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String companyAddress) {
		company_address = companyAddress;
	}
	public String getCompany_telno() {
		return company_telno;
	}
	public void setCompany_telno(String companyTelno) {
		company_telno = companyTelno;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detailurl) {
		detail_url = detailurl;
	}
	
	
	
	public String getAll_stairs() {
		return all_stairs;
	}
	public void setAll_stairs(String all_stairs) {
		this.all_stairs = all_stairs;
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
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String[] getDimension() {
		return dimension;
	}
	public String getDimension_selected(String index) {
		if (dimension.equals(index)) {
			return " checked ";
		} else {
			return "";
		}			
	}
	public String getDimension1Tag() {
		return UtilHandler.getDimension1Tag(dimension[0]);
	}
	public String getDimension2Tag() {
		return UtilHandler.getDimension2Tag(dimension[0],dimension[1]);
	}
	public void setDimension(String[] dimension) {
		this.dimension = dimension;
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
	public String getHouse_fee1Tag() {		
		return UtilHandler.getHouseFee1Tag(house_fee[0]);
	}
	public String getHouse_fee2Tag() {		
		return UtilHandler.getHouseFee2Tag(house_fee[0], house_fee[1]);
	}
	public String[] getHouse_fee() {
		return house_fee;
	}
	public void setHouse_fee(String[] house_fee) {
		this.house_fee = house_fee;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getHouse_option_checked(int index) {
		
		if(!Util.isEmpty(house_option[index]) && "1".equals(house_option[index])){
			return " checked ";
		} else {
			return "";
		}		
	}
	public String[] getHouse_option() {
		return house_option;
	}
	public void setHouse_option(String[] house_option) {
		this.house_option = house_option;
	}
	public String getHouse_sort() {
		return house_sort;
	}
	public String getHouse_sort_checked(int index) {
		
		return house_sort_checked[index];	
	}
	public String getMadori() {
		return madori;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
			mainAreaArray[0] = " checked ";
		} else if ("2".equals(main_area)) {
			mainAreaArray[1] = " checked ";
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
	public void setToilet(String toilet) {
		if("0".equals(toilet)){
			this.toilet_checked[0] = " checked ";
		} else if ("1".equals(toilet)){
			this.toilet_checked[1] = " checked ";
		} else if ("2".equals(toilet)){	
			this.toilet_checked[2] = " checked ";
		} else if ("3".equals(toilet)){		
			this.toilet_checked[3] = " checked ";
		}
		this.toilet = toilet;
	}
	public String getToilet_checked(int index) {
		return toilet_checked[index];
	}
	public String getToilet() {
		return toilet;
	}
	public void setHouse_sort(String house_sort) {
		if("0".equals(house_sort)){
			this.house_sort_checked[0] = " checked ";
		} else if ("1".equals(house_sort)){
			this.house_sort_checked[1] = " checked ";
		} else if ("2".equals(house_sort)){	
			this.house_sort_checked[2] = " checked ";
		} else if ("3".equals(house_sort)){		
			this.house_sort_checked[3] = " checked ";
		} else if ("4".equals(house_sort)){
			this.house_sort_checked[4] = " checked ";
		} else if ("5".equals(house_sort)){	
			this.house_sort_checked[5] = " checked ";
		} else if ("6".equals(house_sort)){		
			this.house_sort_checked[6] = " checked ";		
		} else if ("7".equals(house_sort)){		
			this.house_sort_checked[7] = " checked ";				
		}		
		this.house_sort = house_sort;
	}

	public void setMadori(String madori) {
		if("0".equals(madori)){
			this.madori_checked[0] = " checked ";
		} else if ("1".equals(madori)){
			this.madori_checked[1] = " checked ";
		} else if ("2".equals(madori)){	
			this.madori_checked[2] = " checked ";
		} else if ("3".equals(madori)){		
			this.madori_checked[3] = " checked ";
		} else if ("4".equals(madori)){
			this.madori_checked[4] = " checked ";
		} else if ("5".equals(madori)){	
			this.madori_checked[5] = " checked ";
		} else if ("6".equals(madori)){		
			this.madori_checked[6] = " checked ";		
		} else if ("7".equals(madori)){		
			this.madori_checked[7] = " checked ";	
		} else if ("8".equals(madori)){		
			this.madori_checked[8] = " checked ";
		} else if ("9".equals(madori)){
			this.madori_checked[9] = " checked ";
		} else if ("10".equals(madori)){	
			this.madori_checked[10] = " checked ";
		} else if ("11".equals(madori)){		
			this.madori_checked[11] = " checked ";		
		}		
		this.madori = madori;		
	}	
	
	public String getMadori_checked(int index) {
	
		return madori_checked[index];
	}		
}
