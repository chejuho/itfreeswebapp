package housesell.action;

import housesell.bean.HouseSearchBean;
import housesell.bean.HouseSellSortBean;
import housesell.handler.HouseSellListHandler;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.bean.PageBean;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class HouseSellListAction extends HttpServlet {
	/**
	 * HouseSellListを開く
	 * 
	 * @param request
	 *            response
	 * @return HouseBean、HouseSellSortBean、PageBean、HouseBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("HouseSellListAction.start");
		HttpSession session = request.getSession();
		session.setAttribute("action", "HouseSellList");
		session.setAttribute("topmenu", "housesell");
		
		boolean adviserSign = false;
		
		HouseSearchBean houseSearchBean = new HouseSearchBean();
		HouseSellSortBean houseSellSortBean = (HouseSellSortBean) session.getAttribute("HouseSellSortBean");
		
		if (houseSellSortBean == null) {
			houseSellSortBean = new HouseSellSortBean();
		}
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
			
		houseSearchBean.setAreaMap1(area1InfoMap);
		houseSearchBean.setAreaMap2(area2InfoMap);
		houseSearchBean.setLineMap(lineInfoMap);
		houseSearchBean.setStationMap(stationInfoMap);
		
		if (!Util.isEmpty(request.getParameter("all_search"))) {
			setHouseSearchBean(houseSearchBean, request);
			/*
			 * houseSearchBean.setSearch(EnDecoding.decoding(request.getParameter("all_search")));
			 * houseSearchBean.setDecodedSearch(EnDecoding.decoding(EnDecoding.decoding(request.getParameter("all_search"))));
			 * houseSearchBean.setSearch_range("0");
			 */
		} else if ("-".equals(request.getParameter("user_id"))) {
			setHouseSearchBean(houseSearchBean, request);
			session.setAttribute("action",
					"HouseSellList?re=9&search_area_code_1="
							+ houseSearchBean.getArea_code_1()
							+ "&search_area_code_2="
							+ houseSearchBean.getArea_code_2()
							+ "&search_line_code="
							+ houseSearchBean.getLine_code()
							+ "&search_station_code="
							+ houseSearchBean.getStation_code() + "&pageSize="
							+ houseSearchBean.getPageSize() + "&user_id=");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);
		} else if ("b".equals(request.getParameter("f"))) {
			setMulHouseSearchBean(houseSearchBean, request);
		} else {
			setHouseSearchBean(houseSearchBean, request);
		}
		
		getChangeSort(houseSellSortBean, request);
		// セッションに最新HouseSellSortBeanをセットする
		session.setAttribute("HouseSellSortBean", houseSellSortBean);

		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, houseSearchBean.getPageSize());

		List houseBeanList = null;
		HouseSellListHandler houseSellListHandler = HouseSellListHandler.getInstance();
		try {
			houseBeanList = houseSellListHandler.getHouseBeanListTotal(pageBean, houseSearchBean, houseSellSortBean);
			adviserSign = Util.hasPrivilege(request);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("HouseSellListAction", e);
		} 
		
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("HouseSearchBean", houseSearchBean);
		request.setAttribute("adviserSign", Boolean.valueOf(adviserSign));
		request.setAttribute("HouseBeanList", houseBeanList);
		this.getServletContext().getRequestDispatcher("/jsp/housesell/houseSellList.jsp").forward(request, response);
		
		
	}

	/**
	 * pageの情報を入力する
	 * 
	 * @param bean、request
	 * @return beanの値
	 */
	private void setPageBean(PageBean bean, HttpServletRequest request) {
		String pageNumStr = "";
		if (!Util.isEmpty(request.getParameter("pageNum"))) {
			pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
		} else if (!Util.isEmpty(request.getParameter("before_pageNum"))) {
			pageNumStr = Util.changeNullStr(request
					.getParameter("before_pageNum"));
		}
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

	private void setMulHouseSearchBean(HouseSearchBean houseSearchBean,
			HttpServletRequest request) throws IOException {
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		if (!Util.isEmpty(multi.getParameter("house_fee_from"))) {
			houseSearchBean.setHouse_fee(0, multi
					.getParameter("house_fee_from"));
		}
		if (!Util.isEmpty(multi.getParameter("house_fee_to"))) {
			houseSearchBean.setHouse_fee(1, multi.getParameter("house_fee_to"));
		}

		if (!Util.isEmpty(multi.getParameter("search_area_code_1"))) {
			houseSearchBean.setArea_code_1(multi
					.getParameter("search_area_code_1"));
		}
		if ("00".equals(houseSearchBean.getArea_code_1())) {
			houseSearchBean.setArea_code_2("0000");
		} else {
			houseSearchBean.setArea_code_2(Util.changeNullStr(multi
					.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(multi.getParameter("search_line_code"))) {
			houseSearchBean
					.setLine_code(multi.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(multi.getParameter("search_station_code"))) {
			houseSearchBean.setStation_code(multi
					.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(multi.getParameter("search_walk_time"))) {
			houseSearchBean
					.setWalk_time(multi.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(multi.getParameter("search_regist_date"))) {
			houseSearchBean.setRegist_date(multi
					.getParameter("search_regist_date"));
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
			houseSearchBean.setFlg_tadami(multi
					.getParameter("search_flg_tadami"));
		}
		if (!Util.isEmpty(multi.getParameter("search_build_year"))) {
			houseSearchBean.setBuild_year(multi
					.getParameter("search_build_year"));
		}
		if (!Util.isEmpty(multi.getParameter("search_toilet"))) {
			houseSearchBean.setToilet(multi.getParameter("search_toilet"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_0"))
				&& "0".equals(multi.getParameter("house_sort_0"))) {
			houseSearchBean
					.setHouse_sort(0, multi.getParameter("house_sort_0"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_1"))
				&& "1".equals(multi.getParameter("house_sort_1"))) {
			houseSearchBean
					.setHouse_sort(1, multi.getParameter("house_sort_1"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_2"))
				&& "2".equals(multi.getParameter("house_sort_2"))) {
			houseSearchBean
					.setHouse_sort(2, multi.getParameter("house_sort_2"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_3"))
				&& "3".equals(multi.getParameter("house_sort_3"))) {
			houseSearchBean
					.setHouse_sort(3, multi.getParameter("house_sort_3"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_4"))
				&& "4".equals(multi.getParameter("house_sort_4"))) {
			houseSearchBean
					.setHouse_sort(4, multi.getParameter("house_sort_4"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_5"))
				&& "5".equals(multi.getParameter("house_sort_5"))) {
			houseSearchBean
					.setHouse_sort(5, multi.getParameter("house_sort_5"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_6"))
				&& "6".equals(multi.getParameter("house_sort_6"))) {
			houseSearchBean
					.setHouse_sort(6, multi.getParameter("house_sort_6"));
		}
		if (!Util.isEmpty(multi.getParameter("house_sort_7"))
				&& "7".equals(multi.getParameter("house_sort_7"))) {
			houseSearchBean
					.setHouse_sort(7, multi.getParameter("house_sort_7"));
		}
		if (!Util.isEmpty(multi.getParameter("pageSize"))) {
			houseSearchBean.setPageSize(multi.getParameter("pageSize"));
		}

		if (!Util.isEmpty(multi.getParameter("house_option_0"))
				&& "0".equals(multi.getParameter("house_option_0"))) {
			houseSearchBean.setHouse_option(0, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_1"))
				&& "1".equals(multi.getParameter("house_option_1"))) {
			houseSearchBean.setHouse_option(1, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_2"))
				&& "2".equals(multi.getParameter("house_option_2"))) {
			houseSearchBean.setHouse_option(2, "1");
		}
		if (!Util.isEmpty(multi.getParameter("house_option_3"))
				&& "3".equals(multi.getParameter("house_option_3"))) {
			houseSearchBean.setHouse_option(3, "1");
		}
		if ("0".equals(multi.getParameter("re"))) {
			houseSearchBean.setArea_code_2("0000");
		} else if ("1".equals(multi.getParameter("re"))) {
			houseSearchBean.setStation_code("0000");
		}
	}

	private void setHouseSearchBean(HouseSearchBean houseSearchBean,
			HttpServletRequest request) {

		if (!Util.isEmpty(request.getParameter("house_fee_from"))) {
			houseSearchBean.setHouse_fee(0, request
					.getParameter("house_fee_from"));
		}
		if (!Util.isEmpty(request.getParameter("house_fee_to"))) {
			houseSearchBean.setHouse_fee(1, request
					.getParameter("house_fee_to"));
		}

		if (!Util.isEmpty(request.getParameter("search_area_code_1"))) {
			houseSearchBean.setArea_code_1(request
					.getParameter("search_area_code_1"));
		}
		if ("00".equals(houseSearchBean.getArea_code_1())) {
			houseSearchBean.setArea_code_2("0000");
		} else {
			houseSearchBean.setArea_code_2(Util.changeNullStr(request
					.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(request.getParameter("search_line_code"))) {
			houseSearchBean.setLine_code(request
					.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_station_code"))) {
			houseSearchBean.setStation_code(request
					.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_walk_time"))) {
			houseSearchBean.setWalk_time(request
					.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(request.getParameter("search_regist_date"))) {
			houseSearchBean.setRegist_date(request
					.getParameter("search_regist_date"));
		} else {
			houseSearchBean.setRegist_date("3");
		}
		if (!Util.isEmpty(request.getParameter("dimension_1"))) {
			houseSearchBean
					.setDimension(0, request.getParameter("dimension_1"));
		}
		if (!Util.isEmpty(request.getParameter("dimension_2"))) {
			houseSearchBean
					.setDimension(1, request.getParameter("dimension_2"));
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
			houseSearchBean.setFlg_tadami(request
					.getParameter("search_flg_tadami"));
		}
		if (!Util.isEmpty(request.getParameter("search_build_year"))) {
			houseSearchBean.setBuild_year(request
					.getParameter("search_build_year"));
		}
		if (!Util.isEmpty(request.getParameter("search_toilet"))) {
			houseSearchBean.setToilet(request.getParameter("search_toilet"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_0"))
				&& "0".equals(request.getParameter("house_sort_0"))) {
			houseSearchBean.setHouse_sort(0, request
					.getParameter("house_sort_0"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_1"))
				&& "1".equals(request.getParameter("house_sort_1"))) {
			houseSearchBean.setHouse_sort(1, request
					.getParameter("house_sort_1"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_2"))
				&& "2".equals(request.getParameter("house_sort_2"))) {
			houseSearchBean.setHouse_sort(2, request
					.getParameter("house_sort_2"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_3"))
				&& "3".equals(request.getParameter("house_sort_3"))) {
			houseSearchBean.setHouse_sort(3, request
					.getParameter("house_sort_3"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_4"))
				&& "4".equals(request.getParameter("house_sort_4"))) {
			houseSearchBean.setHouse_sort(4, request
					.getParameter("house_sort_4"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_5"))
				&& "5".equals(request.getParameter("house_sort_5"))) {
			houseSearchBean.setHouse_sort(5, request
					.getParameter("house_sort_5"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_6"))
				&& "6".equals(request.getParameter("house_sort_6"))) {
			houseSearchBean.setHouse_sort(6, request
					.getParameter("house_sort_6"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_7"))
				&& "7".equals(request.getParameter("house_sort_7"))) {
			houseSearchBean.setHouse_sort(7, request
					.getParameter("house_sort_7"));
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
		if ("0".equals(request.getParameter("re"))) {
			houseSearchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))) {
			houseSearchBean.setStation_code("0000");
		}
	}

	/**
	 * list画面のsortの形を変更する
	 * 
	 * @param houseSellSortBean
	 *            基本値は0で一回クリックしたら形が変更する
	 * @return imageの変更になったbeanの値
	 */
	private void getChangeSort(HouseSellSortBean houseSellSortBean,
			HttpServletRequest request) {
		List<String> list = houseSellSortBean.getSortList();
		final String REGIST_DATE_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.REGIST_DATE + Const.SPACE + Const.ASC + Const.SPACE;
		final String REGIST_DATE_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.REGIST_DATE + Const.SPACE + Const.DESC + Const.SPACE;
		final String ADDREES_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.AREA_CODE_1 + Const.SPACE + Const.ASC + Const.SPACE;
		final String ADDREES_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.AREA_CODE_1 + Const.SPACE + Const.DESC + Const.SPACE;
		final String LINE_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.LINE_CODE + Const.SPACE + Const.ASC + Const.SPACE;
		final String LINE_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.LINE_CODE + Const.SPACE + Const.DESC + Const.SPACE;
		final String WALK_TIME_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.WALK_TIME + Const.SPACE + Const.ASC + Const.SPACE;
		final String WALK_TIME_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.WALK_TIME + Const.SPACE + Const.DESC + Const.SPACE;
		final String HOUSE_FEE_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.HOUSE_FEE + Const.SPACE + Const.ASC + Const.SPACE;
		final String HOUSE_FEE_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.HOUSE_FEE + Const.SPACE + Const.DESC + Const.SPACE;
		final String MANAGE_FEE_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.MANAGE_FEE + Const.SPACE + Const.ASC + Const.SPACE;
		final String MANAGE_FEE_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.MANAGE_FEE + Const.SPACE + Const.DESC + Const.SPACE;
		final String DEPOSIT_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.DEPOSIT + Const.SPACE + Const.ASC + Const.SPACE;
		final String DEPOSIT_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.DEPOSIT + Const.SPACE + Const.DESC + Const.SPACE;
		final String REIKIN_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.REIKIN + Const.SPACE + Const.ASC + Const.SPACE;
		final String REIKIN_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.REIKIN + Const.SPACE + Const.DESC + Const.SPACE;
		final String GUARANTY_MONEY_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.GUARANTY_MONEY + Const.SPACE + Const.ASC + Const.SPACE;
		final String GUARANTY_MONEY_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.GUARANTY_MONEY + Const.SPACE + Const.DESC + Const.SPACE;
		final String MADORI_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.MADORI + Const.SPACE + Const.ASC + Const.SPACE;
		final String MADORI_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.MADORI + Const.SPACE + Const.DESC + Const.SPACE;
		final String DIMENSION_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.DIMENSION + Const.SPACE + Const.ASC + Const.SPACE;
		final String DIMENSION_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.DIMENSION + Const.SPACE + Const.DESC + Const.SPACE;
		final String HOUSE_SORT_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.HOUSE_SORT + Const.SPACE + Const.ASC + Const.SPACE;
		final String HOUSE_SORT_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.HOUSE_SORT + Const.SPACE + Const.DESC + Const.SPACE;
		final String BUILD_YEAR_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.BUILD_YEAR + Const.SPACE + Const.ASC + Const.SPACE;
		final String BUILD_YEAR_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.BUILD_YEAR + Const.SPACE + Const.DESC + Const.SPACE;
		final String USER_ID_UP = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.USER_ID + Const.SPACE + Const.ASC + Const.SPACE;
		final String USER_ID_DOWN = Const.SPACE + Const.TBL_HOUSE_INFO
				+ Const.USER_ID + Const.SPACE + Const.DESC + Const.SPACE;
		if (list.size() == 0) {
			list.add(REGIST_DATE_DOWN);
		}
		if (!Util.isEmpty(request.getParameter("address_up"))
				&& "0".equals(request.getParameter("address_up"))) {
			houseSellSortBean.setAddress_up("1");
			houseSellSortBean.setAddress_image("jsp/images/new/down.gif");
			list.add(ADDREES_DOWN);
		} else if (!Util.isEmpty(request.getParameter("address_up"))
				&& "1".equals(request.getParameter("address_up"))) {
			houseSellSortBean.setAddress_up("0");
			houseSellSortBean.setAddress_image("jsp/images/new/up.gif");
			list.add(ADDREES_UP);
		} else if ("1".equals(houseSellSortBean.getAddress_up())) {
			houseSellSortBean.setAddress_up("1");
			houseSellSortBean.setAddress_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setAddress_up("0");
			houseSellSortBean.setAddress_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("line_up"))
				&& "0".equals(request.getParameter("line_up"))) {
			houseSellSortBean.setLine_up("1");
			houseSellSortBean.setLine_image("jsp/images/new/down.gif");
			list.add(LINE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("line_up"))
				&& "1".equals(request.getParameter("line_up"))) {
			houseSellSortBean.setLine_up("0");
			houseSellSortBean.setLine_image("jsp/images/new/up.gif");
			list.add(LINE_UP);
		} else if ("1".equals(houseSellSortBean.getLine_up())) {
			houseSellSortBean.setLine_up("1");
			houseSellSortBean.setLine_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setLine_up("0");
			houseSellSortBean.setLine_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "0".equals(request.getParameter("walk_up"))) {
			houseSellSortBean.setWalk_up("1");
			houseSellSortBean.setWalk_image("jsp/images/new/down.gif");
			list.add(WALK_TIME_DOWN);
		} else if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "1".equals(request.getParameter("walk_up"))) {
			houseSellSortBean.setWalk_up("0");
			houseSellSortBean.setWalk_image("jsp/images/new/up.gif");
			list.add(WALK_TIME_UP);
		} else if ("1".equals(houseSellSortBean.getWalk_up())) {
			houseSellSortBean.setWalk_up("1");
			houseSellSortBean.setWalk_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setWalk_up("0");
			houseSellSortBean.setWalk_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "0".equals(request.getParameter("houseFee_up"))) {
			houseSellSortBean.setHouseFee_up("1");
			houseSellSortBean.setHouseFee_image("jsp/images/new/down.gif");
			list.add(HOUSE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "1".equals(request.getParameter("houseFee_up"))) {
			houseSellSortBean.setHouseFee_up("0");
			houseSellSortBean.setHouseFee_image("jsp/images/new/up.gif");
			list.add(HOUSE_FEE_UP);
		} else if ("1".equals(houseSellSortBean.getHouseFee_up())) {
			houseSellSortBean.setHouseFee_up("1");
			houseSellSortBean.setHouseFee_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setHouseFee_up("0");
			houseSellSortBean.setHouseFee_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "0".equals(request.getParameter("manageFee_up"))) {
			houseSellSortBean.setManageFee_up("1");
			houseSellSortBean.setManageFee_image("jsp/images/new/down.gif");
			list.add(MANAGE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "1".equals(request.getParameter("manageFee_up"))) {
			houseSellSortBean.setManageFee_up("0");
			houseSellSortBean.setManageFee_image("jsp/images/new/up.gif");
			list.add(MANAGE_FEE_UP);
		} else if ("1".equals(houseSellSortBean.getManageFee_image())) {
			houseSellSortBean.setManageFee_up("1");
			houseSellSortBean.setManageFee_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setManageFee_up("0");
			houseSellSortBean.setManageFee_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "0".equals(request.getParameter("deposit_up"))) {
			houseSellSortBean.setDeposit_up("1");
			houseSellSortBean.setDeposit_image("jsp/images/new/down.gif");
			list.add(DEPOSIT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "1".equals(request.getParameter("deposit_up"))) {
			houseSellSortBean.setDeposit_up("0");
			houseSellSortBean.setDeposit_image("jsp/images/new/up.gif");
			list.add(DEPOSIT_UP);
		} else if ("1".equals(houseSellSortBean.getDeposit_up())) {
			houseSellSortBean.setDeposit_up("1");
			houseSellSortBean.setDeposit_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setDeposit_up("0");
			houseSellSortBean.setDeposit_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "0".equals(request.getParameter("reikin_up"))) {
			houseSellSortBean.setReikin_up("1");
			houseSellSortBean.setReikin_image("jsp/images/new/down.gif");
			list.add(REIKIN_DOWN);
		} else if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "1".equals(request.getParameter("reikin_up"))) {
			houseSellSortBean.setReikin_up("0");
			houseSellSortBean.setReikin_image("jsp/images/new/up.gif");
			list.add(REIKIN_UP);
		} else if ("1".equals(houseSellSortBean.getReikin_up())) {
			houseSellSortBean.setReikin_up("1");
			houseSellSortBean.setReikin_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setReikin_up("0");
			houseSellSortBean.setReikin_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "0".equals(request.getParameter("guaranty_up"))) {
			houseSellSortBean.setGuaranty_up("1");
			houseSellSortBean.setGuaranty_image("jsp/images/new/down.gif");
			list.add(GUARANTY_MONEY_DOWN);
		} else if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "1".equals(request.getParameter("guaranty_up"))) {
			houseSellSortBean.setGuaranty_up("0");
			houseSellSortBean.setGuaranty_image("jsp/images/new/up.gif");
			list.add(GUARANTY_MONEY_UP);
		} else if ("1".equals(houseSellSortBean.getGuaranty_up())) {
			houseSellSortBean.setGuaranty_up("1");
			houseSellSortBean.setGuaranty_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setGuaranty_up("0");
			houseSellSortBean.setGuaranty_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "0".equals(request.getParameter("madori_up"))) {
			houseSellSortBean.setMadori_up("1");
			houseSellSortBean.setMadori_image("jsp/images/new/down.gif");
			list.add(MADORI_DOWN);
		} else if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "1".equals(request.getParameter("madori_up"))) {
			houseSellSortBean.setMadori_up("0");
			houseSellSortBean.setMadori_image("jsp/images/new/up.gif");
			list.add(MADORI_UP);
		} else if ("1".equals(houseSellSortBean.getMadori_up())) {
			houseSellSortBean.setMadori_up("1");
			houseSellSortBean.setMadori_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setMadori_up("0");
			houseSellSortBean.setMadori_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "0".equals(request.getParameter("dimension_up"))) {
			houseSellSortBean.setDimension_up("1");
			houseSellSortBean.setDimension_image("jsp/images/new/down.gif");
			list.add(DIMENSION_DOWN);
		} else if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "1".equals(request.getParameter("dimension_up"))) {
			houseSellSortBean.setDimension_up("0");
			houseSellSortBean.setDimension_image("jsp/images/new/up.gif");
			list.add(DIMENSION_UP);
		} else if ("1".equals(houseSellSortBean.getDimension_up())) {
			houseSellSortBean.setDimension_up("1");
			houseSellSortBean.setDimension_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setDimension_up("0");
			houseSellSortBean.setDimension_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "0".equals(request.getParameter("houseSort_up"))) {
			houseSellSortBean.setHouseSort_up("1");
			houseSellSortBean.setHouseSort_image("jsp/images/new/down.gif");
			list.add(HOUSE_SORT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "1".equals(request.getParameter("houseSort_up"))) {
			houseSellSortBean.setHouseSort_up("0");
			houseSellSortBean.setHouseSort_image("jsp/images/new/up.gif");
			list.add(HOUSE_SORT_UP);
		} else if ("1".equals(houseSellSortBean.getHouseSort_up())) {
			houseSellSortBean.setHouseSort_up("1");
			houseSellSortBean.setHouseSort_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setHouseSort_up("0");
			houseSellSortBean.setHouseSort_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "0".equals(request.getParameter("buildDate_up"))) {
			houseSellSortBean.setBuildDate_up("1");
			houseSellSortBean.setBuildDate_image("jsp/images/new/down.gif");
			list.add(BUILD_YEAR_DOWN);
		} else if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "1".equals(request.getParameter("buildDate_up"))) {
			houseSellSortBean.setBuildDate_up("0");
			houseSellSortBean.setBuildDate_image("jsp/images/new/up.gif");
			list.add(BUILD_YEAR_UP);
		} else if ("1".equals(houseSellSortBean.getBuildDate_up())) {
			houseSellSortBean.setBuildDate_up("1");
			houseSellSortBean.setBuildDate_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setBuildDate_up("0");
			houseSellSortBean.setBuildDate_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "0".equals(request.getParameter("userId_up"))) {
			houseSellSortBean.setUserId_up("1");
			houseSellSortBean.setUserId_image("jsp/images/new/down.gif");
			list.add(USER_ID_DOWN);
		} else if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "1".equals(request.getParameter("userId_up"))) {
			houseSellSortBean.setUserId_up("0");
			houseSellSortBean.setUserId_image("jsp/images/new/up.gif");
			list.add(USER_ID_UP);
		} else if ("1".equals(houseSellSortBean.getUserId_up())) {
			houseSellSortBean.setUserId_up("1");
			houseSellSortBean.setUserId_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setUserId_up("0");
			houseSellSortBean.setUserId_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "0".equals(request.getParameter("registDate_up"))) {
			houseSellSortBean.setRegistDate_up("1");
			houseSellSortBean.setRegistDate_image("jsp/images/new/down.gif");
			list.add(REGIST_DATE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "1".equals(request.getParameter("registDate_up"))) {
			houseSellSortBean.setRegistDate_up("0");
			houseSellSortBean.setRegistDate_image("jsp/images/new/up.gif");
			list.add(REGIST_DATE_UP);
		} else if ("1".equals(houseSellSortBean.getRegistDate_up())) {
			houseSellSortBean.setRegistDate_up("1");
			houseSellSortBean.setRegistDate_image("jsp/images/new/down.gif");
		} else {
			houseSellSortBean.setRegistDate_up("0");
			houseSellSortBean.setRegistDate_image("jsp/images/new/up.gif");
		}
	}
}