package common.bean;

import java.util.SortedMap;

import common.exception.AppException;
import common.exception.SysException;
import common.handler.UtilHandler;


public class SearchBean {
	private String all_search="";
	private String all_search_decoded="";
	private String all_search_range="";
	private String all_search_range1="";
	private String all_search_range2="";
	private String all_search_range3="";
	private String all_search_range4="";
	private String all_search_range5="";
	private String all_search_range6="";
	private String all_search_range7="";
	private String all_search_range8="";
	private String cate_code_1 = "";
	private String cate_code_2 = "";
	private String pageSize = "";
	private String pageNum = "";
	private String area_code_1 = "";
	private String area_code_2 = "";
	private String line_code = "";
	private String station_code = "";
	private SortedMap areaMap1 = null;
	private SortedMap areaMap2 = null;
	private SortedMap lineMap = null;
	private SortedMap stationMap = null;
	public String getArea_1Tag() throws SysException {
		return UtilHandler.getArea1TagFromMap(area_code_1, areaMap1);
	}
	public String getArea_2Tag() throws SysException {
		return UtilHandler.getArea2TagFromMap(area_code_1, area_code_2, areaMap2);
	}
	public String getLineTag() throws AppException {
		return UtilHandler.getTrainLineTagFromMap(line_code, lineMap);
	}
	public String getStationTag() throws AppException {
		return UtilHandler.getStationTagFromMap(line_code, station_code, stationMap);
	}
	/** ユーザ判別サイン 追加 
	 *  "0" : ユーザではない
	 *  "1" : ユーザ
	 * */
	private String userFlag = "";
	
	public String getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}
	
	
	public String getAll_search() {
		return all_search;
	}
	public void setAll_search(String all_search) {
		this.all_search = all_search;
	}
	public String getAll_search_range1_selected() {
		return all_search_range1;
	}
	public String getAll_search_range2_selected() {
		return all_search_range2;
	}
	public String getAll_search_range3_selected() {
		return all_search_range3;
	}
	public String getAll_search_range4_selected() {
		return all_search_range4;
	}
	public String getAll_search_range5_selected() {
		return all_search_range5;
	}
	public String getAll_search_range6_selected() {
		return all_search_range6;
	}
	public String getAll_search_range7_selected() {
		return all_search_range7;
	}
	public String getAll_search_range8_selected() {
		return all_search_range8;
	}
	
	public String getAll_search_range() {
		return all_search_range;
	}
	public void setAll_search_range(String all_search_range) {
		if("1".equals(all_search_range)){
			all_search_range1 = " selected ";
		} else if("2".equals(all_search_range)){
			all_search_range2 = " selected ";
		} else if("3".equals(all_search_range)){
			all_search_range3 = " selected ";
		} else if("4".equals(all_search_range)){
			all_search_range4 = " selected ";
		} else if("5".equals(all_search_range)){
			all_search_range5 = " selected ";
		} else if("6".equals(all_search_range)){
			all_search_range6 = " selected ";
		} else if("7".equals(all_search_range)){
			all_search_range7 = " selected ";
		} else if("8".equals(all_search_range)){
			all_search_range8 = " selected ";
		} 		
		this.all_search_range = all_search_range;
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
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
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
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
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
	public String getAll_search_decoded() {
		return all_search_decoded;
	}
	public void setAll_search_decoded(String all_search_decoded) {
		this.all_search_decoded = all_search_decoded;
	}
}
