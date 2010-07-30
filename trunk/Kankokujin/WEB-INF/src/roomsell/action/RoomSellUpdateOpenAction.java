package roomsell.action;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import roomsell.bean.RoomBean;
import roomsell.bean.RoomSearchBean;
import roomsell.handler.RoomSellDetailHandler;

import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class RoomSellUpdateOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug(
					"RoomSellUpdateOpenAction.start");
			RoomSellDetailHandler roomSellDetailHandler = RoomSellDetailHandler.getInstance();
			RoomSearchBean roomSearchBean = new RoomSearchBean();
			
			RoomBean roomBean = new RoomBean();
			roomBean.setId(request.getParameter("id"));
			SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
			SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
			SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
			SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
				
			roomSearchBean.setAreaMap1(area1InfoMap);
			roomSearchBean.setAreaMap2(area2InfoMap);
			roomSearchBean.setLineMap(lineInfoMap);
			roomSearchBean.setStationMap(stationInfoMap);
			roomBean.setAreaMap1(area1InfoMap);
			roomBean.setAreaMap2(area2InfoMap);
			roomBean.setLineMap(lineInfoMap);
			roomBean.setStationMap(stationInfoMap);
			//reload
			if(Util.isEmpty(request.getParameter("id"))){
				setRoomBean(roomBean, roomSearchBean, request);
			//from detail
			} else {
				setRoomSearchBean(roomSearchBean, request);
				roomSellDetailHandler.getRoomBean(roomBean, false, false);
			}
			request.setAttribute("RoomBean", roomBean);
			request.setAttribute("RoomSearchBean", roomSearchBean);
		} catch (AppException e) {
			throw new KankokujinException("RoomSellUpdateOpenAction", e);
		} catch (Exception e) {
			throw new KankokujinException("RoomSellUpdateOpenAction", e);
		} finally {
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/roomsell/roomSellUpdate.jsp")
				.forward(request, response);

	}
	private void setRoomBean(RoomBean roomBean, RoomSearchBean roomSearchBean, HttpServletRequest request) throws IOException{

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		roomBean.setId(Util.changeNullStr(multi.getParameter("id")));		
		roomBean.setTitle(Util.changeNullStr(multi
				.getParameter("title")));
		roomBean.setRoom_name(Util.changeNullStr(multi
				.getParameter("room_name")));
		roomBean.setRoom_sort(Util.changeNullStr(multi.getParameter("room_sort")));		
		roomBean.setBuild_sort(Util.changeNullStr(multi
				.getParameter("build_sort")));	
		roomBean.setEquipment_fee(Util.changeNullStr(multi
				.getParameter("equipment_fee")));	
		roomBean.setEntrance_fee(Util.changeNullStr(multi
				.getParameter("entrance_fee")));		
		roomBean.setRoom_type(multi.getParameter("room_type"));
		roomBean.setSex(multi.getParameter("sex"));
		roomBean.setTel_no1_1(Util.changeNullStr(multi.getParameter("tel_no1_1")));	
		roomBean.setTel_no1_2(Util.changeNullStr(multi.getParameter("tel_no1_2")));
		roomBean.setTel_no1_3(Util.changeNullStr(multi.getParameter("tel_no1_3")));
		roomBean.setTel_no2_1(Util.changeNullStr(multi.getParameter("tel_no2_1")));	
		roomBean.setTel_no2_2(Util.changeNullStr(multi.getParameter("tel_no2_2")));
		roomBean.setTel_no2_3(Util.changeNullStr(multi.getParameter("tel_no2_3")));
		roomBean.setRoom_fee(Util.changeNullStr(multi.getParameter("room_fee")));		
		roomBean.setFee_unit(Util.changeNullStr(multi.getParameter("fee_unit")));
		roomBean.setDetail_info(Util.changeNullStr(multi
				.getParameter("detail_info")));
		roomBean.setEmail(Util.changeNullStr(multi
				.getParameter("email")));		
		roomBean.setUrl(Util.changeNullStr(multi
				.getParameter("url")));			
		roomBean.setArea_code_1(Util.changeNullStr(multi
				.getParameter("area_code_1")));
		roomBean.setArea_code_2(Util.changeNullStr(multi
				.getParameter("area_code_2")));
		roomBean.setArea_code_3(Util.changeNullStr(multi
				.getParameter("area_code_3")));
		roomBean.setMain_area(Util.changeNullStr(multi
				.getParameter("main_area")));
		roomBean.setLine_code(Util.changeNullStr(multi
				.getParameter("line_code")));
		roomBean.setStation_code(Util.changeNullStr(multi
				.getParameter("station_code")));

		roomBean.setDeposit_fee(Util.changeNullStr(multi
				.getParameter("deposit_fee")));

		roomBean.setUser_id(Util.changeNullStr(multi
				.getParameter("user_id")));
		roomBean.setWalk_time(Util.changeNullStr(multi
				.getParameter("walk_time")));
		roomBean.setArea_fast(Util.changeNullStr(multi
				.getParameter("area_fast")));
		roomBean.setCome_dock(Util.changeNullStr(multi
				.getParameter("come_dock")));
		roomBean.setCome_dock_year(Util.changeNullStr(multi
				.getParameter("come_dock_year")));
		roomBean.setCome_dock_month(Util.changeNullStr(multi
				.getParameter("come_dock_month")));
		
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name1")))){
			roomBean.setPhoto_name1(multi.getParameter("image1"));
		} else {
			roomBean.setPhoto_name1(Util.changePhotoPath(multi.getFilesystemName("photo_name1")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name2")))){
			roomBean.setPhoto_name2(multi.getParameter("image2"));
		} else {
			roomBean.setPhoto_name2(Util.changePhotoPath(multi.getFilesystemName("photo_name2")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name3")))){
			roomBean.setPhoto_name3(multi.getParameter("image3"));
		} else {
			roomBean.setPhoto_name3(Util.changePhotoPath(multi.getFilesystemName("photo_name3")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name4")))){
			roomBean.setPhoto_name4(multi.getParameter("image4"));
		} else {
			roomBean.setPhoto_name4(Util.changePhotoPath(multi.getFilesystemName("photo_name4")));
		}
		if(Util.isEmpty(Util.changePhotoPath(multi.getFilesystemName("photo_name5")))){
			roomBean.setPhoto_name5(multi.getParameter("image5"));
		} else {
			roomBean.setPhoto_name5(Util.changePhotoPath(multi.getFilesystemName("photo_name5")));
		}
		if(!Util.isEmpty(request.getParameter("del"))){
			if("1".equals(request.getParameter("del"))){
				roomBean.setPhoto_name1("");
			} else if("2".equals(request.getParameter("del"))){
				roomBean.setPhoto_name2("");
			} else if("3".equals(request.getParameter("del"))){
				roomBean.setPhoto_name3("");
			} else if("4".equals(request.getParameter("del"))){
				roomBean.setPhoto_name4("");
			} else if("5".equals(request.getParameter("del"))){			
				roomBean.setPhoto_name5("");
			}
		}
		roomSearchBean.setCate_code_1(multi.getParameter("cate_code_1"));
		roomSearchBean.setBefore(multi.getParameter("before"));
		roomSearchBean.setUser_id(multi.getParameter("user_id"));
		if(!Util.isEmpty(multi.getParameter("pageSize"))) {
			roomSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("pageSize")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageSize"))){
			roomSearchBean.setPageSize(Util.changeNullStr(multi.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(multi.getParameter("pageNum"))) {
			roomSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("pageNum")));
		} else if(!Util.isEmpty(multi.getParameter("before_pageNum"))){
			roomSearchBean.setPageNum(Util.changeNullStr(multi.getParameter("before_pageNum")));
		}			
		roomSearchBean.setRoom_fee_from(Util.changeNullStr(multi.getParameter("room_fee_from")));
		roomSearchBean.setRoom_fee_to(Util.changeNullStr(multi.getParameter("room_fee_to")));
		roomSearchBean.setRoom_sort(0, Util.changeNullStr(multi.getParameter("room_sort_0")));
		roomSearchBean.setRoom_sort(1, Util.changeNullStr(multi.getParameter("room_sort_1")));
		roomSearchBean.setRoom_sort(2, Util.changeNullStr(multi.getParameter("room_sort_2")));
		roomSearchBean.setRoom_sort(3, Util.changeNullStr(multi.getParameter("room_sort_3")));
		roomSearchBean.setRoom_sort(4, Util.changeNullStr(multi.getParameter("room_sort_4")));
		roomSearchBean.setRoom_sort(5, Util.changeNullStr(multi.getParameter("room_sort_5")));
		roomSearchBean.setRoom_sort(6, Util.changeNullStr(multi.getParameter("room_sort_6")));
		roomSearchBean.setRoom_sort(7, Util.changeNullStr(multi.getParameter("room_sort_7")));
		roomSearchBean.setRoom_sort(8, Util.changeNullStr(multi.getParameter("room_sort_8")));
		roomSearchBean.setRoom_sort(9, Util.changeNullStr(multi.getParameter("room_sort_9")));
		roomSearchBean.setRoom_sort(10, Util.changeNullStr(multi.getParameter("room_sort_10")));
		roomSearchBean.setSex(Util.changeNullStr(multi.getParameter("search_sex")));
		roomSearchBean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		roomSearchBean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));
		roomSearchBean.setBuild_sort(Util.changeNullStr(multi.getParameter("search_build_sort")));
		roomSearchBean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		if("00".equals(roomSearchBean.getArea_code_1())){
			roomSearchBean.setArea_code_2("0000");
		} else {
			roomSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		}
		roomSearchBean.setRoom_type(Util.changeNullStr(multi.getParameter("search_room_type")));
		roomSearchBean.setRegist_date(Util.changeNullStr(multi.getParameter("search_regist_date")));
		if("0".equals(multi.getParameter("re"))){
			roomSearchBean.setArea_code_2("0000");
		} else if ("1".equals(multi.getParameter("re"))){
			roomSearchBean.setStation_code("0000");
		}

	}	

	private void setRoomSearchBean(RoomSearchBean roomSearchBean, HttpServletRequest request){
		roomSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("cate_code_1")));
		roomSearchBean.setBefore(request.getParameter("before"));
		roomSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		if(!Util.isEmpty(request.getParameter("pageSize"))) {
			roomSearchBean.setPageSize(Util.changeNullStr(request.getParameter("pageSize")));
		} else if(!Util.isEmpty(request.getParameter("before_pageSize"))){
			roomSearchBean.setPageSize(Util.changeNullStr(request.getParameter("before_pageSize")));
		}
		if(!Util.isEmpty(request.getParameter("pageNum"))) {
			roomSearchBean.setPageNum(Util.changeNullStr(request.getParameter("pageNum")));
		} else if(!Util.isEmpty(request.getParameter("before_pageNum"))){
			roomSearchBean.setPageNum(Util.changeNullStr(request.getParameter("before_pageNum")));
		}		
		
		roomSearchBean.setRoom_fee_from(Util.changeNullStr(request.getParameter("room_fee_from")));
		roomSearchBean.setRoom_fee_to(Util.changeNullStr(request.getParameter("room_fee_to")));
		roomSearchBean.setRoom_sort(0, Util.changeNullStr(request.getParameter("room_sort_0")));
		roomSearchBean.setRoom_sort(1, Util.changeNullStr(request.getParameter("room_sort_1")));
		roomSearchBean.setRoom_sort(2, Util.changeNullStr(request.getParameter("room_sort_2")));
		roomSearchBean.setRoom_sort(3, Util.changeNullStr(request.getParameter("room_sort_3")));
		roomSearchBean.setRoom_sort(4, Util.changeNullStr(request.getParameter("room_sort_4")));
		roomSearchBean.setRoom_sort(5, Util.changeNullStr(request.getParameter("room_sort_5")));
		roomSearchBean.setRoom_sort(6, Util.changeNullStr(request.getParameter("room_sort_6")));
		roomSearchBean.setRoom_sort(7, Util.changeNullStr(request.getParameter("room_sort_7")));
		roomSearchBean.setRoom_sort(8, Util.changeNullStr(request.getParameter("room_sort_8")));
		roomSearchBean.setRoom_sort(9, Util.changeNullStr(request.getParameter("room_sort_9")));
		roomSearchBean.setRoom_sort(10, Util.changeNullStr(request.getParameter("room_sort_10")));
		roomSearchBean.setSex(Util.changeNullStr(request.getParameter("search_sex")));
		roomSearchBean.setLine_code(Util.changeNullStr(request.getParameter("search_line_code")));
		roomSearchBean.setStation_code(Util.changeNullStr(request.getParameter("search_station_code")));
		roomSearchBean.setBuild_sort(Util.changeNullStr(request.getParameter("search_build_sort")));
		roomSearchBean.setArea_code_1(Util.changeNullStr(request.getParameter("search_area_code_1")));
		if("00".equals(roomSearchBean.getArea_code_1())){
			roomSearchBean.setArea_code_2("0000");
		} else {
			roomSearchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		}
		roomSearchBean.setRoom_type(Util.changeNullStr(request.getParameter("search_room_type")));
		roomSearchBean.setRegist_date(Util.changeNullStr(request.getParameter("search_regist_date")));
		if("0".equals(request.getParameter("re"))){
			roomSearchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))){
			roomSearchBean.setStation_code("0000");
		}
	}
}
