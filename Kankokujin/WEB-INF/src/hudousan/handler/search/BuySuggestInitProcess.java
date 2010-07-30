package hudousan.handler.search;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.constant.Const;
import common.exception.AppException;
import common.page.PageUtil;
import common.util.Util;

import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;
import hudousan.common.HudousanUtil;
import hudousan.handler.HudousanSearchHandler;
import hudousan.handler.RequestProcess;

public class BuySuggestInitProcess extends RequestProcess {



	@Override
	public String execute(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = HudousanUtil.newCreateSession(request);
		HudousanSortBean sortBean = new HudousanSortBean();
		/** ページ情報 */
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, "10");

		List hudousanBeanList = null;
		HudousanSearchHandler hudousanSearchHandler = HudousanSearchHandler.getInstance();
		try {
			hudousanBeanList = hudousanSearchHandler.getHudousanBeanListSuggert(pageBean, sortBean, "0");
		} catch (AppException e) {
			e.printStackTrace();
			//throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			//throw new KankokujinException("HouseSellListAction", e);
		}
		request.setAttribute("mode", "SuggestMode");
		request.setAttribute("leaseSign", "0");
		session.setAttribute("PageBean", pageBean);
		request.setAttribute("HudousanBeanList", hudousanBeanList);
		
		return "/jsp/hudousan/leaseBuySearch.jsp";
	}
	
	
	/**
	 * 
	 * @param searchBean
	 * @param request
	 */
	private void setSearchBean(HudousanSearchBean searchBean,
			HttpServletRequest request) {

		if (!Util.isEmpty(request.getParameter("house_fee_from"))) {
			searchBean.setHouse_fee(0, request.getParameter("house_fee_from"));
		}
		if (!Util.isEmpty(request.getParameter("house_fee_to"))) {
			searchBean.setHouse_fee(1, request.getParameter("house_fee_to"));
		}

		if (!Util.isEmpty(request.getParameter("search_area_code_1"))) {
			searchBean.setArea_code_1(request.getParameter("search_area_code_1"));
		}
		if ("00".equals(searchBean.getArea_code_1())) {
			searchBean.setArea_code_2("0000");
		} else {
			searchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(request.getParameter("search_line_code"))) {
			searchBean.setLine_code(request.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_station_code"))) {
			searchBean.setStation_code(request.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_walk_time"))) {
			searchBean.setWalk_time(request.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(request.getParameter("search_regist_date"))) {
			searchBean.setRegist_date(request.getParameter("search_regist_date"));
		} else {
			searchBean.setRegist_date("3");
		}
		if (!Util.isEmpty(request.getParameter("dimension_1"))) {
			searchBean.setDimension(0, request.getParameter("dimension_1"));
		}
		if (!Util.isEmpty(request.getParameter("dimension_2"))) {
			searchBean.setDimension(1, request.getParameter("dimension_2"));
		}
		searchBean.setUser_id(request.getParameter("user_id"));

		if (!Util.isEmpty(request.getParameter("madori_0"))
				&& "0".equals(request.getParameter("madori_0"))) {
			searchBean.setMadori(0, "0");
		}
		if (!Util.isEmpty(request.getParameter("madori_1"))
				&& "1".equals(request.getParameter("madori_1"))) {
			searchBean.setMadori(1, "1");
		}
		if (!Util.isEmpty(request.getParameter("madori_2"))
				&& "2".equals(request.getParameter("madori_2"))) {
			searchBean.setMadori(2, "2");
		}
		if (!Util.isEmpty(request.getParameter("madori_3"))
				&& "3".equals(request.getParameter("madori_3"))) {
			searchBean.setMadori(3, "3");
		}
		if (!Util.isEmpty(request.getParameter("madori_4"))
				&& "4".equals(request.getParameter("madori_4"))) {
			searchBean.setMadori(4, "4");
		}
		if (!Util.isEmpty(request.getParameter("madori_5"))
				&& "5".equals(request.getParameter("madori_5"))) {
			searchBean.setMadori(5, "5");
		}
		if (!Util.isEmpty(request.getParameter("madori_6"))
				&& "6".equals(request.getParameter("madori_6"))) {
			searchBean.setMadori(6, "6");
		}
		if (!Util.isEmpty(request.getParameter("madori_7"))
				&& "7".equals(request.getParameter("madori_7"))) {
			searchBean.setMadori(7, "7");
		}
		if (!Util.isEmpty(request.getParameter("madori_8"))
				&& "8".equals(request.getParameter("madori_8"))) {
			searchBean.setMadori(8, "8");
		}
		if (!Util.isEmpty(request.getParameter("madori_9"))
				&& "9".equals(request.getParameter("madori_9"))) {
			searchBean.setMadori(9, "9");
		}
		if (!Util.isEmpty(request.getParameter("madori_10"))
				&& "10".equals(request.getParameter("madori_10"))) {
			searchBean.setMadori(10, "10");
		}
		if (!Util.isEmpty(request.getParameter("madori_11"))
				&& "11".equals(request.getParameter("madori_11"))) {
			searchBean.setMadori(11, "11");
		}

		if (!Util.isEmpty(request.getParameter("search_flg_tadami"))) {
			searchBean.setFlg_tadami(request.getParameter("search_flg_tadami"));
		}
		if (!Util.isEmpty(request.getParameter("search_build_year"))) {
			searchBean.setBuild_year(request.getParameter("search_build_year"));
		}
		if (!Util.isEmpty(request.getParameter("search_toilet"))) {
			searchBean.setToilet(request.getParameter("search_toilet"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_0"))
				&& "0".equals(request.getParameter("house_sort_0"))) {
			searchBean.setHouse_sort(0, request.getParameter("house_sort_0"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_1"))
				&& "1".equals(request.getParameter("house_sort_1"))) {
			searchBean.setHouse_sort(1, request.getParameter("house_sort_1"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_2"))
				&& "2".equals(request.getParameter("house_sort_2"))) {
			searchBean.setHouse_sort(2, request.getParameter("house_sort_2"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_3"))
				&& "3".equals(request.getParameter("house_sort_3"))) {
			searchBean.setHouse_sort(3, request.getParameter("house_sort_3"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_4"))
				&& "4".equals(request.getParameter("house_sort_4"))) {
			searchBean.setHouse_sort(4, request.getParameter("house_sort_4"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_5"))
				&& "5".equals(request.getParameter("house_sort_5"))) {
			searchBean.setHouse_sort(5, request.getParameter("house_sort_5"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_6"))
				&& "6".equals(request.getParameter("house_sort_6"))) {
			searchBean.setHouse_sort(6, request.getParameter("house_sort_6"));
		}
		if (!Util.isEmpty(request.getParameter("house_sort_7"))
				&& "7".equals(request.getParameter("house_sort_7"))) {
			searchBean.setHouse_sort(7, request.getParameter("house_sort_7"));
		}
		if (!Util.isEmpty(request.getParameter("pageSize"))) {
			searchBean.setPageSize(request.getParameter("pageSize"));
		}

		if (!Util.isEmpty(request.getParameter("house_option_0"))
				&& "1".equals(request.getParameter("house_option_0"))) {
			searchBean.setHouse_option(0, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_1"))
				&& "1".equals(request.getParameter("house_option_1"))) {
			searchBean.setHouse_option(1, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_2"))
				&& "1".equals(request.getParameter("house_option_2"))) {
			searchBean.setHouse_option(2, "1");
		}
		if (!Util.isEmpty(request.getParameter("house_option_3"))
				&& "1".equals(request.getParameter("house_option_3"))) {
			searchBean.setHouse_option(3, "1");
		}
		if ("0".equals(request.getParameter("re"))) {
			searchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))) {
			searchBean.setStation_code("0000");
		}
	}
	
	
	/**
	 * list画面のsortの形を変更する
	 * 
	 * @param houseSellSortBean
	 *            基本値は0で一回クリックしたら形が変更する
	 * @return imageの変更になったbeanの値
	 */
	private void changeSort(HudousanSortBean sortBean,
			HttpServletRequest request) {
		
		
		
		List<String> list = sortBean.getSortList();
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
			sortBean.setAddress_up("1");
			sortBean.setAddress_image("jsp/images/new/down.gif");
			list.add(ADDREES_DOWN);
		} else if (!Util.isEmpty(request.getParameter("address_up"))
				&& "1".equals(request.getParameter("address_up"))) {
			sortBean.setAddress_up("0");
			sortBean.setAddress_image("jsp/images/new/up.gif");
			list.add(ADDREES_UP);
		} else if ("1".equals(sortBean.getAddress_up())) {
			sortBean.setAddress_up("1");
			sortBean.setAddress_image("jsp/images/new/down.gif");
		} else {
			sortBean.setAddress_up("0");
			sortBean.setAddress_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("line_up"))
				&& "0".equals(request.getParameter("line_up"))) {
			sortBean.setLine_up("1");
			sortBean.setLine_image("jsp/images/new/down.gif");
			list.add(LINE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("line_up"))
				&& "1".equals(request.getParameter("line_up"))) {
			sortBean.setLine_up("0");
			sortBean.setLine_image("jsp/images/new/up.gif");
			list.add(LINE_UP);
		} else if ("1".equals(sortBean.getLine_up())) {
			sortBean.setLine_up("1");
			sortBean.setLine_image("jsp/images/new/down.gif");
		} else {
			sortBean.setLine_up("0");
			sortBean.setLine_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "0".equals(request.getParameter("walk_up"))) {
			sortBean.setWalk_up("1");
			sortBean.setWalk_image("jsp/images/new/down.gif");
			list.add(WALK_TIME_DOWN);
		} else if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "1".equals(request.getParameter("walk_up"))) {
			sortBean.setWalk_up("0");
			sortBean.setWalk_image("jsp/images/new/up.gif");
			list.add(WALK_TIME_UP);
		} else if ("1".equals(sortBean.getWalk_up())) {
			sortBean.setWalk_up("1");
			sortBean.setWalk_image("jsp/images/new/down.gif");
		} else {
			sortBean.setWalk_up("0");
			sortBean.setWalk_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "0".equals(request.getParameter("houseFee_up"))) {
			sortBean.setHouseFee_up("1");
			sortBean.setHouseFee_image("jsp/images/new/down.gif");
			list.add(HOUSE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "1".equals(request.getParameter("houseFee_up"))) {
			sortBean.setHouseFee_up("0");
			sortBean.setHouseFee_image("jsp/images/new/up.gif");
			list.add(HOUSE_FEE_UP);
		} else if ("1".equals(sortBean.getHouseFee_up())) {
			sortBean.setHouseFee_up("1");
			sortBean.setHouseFee_image("jsp/images/new/down.gif");
		} else {
			sortBean.setHouseFee_up("0");
			sortBean.setHouseFee_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "0".equals(request.getParameter("manageFee_up"))) {
			sortBean.setManageFee_up("1");
			sortBean.setManageFee_image("jsp/images/new/down.gif");
			list.add(MANAGE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "1".equals(request.getParameter("manageFee_up"))) {
			sortBean.setManageFee_up("0");
			sortBean.setManageFee_image("jsp/images/new/up.gif");
			list.add(MANAGE_FEE_UP);
		} else if ("1".equals(sortBean.getManageFee_image())) {
			sortBean.setManageFee_up("1");
			sortBean.setManageFee_image("jsp/images/new/down.gif");
		} else {
			sortBean.setManageFee_up("0");
			sortBean.setManageFee_image("jsp/images/new/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "0".equals(request.getParameter("deposit_up"))) {
			sortBean.setDeposit_up("1");
			sortBean.setDeposit_image("jsp/images/new/down.gif");
			list.add(DEPOSIT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "1".equals(request.getParameter("deposit_up"))) {
			sortBean.setDeposit_up("0");
			sortBean.setDeposit_image("jsp/images/new/up.gif");
			list.add(DEPOSIT_UP);
		} else if ("1".equals(sortBean.getDeposit_up())) {
			sortBean.setDeposit_up("1");
			sortBean.setDeposit_image("jsp/images/new/down.gif");
		} else {
			sortBean.setDeposit_up("0");
			sortBean.setDeposit_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "0".equals(request.getParameter("reikin_up"))) {
			sortBean.setReikin_up("1");
			sortBean.setReikin_image("jsp/images/new/down.gif");
			list.add(REIKIN_DOWN);
		} else if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "1".equals(request.getParameter("reikin_up"))) {
			sortBean.setReikin_up("0");
			sortBean.setReikin_image("jsp/images/new/up.gif");
			list.add(REIKIN_UP);
		} else if ("1".equals(sortBean.getReikin_up())) {
			sortBean.setReikin_up("1");
			sortBean.setReikin_image("jsp/images/new/down.gif");
		} else {
			sortBean.setReikin_up("0");
			sortBean.setReikin_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "0".equals(request.getParameter("guaranty_up"))) {
			sortBean.setGuaranty_up("1");
			sortBean.setGuaranty_image("jsp/images/new/down.gif");
			list.add(GUARANTY_MONEY_DOWN);
		} else if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "1".equals(request.getParameter("guaranty_up"))) {
			sortBean.setGuaranty_up("0");
			sortBean.setGuaranty_image("jsp/images/new/up.gif");
			list.add(GUARANTY_MONEY_UP);
		} else if ("1".equals(sortBean.getGuaranty_up())) {
			sortBean.setGuaranty_up("1");
			sortBean.setGuaranty_image("jsp/images/new/down.gif");
		} else {
			sortBean.setGuaranty_up("0");
			sortBean.setGuaranty_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "0".equals(request.getParameter("madori_up"))) {
			sortBean.setMadori_up("1");
			sortBean.setMadori_image("jsp/images/new/down.gif");
			list.add(MADORI_DOWN);
		} else if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "1".equals(request.getParameter("madori_up"))) {
			sortBean.setMadori_up("0");
			sortBean.setMadori_image("jsp/images/new/up.gif");
			list.add(MADORI_UP);
		} else if ("1".equals(sortBean.getMadori_up())) {
			sortBean.setMadori_up("1");
			sortBean.setMadori_image("jsp/images/new/down.gif");
		} else {
			sortBean.setMadori_up("0");
			sortBean.setMadori_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "0".equals(request.getParameter("dimension_up"))) {
			sortBean.setDimension_up("1");
			sortBean.setDimension_image("jsp/images/new/down.gif");
			list.add(DIMENSION_DOWN);
		} else if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "1".equals(request.getParameter("dimension_up"))) {
			sortBean.setDimension_up("0");
			sortBean.setDimension_image("jsp/images/new/up.gif");
			list.add(DIMENSION_UP);
		} else if ("1".equals(sortBean.getDimension_up())) {
			sortBean.setDimension_up("1");
			sortBean.setDimension_image("jsp/images/new/down.gif");
		} else {
			sortBean.setDimension_up("0");
			sortBean.setDimension_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "0".equals(request.getParameter("houseSort_up"))) {
			sortBean.setHouseSort_up("1");
			sortBean.setHouseSort_image("jsp/images/new/down.gif");
			list.add(HOUSE_SORT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "1".equals(request.getParameter("houseSort_up"))) {
			sortBean.setHouseSort_up("0");
			sortBean.setHouseSort_image("jsp/images/new/up.gif");
			list.add(HOUSE_SORT_UP);
		} else if ("1".equals(sortBean.getHouseSort_up())) {
			sortBean.setHouseSort_up("1");
			sortBean.setHouseSort_image("jsp/images/new/down.gif");
		} else {
			sortBean.setHouseSort_up("0");
			sortBean.setHouseSort_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "0".equals(request.getParameter("buildDate_up"))) {
			sortBean.setBuildDate_up("1");
			sortBean.setBuildDate_image("jsp/images/new/down.gif");
			list.add(BUILD_YEAR_DOWN);
		} else if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "1".equals(request.getParameter("buildDate_up"))) {
			sortBean.setBuildDate_up("0");
			sortBean.setBuildDate_image("jsp/images/new/up.gif");
			list.add(BUILD_YEAR_UP);
		} else if ("1".equals(sortBean.getBuildDate_up())) {
			sortBean.setBuildDate_up("1");
			sortBean.setBuildDate_image("jsp/images/new/down.gif");
		} else {
			sortBean.setBuildDate_up("0");
			sortBean.setBuildDate_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "0".equals(request.getParameter("userId_up"))) {
			sortBean.setUserId_up("1");
			sortBean.setUserId_image("jsp/images/new/down.gif");
			list.add(USER_ID_DOWN);
		} else if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "1".equals(request.getParameter("userId_up"))) {
			sortBean.setUserId_up("0");
			sortBean.setUserId_image("jsp/images/new/up.gif");
			list.add(USER_ID_UP);
		} else if ("1".equals(sortBean.getUserId_up())) {
			sortBean.setUserId_up("1");
			sortBean.setUserId_image("jsp/images/new/down.gif");
		} else {
			sortBean.setUserId_up("0");
			sortBean.setUserId_image("jsp/images/new/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "0".equals(request.getParameter("registDate_up"))) {
			sortBean.setRegistDate_up("1");
			sortBean.setRegistDate_image("jsp/images/new/down.gif");
			list.add(REGIST_DATE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "1".equals(request.getParameter("registDate_up"))) {
			sortBean.setRegistDate_up("0");
			sortBean.setRegistDate_image("jsp/images/new/up.gif");
			list.add(REGIST_DATE_UP);
		} else if ("1".equals(sortBean.getRegistDate_up())) {
			sortBean.setRegistDate_up("1");
			sortBean.setRegistDate_image("jsp/images/new/down.gif");
		} else {
			sortBean.setRegistDate_up("0");
			sortBean.setRegistDate_image("jsp/images/new/up.gif");
		}
	}

	

}
