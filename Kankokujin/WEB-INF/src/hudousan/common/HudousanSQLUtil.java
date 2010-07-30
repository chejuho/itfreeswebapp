package hudousan.common;

import hudousan.bean.HudousanBean;
import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import common.util.Util;

public class HudousanSQLUtil {


	/**
	 * @param gourmetSearchBean
	 * @return Count��擾����SQL
	 */
	public static String getCountGetSearchQuery(
			HudousanSearchBean searchBean,
			String sign) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from hudousan, member, t_area , t_train where ");
		sb.append(" hudousan.user_id=member.user_id and ");
		sb.append(" hudousan.area_code_1=t_area.area_code_1 and ");
		sb.append(" hudousan.area_code_2=t_area.area_code_2 and ");
		sb.append(" hudousan.line_code=t_train.line_code and ");
		sb.append(" hudousan.station_code=t_train.station_code and ");
		sb.append(" hudousan.lease_sign=" + sign);
		sb.append(getWhereList(searchBean));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return ���X�g��擾����SQL
	 */
	public static String getListGetSearchQuery(
			HudousanSearchBean searchBean,
			HudousanSortBean sortBean,
			String sign) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from hudousan, member, t_area , t_train where ");
		sb.append(" hudousan.user_id=member.user_id and ");
		sb.append(" hudousan.area_code_1=t_area.area_code_1 and ");
		sb.append(" hudousan.area_code_2=t_area.area_code_2 and ");
		sb.append(" hudousan.line_code=t_train.line_code and ");
		sb.append(" hudousan.station_code=t_train.station_code and ");
		sb.append(" hudousan.lease_sign=" + sign);
		sb.append(getWhereList(searchBean));
		getOrderbySQL(reverseList(sortBean.getSortList()), sb);
		sb.append(" limit ?,? ");
		
