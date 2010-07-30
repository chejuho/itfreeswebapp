package roomsell.action;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roomsell.bean.RoomSearchBean;
import roomsell.handler.RoomSellListHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.PageBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class RoomSellListAction extends HttpServlet {
	/**
	 * RoomSellListを表示する
	 * 
	 * @param request
	 *            response
	 * @return HouseBean、HouseSellSortBean、PageBean、HouseBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("RoomSellListAction.start");
		HttpSession session = request.getSession();	
		
		RoomSearchBean roomSearchBean = new RoomSearchBean();
		roomSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
		if(!Util.isEmpty(request.getParameter("all_search"))) {	
			setRoomSearchBean(roomSearchBean, request);
		} else if("-".equals(request.getParameter("user_id"))) {	
			setRoomSearchBean(roomSearchBean, request);
			session.setAttribute("action", "RoomSellList?re=9&cate_code_1="+roomSearchBean.getCate_code_1()+"&search_area_code_1=" + roomSearchBean.getArea_code_1() + "&search_area_code_2=" + roomSearchBean.getArea_code_2() + "&search_line_code=" + roomSearchBean.getLine_code() + "&search_station_code=" + roomSearchBean.getStation_code()+"&pageSize="+roomSearchBean.getPageSize()+"&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen")
					.forward(request, response);	
		} else if("b".equals(request.getParameter("f"))) {		
			setMulRoomSearchBean(roomSearchBean, request);			
		} else {			
			setRoomSearchBean(roomSearchBean, request);
		}			
		if("C10001".equals(roomSearchBean.getCate_code_1())){
			session.setAttribute("topmenu", "roomsell1");
			session.setAttribute("action", "RoomSellList?re=9&cate_code_1=C10001&search_area_code_1=" + roomSearchBean.getArea_code_1() + "&search_area_code_2=" + roomSearchBean.getArea_code_2() + "&search_line_code=" + roomSearchBean.getLine_code() + "&search_station_code=" + roomSearchBean.getStation_code()+"&pageSize="+roomSearchBean.getPageSize()+"&user_id=");				
		} else if ("C10002".equals(roomSearchBean.getCate_code_1())) {				
			session.setAttribute("topmenu", "roomsell2");
			session.setAttribute("action", "RoomSellList?re=9&cate_code_1=C10002&search_area_code_1=" + roomSearchBean.getArea_code_1() + "&search_area_code_2=" + roomSearchBean.getArea_code_2() + "&search_line_code=" + roomSearchBean.getLine_code() + "&search_station_code=" + roomSearchBean.getStation_code()+"&pageSize="+roomSearchBean.getPageSize()+"&user_id=");				
		} 
		
		
		RoomSellListHandler roomSellListHandler = RoomSellListHandler.getInstance();
		List roomBeanList = null;
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
			
		roomSearchBean.setAreaMap1(area1InfoMap);
		roomSearchBean.setAreaMap2(area2InfoMap);
		roomSearchBean.setLineMap(lineInfoMap);
		roomSearchBean.setStationMap(stationInfoMap);

		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, roomSearchBean.getPageSize());

		try {
			roomBeanList = roomSellListHandler.getRoomBeanListTotal(pageBean, roomSearchBean);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			KankokujinLogger.getInstance().debug("RoomSellListAction.end");
		}
		
		session.setAttribute("PageBean", pageBean);

		request.setAttribute("RoomBeanList", roomBeanList);
		request.setAttribute("RoomSearchBean", roomSearchBean);
	
		this.getServletContext().getRequestDispatcher("/jsp/roomsell/roomSellList.jsp").forward(request, response);

	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = request.getParameter("pageNum");
		if (!Util.isEmpty(pageNumStr)) {
			if (!"sprev".equals(pageNumStr) && !"bprev".equals(pageNumStr)
					&& !"snext".equals(pageNumStr)
					&& !"bnext".equals(pageNumStr)) {
				bean.setPageNum((Integer.parseInt(pageNumStr)));
			} else {
				bean.setPagingSign(pageNumStr);
			}
		}
	}
	private void setMulRoomSearchBean(RoomSearchBean roomSearchBean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());		
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
		roomSearchBean.setBefore(multi.getParameter("before"));
		roomSearchBean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		roomSearchBean.setArea_code_1(Util.changeNullStr(multi.getParameter("search_area_code_1")));
		if("00".equals(roomSearchBean.getArea_code_1())){
			roomSearchBean.setArea_code_2("0000");
		} else {
			roomSearchBean.setArea_code_2(Util.changeNullStr(multi.getParameter("search_area_code_2")));
		}		
		roomSearchBean.setLine_code(Util.changeNullStr(multi.getParameter("search_line_code")));
		roomSearchBean.setStation_code(Util.changeNullStr(multi.getParameter("search_station_code")));
		roomSearchBean.setCate_code_1(Util.changeNullStr(multi.getParameter("cate_code_1")));
		if("0".equals(multi.getParameter("re"))){
			roomSearchBean.setArea_code_2("0000");
		} else if ("1".equals(multi.getParameter("re"))){
			roomSearchBean.setStation_code("0000");
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
		roomSearchBean.setBuild_sort(Util.changeNullStr(multi.getParameter("search_build_sort")));
		roomSearchBean.setRoom_type(Util.changeNullStr(multi.getParameter("search_room_type")));
		roomSearchBean.setRegist_date(Util.changeNullStr(multi.getParameter("search_regist_date")));
	}
	private void setRoomSearchBean(RoomSearchBean roomSearchBean, HttpServletRequest request) {
		roomSearchBean.setCate_code_1(Util.changeNullStr(request.getParameter("cate_code_1")));
		roomSearchBean.setUser_id(Util.changeNullStr(request.getParameter("user_id")));
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
		if (!Util.isEmpty(request.getParameter("pageSize"))) {
			 roomSearchBean.setPageSize(request.getParameter("pageSize")); 
		}
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
		
	}
}