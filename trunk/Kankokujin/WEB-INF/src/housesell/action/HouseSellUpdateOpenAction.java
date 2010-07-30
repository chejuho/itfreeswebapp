package housesell.action;

import housesell.bean.HouseBean;
import housesell.bean.HouseSearchBean;
import housesell.handler.HouseSellDetailHandler;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class HouseSellUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug(
					"HouseSellUpdateOpenAction.start");
			HouseBean houseBean = new HouseBean();
			houseBean.setId(request.getParameter("id"));
			HouseSearchBean houseSearchBean = new HouseSearchBean();
			SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
			SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
			SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
			SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
				
			houseSearchBean.setAreaMap1(area1InfoMap);
			houseSearchBean.setAreaMap2(area2InfoMap);
			houseSearchBean.setLineMap(lineInfoMap);
			houseSearchBean.setStationMap(stationInfoMap);
			houseBean.setAreaMap1(area1InfoMap);
			houseBean.setAreaMap2(area2InfoMap);
			houseBean.setLineMap(lineInfoMap);
			houseBean.setStationMap(stationInfoMap);
			// reload
			if (Util.isEmpty(houseBean.getId())) {
				setHouseBean(houseBean, houseSearchBean, request);
				// from detail
			} else {
				HouseSellDetailHandler houseSellDetailHandler = HouseSellDetailHandler.getInstance();
				houseBean = houseSellDetailHandler.getHouseBean(houseBean,false, false);
				setHouseSearchBean(houseSearchBean, request);
				
			}
			request.setAttribute("HouseBean", houseBean);
			request.setAttribute("HouseSearchBean", houseSearchBean);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HouseSellUpdateOpenAction", e);
		} finally {
			KankokujinLogger.getInstance().debug(
					"HouseSellUpdateOpenAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/housesell/houseSellUpdate.jsp")
				.forward(request, response);

	}
	private void setHouseBean(HouseBean houseBean, HouseSearchBean houseSearchBean, HttpServletRequest request) throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		houseBean.setId(Util.changeNullStr(multi
				.getParameter("id")));
		houseBean.setArea_code_1(Util.changeNullStr(multi
				.getParameter("area_code_1")));
		houseBean.setArea_code_2(Util.changeNullStr(multi
				.getParameter("area_code_2")));
		houseBean.setArea_code_3(Util.changeNullStr(multi
				.getParameter("area_code_3")));
		houseBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		houseBean.setLine_code(Util.changeNullStr(multi
				.getParameter("line_code")));
		houseBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));
		houseBean.setTitle(Util.changeNullStr(multi
				.getParameter("title")));
		houseBean.setHouse_name(Util.changeNullStr(multi
				.getParameter("house_name")));
		houseBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));
		houseBean.setEmail(Util.changeNullStr(multi
				.getParameter("email")));
		houseBean
				.setHouse_fee(new String[] {
						Util.changeNullStr(multi
								.getParameter("house_fee")), "" });
		houseBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));
		houseBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		houseBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		houseBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));
		houseBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		houseBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));						
		houseBean.setManage_fee(Util.changeNullStr(multi
				.getParameter("manage_fee")));
		houseBean
				.setDimension(new String[] {
						Util.changeNullStr(multi
								.getParameter("dimension")), "" });
		houseBean.setDeposit(Util.changeNullStr(multi
				.getParameter("deposit")));
		houseBean.setReikin(Util.changeNullStr(multi
				.getParameter("reikin")));
		houseBean.setBuild_year(Util.changeNullStr(multi
				.getParameter("build_year")));
		houseBean.setBuild_month(Util.changeNullStr(multi
				.getParameter("build_month")));
		houseBean.setAll_stairs(Util.changeNullStr(multi
				.getParameter("all_stairs")));
		houseBean.setStairs(Util.changeNullStr(multi
				.getParameter("stairs")));
		houseBean.setUser_id(Util.changeNullStr(multi
				.getParameter("user_id")));
		houseBean.setWalk_time(Util.changeNullStr(multi
				.getParameter("walk_time")));
		houseBean.setMadori_info(Util.changeNullStr(multi
				.getParameter("madori_info")));					
		houseBean.setToilet(multi.getParameter("toilet"));
		if (!Util.isEmpty(multi.getParameter("house_sort"))) {
			houseBean.setHouse_sort(multi.getParameter("house_sort"));
		}
		houseBean.setMadori(Util.changeNullStr(multi
				.getParameter("madori")));

		houseBean.setFlg_tadami(Util.changeNullStr(multi
				.getParameter("flg_tadami")));
		houseBean.setArea_fast(Util.changeNullStr(multi
				.getParameter("area_fast")));
		houseBean.setCome_dock(Util.changeNullStr(multi
				.getParameter("come_dock")));
		houseBean.setCome_dock_year(Util.changeNullStr(multi
				.getParameter("come_dock_year")));
		houseBean.setCome_dock_month(Util.changeNullStr(multi
				.getParameter("come_dock_month")));
		houseBean.setPoint_compass(Util.changeNullStr(multi
				.getParameter("point_compass")));
		houseBean.setGuaranty_money(Util.changeNullStr(multi
				.getParameter("guaranty_money")));
		String photo_name1 = Util.changePhotoPath(multi.getFilesystemName("photo_name1"));
		String photo_name2 = Util.changePhotoPath(multi.getFilesystemName("photo_name2"));
		String photo_name3 = Util.changePhotoPath(multi.getFilesystemName("photo_name3"));
		String photo_name4 = Util.changePhotoPath(multi.getFilesystemName("photo_name4"));
		String photo_name5 = Util.changePhotoPath(multi.getFilesystemName("photo_name5"));
		
		if(Util.isEmpty(photo_name1)){
			houseBean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			houseBean.setPhoto_name1(photo_name1);
		}
		if(Util.isEmpty(photo_name2)){
			houseBean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			houseBean.setPhoto_name2(photo_name2);
		}
		if(Util.isEmpty(photo_name3)){
			houseBean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			houseBean.setPhoto_name3(photo_name3);
		}
		if(Util.isEmpty(photo_name4)){
			houseBean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			houseBean.setPhoto_name4(photo_name4);
		}
		if(Util.isEmpty(photo_name5)){
			houseBean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			houseBean.setPhoto_name5(photo_name5);
		}

		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				houseBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				houseBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				houseBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				houseBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				houseBean.setPhoto_name5("");
			}
		}
		String[] house_option = { "", "", ""};
		if (!Util.isEmpty(multi.getParameter("option_0"))) {
			house_option[0] = changeStrOn(multi.getParameter("option_0"));
		}
		if (!Util.isEmpty(multi.getParameter("option_1"))) {
			house_option[1] = changeStrOn(multi.getParameter("option_1"));
		}
		if (!Util.isEmpty(multi.getParameter("option_2"))) {
			house_option[2] = changeStrOn(multi.getParameter("option_2"));
		}
		houseBean.setHouse_option(house_option);	

		//HouseSearchBean
		houseSearchBean.setBefore(Util.changeNullStr(multi.getParameter("before")));
		if (!Util.isEmpty(multi.getParameter("house_fee_from"))) {
			houseSearchBean.setHouse_fee(0, multi.getParameter("house_fee_from"));
		}
		if (!Util.isEmpty(multi.getParameter("house_fee_to"))) {
			houseSearchBean.setHouse_fee(1, multi.getParameter("house_fee_to"));
		}

		if (!Util.isEmpty(multi.getParameter("search_area_code_1"))) {
			houseSearchBean.setArea_code_1(multi.getParameter("search_area_code_1"));
		}
		if("00".equals(houseSearchBean.getArea_code_1())){
			houseSearchBean.setArea_code_2("0000");
		} else {
			houseSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(multi.getParameter("search_line_code"))) {
			houseSearchBean.setLine_code(multi.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(multi.getParameter("search_station_code"))) {
			houseSearchBean.setStation_code(multi.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(multi.getParameter("search_walk_time"))) {
			houseSearchBean.setWalk_time(multi.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(multi.getParameter("search_regist_date"))) {
			houseSearchBean.setRegist_date(multi.getParameter("search_regist_date"));
		} else {
			houseSearchBean.setRegist_date("3");
		}
		if (!Util.isEmpty(multi.getParameter("dimension_1"))) {
			houseSearchBean.setDimension(0, multi.getParameter("dimension_1"));
		}
		if (!Util.isEmpty(multi.getParameter("dimension_2"))) {
			houseSearchBean.setDimension(1, multi.getParameter("dimension_2"));
		}
		houseSearchBean.setUser_id(multi.getParameter("user_id"));

		if (!Util.isEmpty(multi.getParameter("madori_0"))
				&& "0".equals(multi.getParameter("madori_0"))) {
			houseSearchBean.setMadori(0, "0");
		}
		if (!Util.isEmpty(multi.getParameter("madori_1"))
				&& "1".equals(multi.getParameter("madori_1"))) {
			houseSearchBean.setMadori(1, "1");
		}
		if (!Util.isEmpty(multi.getParameter("madori_2"))
				&& "2".equals(multi.getParameter("madori_2"))) {
			houseSearchBean.setMadori(2, "2");
		}
		if (!Util.isEmpty(multi.getParameter("madori_3"))
				&& "3".equals(multi.getParameter("madori_3"))) {
			houseSearchBean.setMadori(3, "3");
		}
		if (!Util.isEmpty(multi.getParameter("madori_4"))
				&& "4".equals(multi.getParameter("madori_4"))) {
			houseSearchBean.setMadori(4, "4");
		}
		if (!Util.isEmpty(multi.getParameter("madori_5"))
				&& "5".equals(multi.getParameter("madori_5"))) {
			houseSearchBean.setMadori(5, "5");
		}
		if (!Util.isEmpty(multi.getParameter("madori_6"))
				&& "6".equals(multi.getParameter("madori_6"))) {
			houseSearchBean.setMadori(6, "6");
		}
		if (!Util.isEmpty(multi.getParameter("madori_7"))
				&& "7".equals(multi.getParameter("madori_7"))) {
			houseSearchBean.setMadori(7, "7");
		}
		if (!Util.isEmpty(multi.getParameter("madori_8"))
				&& "8".equals(multi.getParameter("madori_8"))) {
			houseSearchBean.setMadori(8, "8");
		}
		if (!Util.isEmpty(multi.getParameter("madori_9"))
				&& "9".equals(multi.getParameter("madori_9"))) {
			houseSearchBean.setMadori(9, "9");
		}
		if (!Util.isEmpty(multi.getParameter("madori_10"))
				&& "10".equals(multi.getParameter("madori_10"))) {
			houseSearchBean.setMadori(10, "10");
		}
		if (!Util.isEmpty(multi.getParameter("madori_11"))
				&& "11".equals(multi.getParameter("madori_11"))) {
			houseSearchBean.setMadori(11, "11");
		}

		if (!Util.isEmpty(multi.getParameter("search_flg_tadami"))) {
			houseSearchBean.setFlg_tadami(multi.getParameter("search_flg_tadami"));
		}
		if (!Util.isEmpty(multi.getParameter("search_build_year"))) {
			houseSearchBean.setBuild_year(multi.getParameter("search_build_year"));
		}
		if (!Util.isEmpty(multi.getParameter("search_toilet"))) {
			houseSearchBean.setToilet(multi.getParameter("search_toilet"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_0"))
				&& "0".equals(multi.getParameter("house_sort_0"))) {
			houseSearchBean.setHouse_sort(0, multi.getParameter("house_sort_0"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_1"))
				&& "1".equals(multi.getParameter("house_sort_1"))) {
			houseSearchBean.setHouse_sort(1, multi.getParameter("house_sort_1"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_2"))
				&& "2".equals(multi.getParameter("house_sort_2"))) {
			houseSearchBean.setHouse_sort(2, multi.getParameter("house_sort_2"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_3"))
				&& "3".equals(multi.getParameter("house_sort_3"))) {
			houseSearchBean.setHouse_sort(3, multi.getParameter("house_sort_3"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_4"))
				&& "4".equals(multi.getParameter("house_sort_4"))) {
			houseSearchBean.setHouse_sort(4, multi.getParameter("house_sort_4"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_5"))
				&& "5".equals(multi.getParameter("house_sort_5"))) {
			houseSearchBean.setHouse_sort(5, multi.getParameter("house_sort_5"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_6"))
				&& "6".equals(multi.getParameter("house_sort_6"))) {
			houseSearchBean.setHouse_sort(6, multi.getParameter("house_sort_6"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_7"))
				&& "7".equals(multi.getParameter("house_sort_7"))) {
			houseSearchBean.setHouse_sort(7, multi.getParameter("house_sort_7"));
		}
		if (!Util.isEmpty(multi.getParameter("pageSize"))) {
			houseSearchBean.setPageSize(multi.getParameter("pageSize"));
		}

		if (!Util.isEmpty(multi.getParameter("house_option_0"))
				&& "1".equals(multi.getParameter("house_option_0"))) {
			houseSearchBean.setHouse_option(0, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_1"))
				&& "1".equals(multi.getParameter("house_option_1"))) {
			houseSearchBean.setHouse_option(1, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_2"))
				&& "1".equals(multi.getParameter("house_option_2"))) {
			houseSearchBean.setHouse_option(2, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_3"))
				&& "1".equals(multi.getParameter("house_option_3"))) {
			houseSearchBean.setHouse_option(3, "1");
		}
		if("0".equals(multi.getParameter("re"))){
			houseSearchBean.setArea_code_2("0000");
		} else if ("1".equals(multi.getParameter("re"))){
			houseSearchBean.setStation_code("0000");
		}
	}
	private void setHouseSearchBean(HouseSearchBean houseSearchBean, HttpServletRequest request) throws ServletException, IOException {
		houseSearchBean.setBefore(Util.changeNullStr(request.getParameter("before")));
		if (!Util.isEmpty(request.getParameter("house_fee_from"))) {
			houseSearchBean.setHouse_fee(0, request.getParameter("house_fee_from"));
		}
		if (!Util.isEmpty(request.getParameter("house_fee_to"))) {
			houseSearchBean.setHouse_fee(1, request.getParameter("house_fee_to"));
		}

		if (!Util.isEmpty(request.getParameter("search_area_code_1"))) {
			houseSearchBean.setArea_code_1(request.getParameter("search_area_code_1"));
		}
		if("00".equals(houseSearchBean.getArea_code_1())){
			houseSearchBean.setArea_code_2("0000");
		} else {
			houseSearchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(request.getParameter("search_line_code"))) {
			houseSearchBean.setLine_code(request.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_station_code"))) {
			houseSearchBean.setStation_code(request.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_walk_time"))) {
			houseSearchBean.setWalk_time(request.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(request.getParameter("search_regist_date"))) {
			houseSearchBean.setRegist_date(request.getParameter("search_regist_date"));
		} else {
			houseSearchBean.setRegist_date("3");
		}
		if (!Util.isEmpty(request.getParameter("dimension_1"))) {
			houseSearchBean.setDimension(0, request.getParameter("dimension_1"));
		}
		if (!Util.isEmpty(request.getParameter("dimension_2"))) {
			houseSearchBean.setDimension(1, request.getParameter("dimension_2"));
		}
		houseSearchBean.setUser_id(request.getParameter("user_id"));

		if (!Util.isEmpty(request.getParameter("madori_0"))
				&& "0".equals(request.getParameter("madori_0"))) {
			houseSearchBean.setMadori(0, "0");
		}
		if (!Util.isEmpty(request.getParameter("madori_1"))
				&& "1".equals(request.getParameter("madori_1"))) {
			houseSearchBean.setMadori(1, "1");
		}
		if (!Util.isEmpty(request.getParameter("madori_2"))
				&& "2".equals(request.getParameter("madori_2"))) {
			houseSearchBean.setMadori(2, "2");
		}
		if (!Util.isEmpty(request.getParameter("madori_3"))
				&& "3".equals(request.getParameter("madori_3"))) {
			houseSearchBean.setMadori(3, "3");
		}
		if (!Util.isEmpty(request.getParameter("madori_4"))
				&& "4".equals(request.getParameter("madori_4"))) {
			houseSearchBean.setMadori(4, "4");
		}
		if (!Util.isEmpty(request.getParameter("madori_5"))
				&& "5".equals(request.getParameter("madori_5"))) {
			houseSearchBean.setMadori(5, "5");
		}
		if (!Util.isEmpty(request.getParameter("madori_6"))
				&& "6".equals(request.getParameter("madori_6"))) {
			houseSearchBean.setMadori(6, "6");
		}
		if (!Util.isEmpty(request.getParameter("madori_7"))
				&& "7".equals(request.getParameter("madori_7"))) {
			houseSearchBean.setMadori(7, "7");
		}
		if (!Util.isEmpty(request.getParameter("madori_8"))
				&& "8".equals(request.getParameter("madori_8"))) {
			houseSearchBean.setMadori(8, "8");
		}
		if (!Util.isEmpty(request.getParameter("madori_9"))
				&& "9".equals(request.getParameter("madori_9"))) {
			houseSearchBean.setMadori(9, "9");
		}
		if (!Util.isEmpty(request.getParameter("madori_10"))
				&& "10".equals(request.getParameter("madori_10"))) {
			houseSearchBean.setMadori(10, "10");
		}
		if (!Util.isEmpty(request.getParameter("madori_11"))
				&& "11".equals(request.getParameter("madori_11"))) {
			houseSearchBean.setMadori(11, "11");
		}

		if (!Util.isEmpty(request.getParameter("search_flg_tadami"))) {
			houseSearchBean.setFlg_tadami(request.getParameter("search_flg_tadami"));
		}
		if (!Util.isEmpty(request.getParameter("search_build_year"))) {
			houseSearchBean.setBuild_year(request.getParameter("search_build_year"));
		}
		if (!Util.isEmpty(request.getParameter("search_toilet"))) {
			houseSearchBean.setToilet(request.getParameter("search_toilet"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_0"))
				&& "0".equals(request.getParameter("house_sort_0"))) {
			houseSearchBean.setHouse_sort(0, request.getParameter("house_sort_0"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_1"))
				&& "1".equals(request.getParameter("house_sort_1"))) {
			houseSearchBean.setHouse_sort(1, request.getParameter("house_sort_1"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_2"))
				&& "2".equals(request.getParameter("house_sort_2"))) {
			houseSearchBean.setHouse_sort(2, request.getParameter("house_sort_2"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_3"))
				&& "3".equals(request.getParameter("house_sort_3"))) {
			houseSearchBean.setHouse_sort(3, request.getParameter("house_sort_3"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_4"))
				&& "4".equals(request.getParameter("house_sort_4"))) {
			houseSearchBean.setHouse_sort(4, request.getParameter("house_sort_4"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_5"))
				&& "5".equals(request.getParameter("house_sort_5"))) {
			houseSearchBean.setHouse_sort(5, request.getParameter("house_sort_5"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_6"))
				&& "6".equals(request.getParameter("house_sort_6"))) {
			houseSearchBean.setHouse_sort(6, request.getParameter("house_sort_6"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_7"))
				&& "7".equals(request.getParameter("house_sort_7"))) {
			houseSearchBean.setHouse_sort(7, request.getParameter("house_sort_7"));
		}
		if (!Util.isEmpty(request.getParameter("pageSize"))) {
			houseSearchBean.setPageSize(request.getParameter("pageSize"));
		}

		if (!Util.isEmpty(request.getParameter("house_option_0"))
				&& "1".equals(request.getParameter("house_option_0"))) {
			houseSearchBean.setHouse_option(0, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_1"))
				&& "1".equals(request.getParameter("house_option_1"))) {
			houseSearchBean.setHouse_option(1, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_2"))
				&& "1".equals(request.getParameter("house_option_2"))) {
			houseSearchBean.setHouse_option(2, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_3"))
				&& "1".equals(request.getParameter("house_option_3"))) {
			houseSearchBean.setHouse_option(3, "1");
		}
		if("0".equals(request.getParameter("re"))){
			houseSearchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))){
			houseSearchBean.setStation_code("0000");
		}

	}	
	private String changeStrOn(String inputStr) {
		String result = "";
		if (inputStr != null && "on".equals(inputStr)) {
			result = "1";
		}
		return result;
	}
}
