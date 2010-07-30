package store.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import roomsell.handler.RoomSellDetailHandler;
import store.bean.StoreBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class StoreDetailHandler {
	
	private static StoreDetailHandler instance = null;

	private StoreDetailHandler() {

	}

	public static StoreDetailHandler getInstance() {
		if (instance == null) {
			synchronized (StoreDetailHandler.class) {
				if (instance == null) {
					instance = new StoreDetailHandler();
				}
			}
		}

		return instance;
	}
	
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public StoreBean getStoreBean(StoreBean bean, boolean updateflg, boolean brflg) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			if(updateflg){
				String strSql = "update store_info set read_count = read_count + 1 where id = ?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, bean.getId());
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("StoreDetailHandler.getStoreBean" + pstmt1.getQueryString());
				if (result == 1) {
					//return bean;
				}				
			}

			StringBuffer sb = new StringBuffer();
			sb.append("select * from store_info, member, t_area , t_train, t_store_category where ");
			sb.append("store_info.id = ? and member.user_id=store_info.user_id and ");
			sb.append("store_info.area_code_1=t_area.area_code_1 and store_info.area_code_2=t_area.area_code_2 and ");
			sb.append("store_info.line_code=t_train.line_code and store_info.station_code=t_train.station_code and ");
			sb.append("store_info.cate_code_1=t_store_category.cate_code_1 and ");
			sb.append("store_info.cate_code_2=t_store_category.cate_code_2 ");
			pstmt2 = new LogPreparedStatement(con, sb.toString());
			pstmt2.setString(1, bean.getId());
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("StoreDetailHandler.getStoreBean" + pstmt2.getQueryString());
			if (rs.next()) {

				bean.setId(rs.getString("id"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setStore_name_k(Util.changeNullStr(rs.getString("store_name_k")));
				bean.setStore_name_j(Util.changeNullStr(rs.getString("store_name_j")));
				bean.setSearch_word(Util.changeNullStr(rs.getString("search_word")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setFax_no_1(Util.changeNullStr(rs.getString("fax_no_1")));
				bean.setFax_no_2(Util.changeNullStr(rs.getString("fax_no_2")));
				bean.setFax_no_3(Util.changeNullStr(rs.getString("fax_no_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setUrl(Util.changeNullStr(rs.getString("url")));
				bean.setWork_time(Util.changeNullStr(rs.getString("work_time")));
				bean.setRest_day(Util.changeNullStr(rs.getString("rest_day")));
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setPhoto_name2(Util.changeNullStr(rs.getString("photo_name2")));
				bean.setPhoto_name3(Util.changeNullStr(rs.getString("photo_name3")));
				bean.setPhoto_name4(Util.changeNullStr(rs.getString("photo_name4")));
				bean.setPhoto_name5(Util.changeNullStr(rs.getString("photo_name5")));		
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				if(!"00".equals(bean.getArea_code_1())){
					bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
				}
				if(!"00".equals(bean.getArea_code_2().substring(2, 4))){
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}				
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if(!"00".equals(bean.getLine_code())){
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if(!"00".equals(bean.getStation_code().substring(2, 4))){
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setCate_name_1(Util.changeNullStr(rs.getString("category_name_1")));
				bean.setCate_name_2(Util.changeNullStr(rs.getString("category_name_2")));				
				bean.setArea_fast(Util.changeNullStr(rs.getString("area_fast")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				if(brflg){
					bean.setDetail_info(Util.changeRnToBrTag(Util.changeNullStr(rs.getString("detail_info"))));
				} else {
					bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				}
				
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
				
			}
		} catch (SQLException e) {
			throw new SysException("SYE0015", e);

		} catch (Exception e) {
			throw new SysException("SYE0015" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}
			if (pstmt2 != null)
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}				
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}