		return sb.toString();
	}
	
	
	/**
	 * @param gourmetSearchBean
	 * @return Count��擾����SQL
	 */
	public static String getCountGetSuggestQuery(String sign) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from hudousan, member, t_area , t_train where ");
		sb.append(" hudousan.user_id=member.user_id and ");
		sb.append(" hudousan.area_code_1=t_area.area_code_1 and ");
		sb.append(" hudousan.area_code_2=t_area.area_code_2 and ");
		sb.append(" hudousan.line_code=t_train.line_code and ");
		sb.append(" hudousan.station_code=t_train.station_code and ");
		sb.append(" hudousan.lease_sign=" + sign + " and ");
		sb.append(" hudousan.suggest_sign=" + "1");
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return ���X�g��擾����SQL
	 */
	public static String getListGetSuggestQuery(String sign, HudousanSortBean sortBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from hudousan, member, t_area , t_train where ");
		sb.append(" hudousan.user_id=member.user_id and ");
		sb.append(" hudousan.area_code_1=t_area.area_code_1 and ");
		sb.append(" hudousan.area_code_2=t_area.area_code_2 and ");
		sb.append(" hudousan.line_code=t_train.line_code and ");
		sb.append(" hudousan.station_code=t_train.station_code and ");
		sb.append(" hudousan.lease_sign=" + sign + " and ");
		sb.append(" hudousan.suggest_sign=" + "1");
		getOrderbySQL(reverseList(sortBean.getSortList()), sb);
		sb.append(" limit ?,? ");
		return sb.toString();
	}
	
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getWhereList(HudousanSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		// �ƒJ�n�l�i
		if ((!"".equals(bean.getHouse_fee(0)) || !"".equals(bean.getHouse_fee(1)))
				&& (!"100".equals(bean.getHouse_fee(0)) || !"100".equals(bean.getHouse_fee(1)))) {
			list.add(getHouseFeeTag(bean.getHouse_fee(0), bean.getHouse_fee(1)));
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
				&& (!"1000".equals(bean.getDimension(0)) || !"1000".equals(bean.getDimension(1)))) {
			list.add(getDimensionTag(bean.getDimension(0), bean.getDimension(1)));
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
				&& ("0".equals(bean.getFlg_tadami()) || "1".equals(bean.getFlg_tadami()))) {
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
		list.add(" hudousan.deleteflg=0 ");

		return getWhereSQL(list);

	}
	/**
	 * 
	 * @param list
	 * @return
	 * @throws SQLException 
	 */
	public static void resultSetToHudousanBean(HudousanBean bean, ResultSet rs) throws SQLException {
		bean.setId(rs.getString("id"));
		bean.setTitle(rs.getString("title"));
		bean.setUser_name(Util.cutLongName(3, rs.getString("name")));
		bean.setHouse_name(rs.getString("house_name"));
		bean.setDetail_info(rs.getString("detail_info"));
		bean.setManage_fee(Util.changePriceToMan(rs.getString("manage_fee")));
		bean.setHouse_sort(rs.getString("house_sort"));
		bean.setDimension(new String[] { rs.getString("dimension") });
		bean.setHouse_fee(new String[] { Util.changePriceToMan(rs.getString("house_fee")), "" });
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
		bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
		bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
		if (!"00".equals(bean.getArea_code_1())) {
			bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
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

	}
	
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private static List reverseList(List list) {
		//Collections.reverse(list);
		List<String> newList = new ArrayList<String>();
		for (int i = list.size() - 1; i >= 0; i--) {
			String temp = (String) list.get(i);
			if (!newList.contains(temp)) {
				newList.add(temp);
			}
		}
		return newList;

	}
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�order by�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static void getOrderbySQL(List list, StringBuffer sb) {
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
	/**
	 * 
	 * @param house_fee_from
	 * @param house_fee_to
	 * @return
	 */
	private static String getHouseFeeTag(String house_fee_from, String house_fee_to) {
		StringBuffer sb = new StringBuffer();
		try {
			int house_fee1 = Integer.parseInt(house_fee_from) * 10000;
			int house_fee2 = Integer.parseInt(house_fee_to) * 10000;
			if (!"100".equals(house_fee_from)) {
				sb.append(" hudousan.house_fee >= " + house_fee1);
			}
			if (!"100".equals(house_fee_from) && !"100".equals(house_fee_to)) {
				sb.append(" and ");
			}
			if (!"100".equals(house_fee_to)) {
				sb.append(" hudousan.house_fee <= " + house_fee2);
			}
		} catch (Exception e) {

		}
		return sb.toString();
	}
	
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static ArrayList getHouse_sortTag(HudousanSearchBean bean) {
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
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getOrSQL(ArrayList list) {
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
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getAreaCode1Tag(String area_code_1) {
		return "hudousan.area_code_1='" + area_code_1+"'";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getAreaCode2Tag(String area_code_2) {
		return "hudousan.area_code_2='" + area_code_2+"'";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getLineCodeTag(String line_code) {
		return "hudousan.line_code='" + line_code+"'";
	}
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getStationCodeTag(String station_code) {
		return "hudousan.station_code='" + station_code+"'";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getWalkTimeTag(String walk_time) {
		if ("0".equals(walk_time)) {
			walk_time = "5";
		} else if ("1".equals(walk_time)) {
			walk_time = "10";
		} else if ("2".equals(walk_time)) {
			walk_time = "15";
		}
		return "hudousan.walk_time <= " + walk_time
				+ " and hudousan.walk_time <> ''";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getDimensionTag(String dimension_1, String dimension_2) {
		StringBuffer sb = new StringBuffer();
		if (!"1000".equals(dimension_1)) {
			sb.append(" hudousan.dimension >= " + dimension_1);
		}
		if (!"1000".equals(dimension_1) && !"1000".equals(dimension_2)) {
			sb.append(" and ");
		}
		if (!"1000".equals(dimension_2)) {
			sb.append(" hudousan.dimension <= " + dimension_2);
		}
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */

	private static ArrayList getMadoriTag(HudousanSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!Util.isEmpty(bean.getMadori_checked(0))) {
			list.add(" hudousan.madori=0");
		}
		if (!Util.isEmpty(bean.getMadori_checked(1))) {
			list.add(" hudousan.madori=1");
		}
		if (!Util.isEmpty(bean.getMadori_checked(2))) {
			list.add(" hudousan.madori=2");
		}
		if (!Util.isEmpty(bean.getMadori_checked(3))) {
			list.add(" hudousan.madori=3");
		}
		if (!Util.isEmpty(bean.getMadori_checked(4))) {
			list.add(" hudousan.madori=4");
		}
		if (!Util.isEmpty(bean.getMadori_checked(5))) {
			list.add(" hudousan.madori=5");
		}
		if (!Util.isEmpty(bean.getMadori_checked(6))) {
			list.add(" hudousan.madori=6");
		}
		if (!Util.isEmpty(bean.getMadori_checked(7))) {
			list.add(" hudousan.madori=7");
		}
		if (!Util.isEmpty(bean.getMadori_checked(8))) {
			list.add(" hudousan.madori=8");
		}
		if (!Util.isEmpty(bean.getMadori_checked(9))) {
			list.add(" hudousan.madori=9");
		}
		if (!Util.isEmpty(bean.getMadori_checked(10))) {
			list.add(" hudousan.madori=10");
		}
		if (!Util.isEmpty(bean.getMadori_checked(11))) {
			list.add(" hudousan.madori=11");
		}
		return list;
	}
	
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getBuildYearTag(String build_yaer) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(build_yaer)) {
			sb.append("hudousan.build_year = YEAR(CURDATE())");
		} else if ("1".equals(build_yaer)) {
			sb
					.append("hudousan.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 3 YEAR)) AND hudousan.build_year <= YEAR(CURDATE())");
		} else if ("2".equals(build_yaer)) {
			sb
					.append("hudousan.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 5 YEAR)) AND hudousan.build_year <= YEAR(CURDATE())");
		} else if ("3".equals(build_yaer)) {
			sb
					.append("hudousan.build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 10 YEAR)) AND hudousan.build_year <= YEAR(CURDATE())");
		}
		sb.append(" and hudousan.build_year > 0 ");
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getStairsTag(String stairs) {
		return " hudousan.stairs>=2 ";
	}

	private static String getHouse_Option1Tag(String house_option) {
		return " substring(hudousan.house_option, 1, 1)=1 ";
	}

	private static String getHouse_Option2Tag(String house_option) {
		return "  substring(hudousan.house_option, 2, 1)=1  ";
	}

	private static String getHouse_Option3Tag(String house_option) {
		return "  substring(hudousan.house_option, 3, 1)=1  ";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getFlgTadamiTag(String flg_tadami) {
		return "hudousan.flg_tadami = '" + flg_tadami + "'";
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getToiletTag(HudousanSearchBean houseSearchBean) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(houseSearchBean.getToilet())) {
			sb.append("hudousan.toilet = '0'");
		}

		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getRegistDateTag(String regist_date) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(regist_date)) {
			sb.append("hudousan.update_date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)");
		} else if ("1".equals(regist_date)) {
			sb.append("hudousan.update_date > DATE_SUB(CURDATE(),INTERVAL 14 DAY)");
		} else if ("2".equals(regist_date)) {
			sb.append("hudousan.update_date > DATE_SUB(CURDATE(),INTERVAL 30 DAY)");
		}
		return sb.toString();

	}
	
	private static String getUser_id_Tag(String user_id) {
		return "hudousan.user_id = '" + user_id + "'";
	}

	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private static String getWhereSQL(ArrayList list) {
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
}
