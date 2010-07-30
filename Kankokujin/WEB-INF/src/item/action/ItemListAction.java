package item.action;

import housesell.bean.HouseBean;
import housesell.bean.HouseSellSortBean;
import item.handler.ItemHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.bean.CategoryBean;
import category.handler.CategoryHandler;

import common.bean.PageBean;
import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class ItemListAction extends HttpServlet {
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
		try {
			KankokujinLogger.getInstance().debug("ItemListAction.start");
			String cate_code = request.getParameter("cate_code");
			
			if (Util.isEmpty(cate_code)){
				cate_code  = (String) request.getAttribute("cate_code");	
				if (Util.isEmpty(cate_code) || "null".equals(cate_code)){
					cate_code = "";
				}
			}
				
			HttpSession session = request.getSession();
			String sort_code = request.getParameter("sort_code");
			if (Util.isEmpty(sort_code)) {
				sort_code = (String) session.getAttribute("sort_code");
				if (sort_code == null) {
					sort_code = "1";
				}
			} else {
				session.setAttribute("sort_Code", sort_code);
				CategoryHandler category = new CategoryHandler();
				session.setAttribute("categoryMap", category.getCategoryMap(sort_code));
			}

			CategoryHandler categoryHandler = new CategoryHandler();
			Map map = categoryHandler.getCategoryMap(sort_code);
			String menu_tag = categoryHandler.getMenuTag(sort_code, cate_code, map);
			request.setAttribute("MenuTag", menu_tag);
			
			ItemHandler handler = new ItemHandler();


			ArrayList itemList = null;
			
			itemList = handler.getItemList(sort_code, cate_code, "");

			String categorySelect = "";

			if("".equals(cate_code)) {
				cate_code = "0001";
				categorySelect = categoryHandler.changCateListToTag(cate_code,map, 14, "", "", "");
			} else {
				categorySelect = categoryHandler.getAllViewTag(cate_code,map, 14, "", "", "");
			}
			
			request.setAttribute("CategorySelect", categorySelect);
			
			request.setAttribute("cate_code", cate_code);
			
			request.setAttribute("itemList", itemList);
			CategoryBean cateForm= (CategoryBean)map.get(cate_code);
			String viewSort = "";
			if (cateForm == null) {
				viewSort = "1";
			} else {			
				viewSort = cateForm.getView_sort();
			}

//		} catch (AppException e) {
//			throw new KankokujinException("HouseSellListAction", e);
		} catch (Exception e) {
			throw new KankokujinException("ItemListAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("ItemListAction.end");
		}
//		this.getServletContext().getRequestDispatcher(
//				"/jsp/item/itemList.jsp").forward(request, response);
		this.getServletContext().getRequestDispatcher(
		"/StoreList").forward(request, response);		

	}

	private void setMenuCategory(){
		
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

	/**
	 * HouseBeanに関してnull及び“”の値がなければ値を入力する
	 * 
	 * @param bean,houseSellSortBean,request
	 * @return beanの値
	 */

	private void setHouseBean(HouseBean bean,
			HouseSellSortBean houseSellSortBean, HttpServletRequest request) {

		String[] house_fee = new String[] { "", "" };
		if (!Util.isEmpty(request.getParameter("house_fee_from"))) {
			house_fee[0] = request.getParameter("house_fee_from");
		}
		if (!Util.isEmpty(request.getParameter("house_fee_to"))) {
			house_fee[1] = request.getParameter("house_fee_to");
		}
		bean.setHouse_fee(house_fee);

		if (!Util.isEmpty(request.getParameter("area_code_1"))) {
			bean.setArea_code_1(request.getParameter("area_code_1"));
		}
		if (!Util.isEmpty(request.getParameter("area_code_2"))) {
			bean.setArea_code_2(request.getParameter("area_code_2"));
		}

		if (!Util.isEmpty(request.getParameter("line_code"))) {
			bean.setLine_code(request.getParameter("line_code"));
		}
		if (!Util.isEmpty(request.getParameter("station_code"))) {
			bean.setStation_code(request.getParameter("station_code"));
		}
		if (!Util.isEmpty(request.getParameter("walk_time"))) {
			bean.setWalk_time(request.getParameter("walk_time"));
		}
/*		if (!Util.isEmpty(request.getParameter("regist_date"))) {
			bean.setRegist_date(request.getParameter("regist_date"));
		}
		if (!Util.isEmpty(request.getParameter("regist_date"))) {
			bean.setRegist_date(request.getParameter("regist_date"));
		} else {
			bean.setRegist_date("1");
		}*/
		String[] dimension = new String[] { "", "" };
		if (!Util.isEmpty(request.getParameter("dimension_1"))) {
			dimension[0] = request.getParameter("dimension_1");
		}
		if (!Util.isEmpty(request.getParameter("dimension_2"))) {
			dimension[1] = request.getParameter("dimension_2");
		}
		bean.setDimension(dimension);
		String[] madori = new String[] { "", "", "", "", "", "", "", "", "",
				"", "", "" };
		if (!Util.isEmpty(request.getParameter("madori_0"))) {
			madori[0] = request.getParameter("madori_0");
		}
		if (!Util.isEmpty(request.getParameter("madori_1"))) {
			madori[1] = request.getParameter("madori_1");
		}
		if (!Util.isEmpty(request.getParameter("madori_2"))) {
			madori[2] = request.getParameter("madori_2");
		}
		if (!Util.isEmpty(request.getParameter("madori_3"))) {
			madori[3] = request.getParameter("madori_3");
		}
		if (!Util.isEmpty(request.getParameter("madori_4"))) {
			madori[4] = request.getParameter("madori_4");
		}
		if (!Util.isEmpty(request.getParameter("madori_5"))) {
			madori[5] = request.getParameter("madori_5");
		}
		if (!Util.isEmpty(request.getParameter("madori_6"))) {
			madori[6] = request.getParameter("madori_6");
		}
		if (!Util.isEmpty(request.getParameter("madori_7"))) {
			madori[7] = request.getParameter("madori_7");
		}
		if (!Util.isEmpty(request.getParameter("madori_8"))) {
			madori[8] = request.getParameter("madori_8");
		}
		if (!Util.isEmpty(request.getParameter("madori_9"))) {
			madori[9] = request.getParameter("madori_9");
		}
		if (!Util.isEmpty(request.getParameter("madori_10"))) {
			madori[10] = request.getParameter("madori_10");
		}
		if (!Util.isEmpty(request.getParameter("madori_11"))) {
			madori[11] = request.getParameter("madori_11");
		}
		//bean.setMadori(madori);

		if (!Util.isEmpty(request.getParameter("flg_tadami"))) {
			bean.setFlg_tadami(request.getParameter("flg_tadami"));
		}
		if (!Util.isEmpty(request.getParameter("flg_tadami"))) {
			bean.setFlg_tadami(request.getParameter("flg_tadami"));
		}
		if (!Util.isEmpty(request.getParameter("build_year"))) {
			bean.setBuild_year(request.getParameter("build_year"));
		}
		String[] toilet = new String[] { "", "", "", "" };
		if (!Util.isEmpty(request.getParameter("toilet"))) {
			String temp = request.getParameter("toilet");
			try {
				int index = Integer.parseInt(temp);
				toilet[index] = temp;
			} catch (Exception e) {
			}
		}
		//bean.setToilet(toilet);
		String[] house_sort = new String[] { "", "", "", "", "", "", "", "" };
		if (!Util.isEmpty(request.getParameter("house_sort_0"))) {
			house_sort[0] = request.getParameter("house_sort_0");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_1"))) {
			house_sort[1] = request.getParameter("house_sort_1");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_2"))) {
			house_sort[2] = request.getParameter("house_sort_2");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_3"))) {
			house_sort[3] = request.getParameter("house_sort_3");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_4"))) {
			house_sort[4] = request.getParameter("house_sort_4");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_5"))) {
			house_sort[5] = request.getParameter("house_sort_5");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_6"))) {
			house_sort[6] = request.getParameter("house_sort_6");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_7"))) {
			house_sort[7] = request.getParameter("house_sort_7");
		}
		//bean.setHouse_sort(house_sort);

		if (!Util.isEmpty(request.getParameter("stairs"))) {
			bean.setStairs(request.getParameter("stairs"));
		}
	/*	if (!Util.isEmpty(request.getParameter("pageSize"))) {
			bean.setPageSize(request.getParameter("pageSize"));
		}*/

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
		final String REGIST_DATE_UP = Const.SPACE + Const.REGIST_DATE
				+ Const.SPACE + Const.ASC + Const.SPACE;
		final String REGIST_DATE_DOWN = Const.SPACE + Const.REGIST_DATE
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String ADDREES_UP = Const.SPACE + Const.AREA_CODE_1 + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String ADDREES_DOWN = Const.SPACE + Const.AREA_CODE_1
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String LINE_UP = Const.SPACE + Const.LINE_CODE + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String LINE_DOWN = Const.SPACE + Const.LINE_CODE + Const.SPACE
				+ Const.DESC + Const.SPACE;
		final String WALK_TIME_UP = Const.SPACE + Const.WALK_TIME + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String WALK_TIME_DOWN = Const.SPACE + Const.WALK_TIME
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String HOUSE_FEE_UP = Const.SPACE + Const.HOUSE_FEE + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String HOUSE_FEE_DOWN = Const.SPACE + Const.HOUSE_FEE
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String MANAGE_FEE_UP = Const.SPACE + Const.MANAGE_FEE
				+ Const.SPACE + Const.ASC + Const.SPACE;
		final String MANAGE_FEE_DOWN = Const.SPACE + Const.MANAGE_FEE
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String DEPOSIT_UP = Const.SPACE + Const.DEPOSIT + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String DEPOSIT_DOWN = Const.SPACE + Const.DEPOSIT + Const.SPACE
				+ Const.DESC + Const.SPACE;
		final String REIKIN_UP = Const.SPACE + Const.REIKIN + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String REIKIN_DOWN = Const.SPACE + Const.REIKIN + Const.SPACE
				+ Const.DESC + Const.SPACE;
		final String GUARANTY_MONEY_UP = Const.SPACE + Const.GUARANTY_MONEY
				+ Const.SPACE + Const.ASC + Const.SPACE;
		final String GUARANTY_MONEY_DOWN = Const.SPACE + Const.GUARANTY_MONEY
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String MADORI_UP = Const.SPACE + Const.MADORI + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String MADORI_DOWN = Const.SPACE + Const.MADORI + Const.SPACE
				+ Const.DESC + Const.SPACE;
		final String DIMENSION_UP = Const.SPACE + Const.DIMENSION + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String DIMENSION_DOWN = Const.SPACE + Const.DIMENSION
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String HOUSE_SORT_UP = Const.SPACE + Const.HOUSE_SORT
				+ Const.SPACE + Const.ASC + Const.SPACE;
		final String HOUSE_SORT_DOWN = Const.SPACE + Const.HOUSE_SORT
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String BUILD_YEAR_UP = Const.SPACE + Const.BUILD_YEAR
				+ Const.SPACE + Const.ASC + Const.SPACE;
		final String BUILD_YEAR_DOWN = Const.SPACE + Const.BUILD_YEAR
				+ Const.SPACE + Const.DESC + Const.SPACE;
		final String USER_ID_UP = Const.SPACE + Const.USER_ID + Const.SPACE
				+ Const.ASC + Const.SPACE;
		final String USER_ID_DOWN = Const.SPACE + Const.USER_ID + Const.SPACE
				+ Const.DESC + Const.SPACE;
		if (list.size() == 0) {
			list.add(REGIST_DATE_DOWN);
		}
		if (!Util.isEmpty(request.getParameter("address_up"))
				&& "0".equals(request.getParameter("address_up"))) {
			houseSellSortBean.setAddress_up("1");
			houseSellSortBean.setAddress_image("jsp/images/common/down.gif");
			list.add(ADDREES_DOWN);
		} else if (!Util.isEmpty(request.getParameter("address_up"))
				&& "1".equals(request.getParameter("address_up"))) {
			houseSellSortBean.setAddress_up("0");
			houseSellSortBean.setAddress_image("jsp/images/common/up.gif");
			list.add(ADDREES_UP);
		} else if ("1".equals(houseSellSortBean.getAddress_up())) {
			houseSellSortBean.setAddress_up("1");
			houseSellSortBean.setAddress_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setAddress_up("0");
			houseSellSortBean.setAddress_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("line_up"))
				&& "0".equals(request.getParameter("line_up"))) {
			houseSellSortBean.setLine_up("1");
			houseSellSortBean.setLine_image("jsp/images/common/down.gif");
			list.add(LINE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("line_up"))
				&& "1".equals(request.getParameter("line_up"))) {
			houseSellSortBean.setLine_up("0");
			houseSellSortBean.setLine_image("jsp/images/common/up.gif");
			list.add(LINE_UP);
		} else if ("1".equals(houseSellSortBean.getLine_up())) {
			houseSellSortBean.setLine_up("1");
			houseSellSortBean.setLine_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setLine_up("0");
			houseSellSortBean.setLine_image("jsp/images/common/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "0".equals(request.getParameter("walk_up"))) {
			houseSellSortBean.setWalk_up("1");
			houseSellSortBean.setWalk_image("jsp/images/common/down.gif");
			list.add(WALK_TIME_DOWN);
		} else if (!Util.isEmpty(request.getParameter("walk_up"))
				&& "1".equals(request.getParameter("walk_up"))) {
			houseSellSortBean.setWalk_up("0");
			houseSellSortBean.setWalk_image("jsp/images/common/up.gif");
			list.add(WALK_TIME_UP);
		} else if ("1".equals(houseSellSortBean.getWalk_up())) {
			houseSellSortBean.setWalk_up("1");
			houseSellSortBean.setWalk_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setWalk_up("0");
			houseSellSortBean.setWalk_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "0".equals(request.getParameter("houseFee_up"))) {
			houseSellSortBean.setHouseFee_up("1");
			houseSellSortBean.setHouseFee_image("jsp/images/common/down.gif");
			list.add(HOUSE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseFee_up"))
				&& "1".equals(request.getParameter("houseFee_up"))) {
			houseSellSortBean.setHouseFee_up("0");
			houseSellSortBean.setHouseFee_image("jsp/images/common/up.gif");
			list.add(HOUSE_FEE_UP);
		} else if ("1".equals(houseSellSortBean.getHouseFee_up())) {
			houseSellSortBean.setHouseFee_up("1");
			houseSellSortBean.setHouseFee_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setHouseFee_up("0");
			houseSellSortBean.setHouseFee_image("jsp/images/common/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "0".equals(request.getParameter("manageFee_up"))) {
			houseSellSortBean.setManageFee_up("1");
			houseSellSortBean.setManageFee_image("jsp/images/common/down.gif");
			list.add(MANAGE_FEE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("manageFee_up"))
				&& "1".equals(request.getParameter("manageFee_up"))) {
			houseSellSortBean.setManageFee_up("0");
			houseSellSortBean.setManageFee_image("jsp/images/common/up.gif");
			list.add(MANAGE_FEE_UP);
		} else if ("1".equals(houseSellSortBean.getManageFee_image())) {
			houseSellSortBean.setManageFee_up("1");
			houseSellSortBean.setManageFee_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setManageFee_up("0");
			houseSellSortBean.setManageFee_image("jsp/images/common/up.gif");
		}

		if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "0".equals(request.getParameter("deposit_up"))) {
			houseSellSortBean.setDeposit_up("1");
			houseSellSortBean.setDeposit_image("jsp/images/common/down.gif");
			list.add(DEPOSIT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("deposit_up"))
				&& "1".equals(request.getParameter("deposit_up"))) {
			houseSellSortBean.setDeposit_up("0");
			houseSellSortBean.setDeposit_image("jsp/images/common/up.gif");
			list.add(DEPOSIT_UP);
		} else if ("1".equals(houseSellSortBean.getDeposit_up())) {
			houseSellSortBean.setDeposit_up("1");
			houseSellSortBean.setDeposit_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setDeposit_up("0");
			houseSellSortBean.setDeposit_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "0".equals(request.getParameter("reikin_up"))) {
			houseSellSortBean.setReikin_up("1");
			houseSellSortBean.setReikin_image("jsp/images/common/down.gif");
			list.add(REIKIN_DOWN);
		} else if (!Util.isEmpty(request.getParameter("reikin_up"))
				&& "1".equals(request.getParameter("reikin_up"))) {
			houseSellSortBean.setReikin_up("0");
			houseSellSortBean.setReikin_image("jsp/images/common/up.gif");
			list.add(REIKIN_UP);
		} else if ("1".equals(houseSellSortBean.getReikin_up())) {
			houseSellSortBean.setReikin_up("1");
			houseSellSortBean.setReikin_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setReikin_up("0");
			houseSellSortBean.setReikin_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "0".equals(request.getParameter("guaranty_up"))) {
			houseSellSortBean.setGuaranty_up("1");
			houseSellSortBean.setGuaranty_image("jsp/images/common/down.gif");
			list.add(GUARANTY_MONEY_DOWN);
		} else if (!Util.isEmpty(request.getParameter("guaranty_up"))
				&& "1".equals(request.getParameter("guaranty_up"))) {
			houseSellSortBean.setGuaranty_up("0");
			houseSellSortBean.setGuaranty_image("jsp/images/common/up.gif");
			list.add(GUARANTY_MONEY_UP);
		} else if ("1".equals(houseSellSortBean.getGuaranty_up())) {
			houseSellSortBean.setGuaranty_up("1");
			houseSellSortBean.setGuaranty_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setGuaranty_up("0");
			houseSellSortBean.setGuaranty_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "0".equals(request.getParameter("madori_up"))) {
			houseSellSortBean.setMadori_up("1");
			houseSellSortBean.setMadori_image("jsp/images/common/down.gif");
			list.add(MADORI_DOWN);
		} else if (!Util.isEmpty(request.getParameter("madori_up"))
				&& "1".equals(request.getParameter("madori_up"))) {
			houseSellSortBean.setMadori_up("0");
			houseSellSortBean.setMadori_image("jsp/images/common/up.gif");
			list.add(MADORI_UP);
		} else if ("1".equals(houseSellSortBean.getMadori_up())) {
			houseSellSortBean.setMadori_up("1");
			houseSellSortBean.setMadori_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setMadori_up("0");
			houseSellSortBean.setMadori_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "0".equals(request.getParameter("dimension_up"))) {
			houseSellSortBean.setDimension_up("1");
			houseSellSortBean.setDimension_image("jsp/images/common/down.gif");
			list.add(DIMENSION_DOWN);
		} else if (!Util.isEmpty(request.getParameter("dimension_up"))
				&& "1".equals(request.getParameter("dimension_up"))) {
			houseSellSortBean.setDimension_up("0");
			houseSellSortBean.setDimension_image("jsp/images/common/up.gif");
			list.add(DIMENSION_UP);
		} else if ("1".equals(houseSellSortBean.getDimension_up())) {
			houseSellSortBean.setDimension_up("1");
			houseSellSortBean.setDimension_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setDimension_up("0");
			houseSellSortBean.setDimension_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "0".equals(request.getParameter("houseSort_up"))) {
			houseSellSortBean.setHouseSort_up("1");
			houseSellSortBean.setHouseSort_image("jsp/images/common/down.gif");
			list.add(HOUSE_SORT_DOWN);
		} else if (!Util.isEmpty(request.getParameter("houseSort_up"))
				&& "1".equals(request.getParameter("houseSort_up"))) {
			houseSellSortBean.setHouseSort_up("0");
			houseSellSortBean.setHouseSort_image("jsp/images/common/up.gif");
			list.add(HOUSE_SORT_UP);
		} else if ("1".equals(houseSellSortBean.getHouseSort_up())) {
			houseSellSortBean.setHouseSort_up("1");
			houseSellSortBean.setHouseSort_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setHouseSort_up("0");
			houseSellSortBean.setHouseSort_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "0".equals(request.getParameter("buildDate_up"))) {
			houseSellSortBean.setBuildDate_up("1");
			houseSellSortBean.setBuildDate_image("jsp/images/common/down.gif");
			list.add(BUILD_YEAR_DOWN);
		} else if (!Util.isEmpty(request.getParameter("buildDate_up"))
				&& "1".equals(request.getParameter("buildDate_up"))) {
			houseSellSortBean.setBuildDate_up("0");
			houseSellSortBean.setBuildDate_image("jsp/images/common/up.gif");
			list.add(BUILD_YEAR_UP);
		} else if ("1".equals(houseSellSortBean.getBuildDate_up())) {
			houseSellSortBean.setBuildDate_up("1");
			houseSellSortBean.setBuildDate_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setBuildDate_up("0");
			houseSellSortBean.setBuildDate_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "0".equals(request.getParameter("userId_up"))) {
			houseSellSortBean.setUserId_up("1");
			houseSellSortBean.setUserId_image("jsp/images/common/down.gif");
			list.add(USER_ID_DOWN);
		} else if (!Util.isEmpty(request.getParameter("userId_up"))
				&& "1".equals(request.getParameter("userId_up"))) {
			houseSellSortBean.setUserId_up("0");
			houseSellSortBean.setUserId_image("jsp/images/common/up.gif");
			list.add(USER_ID_UP);
		} else if ("1".equals(houseSellSortBean.getUserId_up())) {
			houseSellSortBean.setUserId_up("1");
			houseSellSortBean.setUserId_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setUserId_up("0");
			houseSellSortBean.setUserId_image("jsp/images/common/up.gif");
		}
		if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "0".equals(request.getParameter("registDate_up"))) {
			houseSellSortBean.setRegistDate_up("1");
			houseSellSortBean.setRegistDate_image("jsp/images/common/down.gif");
			list.add(REGIST_DATE_DOWN);
		} else if (!Util.isEmpty(request.getParameter("registDate_up"))
				&& "1".equals(request.getParameter("registDate_up"))) {
			houseSellSortBean.setRegistDate_up("0");
			houseSellSortBean.setRegistDate_image("jsp/images/common/up.gif");
			list.add(REGIST_DATE_UP);
		} else if ("1".equals(houseSellSortBean.getRegistDate_up())) {
			houseSellSortBean.setRegistDate_up("1");
			houseSellSortBean.setRegistDate_image("jsp/images/common/down.gif");
		} else {
			houseSellSortBean.setRegistDate_up("0");
			houseSellSortBean.setRegistDate_image("jsp/images/common/up.gif");
		}
	}
}