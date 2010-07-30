package housesell.action;

import housesell.bean.HouseBean;
import housesell.bean.HouseSearchBean;
import housesell.handler.HouseSellDetailHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class HouseSellDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug("HouseSellDetailAction.start");
			HttpSession session = request.getSession();
			session.setAttribute("topmenu", "housesell");			
			HouseSellDetailHandler houseSellDetailHandler = HouseSellDetailHandler.getInstance();
			HouseBean houseBean = new HouseBean();
			houseBean.setId(request.getParameter("id"));
			HouseSearchBean houseSearchBean = new HouseSearchBean();
			
			//from list
			if (!Util.isEmpty(houseBean.getId())) {
				setBean(houseSearchBean, request);
				houseBean = houseSellDetailHandler.getHouseBean(houseBean, true, true);
			//back
			} else {
				setBackBean(houseBean, houseSearchBean, request);
				houseBean = houseSellDetailHandler.getHouseBean(houseBean, false, true);
			}	
			session.setAttribute("action", "HouseSellDetail?id=" +houseBean.getId() +"&before="+houseSearchBean.getBefore());
			request.setAttribute("HouseBean", houseBean);
			request.setAttribute("HouseSearchBean", houseSearchBean);

		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HouseSellDetailAction", e);
		} finally {
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/housesell/houseSellDetail.jsp")
				.forward(request, response);
	}
	private void setBean(HouseSearchBean houseSearchBean, HttpServletRequest request) {
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
		houseSearchBean.setBefore(request.getParameter("before"));
	}
	private void setBackBean(HouseBean houseBean, HouseSearchBean houseSearchBean, HttpServletRequest request) throws ServletException, IOException{
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		houseBean.setId(Util.changeNullStr(multi.getParameter("id")));
		houseSearchBean.setBefore(multi.getParameter("before"));
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
}
