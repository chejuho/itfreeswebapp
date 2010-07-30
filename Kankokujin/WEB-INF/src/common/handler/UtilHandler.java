package common.handler;

import housesell.bean.HouseBean;
import housesell.bean.HouseSellSortBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

import menu.bean.MenuBean;
import menu.handler.SQLUtil;

import bean.AreaBean;
import bean.TrainBean;
import category.bean.CategoryBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class UtilHandler {
	public static ArrayList<CategoryBean> getCategory1ListFromMap(SortedMap category1Map) {
		
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		Set set = category1Map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String)it.next();
			if(!"C10000".equals(key)){
				CategoryBean bean = new CategoryBean();
				bean.setCate_code(key);
				bean.setCate_name((String) category1Map.get(key));
				list.add(bean);
			}
		}
		return list;
	}
	public static ArrayList<CategoryBean> getCategory2ListFromMap(
			String cate_code, SortedMap category2Map) {
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		if (!Util.isEmpty(cate_code)) {
			Set set = category2Map.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()){
				String key = (String)it.next();
				if (cate_code.substring(2, 4).equals(key.substring(2, 4)) && !"00".equals(key.substring(4, 6))) {
					CategoryBean bean = new CategoryBean();
					bean.setCate_code(cate_code);
					bean.setCate_code_2(key);
					bean.setCate_name_2((String) category2Map.get(key));
					list.add(bean);
				}
			}
		}
		return list;
	}	

	/**
	 * ��̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	public static ArrayList<TrainBean> getTrainLineInfo() throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<TrainBean> list = new ArrayList<TrainBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select line_code, line_kanji from t_train group by line_code";
			KankokujinLogger.getInstance().debug("getTrainLineInfo " + strSql);
			pstmt = con.prepareStatement(strSql);
			KankokujinLogger.getInstance().debug(
					"getTrainLineInfo sql =" + strSql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TrainBean bean = new TrainBean();
				bean.setLine_code(rs.getString("line_code"));
				bean.setLine_kanji(rs
						.getString("line_kanji"));
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
		return list;

	}

	public static String getTrainLineTag(String lineCode) throws AppException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getTrainLineInfo();
		Iterator it = list.iterator();
		while (it.hasNext()) {

			TrainBean bean = (TrainBean) it.next();
			sb.append("<option ");
			if (lineCode != null && lineCode.equals(bean.getLine_code())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getLine_code() + "'>");
			sb.append(bean.getLine_kanji());
			sb.append("</option>");
		}

		return sb.toString();
	}

	public static String getStationTag(String lineCode, String stationCode)
			throws AppException {
		StringBuffer sb = new StringBuffer();
		if(Util.isEmpty(lineCode)){
			lineCode = "00";
		}
		ArrayList list = getStationInfoList(lineCode);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			TrainBean bean = (TrainBean) it.next();
			sb.append("<option");
			if (stationCode != null
					&& stationCode.equals(bean.getStation_code())) {
				sb.append(" selected");
			}
			sb.append(" value='");

			sb.append(bean.getStation_code() + "'>");
			sb.append(bean.getStation_kanji());
			sb.append("</option>");

		}

		return sb.toString();

	}

	/**
	 * �w�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<TrainBean> getStationInfoList(String lineCode)
			throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<TrainBean> list = new ArrayList<TrainBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select station_code, station_kanji from t_train where line_code ='"
					+ lineCode + "'";
			KankokujinLogger.getInstance()
					.debug("getStationInfoList " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TrainBean bean = new TrainBean();
				bean.setStation_code(rs.getString("station_code"));
				bean.setStation_kanji(rs
						.getString("station_kanji"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("SQLException" + e);

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
		return list;

	}

	/**
	 * �n��R�[�h�P�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getCate1Tag(String cate_code_1, String tableName) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getCate1Info(tableName);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			CategoryBean bean = (CategoryBean) it.next();
			sb.append("<option ");
			if (!Util.isEmpty(cate_code_1) && cate_code_1.equals(bean.getCate_code())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getCate_code() + "'>");
			sb.append(bean.getCate_name());
			sb.append("</option>");
		}
		return sb.toString();

	}

	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<CategoryBean> getCate1Info(String tableName) throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select cate_code_1, category_name_1 from " + tableName + " group by cate_code_1";
			KankokujinLogger.getInstance().debug("getCate1Info " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				bean.setCate_code(rs.getString("cate_code_1"));
				bean.setCate_name(rs
						.getString("category_name_1"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0034", e);

		} catch (Exception e) {
			throw new SysException("SYE0034", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0034", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0034", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return list;

	}

	/**
	 * �n��R�[�h�Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getCate2Tag(String cate_code_1, String cate_code_2, String tableName)
			throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getCate2Info(cate_code_1, tableName);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			CategoryBean bean = (CategoryBean) it.next();

			sb.append("<option ");

			if (cate_code_2 != null && cate_code_2.equals(bean.getCate_code_2())) {
				sb.append("selected");
			}

			sb.append(" value='");
			sb.append(bean.getCate_code_2() + "'>");
			sb.append(bean.getCate_name_2());
			sb.append("</option>");
		}
		return sb.toString();

	}

	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<CategoryBean> getCate2Info(String cate_code_1, String tableName)
			throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select cate_code_2, category_name_2 from " + tableName + " where cate_code_1='"
					+ cate_code_1 + "'";
			KankokujinLogger.getInstance().debug("getCate2Info " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				bean.setCate_code_2(rs.getString("cate_code_2"));
				bean.setCate_name_2(rs
						.getString("category_name_2"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0035", e);

		} catch (Exception e) {
			throw new SysException("SYE0035", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0035", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0035", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return list;

	}
	/**
	 * �n��R�[�h�P�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea1Tag(String areaCode1) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea1Info();
		Iterator it = list.iterator();

		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();
			sb.append("<option ");
			if (areaCode1 != null && areaCode1.equals(bean.getArea_code_1())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getArea_code_1() + "'>");
			sb.append(bean.getArea_name_1());
			sb.append("</option>");
		}
		return sb.toString();

	}

	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<AreaBean> getArea1Info() throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<AreaBean> list = new ArrayList<AreaBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select area_code_1, area_name_1 from t_area group by area_code_1";
			KankokujinLogger.getInstance().debug("getArea1Info " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AreaBean bean = new AreaBean();
				bean.setArea_code_1(rs.getString("area_code_1"));
				bean.setArea_name_1(rs
						.getString("area_name_1"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return list;

	}

	/**
	 * �n��R�[�h�Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea2Tag(String areaCode1, String areaCode2)
			throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea2Info(areaCode1);
	
		Iterator it = list.iterator();

		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();

			sb.append("<option ");

			if (areaCode2 != null && areaCode2.equals(bean.getArea_code_2())) {
				sb.append("selected");
			}

			sb.append(" value='");
			sb.append(bean.getArea_code_2() + "'>");
			sb.append(bean.getArea_name_2());
			sb.append("</option>");
		}
		return sb.toString();

	}

	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<AreaBean> getArea2Info(String areaCode1)
			throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(Util.isEmpty(areaCode1)){
			areaCode1 = "00";
		} 
		ArrayList<AreaBean> list = new ArrayList<AreaBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select area_code_2, area_name_2 from t_area where area_code_1='"
					+ areaCode1 + "'";
			KankokujinLogger.getInstance().debug("getArea2Info " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AreaBean bean = new AreaBean();
				bean.setArea_code_2(rs.getString("area_code_2"));
				bean.setArea_name_2(rs
						.getString("area_name_2"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0032", e);

		} catch (Exception e) {
			throw new SysException("SYE0032", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0032", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0032", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return list;

	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	public String getWhereList(HouseBean bean) {
		ArrayList<String> list = new ArrayList<String>();

		String sql = "";
		// �ƒ\J�n�l�i
		if ((!"".equals(bean.getHouse_fee()[0]) || !"".equals(bean
				.getHouse_fee()[1]))
				&& (!"100".equals(bean.getHouse_fee()[0]) || !"100".equals(bean
						.getHouse_fee()[1]))) {
			sql = getHouseFeeTag(bean.getHouse_fee()[0], bean.getHouse_fee()[1]);
			list.add(sql);
		}
		if ((!"".equals(bean.getHouse_sort_checked(0))
				|| !"".equals(bean.getHouse_sort_checked(1))
				|| !"".equals(bean.getHouse_sort_checked(2))
				|| !"".equals(bean.getHouse_sort_checked(3))
				|| !"".equals(bean.getHouse_sort_checked(4))
				|| !"".equals(bean.getHouse_sort_checked(5))
				|| !"".equals(bean.getHouse_sort_checked(6))
				|| !"".equals(bean.getHouse_sort_checked(7)))) {
			sql = getOrSQL(getHouse_sortTag(bean));
			list.add(sql);
		}
		if (!"".equals(bean.getArea_code_1())
				&& !"00".equals(bean.getArea_code_1())) {
			sql = getAreaCode1Tag(bean.getArea_code_1());
			list.add(sql);
		}
		if (!"".equals(bean.getArea_code_2())
				&& !"00".equals(bean.getArea_code_2())) {
			sql = getAreaCode2Tag(bean.getArea_code_2());
			list.add(sql);
		}
		if (!"".equals(bean.getLine_code())
				&& !"00".equals(bean.getLine_code())) {
			sql = getLineCodeTag(bean.getLine_code());
			list.add(sql);
		}
		if (!"".equals(bean.getStation_code())
				&& !"0000".equals(bean.getStation_code())) {
			sql = getStationCodeTag(bean.getStation_code());
			list.add(sql);
		}
		if (!"".equals(bean.getWalk_time())
				&& !"NO".equals(bean.getWalk_time())) {
			sql = getWalkTimeTag(bean.getWalk_time());
			list.add(sql);
		}
		if ((!"".equals(bean.getDimension()[0]) || !"".equals(bean
				.getDimension()[1]))
				&& (!"1000".equals(bean.getDimension()[0]) || !"1000"
						.equals(bean.getDimension()[1]))) {
			sql = getDimensionTag(bean.getDimension()[0],
					bean.getDimension()[1]);
			list.add(sql);
		}
/*		if ((!"".equals(bean.getMadori()[0]) || !"".equals(bean.getMadori()[1])
				|| !"".equals(bean.getMadori()[2])
				|| !"".equals(bean.getMadori()[3])
				|| !"".equals(bean.getMadori()[4])
				|| !"".equals(bean.getMadori()[5])
				|| !"".equals(bean.getMadori()[6])
				|| !"".equals(bean.getMadori()[7])
				|| !"".equals(bean.getMadori()[8])
				|| !"".equals(bean.getMadori()[9])
				|| !"".equals(bean.getMadori()[10]) || !"".equals(bean
				.getMadori()[11]))) {
			sql = getOrSQL(getMadoriTag(bean));
			list.add(sql);
		}*/
		if (!"".equals(bean.getBuild_year())
				&& !"NO".equals(bean.getBuild_year())) {
			sql = getBuildYearTag(bean.getBuild_year());
			list.add(sql);
		}
		if (!"".equals(bean.getAll_stairs())
				&& !"".equals(bean.getAll_stairs())) {
			sql = getAllStairsTag(bean.getAll_stairs());
			list.add(sql);
		}
		if (!"".equals(bean.getStairs()) && !"0".equals(bean.getStairs())) {
			sql = getStairsTag(bean.getStairs());
			list.add(sql);
		}
		if (!"".equals(bean.getFlg_tadami())) {
			sql = getFlgTadamiTag(bean.getFlg_tadami());
			list.add(sql);
		}
		if (!"".equals(bean.getToilet())) {
			//sql = getToiletTag(bean.getToilet()[0]);
			sql = getToiletTag(bean.getToilet());
			list.add(sql);
		}
