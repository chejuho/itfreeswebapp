package housesell.handler;

import housesell.bean.HouseBean;
import housesell.bean.HouseSearchBean;
import housesell.bean.HouseSellSortBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class HouseSellListHandler {
	private static HouseSellListHandler instance = null;

	private HouseSellListHandler() {

	}

	public static HouseSellListHandler getInstance() {
		if (instance == null) {
			synchronized (HouseSellListHandler.class) {
				if (instance == null) {
					instance = new HouseSellListHandler();
				}
			}
		}

		return instance;
	}

	/**
	 * countの情報をお知らせする
	 * 
	 * @param bean
	 *            countを及ぶ
	 * @return count columnIndexの最初の列をintとして取得
	 */
	public int getInfoCount(HouseSearchBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb
					.append("select count(*) from house_info, member, t_area , t_train where ");
			sb.append(" house_info.user_id=member.user_id and ");
			sb.append(" house_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" house_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" house_info.line_code=t_train.line_code and ");
			sb.append(" house_info.station_code=t_train.station_code ");
			sb.append(getWhereList(bean));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getInfoCount" + pstmt.getQueryString());
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return count;

	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereList(HouseSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		// 家賃開始値段
		if ((!"".equals(bean.getHouse_fee(0)) || !"".equals(bean
				.getHouse_fee(1)))
				&& (!"100".equals(bean.getHouse_fee(0)) || !"100".equals(bean
						.getHouse_fee(1)))) {
			list
					.add(getHouseFeeTag(bean.getHouse_fee(0), bean
							.getHouse_fee(1)));
		}
		if (!Util.isEmpty(bean.getHouse_sort(0))
				|| !Util.isEmpty(bean.getHouse_sort(1))
				|| !Util.isEmpty(bean.getHouse_sort(2))
				|| !Util.isEmpty(bean.getHouse_sort(3))
				|| !Util.isEmpty(bean.getHouse_sort(4))
				|| !Util.isEmpty(bean.getHouse_sort(5))
				|| !Util.isEmpty(bean.getHouse_sort(6))) {
			list.add(getOrSQL(getHouse_sortTag(bean)));
		}
		if (!"".equals(bean.getArea_code_1())
				&& !"00".equals(bean.getArea_code_1())) {
			list.add(getAreaCode1Tag(bean.getArea_code_1()));
		}
		if (!"".equals(bean.getArea_code_2())
				&& !"00".equals(bean.getArea_code_2().substring(2, 4))) {
			list.add(getAreaCode2Tag(bean.getArea_code_2()));
		}
		if (!"".equals(bean.getLine_code())
				&& !"00".equals(bean.getLine_code())) {
			list.add(getLineCodeTag(bean.getLine_code()));
		}
		if (!"".equals(bean.getStation_code())
				&& !"00".equals(bean.getStation_code().substring(2, 4))) {
			list.add(getStationCodeTag(bean.getStation_code()));
		}
		if (!"".equals(bean.getWalk_time()) && !"3".equals(bean.getWalk_time())) {
			list.add(getWalkTimeTag(bean.getWalk_time()));
		}
		if ((!"".equals(bean.getDimension(0)) || !"".equals(bean
				.getDimension(1)))
				&& (!"1000".equals(bean.getDimension(0)) || !"1000".equals(bean
						.getDimension(1)))) {
			list
					.add(getDimensionTag(bean.getDimension(0), bean
							.getDimension(1)));
		}
		if (!Util.isEmpty(bean.getMadori_checked(0))
				|| !Util.isEmpty(bean.getMadori_checked(1))
				|| !Util.isEmpty(bean.getMadori_checked(2))
				|| !Util.isEmpty(bean.getMadori_checked(3))
				|| !Util.isEmpty(bean.getMadori_checked(4))
				|| !Util.isEmpty(bean.getMadori_checked(5))
				|| !Util.isEmpty(bean.getMadori_checked(6))
				|| !Util.isEmpty(bean.getMadori_checked(7))
				|| !Util.isEmpty(bean.getMadori_checked(8))
				|| !Util.isEmpty(bean.getMadori_checked(9))
				|| !Util.isEmpty(bean.getMadori_checked(10))
				|| !Util.isEmpty(bean.getMadori_checked(11))) {
			list.add(getOrSQL(getMadoriTag(bean)));
		}
		if (!"".equals(bean.getBuild_year())
				&& !"4".equals(bean.getBuild_year())) {
			list.add(getBuildYearTag(bean.getBuild_year()));
		}
		if ("1".equals(bean.getHouse_option(0))) {
			list.add(getStairsTag(bean.getStairs()));
		}
		if ("1".equals(bean.getHouse_option(1))) {
			list.add(getHouse_Option1Tag(bean.getHouse_option(1)));
		}
		if ("1".equals(bean.getHouse_option(2))) {
			list.add(getHouse_Option2Tag(bean.getHouse_option(2)));
		}
		if ("1".equals(bean.getHouse_option(3))) {
			list.add(getHouse_Option3Tag(bean.getHouse_option(3)));
		}

		if (!Util.isEmpty(bean.getFlg_tadami())
				&& ("0".equals(bean.getFlg_tadami()) || "1".equals(bean
						.getFlg_tadami()))) {
			list.add(getFlgTadamiTag(bean.getFlg_tadami()));
		}
		if ("0".equals(bean.getToilet())) {
			list.add(getToiletTag(bean));
		}
		if (("0".equals(bean.getRegist_date()))
				|| ("1".equals(bean.getRegist_date()))
				|| ("2".equals(bean.getRegist_date()))) {
			list.add(getRegistDateTag(bean.getRegist_date()));
		}
		if (!Util.isEmpty(bean.getUser_id())) {
			list.add(getUser_id_Tag(bean.getUser_id()));
		}
		list.add(" house_info.deleteflg=0 ");

		return getWhereSQL(list);

	}

	private String getUser_id_Tag(String user_id) {
		return "house_info.user_id = '" + user_id + "'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();

		/*
		 * if (list.size() > 0) { sb.append(" where "); }
		 */
		// boolean isNotFirst = false;
		while (it.hasNext()) {
			// if (isNotFirst) {
			sb.append(" and ");
			// }
			// isNotFirst = true;
			sb.append((String) it.next());
			sb.append(" ");
		}
		return sb.toString();

	}

	/**
	 * descとascの整列
	 * 
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<HouseBean> getHouseBeanList(
			HouseSearchBean houseSearchBean,
			HouseSellSortBean houseSellSortBean, int start, int num)
			throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<HouseBean> list = new ArrayList<HouseBean>();
		StringBuffer sb = new StringBuffer();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			sb.append("select * from house_info, member, t_area , t_train where ");
			sb.append(" house_info.user_id=member.user_id and ");
			sb.append(" house_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" house_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" house_info.line_code=t_train.line_code and ");
			sb.append(" house_info.station_code=t_train.station_code ");

			sb.append(getWhereList(houseSearchBean));
			getOrderbySQL(cutSameList(houseSellSortBean.getSortList()), sb);
			sb.append(" limit ?,? ");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanList" + pstmt.getQueryString());
			while (rs.next()) {

				HouseBean bean = new HouseBean();

				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setUser_name(rs.getString("name"));
				bean.setHouse_name(rs.getString("house_name"));
				bean.setDetail_info(rs.getString("detail_info"));
				bean.setManage_fee(Util.changePriceToMan(rs
						.getString("manage_fee")));
				bean.setHouse_sort(rs.getString("house_sort"));
				bean.setDimension(new String[] { rs.getString("dimension") });
				bean.setHouse_fee(new String[] {
						Util.changePriceToMan(rs.getString("house_fee")), "" });
				bean.setDeposit(rs.getString("deposit"));
				bean.setReikin(rs.getString("reikin"));
				bean.setWalk_time(rs.getString("walk_time"));
				bean.setBuild_year(Util.changeNullStr(rs
						.getString("build_year")));
				bean.setBuild_month(rs.getString("build_month"));
				bean.setMadori(rs.getString("madori"));
				bean.setAll_stairs(rs.getString("all_stairs"));
				bean.setStairs(rs.getString("stairs"));
				bean.setFlg_tadami(rs.getString("flg_tadami"));
				bean.setToilet(rs.getString("toilet"));
				bean.setArea_code_1(Util.changeNullStr(rs
						.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs
						.getString("area_code_2")));
				if (!"00".equals(bean.getArea_code_1())) {
					bean.setArea_name_1(Util.changeNullStr(rs
							.getString("area_name_1")));
				}
				if (!"00".equals(bean.getArea_code_2().substring(2, 4))) {
					bean.setArea_name_2(Util.changeNullStr(rs
							.getString("area_name_2")));
				}
				bean.setArea_code_3(Util.changeNullStr(rs
						.getString("area_code_3")));
				bean
						.setLine_code(Util.changeNullStr(rs
								.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs
						.getString("station_code")));
				if (!"00".equals(bean.getLine_code())) {
					bean.setLine_name(Util.changeNullStr(rs
							.getString("line_kanji")));
				}
				if (!"00".equals(bean.getStation_code().substring(2, 4))) {
					bean.setStation_name(Util.changeNullStr(rs
							.getString("station_kanji")));
				}

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setGuaranty_money(rs.getString("guaranty_money"));
				bean.setHouse_option(Util.changeStrToArray(Util
						.changeNullStr(rs.getString("house_option"))));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
	private String getHouseFeeTag(String house_fee_from, String house_fee_to) {
		StringBuffer sb = new StringBuffer();
		try {
			int house_fee1 = Integer.parseInt(house_fee_from) * 10000;
			int house_fee2 = Integer.parseInt(house_fee_to) * 10000;
			if (!"100".equals(house_fee_from)) {
				sb.append(" house_info.house_fee >= " + house_fee1);
			}
			if (!"100".equals(house_fee_from) && !"100".equals(house_fee_to)) {
				sb.append(" and ");
			}
			if (!"100".equals(house_fee_to)) {
				sb.append(" house_info.house_fee <= " + house_fee2);
			}
		} catch (Exception e) {

		}
		return sb.toString();
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private ArrayList getHouse_sortTag(HouseSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!Util.isEmpty(bean.getHouse_sort(0))) {
			list.add(" house_sort='0'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(1))) {
			list.add(" house_sort='1'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(2))) {
			list.add(" house_sort='2'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(3))) {
			list.add(" house_sort='3'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(4))) {
			list.add(" house_sort='4'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(5))) {
			list.add(" house_sort='5'");
		}
		if (!Util.isEmpty(bean.getHouse_sort(6))) {
			list.add(" house_sort='6'");
		}
		return list;
	}

	/**
	 * 条件節のハッシュマップ情報からorder by節を作る
	 * 
	 * @param map
	 * @return
	 */
	private void getOrderbySQL(List list, StringBuffer sb) {
		Iterator it = list.iterator();

		if (list.size() > 0) {
			sb.append(" order by ");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" , ");
			}
			isNotFirst = true;
			sb.append((String) it.next());
			sb.append(" ");

		}

	}

	private List cutSameList(List list) {
		Collections.reverse(list);
		Iterator it = list.iterator();
		List<String> newList = new ArrayList<String>();
		while (it.hasNext()) {
			String temp = (String) it.next();
			if (!newList.contains(temp)) {
				newList.add(temp);
			}
		}
		return newList;

	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode1Tag(String area_code_1) {
		return "house_info.area_code_1='" + area_code_1+"'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode2Tag(String area_code_2) {
		return "house_info.area_code_2='" + area_code_2+"'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getLineCodeTag(String line_code) {
		return "house_info.line_code='" + line_code+"'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getStationCodeTag(String station_code) {
		return "house_info.station_code='" + station_code+"'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getWalkTimeTag(String walk_time) {
		if ("0".equals(walk_time)) {
			walk_time = "5";
		} else if ("1".equals(walk_time)) {
			walk_time = "10";
		} else if ("2".equals(walk_time)) {
			walk_time = "15";
		}
		return "house_info.walk_time <= " + walk_time
				+ " and house_info.walk_time <> ''";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getDimensionTag(String dimension_1, String dimension_2) {
		StringBuffer sb = new StringBuffer();
		if (!"1000".equals(dimension_1)) {
			sb.append(" house_info.dimension >= " + dimension_1);
		}
		if (!"1000".equals(dimension_1) && !"1000".equals(dimension_2)) {
			sb.append(" and ");
		}
		if (!"1000".equals(dimension_2)) {
			sb.append(" house_info.dimension <= " + dimension_2);
		}
		return sb.toString();
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getBuildYearTag(String build_yaer) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(build_yaer)) {
			sb.append("house_info.build_year = YEAR(CURDATE())");
		} else if ("1".equals(build_yaer)) {
			sb
					.append("house_info.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 3 YEAR)) AND house_info.build_year <= YEAR(CURDATE())");
		} else if ("2".equals(build_yaer)) {
			sb
					.append("house_info.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 5 YEAR)) AND house_info.build_year <= YEAR(CURDATE())");
		} else if ("3".equals(build_yaer)) {
			sb
					.append("house_info.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 10 YEAR)) AND house_info.build_year <= YEAR(CURDATE())");
		}
		sb.append(" and house_info.build_year > 0 ");
		return sb.toString();
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getStairsTag(String stairs) {
		return " house_info.stairs>=2 ";
	}

	private String getHouse_Option1Tag(String house_option) {
		return " substring(house_info.house_option, 1, 1)=1 ";
	}

	private String getHouse_Option2Tag(String house_option) {
		return "  substring(house_info.house_option, 2, 1)=1  ";
	}

	private String getHouse_Option3Tag(String house_option) {
		return "  substring(house_info.house_option, 3, 1)=1  ";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getFlgTadamiTag(String flg_tadami) {
		return "house_info.flg_tadami = '" + flg_tadami + "'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getToiletTag(HouseSearchBean houseSearchBean) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(houseSearchBean.getToilet())) {
			sb.append("house_info.toilet = '0'");
		}

		return sb.toString();
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getRegistDateTag(String regist_date) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(regist_date)) {
			sb
					.append("house_info.update_date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)");
		} else if ("1".equals(regist_date)) {
			sb
					.append("house_info.update_date > DATE_SUB(CURDATE(),INTERVAL 14 DAY)");
		} else if ("2".equals(regist_date)) {
			sb
					.append("house_info.update_date > DATE_SUB(CURDATE(),INTERVAL 30 DAY)");
		}
		return sb.toString();

	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getOrSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		while (it.hasNext()) {
			if (isFirst) {
				isFirst = false;
				sb.append("(");
			} else {
				sb.append(" or ");
			}
			sb.append((String) it.next());
			sb.append(" ");

		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */

	private ArrayList getMadoriTag(HouseSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!Util.isEmpty(bean.getMadori_checked(0))) {
			list.add(" house_info.madori=0");
		}
		if (!Util.isEmpty(bean.getMadori_checked(1))) {
			list.add(" house_info.madori=1");
		}
		if (!Util.isEmpty(bean.getMadori_checked(2))) {
			list.add(" house_info.madori=2");
		}
		if (!Util.isEmpty(bean.getMadori_checked(3))) {
			list.add(" house_info.madori=3");
		}
		if (!Util.isEmpty(bean.getMadori_checked(4))) {
			list.add(" house_info.madori=4");
		}
		if (!Util.isEmpty(bean.getMadori_checked(5))) {
			list.add(" house_info.madori=5");
		}
		if (!Util.isEmpty(bean.getMadori_checked(6))) {
			list.add(" house_info.madori=6");
		}
		if (!Util.isEmpty(bean.getMadori_checked(7))) {
			list.add(" house_info.madori=7");
		}
		if (!Util.isEmpty(bean.getMadori_checked(8))) {
			list.add(" house_info.madori=8");
		}
		if (!Util.isEmpty(bean.getMadori_checked(9))) {
			list.add(" house_info.madori=9");
		}
		if (!Util.isEmpty(bean.getMadori_checked(10))) {
			list.add(" house_info.madori=10");
		}
		if (!Util.isEmpty(bean.getMadori_checked(11))) {
			list.add(" house_info.madori=11");
		}
		return list;
	}
	
	/**
	 * descとascの整列
	 * 
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<HouseBean> getHouseBeanListTotal(PageBean pageBean, 
			HouseSearchBean houseSearchBean,
			HouseSellSortBean houseSellSortBean)
			throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<HouseBean> list = new ArrayList<HouseBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String countGetQuery = getCountGetQuery(houseSearchBean);
			String listGetQuery = getListGetQuery(houseSearchBean, houseSellSortBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal1 sql= " + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			//ページ処理
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			
			//画面に表示する総データリストを取得
			pstmt = new LogPreparedStatement(con, listGetQuery);
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal2 sql=" + pstmt.getQueryString());
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HouseBean bean = new HouseBean();
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setUser_name(Util.cutLongName(3, rs.getString("name")));
				bean.setHouse_name(rs.getString("house_name"));
				bean.setDetail_info(rs.getString("detail_info"));
				bean.setManage_fee(Util.changePriceToMan(rs.getString("manage_fee")));
				bean.setHouse_sort(rs.getString("house_sort"));
				bean.setDimension(new String[] { rs.getString("dimension") });
				bean.setHouse_fee(new String[] {
						Util.changePriceToMan(rs.getString("house_fee")), "" });
				bean.setDeposit(rs.getString("deposit"));
				bean.setReikin(rs.getString("reikin"));
				bean.setWalk_time(rs.getString("walk_time"));
				bean.setBuild_year(Util.changeNullStr(rs.getString("build_year")));
				bean.setBuild_month(rs.getString("build_month"));
				bean.setMadori(rs.getString("madori"));
				bean.setAll_stairs(rs.getString("all_stairs"));
				bean.setStairs(rs.getString("stairs"));
				bean.setFlg_tadami(rs.getString("flg_tadami"));
				bean.setToilet(rs.getString("toilet"));
				bean.setArea_code_1(Util.changeNullStr(rs
						.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs
						.getString("area_code_2")));
				if (!"00".equals(bean.getArea_code_1())) {
					bean.setArea_name_1(Util.changeNullStr(rs
							.getString("area_name_1")));
				}
				if (!"00".equals(bean.getArea_code_2().substring(2, 4))) {
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if (!"00".equals(bean.getLine_code())) {
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if (!"00".equals(bean.getStation_code().substring(2, 4))) {
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}
				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setGuaranty_money(rs.getString("guaranty_money"));
				bean.setHouse_option(Util.changeStrToArray(Util.changeNullStr(rs.getString("house_option"))));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				
				//追加
				bean.setDetail_url(rs.getString("detail_url"));
				bean.setInfo_site(rs.getString("info_acquisition_site"));
				list.add(bean);
			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
	
	/**
	 * @param gourmetSearchBean
	 * @return Countを取得するSQL
	 */
	private String getCountGetQuery(HouseSearchBean houseSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from house_info, member, t_area , t_train where ");
		sb.append(" house_info.user_id=member.user_id and ");
		sb.append(" house_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" house_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" house_info.line_code=t_train.line_code and ");
		sb.append(" house_info.station_code=t_train.station_code ");
		sb.append(getWhereList(houseSearchBean));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return リストを取得するSQL
	 */
	private String getListGetQuery(HouseSearchBean houseSearchBean, HouseSellSortBean houseSellSortBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from house_info, member, t_area , t_train where ");
		sb.append(" house_info.user_id=member.user_id and ");
		sb.append(" house_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" house_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" house_info.line_code=t_train.line_code and ");
		sb.append(" house_info.station_code=t_train.station_code ");
		
		sb.append(getWhereList(houseSearchBean));
		getOrderbySQL(cutSameList(houseSellSortBean.getSortList()), sb);
		sb.append(" limit ?,? ");

		
		return sb.toString();
	}

}