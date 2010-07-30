package buysell.bean;

import common.bean.Bean;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.util.Util;


public class BuySellBean extends Bean{
	private String title = "";
	private String price = "";
	private String price_unit = "";
	private String free_price = "";
	private String pro_status = "";
	private String pro_status_no_matter = "";
	private String pro_status_used = "";
	private String pro_status_almonew = "";
	private String pro_status_new = "";
	private String sell_place = "";
	private String member_sort = "";	
	private String member_ama = "";
	private String member_pro = "";
	private String member_no_matter = "";
	private String detail_info = "";
	private String regist_date = "";
	private String read_count = "";
	private String send_method="";
	private String send_direct="";
	private String send_post="";
	private String send_no_matter="";
	public String getCate_1Tag() throws SysException {
		
		return UtilHandler.getCate1Tag(super.getCate_code_1(), "t_buysell_category");
	}
	public String getCate_2Tag() throws SysException {
		
		return UtilHandler.getCate2Tag(super.getCate_code_1(), super.getCate_code_2(), "t_buysell_category");
	}
	public String getDetail_info() {
		return detail_info;
	}
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}
	public String getPrice() {
		if("1".equals(free_price)){
			return "";
		}
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
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
	public String getSell_place() {
		return sell_place;
	}
	public void setSell_place(String sell_place) {
		this.sell_place = sell_place;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getPrice_unit_Selected() {
		String[] priceUnitArray = {"",""};
		if ("".equals(price_unit) || "0".equals(price_unit)) {
			priceUnitArray[0]="selected";
		} else if ("1".equals(price_unit)) {
			priceUnitArray[1]="selected";
		} 
		return priceUnitArray;
	}
	public String getSend_method() {
		return send_method;
	}
	public void setSend_method(String send_method) {
		if (Util.isEmpty(send_method) || "0".equals(send_method)) {
			send_no_matter = "selected";
		} else if ("1".equals(send_method)){
			send_direct = "selected";
		} else if ("2".equals(send_method)){
			send_post = "selected";	
		}	
		this.send_method = send_method;
	}
	public String getPro_status() {
		return pro_status;
	}
	public void setPro_status(String pro_status) {
		if ("".equals(pro_status) || "0".equals(pro_status)) {
			pro_status_no_matter = "selected";
		} else if ("1".equals(pro_status)) {
			pro_status_used = "selected";
		} else if ("2".equals(pro_status)) {
			pro_status_almonew = "selected";	
		} else if ("3".equals(pro_status)) {
			pro_status_new = "selected";					
		} 		
		this.pro_status = pro_status;
	}
	public String getPro_status_almonew() {
		return pro_status_almonew;
	}
	public void setPro_status_almonew(String pro_status_almonew) {
		this.pro_status_almonew = pro_status_almonew;
	}
	public String getPro_status_new() {
		return pro_status_new;
	}
	public void setPro_status_new(String pro_status_new) {
		this.pro_status_new = pro_status_new;
	}
	public String getPro_status_used() {
		return pro_status_used;
	}
	public void setPro_status_used(String pro_status_used) {
		this.pro_status_used = pro_status_used;
	}
	public String getPro_status_no_matter() {
		return pro_status_no_matter;
	}
	public void setPro_status_no_matter(String pro_status_no_matter) {
		this.pro_status_no_matter = pro_status_no_matter;
	}
	public String getSend_direct() {
		return send_direct;
	}
	public void setSend_direct(String send_direct) {
		this.send_direct = send_direct;
	}
	public String getSend_no_matter() {
		return send_no_matter;
	}
	public void setSend_no_matter(String send_no_matter) {
		this.send_no_matter = send_no_matter;
	}
	public String getSend_post() {
		return send_post;
	}
	public void setSend_post(String send_post) {
		this.send_post = send_post;
	}
	public String getFree_price() {
		return free_price;
	}
	public void setFree_price(String free_price) {
		this.free_price = free_price;
	}
	public String getMember_sort() {
		return member_sort;
	}
	public void setMember_sort(String member_sort) {
		if ("0".equals(member_sort)) {
			member_no_matter = "selected";
		} else if ("1".equals(member_sort)) {
			member_ama = "selected";
		} else if ("2".equals(member_sort)) {
			member_pro = "selected";
		}	
		this.member_sort = member_sort;
	}
	public String getMember_ama() {
		return member_ama;
	}
	public void setMember_ama(String member_ama) {
		this.member_ama = member_ama;
	}
	public String getMember_no_matter() {
		return member_no_matter;
	}
	public String getMember_pro() {
		return member_pro;
	}
	public void setMember_pro(String member_pro) {
		this.member_pro = member_pro;
	}
}
