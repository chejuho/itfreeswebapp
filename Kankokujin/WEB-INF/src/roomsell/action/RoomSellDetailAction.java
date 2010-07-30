package roomsell.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roomsell.bean.RoomBean;
import roomsell.bean.RoomSearchBean;
import roomsell.handler.RoomSellDetailHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.Util;

public class RoomSellDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			KankokujinLogger.getInstance().debug("RoomSellDetailAction.start");
			
			RoomSellDetailHandler roomSellDetailHandler = RoomSellDetailHandler.getInstance();
			RoomBean roomBean = new RoomBean();
			roomBean.setId(request.getParameter("id"));
			RoomSearchBean roomSearchBean = new RoomSearchBean();
			
			//from list
			if (!Util.isEmpty(roomBean.getId())) {
				setRoomBean(roomBean, roomSearchBean, request);
				roomSellDetailHandler.getRoomBean(roomBean, true, true);
			//back
			} else {
				setBackRoomBean(roomBean, roomSearchBean, request);
				roomSellDetailHandler.getRoomBean(roomBean, false, true);
			}	
			if(Util.isEmpty(roomSearchBean.getCate_code_1())){
				roomSearchBean.setCate_code_1(roomBean.getCate_code_1());
			}
			if("C10001".equals(roomSearchBean.getCate_code_1())){
				session.setAttribute("topmenu", "roomsell1");
			} else if ("C10002".equals(roomSearchBean.getCate_code_1())) {				
				session.setAttribute("topmenu", "roomsell2");
			}
			SortedMap buysellCategory1Map = (SortedMap) getServletContext().getAttribute("BuySellCategory1");
			SortedMap buysellCategory2Map = (SortedMap) getServletContext().getAttribute("BuySellCategory2");
			List category1List = UtilHandler.getCategory1ListFromMap(buysellCategory1Map);
			List category2List = UtilHandler.getCategory2ListFromMap(roomBean.getCate_code_1(), buysellCategory2Map);
			
			request.setAttribute("Category1List", category1List);
			request.setAttribute("Category2List", category2List);
			session.setAttribute("action", "RoomSellDetail?id=" +roomBean.getId() +"&before="+roomSearchBean.getBefore());
			request.setAttribute("RoomBean", roomBean);
			request.setAttribute("RoomSearchBean", roomSearchBean);

		} catch (AppException e) {
			throw new KankokujinException("RoomSellDetailAction", e);
		} catch (Exception e) {
			throw new KankokujinException("RoomSellDetailAction", e);
		} finally {
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/roomsell/roomSellDetail.jsp")
				.forward(request, response);
	}
	private void setRoomBean(RoomBean roomBean, RoomSearchBean roomSearchBean, HttpServletRequest request){
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
	private void setBackRoomBean(RoomBean roomBean, RoomSearchBean roomSearchBean, HttpServletRequest request) throws IOException{

		MultipartRequest multi = new MultipartRequest(request, Const.UPLOAD_FOLDER_PATH,
				10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		roomBean.setId(Util.changeNullStr(multi.getParameter("id")));
		roomSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		roomSearchBean.setBefore(multi.getParameter("before"));
		roomSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
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
}
