package common.bean;

import java.sql.Timestamp;
import java.util.SortedMap;

import common.constant.Const;
import common.exception.AppException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.Util;

public class Bean {

	private Timestamp update_date = null;
	private String id = "";
	private String user_id = "";
	private String tel_no1_1 = "";
	private String tel_no1_2 = "";
	private String tel_no1_3 = "";	
	private String tel_no2_1 = "";
	private String tel_no2_2 = "";
	private String tel_no2_3 = "";	
	private String fax_no_1 = "";
	private String fax_no_2 = "";
	private String fax_no_3 = "";
	private String email="";
	private String photo_name1 = "";
	private String photo_name2 = "";
	private String photo_name3 = "";
	private String photo_name4 = "";
	private String photo_name5 = "";
	private String area_name_1 = "";
	private String area_name_2 = "";
	private String area_code_1 = "";
	private String area_code_2 = "";	
	private String area_code_3 = "";
	private String line_code = "";
	private String station_code = "";
	private String line_name= "";
	private String station_name = "";
	private String cate_code_1 = "";
	private String cate_code_2 = "";
	private String cate_name_1 = "";
	private String cate_name_2 = "";	
	private String page_size="";
	private String user_name="";	
	private String read_count = "";
	private SortedMap areaMap1 = null;
	private SortedMap areaMap2 = null;
	private SortedMap lineMap = null;
	private SortedMap stationMap = null;
	private SortedMap category1Map = null;
	private SortedMap category2Map = null;
	private String deleteflg = "";
	
	public String getCate_1Tag() throws SysException {
		return UtilHandler.getCate1TagFromMap(cate_code_1, category1Map);
	}
	public String getCate_2Tag() throws SysException {
		return UtilHandler.getCate2TagFromMap(cate_code_1, cate_code_2, category2Map);
	}
	public String getDeleteflg() {
		return deleteflg;
	}
	public void setDeleteflg(String deleteflg) {
		this.deleteflg = deleteflg;
	}
	/** 修正箇所　End**/
	

	public String getLineTag() throws AppException {
		return  UtilHandler.getTrainLineTagFromMap(line_code, lineMap);
	}
	public String getStationTag() throws AppException {
		return UtilHandler.getStationTagFromMap(line_code, station_code, stationMap);
		
	}
	public String getArea_1Tag() throws SysException {
		return UtilHandler.getArea1TagFromMap(area_code_1, areaMap1);
		
	}
	public String getArea_2Tag() throws SysException {
		return UtilHandler.getArea2TagFromMap(area_code_1, area_code_2, areaMap2);
	}
	