/*		if (!"".equals(bean.getRegist_date())) {
			sql = getRegistDateTag(bean.getRegist_date());
			list.add(sql);
		}*/

		sql = "deleteflg=0";
		list.add(sql);
		
		return getWhereSQL(list);

	}
	public void getOrderbyList(HouseSellSortBean houseSellSortBean,
			StringBuffer sb) {
		ArrayList<String> list = new ArrayList<String>();
		if ("0".equals(houseSellSortBean.getAddress_up())) {
			list.add(" area_code_1 desc, area_code_2 desc ");
		}
		if ("1".equals(houseSellSortBean.getAddress_up())) {
			list.add(" area_code_1 asc, area_code_2 asc");
		}
		if ("0".equals(houseSellSortBean.getLine_up())) {
			list.add(" line_code desc, station_code desc ");
		}
		if ("1".equals(houseSellSortBean.getLine_up())) {
			list.add(" line_code asc, station_code asc ");
		}
		if ("0".equals(houseSellSortBean.getWalk_up())) {
			list.add(" walk_time desc ");
		}
		if ("1".equals(houseSellSortBean.getWalk_up())) {
			list.add(" walk_time asc");
		}
		if ("0".equals(houseSellSortBean.getHouseFee_up())) {
			list.add(" house_fee desc ");
		}
		if ("1".equals(houseSellSortBean.getHouseFee_up())) {
			list.add(" house_fee asc ");
		}
		if ("0".equals(houseSellSortBean.getManageFee_up())) {
			list.add(" manage_fee desc ");
		}
		if ("1".equals(houseSellSortBean.getManageFee_up())) {
			list.add(" manage_fee asc ");
		}
		if ("0".equals(houseSellSortBean.getDeposit_up())) {
			list.add(" deposit desc ");
		}
		if ("1".equals(houseSellSortBean.getDeposit_up())) {
			list.add(" deposit asc ");
		}
		if ("0".equals(houseSellSortBean.getReikin_up())) {
			list.add(" reikin desc ");
		}
		if ("1".equals(houseSellSortBean.getReikin_up())) {
			list.add(" reikin asc ");
		}
		if ("0".equals(houseSellSortBean.getGuaranty_up())) {
			list.add(" guaranty_money desc ");
		}
		if ("1".equals(houseSellSortBean.getGuaranty_up())) {
			list.add(" guaranty_money asc ");
		}
		if ("0".equals(houseSellSortBean.getMadori_up())) {
			list.add(" madori desc ");
		}
		if ("1".equals(houseSellSortBean.getMadori_up())) {
			list.add(" madori asc ");
		}
		if ("0".equals(houseSellSortBean.getDeposit_up())) {
			list.add(" dimension desc ");
		}
		if ("1".equals(houseSellSortBean.getDeposit_up())) {
			list.add(" dimension asc ");
		}
		if ("0".equals(houseSellSortBean.getHouseSort_up())) {
			list.add(" house_sort desc ");
		}
		if ("1".equals(houseSellSortBean.getHouseSort_up())) {
			list.add(" house_sort asc ");
		}
		if ("0".equals(houseSellSortBean.getBuildDate_up())) {
			list.add(" build_year desc ");
		}
		if ("1".equals(houseSellSortBean.getBuildDate_up())) {
			list.add(" build_year asc ");
		}
		if ("0".equals(houseSellSortBean.getBuildDate_up())) {
			list.add(" build_year desc ");
		}
		if ("1".equals(houseSellSortBean.getBuildDate_up())) {
			list.add(" build_year asc ");
		}
		if ("0".equals(houseSellSortBean.getUserId_up())) {
			list.add(" user_id desc ");
		}
		if ("1".equals(houseSellSortBean.getUserId_up())) {
			list.add(" user_id asc ");
		}
		if ("0".equals(houseSellSortBean.getRegistDate_up())) {
			list.add(" regist_date desc ");
		}
		if ("1".equals(houseSellSortBean.getRegistDate_up())) {
			list.add(" regist_date asc ");
		}
		getOrderbySQL(list, sb);
	}

	/**
	 * �萔�ꗗ��擾����
	 * 
	 * @return Map
	 * @throws AppException
	 */
	public static Map getConstantMap() throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap map = new HashMap();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select constance_name, constance_value from constant";
			KankokujinLogger.getInstance().debug("getConstantMap " + strSql);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				map.put(rs.getString("constance_name"), rs
						.getString("constance_value"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

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
		return map;

	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�order by�߂���
	 * 
	 * @param map
	 * @return
	 */
	private void getOrderbySQL(ArrayList list, StringBuffer sb) {
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
			String temp = (String) it.next();
			sb.append(temp + " ");

		}

	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode1Tag(String area_code_1) {
		StringBuffer sb = new StringBuffer();
		sb.append("area_code_1 = " + area_code_1);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode2Tag(String area_code_2) {
		StringBuffer sb = new StringBuffer();
		sb.append("area_code_2 = " + area_code_2);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getLineCodeTag(String line_code) {
		StringBuffer sb = new StringBuffer();
		sb.append("line_code = " + line_code);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getStationCodeTag(String station_code) {
		StringBuffer sb = new StringBuffer();
		sb.append("station_code = " + station_code);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getWalkTimeTag(String walk_time) {
		StringBuffer sb = new StringBuffer();
		sb.append("walk_time <= " + walk_time + " and walk_time <> ''");
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getDimensionTag(String dimension_1, String dimension_2) {
		StringBuffer sb = new StringBuffer();
		if (!"1000".equals(dimension_1)) {
			sb.append(" dimension >= " + dimension_1);
		}
		if (!"1000".equals(dimension_1) && !"1000".equals(dimension_2)) {
			sb.append(" and ");
		}
		if (!"1000".equals(dimension_2)) {
			sb.append(" dimension <= " + dimension_2);
		}
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
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
			String temp = (String) it.next();
			sb.append(temp + " ");

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
	private String getBuildYearTag(String build_yaer) {
		StringBuffer sb = new StringBuffer();
		if ("NEW".equals(build_yaer)) {
			sb.append("build_year = YEAR(CURDATE())");
		} else if ("3".equals(build_yaer)) {
			sb
					.append("build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 3 YEAR)) AND build_year <= YEAR(CURDATE())");
		} else if ("5".equals(build_yaer)) {
			sb
					.append("build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 5 YEAR)) AND build_year <= YEAR(CURDATE())");
		} else if ("10".equals(build_yaer)) {
			sb
					.append("build_year > YEAR(DATE_SUB(CURDATE(),INTERVAL 10 YEAR)) AND build_year <= YEAR(CURDATE())");
		}
		sb.append(" and build_year > 0 ");
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private ArrayList getHouse_sortTag(HouseBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!Util.isEmpty(bean.getHouse_sort_checked(0)) && "0".equals(bean.getHouse_sort_checked(0))) {
			list.add(" house_sort=0");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(1)) && "1".equals(bean.getHouse_sort_checked(1))) {
			list.add(" house_sort=1");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(2)) && "2".equals(bean.getHouse_sort_checked(2))) {
			list.add(" house_sort=2");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(3)) && "3".equals(bean.getHouse_sort_checked(3))) {
			list.add(" house_sort=3");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(4)) && "4".equals(bean.getHouse_sort_checked(4))) {
			list.add(" house_sort=4");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(5)) && "5".equals(bean.getHouse_sort_checked(5))) {
			list.add(" house_sort=5");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(6)) && "6".equals(bean.getHouse_sort_checked(6))) {
			list.add(" house_sort=6");
		}
		if (!Util.isEmpty(bean.getHouse_sort_checked(7)) && "7".equals(bean.getHouse_sort_checked(7))) {
			list.add(" house_sort=7");
		}
		return list;
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();

		if (list.size() > 0) {
			sb.append(" where ");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" and ");
			}
			isNotFirst = true;
			String temp = (String) it.next();
			sb.append(temp + " ");

		}
		return sb.toString();

	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAllStairsTag(String all_stairs) {
		StringBuffer sb = new StringBuffer();
		sb.append("all_stairs = " + all_stairs);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getHouseFeeTag(String house_fee_from, String house_fee_to) {
		StringBuffer sb = new StringBuffer();
		int house_fee1 = Integer.parseInt(house_fee_from) * 10000;
		int house_fee2 = Integer.parseInt(house_fee_to) * 10000;
		if (!"100".equals(house_fee_from)) {
			sb.append(" house_fee >= " + house_fee1);
		}
		if (!"100".equals(house_fee_from) && !"100".equals(house_fee_to)) {
			sb.append(" and ");
		}
		if (!"100".equals(house_fee_to)) {
			sb.append(" house_fee <= " + house_fee2);
		}

		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getStairsTag(String stairs) {
		StringBuffer sb = new StringBuffer();
		if ("2".equals(stairs)) {
			sb.append("stairs>=2");
		}
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getFlgTadamiTag(String flg_tadami) {
		StringBuffer sb = new StringBuffer();
		sb.append("flg_tadami = " + flg_tadami);
		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getToiletTag(String toilet) {
		StringBuffer sb = new StringBuffer();
		sb.append("toilet = " + toilet);
		return sb.toString();
	}

	/**
	 * house_fee1�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */

	public static String getHouseFee1Tag(String house_fee1) {
		StringBuffer sb = new StringBuffer();
		int house_fee1Int = 0;
		while (house_fee1Int <= 30) {
			sb.append("<option");
			if (house_fee1 != null && !"".equals(house_fee1)
					&& Integer.parseInt(house_fee1) == house_fee1Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(house_fee1Int + "'>");
			sb.append(house_fee1Int);
			sb.append("</option>");
			house_fee1Int = house_fee1Int + 1;
		}
		return sb.toString();
	}

	/**
	 * house_fee2�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */
	public static String getHouseFee2Tag(String house_fee1, String house_fee2) {
		StringBuffer sb = new StringBuffer();
		int house_fee1Int = 0;
		if (Util.isEmpty(house_fee1)) {
			house_fee1Int = 1;
		} else {
			house_fee1Int = Integer.parseInt(house_fee1) + 1;
		}
		int house_fee2Int = 0;
		if (!Util.isEmpty(house_fee2)) {
			house_fee2Int = Integer.parseInt(house_fee2);
		}

		while (house_fee1Int <= 30) {
			sb.append("<option");
			if (house_fee2 != null && house_fee1Int == house_fee2Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(house_fee1Int + "'>");
			sb.append(house_fee1Int);
			sb.append("</option>");
			house_fee1Int = house_fee1Int + 1;
		}
		return sb.toString();
	}
	
	/**
	 * house_fee1�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */

	public static String getHouse_feeBuy1Tag(String house_fee1) {
		StringBuffer sb = new StringBuffer();
		int house_fee1Int = 0;
		for (int i = 0; i <= 10; i++) {
			sb.append("<option");
			if (house_fee1 != null && !"".equals(house_fee1)
					&& Integer.parseInt(house_fee1) == house_fee1Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(house_fee1Int + "'>");
			if (i < 10) {
				sb.append(house_fee1Int);
				sb.append("���~");
			}
			if (i == 10) {
				sb.append("1���~");
			}
			
			sb.append("</option>");
			house_fee1Int = house_fee1Int + 1000;
		}
		return sb.toString();
	}

	/**
	 * house_fee2�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */
	public static String getHouse_feeBuy2Tag(String house_fee1, String house_fee2) {
		StringBuffer sb = new StringBuffer();
		int house_fee1Int = 0;
		if (Util.isEmpty(house_fee1)) {
			house_fee1Int = 1000;
		} else {
			house_fee1Int = Integer.parseInt(house_fee1) + 1000;
		}
		int house_fee2Int = 0;
		if (!Util.isEmpty(house_fee2)) {
			house_fee2Int = Integer.parseInt(house_fee2);
		}

		for (int i = (house_fee1Int / 1000) ; i <= 10; i++) {
			sb.append("<option");
			if (house_fee2 != null && house_fee1Int == house_fee2Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(house_fee1Int + "'>");
			if (i < 10) {
				sb.append(house_fee1Int);
				sb.append("���~");
			}
			if (i == 10) {
				sb.append("1���~");
			}
			
			sb.append("</option>");
			house_fee1Int = house_fee1Int + 1000;
		}
		return sb.toString();
	}
	
	
	
	
	
	
	public static String getRoomFee1Tag(String room_fee1) {
		StringBuffer sb = new StringBuffer();
		int room_fee1Int = 0;
		while (room_fee1Int <= 60000) {
			sb.append("<option");
			if (room_fee1 != null && !"".equals(room_fee1)
					&& Integer.parseInt(room_fee1) == room_fee1Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(room_fee1Int + "'>");
			sb.append(room_fee1Int);
			sb.append("</option>");
			room_fee1Int = room_fee1Int + 2000;
		}
		return sb.toString();
	}	
	public static String getRoomFee2Tag(String room_fee1, String room_fee2) {
		StringBuffer sb = new StringBuffer();
		int room_fee1Int = 2000;
		if (Util.isEmpty(room_fee1)) {
			//room_fee1Int = 0;
		} else {
			room_fee1Int = Integer.parseInt(room_fee1) + 2000;
		}
		int room_fee2Int = 0;
		if (!Util.isEmpty(room_fee2)) {
			room_fee2Int = Integer.parseInt(room_fee2);
		}

		while (room_fee1Int <= 60000) {
			sb.append("<option");
			if (room_fee2 != null && room_fee1Int == room_fee2Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(room_fee1Int + "'>");
			sb.append(room_fee1Int);
			sb.append("</option>");
			room_fee1Int = room_fee1Int + 2000;
		}
		return sb.toString();
	}

	/**
	 * interpret_fee1�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */

	public static String getInterpretFee1Tag(String interpret_fee1) {
		StringBuffer sb = new StringBuffer();
		int interpret_fee1Int = 0;
		while (interpret_fee1Int <= 10) {
			sb.append("<option");
			if (interpret_fee1 != null && !"".equals(interpret_fee1)
					&& Integer.parseInt(interpret_fee1) == interpret_fee1Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(interpret_fee1Int + "'>");
			sb.append(interpret_fee1Int);
			sb.append("</option>");
			interpret_fee1Int = interpret_fee1Int + 1;
		}
		return sb.toString();
	}

	/**
	 * house_fee2�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */
	public static String getInterpretFee2Tag(String interpret_fee1, String interpret_fee2) {
		StringBuffer sb = new StringBuffer();
		int interpret_fee1Int = 0;
		if (Util.isEmpty(interpret_fee1)) {
			interpret_fee1Int = 1;
		} else {
			interpret_fee1Int = Integer.parseInt(interpret_fee1) + 1;
		}
		int house_fee2Int = 0;
		if (!Util.isEmpty(interpret_fee2)) {
			house_fee2Int = Integer.parseInt(interpret_fee2);
		}

		while (interpret_fee1Int <= 10) {
			sb.append("<option");
			if (interpret_fee2 != null && interpret_fee1Int == house_fee2Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(interpret_fee1Int + "'>");
			sb.append(interpret_fee1Int);
			sb.append("</option>");
			interpret_fee1Int = interpret_fee1Int + 1;
		}
		return sb.toString();
	}



	/**
	 * interpret_fee1�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */

	public static String getAge1Tag(String ages1) {
		StringBuffer sb = new StringBuffer();
		int ageMin = 10;
		int ageMax = 70;
		while (ageMin <= ageMax) {
			sb.append("<option");
			if (ages1 != null && !"".equals(ages1)
					&& Integer.parseInt(ages1) == ageMin) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(ageMin + "'>");
			sb.append(ageMin);
			sb.append("</option>");
			ageMin = ageMin + 5;
		}
		return sb.toString();
	}

	/**
	 * house_fee2�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */
	public static String getAge2Tag(String ages1, String ages2) {
		StringBuffer sb = new StringBuffer();
		int ageMin = 10;
		int ageMax = 70;
		if (Util.isEmpty(ages1)) {
			ageMin = 100;
		} else {
			ageMin = Integer.parseInt(ages1)+5;
		}
		int ages2Int = 0;
		if (!Util.isEmpty(ages2)) {
			ages2Int = Integer.parseInt(ages2);
		}

		while (ageMin <= ageMax) {
			sb.append("<option");
			if (ages2 != null && ageMin == ages2Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(ageMin + "'>");
			sb.append(ageMin);
			sb.append("</option>");
			ageMin = ageMin + 5;
		}
		return sb.toString();
	}

	/**
	 * dimension1�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */

	public static String getDimension1Tag(String dimension1) {
		StringBuffer sb = new StringBuffer();
		int dimension1Int = 10;

		while (dimension1Int <= 150) {
			sb.append("<option");
			if (dimension1 != null && !"".equals(dimension1)
					&& Integer.parseInt(dimension1) == dimension1Int) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(dimension1Int + "'>");
			sb.append(dimension1Int);
			sb.append("</option>");
			dimension1Int = dimension1Int + 10;
		}
		return sb.toString();
	}

	/**
	 * dimension2�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 */
	public static String getDimension2Tag(String dimension1, String dimension2) {
		StringBuffer sb = new StringBuffer();
		int dimension1Int = 0;
		if (!Util.isEmpty(dimension1)) {
			dimension1Int = Integer.parseInt(dimension1) + 10;
		} else {
			dimension1Int = 10;
		}
		int dimension2Int = 0;
		if (!Util.isEmpty(dimension2)) {
			dimension2Int = Integer.parseInt(dimension2);
		}

		while (dimension1Int <= 150) {
			sb.append("<option");
			if (dimension2 != null && (dimension1Int == dimension2Int)) {
				sb.append(" selected");
			}
			sb.append(" value='");
			sb.append(dimension1Int + "'>");
			sb.append(dimension1Int);
			sb.append("</option>");
			dimension1Int = dimension1Int + 10;
		}
		return sb.toString();
	}
	
	/////////////////////////////////////////////////////////////////////////////
	/**
	 * �n��R�[�h�P�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea1TagFromMap(String areaCode1, SortedMap areaMap) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea1InfoFromMap(areaMap);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();
			sb.append("<option ");
			if (areaCode1 != null && areaCode1.equals(bean.getArea_code_1())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getArea_code_1() + "'>");
			sb.append(bean.getArea_name_1());
			sb.append("</option>");
		}
		return sb.toString();

	}
	/**
	 * �n��R�[�h�Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea2TagFromMap(String areaCode1, String areaCode2, SortedMap areaMap)
			throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea2InfoFromMap(areaCode1, areaMap);
	
		Iterator it = list.iterator();

		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();

			sb.append("<option ");

			if (areaCode2 != null && areaCode2.equals(bean.getArea_code_2())) {
				sb.append("selected");
			}

			sb.append(" value='");
			sb.append(bean.getArea_code_2() + "'>");
			sb.append(bean.getArea_name_2());
			sb.append("</option>");
		}
		return sb.toString();

	}
	
	public static String getTrainLineTagFromMap(String lineCode, SortedMap lineMap) throws AppException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getTrainLineInfoFromMap(lineMap);
		Iterator it = list.iterator();
		while (it.hasNext()) {

			TrainBean bean = (TrainBean) it.next();
			sb.append("<option ");
			if (lineCode != null && lineCode.equals(bean.getLine_code())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getLine_code() + "'>");
			sb.append(bean.getLine_kanji());
			sb.append("</option>");
		}

		return sb.toString();
	}
	
	public static String getStationTagFromMap(String lineCode, String stationCode, SortedMap stationMap)
	throws AppException {
		StringBuffer sb = new StringBuffer();
		if(Util.isEmpty(lineCode)){
			lineCode = "00";
		}
		ArrayList list = getStationInfoListFromMap(lineCode, stationMap);
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			TrainBean bean = (TrainBean) it.next();
			sb.append("<option");
			if (stationCode != null
					&& stationCode.equals(bean.getStation_code())) {
				sb.append(" selected");
			}
			sb.append(" value='");
		
			sb.append(bean.getStation_code() + "'>");
			sb.append(bean.getStation_kanji());
			sb.append("</option>");
		
		}
		
		return sb.toString();
	}
	
	/**
	 * �J�e�S���P�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getCate1TagFromMap(String cate_code_1, SortedMap category1Map) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getCate1InfoFromMap(category1Map);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			CategoryBean bean = (CategoryBean) it.next();
			sb.append("<option ");
			if (!Util.isEmpty(cate_code_1) && cate_code_1.equals(bean.getCate_code())) {
				sb.append("selected");
			}
			sb.append(" value='");
			sb.append(bean.getCate_code() + "'>");
			sb.append(bean.getCate_name());
			sb.append("</option>");
		}
		return sb.toString();

	}
	
	/**
	 * �J�e�S���Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getCate2TagFromMap(
			String cate_code_1, String cate_code_2, SortedMap category2Map) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getCate2InfoFromMap(cate_code_1, category2Map);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			CategoryBean bean = (CategoryBean) it.next();

			sb.append("<option ");

			if (cate_code_2 != null && cate_code_2.equals(bean.getCate_code_2())) {
				sb.append("selected");
			}

			sb.append(" value='");
			sb.append(bean.getCate_code_2() + "'>");
			sb.append(bean.getCate_name_2());
			sb.append("</option>");
		}
		return sb.toString();

	}
	
	
	/**
	 * ��̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<TrainBean> getTrainLineInfoFromMap(SortedMap lineMap) {
	
		ArrayList<TrainBean> list = new ArrayList<TrainBean>();
		Set set = lineMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			TrainBean bean = new TrainBean();
			bean.setLine_code(key);
			bean.setLine_kanji((String) lineMap.get(key));
			list.add(bean);

		}
		return list;

	}
	
	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<AreaBean> getArea1InfoFromMap(SortedMap areaMap) throws SysException {
		
		ArrayList<AreaBean> list = new ArrayList<AreaBean>();
		Set set = areaMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			AreaBean bean = new AreaBean();
			bean.setArea_code_1(key);
			bean.setArea_name_1((String) areaMap.get(key));
			list.add(bean);

		}
		return list;
	}
	
	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<AreaBean> getArea2InfoFromMap(
			String areaCode1, SortedMap areaMap) throws SysException {

		if(Util.isEmpty(areaCode1)){
			areaCode1 = "00";
		} 
		ArrayList<AreaBean> list = new ArrayList<AreaBean>();
		Set set = areaMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			if (areaCode1.equals(key.substring(0, 2))) {
				AreaBean bean = new AreaBean();
				bean.setArea_code_2(key);
				bean.setArea_name_2((String) areaMap.get(key));
				list.add(bean);
			}
		}		
		return list;

	}
	/**
	 * �w�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<TrainBean> getStationInfoListFromMap(String lineCode, SortedMap stationMap){
		
		if(Util.isEmpty(lineCode)){
			lineCode = "00";
		}
		
		ArrayList<TrainBean> list = new ArrayList<TrainBean>();
		Set set = stationMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			if(lineCode.equals(key.substring(0,2))){
				TrainBean bean = new TrainBean();
				bean.setStation_code(key);
				bean.setStation_kanji((String) stationMap.get(key));
				list.add(bean);				
			}
		}		
		return list;

	}
	
	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<CategoryBean> getCate1InfoFromMap(SortedMap category1Map) throws SysException {
		
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		Set set = category1Map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			CategoryBean bean = new CategoryBean();
			bean.setCate_code(key);
			bean.setCate_name((String) category1Map.get(key));
			list.add(bean);

		}	
		return list;
	}
	
	/**
	 * �n��R�[�h�P�̃��X�g��擾����
	 * 
	 * @return ArrayList
	 * @throws AppException
	 */
	private static ArrayList<CategoryBean> getCate2InfoFromMap(
			String cate_code_1, SortedMap category2Map) throws SysException {
	
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		Set set = category2Map.keySet();
		Iterator it = set.iterator();
		if (!Util.isEmpty(cate_code_1)) {
			while (it.hasNext()){
				String key = (String) it.next();
				if (cate_code_1.substring(2, 4).equals(key.substring(2, 4))) {
					CategoryBean bean = new CategoryBean();
					bean.setCate_code(cate_code_1);
					bean.setCate_code_2(key);
					bean.setCate_name_2((String) category2Map.get(key));
					list.add(bean);
				}
	
			}
		}
		return list;

	}
	
	/***************************************************************************  */
	/**
	 * �n��R�[�h�P�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea1Name(SortedMap areaMap) throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea1InfoFromMap(areaMap);
		Iterator it = list.iterator();
		sb.append("[");
		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();
			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getArea_code_1());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getArea_name_1());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();

	}
	/**
	 * �n��R�[�h�Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getArea2Name(String areaCode1, SortedMap areaMap)
			throws SysException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getArea2InfoFromMap(areaCode1, areaMap);
	
		Iterator it = list.iterator();
		sb.append("[");
		while (it.hasNext()) {

			AreaBean bean = (AreaBean) it.next();

			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getArea_code_2());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getArea_name_2());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
			
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();

	}
	
	/**
	 * �n��R�[�h�Q�̃��X�g�^�O��擾����
	 * 
	 * @return String
	 * @throws AppException
	 */
	public static String getTrainLineName(SortedMap lineMap) throws AppException {
		StringBuffer sb = new StringBuffer();
		ArrayList list = getTrainLineInfoFromMap(lineMap);
		Iterator it = list.iterator();
		sb.append("[");
		while (it.hasNext()) {

			TrainBean bean = (TrainBean) it.next();
			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getLine_code());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getLine_kanji());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
	
	public static String getStationName(String lineCode, SortedMap stationMap)
	throws AppException {
		StringBuffer sb = new StringBuffer();
		if(Util.isEmpty(lineCode)){
			lineCode = "00";
		}
		ArrayList list = getStationInfoListFromMap(lineCode, stationMap);
		Iterator it = list.iterator();
		sb.append("[");
		while (it.hasNext()) {
			TrainBean bean = (TrainBean) it.next();
			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getStation_code());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getStation_kanji());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
		
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public static String getJSONData(Map map) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			System.out.println(entry.getKey());
			common.bean.CategoryBean bean = (common.bean.CategoryBean) entry.getValue();
			
			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getCate_code());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(bean.getCate_name());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
		
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public static String getJSONData(Map map, String code) {
		
		common.bean.CategoryBean oyaBean = (common.bean.CategoryBean) map.get(code);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Iterator it = oyaBean.getChildBeanList().iterator(); it.hasNext();) {
			common.bean.CategoryBean childBean = (common.bean.CategoryBean) it.next();
			sb.append("{");
			sb.append("\"");
			sb.append("name");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(childBean.getCate_code());
			sb.append("\"");
			sb.append(" , ");
			sb.append("\"");
			sb.append("value");
			sb.append("\"");
			sb.append(" : ");
			sb.append("\"");
			sb.append(childBean.getCate_name());
			sb.append("\"");
			sb.append("}");
			sb.append(" ,");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
		
	}
	
	
	/**
	 * 
	 * @param con
	 * @param search
	 * @param pageBean
	 * @return
	 * @throws SysException
	 */
	public static List searchAddressList(Connection con, String search) throws SysException{
		
		List categoryList = searchCategoryList(con, search, "00");
		
		Map condition = new HashMap();
		List getcolumnList = new ArrayList();
		
		getcolumnList.add("*");
		condition.put("" , search);
		
		UtilHandler.sigleTableGetWhereLike(con, "t_areainfo", condition, getcolumnList);
		 
		return categoryList;
	}
	
	public static String getZipCode(Connection con, String code) throws SysException{
		
		String zipcode = "";
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select zipcode from t_areainfo where ");
		sql.append(SQLUtil.makeEqualState("zipcode", code));
		
		try {
			//��ʂɕ\�����鑍�f�[�^����擾
			pstmt = new LogPreparedStatement(con, sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				zipcode = rs.getString("zipcode");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("SYE0033", e);
			

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
			}			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
		}
		
		return zipcode; 
	}
	
	
	
	/**
	 * 
	 * @param con
	 * @param search
	 * @param pageBean
	 * @return
	 * @throws SysException
	 */
	public static List sigleTableGetWhereLike(
			Connection con,
			String tableName,
			Map condition,
			List getcolumnList) throws SysException{
		
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MenuBean> list = null;
		
		StringBuffer sql = new StringBuffer();  
		sql.append("select ");
		
		for (Iterator it = getcolumnList.iterator(); it.hasNext();) {
			
			String column = (String) it.next();
			sql.append(column);
			sql.append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" from ");
		sql.append(tableName);
		sql.append(" where ");
		sql.append(SQLUtil.makelikeSQL(condition));
		
		try {
			pstmt = new LogPreparedStatement(con, sql.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("sigleTableGetWhereLike" + pstmt.getQueryString());
			
			list = SQLUtil.resultSetToList(rs);
		} catch (SQLException e) {
			throw new SysException("SYE0014", e);
		} catch (Exception e) {
			throw new SysException("SYE0014", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0014", e);
				}
		}
	
		return list;
		
	}
	/**
	 * 
	 * @param con
	 * @param search
	 * @param pageBean
	 * @return
	 * @throws SysException
	 */
	public static List searchCategoryList(Connection con, String search, String sortcode) throws SysException{
		
		List list = new ArrayList();
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		StringBuffer sql = new StringBuffer();  
		sql.append("select * from t_cate where ");
		sql.append(" (kana_name like"); 
		sql.append("'" + search + "%'");
		sql.append(" or kanji_name like ");
		sql.append("'" + search + "%') and ");
		sql.append(SQLUtil.makeEqualState("sortcode", sortcode));

		try {
			//��ʂɕ\�����鑍�f�[�^���X�g��擾
			pstmt = new LogPreparedStatement(con, sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String code = rs.getString("code");
				list.add(fullCategoryInfo(con, code, sortcode));
				
			}
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getSearchStoreListTotal" + pstmt.getQueryString());

			//���ʂ㊃X�g�Ɋi�[

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("SYE0033", e);
			

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
			}			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
		}
		return list;
		
	}
	/**
	 * 
	 * @param con
	 * @param code
	 * @return
	 * @throws SysException
	 */
	public static MenuBean fullCategoryInfo(Connection con, String code, String sortcode) throws SysException{
		
		MenuBean menuBean = new MenuBean();
		List codeList = new ArrayList();
		List kanjiNameList = new ArrayList();
		List kanaNameList = new ArrayList();
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			do {
				StringBuffer sql = new StringBuffer();  
				sql.append("select * from t_cate where ");
				sql.append(SQLUtil.makeEqualState("code", code));
				sql.append(" and ");
				sql.append(SQLUtil.makeEqualState("sortcode", sortcode));
				
					//��ʂɕ\�����鑍�f�[�^����擾
					pstmt = new LogPreparedStatement(con, sql.toString());
					rs = pstmt.executeQuery();
					KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getSearchStoreListTotal" + pstmt.getQueryString());
					if (rs.next()) {
						code = rs.getString("oya_code");
						
						codeList.add(rs.getString("code"));
						kanjiNameList.add(rs.getString("kanji_name"));
						kanaNameList.add(rs.getString("kana_name"));
					} else {
						code = null;
					}
				
			} while (!Util.isEmpty(code));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("SYE0033", e);
			

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
			}			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
		}
		menuBean.put("code", codeList);
		menuBean.put("kanjiName", kanjiNameList);
		menuBean.put("kanaName", kanaNameList);
		
		return menuBean;
		
	}
	/**
	 * 
	 * @param con
	 * @param categoryList
	 * @param sortcode
	 * @throws SysException
	 */
	public static void joinOyaInfo(Connection con, List categoryList, String sortcode) throws SysException{
		for (Iterator it = categoryList.iterator(); it.hasNext();) {
			MenuBean bean = (MenuBean) it.next();
			String kananame = (String) bean.get("kana_name");
			String kanjiname = (String) bean.get("kanji_name");
			String code = (String) bean.get("oya_code");
			MenuBean oyabean = fullCategoryInfo(con, code, sortcode);
			List oyakanjiName = (List) oyabean.get("kanjiName");
			List oyakanaName = (List) oyabean.get("kanaName");
			oyakanjiName.add(0, kanjiname);
			oyakanaName.add(0, kananame);
			
			bean.put("kanjiName", oyakanjiName);
			bean.put("kanaName", oyakanaName);
		}
		
	}
	
	/**
	 * @param menu
	 * @throws SysException
	 */
	public static void getCategoryMenu1(
			String categoryCode) throws SysException {
		
	}
	/**
	 * @param menu
	 * @throws SysException
	 */
	public static void getCategoryMenu2(
			SortedMap category1Map) throws SysException {
		List category1List = getCategory1ListFromMap(category1Map);
		
	}
	/**
	 * @param menu
	 * @throws SysException
	 */
	public static void getCategoryMenu3(
			String categoryCode,
			SortedMap category2Map) throws SysException {
		List category2List = getCategory2ListFromMap(categoryCode, category2Map);
		
	}
	
}