	public Timestamp getUpdate_dateTime() {
		return update_date;
	}
	public String getUpdate_date() {
		return Util.getUpdateDate(update_date);
	}	
	public String getUpdateDateFull() {
		return Util.getUpdateDateFull(update_date);
	}	

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
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
	public String getArea_code_3() {
		return area_code_3;
	}
	public void setArea_code_3(String area_code_3) {
		this.area_code_3 = area_code_3;
	}
	public String getCate_code_1() {
		return cate_code_1;
	}
	public void setCate_code_1(String cate_code_1) {
		this.cate_code_1 = cate_code_1;
	}
	public String getCate_code_2() {
		return cate_code_2;
	}
	public void setCate_code_2(String cate_code_2) {
		this.cate_code_2 = cate_code_2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax_no_1() {
		return fax_no_1;
	}
	public void setFax_no_1(String fax_no_1) {
		this.fax_no_1 = fax_no_1;
	}
	public String getFax_no_2() {
		return fax_no_2;
	}
	public void setFax_no_2(String fax_no_2) {
		this.fax_no_2 = fax_no_2;
	}
	public String getFax_no_3() {
		return fax_no_3;
	}
	public void setFax_no_3(String fax_no_3) {
		this.fax_no_3 = fax_no_3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public String getLine_name() {
		return line_name;
	}
	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}
	public String getLineInfo() {
		if(!Util.isEmpty(line_name) && !Util.isEmpty(station_name)){
			return line_name + " / " + station_name;
		}
		return "";
	}
	public String getPage_size() {
		return page_size;
	}
	public void setPage_size(String page_size) {
		this.page_size = page_size;
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
	public String getRead_count() {
		return read_count;
	}
	public void setRead_count(String read_count) {
		this.read_count = read_count;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getThumbNail_path() {
		if(!Util.isEmpty(photo_name1) && !"XXXXX".equals(photo_name1)){
			return Const.IMAGE_FOLDER_PATH+ "S_" + photo_name1;
		}else{
			return "jsp/images/new/noimage_small.gif";
		}
	}
	public String getPhoto_path1() {
		if(!Util.isEmpty(photo_name1) && !"XXXXX".equals(photo_name1)){
			return Const.IMAGE_FOLDER_PATH+ "M_" + photo_name1;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	public String getPhoto_path2() {
		if(!Util.isEmpty(photo_name2) && !"XXXXX".equals(photo_name2)){
			return Const.IMAGE_FOLDER_PATH+"M_" + photo_name2;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	public String getPhoto_path3() {
		if(!Util.isEmpty(photo_name3) && !"XXXXX".equals(photo_name3)){
			return Const.IMAGE_FOLDER_PATH+"M_" + photo_name3;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	public String getPhoto_path4() {
		if(!Util.isEmpty(photo_name4) && !"XXXXX".equals(photo_name4)){
			return Const.IMAGE_FOLDER_PATH+"M_" + photo_name4;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	public String getPhoto_path5() {
		if(!Util.isEmpty(photo_name5) && !"XXXXX".equals(photo_name5)){
			return Const.IMAGE_FOLDER_PATH+"M_" + photo_name5;
		}else{
			return "jsp/images/common/no_image.gif";
		}
	}
	private String getFName(String no1, String no2, String no3) {
		if (!Util.isEmpty(no1) && !Util.isEmpty(no2)&& !Util.isEmpty(no3)){
			return no1 + "-" + no2 + "-" + no3;
		} else {
			return "";
		}
	}	
	public String getTel_no1_fname() {
		return getFName(tel_no1_1, tel_no1_2, tel_no1_3);
	}
	public String getTel_no2_fname() {
		return getFName(tel_no2_1, tel_no2_2, tel_no2_3);
	}
	public String getFax_no_fname() {
		return getFName(fax_no_1, fax_no_2, fax_no_3);
	}
	public String getArea_name_1() {
		if("東京都23区".equals(area_name_1)){
			area_name_1 = area_name_1.substring(0,3);
		} else if("東京都市部".equals(area_name_1)){
			area_name_1 = area_name_1.substring(0,3);
		}
		return area_name_1;
	}
	public void setArea_name_1(String area_name_1) {
		this.area_name_1 = area_name_1;
	}
	public String getArea_name_2() {
		return area_name_2;
	}
	public void setArea_name_2(String area_name_2) {
		this.area_name_2 = area_name_2;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getCate_name_1() {
		return cate_name_1;
	}
	public void setCate_name_1(String cate_name_1) {
		this.cate_name_1 = cate_name_1;
	}
	public String getCate_name_2() {
		return cate_name_2;
	}
	public void setCate_name_2(String cate_name_2) {
		this.cate_name_2 = cate_name_2;
	}
	public SortedMap getAreaMap1() {
		return areaMap1;
	}
	public void setAreaMap1(SortedMap areaMap1) {
		this.areaMap1 = areaMap1;
	}
	public SortedMap getAreaMap2() {
		return areaMap2;
	}
	public void setAreaMap2(SortedMap areaMap2) {
		this.areaMap2 = areaMap2;
	}
	public SortedMap getLineMap() {
		return lineMap;
	}
	public void setLineMap(SortedMap lineMap) {
		this.lineMap = lineMap;
	}
	public SortedMap getStationMap() {
		return stationMap;
	}
	public void setStationMap(SortedMap stationMap) {
		this.stationMap = stationMap;
	}
	public SortedMap getCategory1Map() {
		return category1Map;
	}
	public void setCategory1Map(SortedMap category1Map) {
		this.category1Map = category1Map;
	}
	public SortedMap getCategory2Map() {
		return category2Map;
	}
	public void setCategory2Map(SortedMap category2Map) {
		this.category2Map = category2Map;
	}
}
