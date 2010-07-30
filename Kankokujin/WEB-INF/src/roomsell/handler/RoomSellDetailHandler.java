package roomsell.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import roomsell.bean.RoomBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class RoomSellDetailHandler {
	private static RoomSellDetailHandler instance = null;

	private RoomSellDetailHandler() {

	}

	public static RoomSellDetailHandler getInstance() {
		if (instance == null) {
			synchronized (RoomSellDetailHandler.class) {
				if (instance == null) {
					instance = new RoomSellDetailHandler();
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
	public RoomBean getRoomBean(RoomBean bean, boolean updateflg, boolean brflg)
			throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			if (updateflg) {
				String strSql = "update room_info set read_count = read_count + 1 where id=?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, bean.getId());
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("RoomSellDetailHandler.getRoomBean.sql1=" + pstmt1.getQueryString());
				if (result == 1) {

				}
			}			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from room_info, member, t_area , t_train where id = ? and ");
			sb.append("member.user_id=room_info.user_id and ");	
			sb.append("room_info.area_code_1=t_area.area_code_1 and room_info.area_code_2=t_area.area_code_2 and ");
			sb.append("room_info.line_code=t_train.line_code and room_info.station_code=t_train.station_code ");
			pstmt2 = new LogPreparedStatement(con, sb.toString());
			pstmt2.setString(1, bean.getId());
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("RoomSellDetailHandler.getRoomBean.sql1=" + pstmt2.getQueryString());
			if (rs.next()) {
				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setTitle(rs.getString("title"));
				bean.setRoom_name(rs.getString("room_name"));
				bean.setRoom_sort(rs.getString("room_sort"));
				bean.setBuild_sort(rs.getString("build_sort"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setArea_fast(rs.getString("area_fast"));
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
				
				bean.setArea_code_3(rs.getString("area_code_3"));
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setWalk_time(Util.changeNullStr(rs.getString("walk_time")));
				if("C10002".equals(bean.getCate_code_1())){
					bean.setRoom_fee(Util.changePriceToMan(rs.getString("room_fee")));	
				} else {
					bean.setRoom_fee(rs.getString("room_fee"));
				}
				bean.setFee_unit(rs.getString("fee_unit"));
				bean.setEquipment_fee(rs.getString("equipment_fee"));
				bean.setDeposit_fee(rs.getString("deposit_fee"));
				bean.setEntrance_fee(rs.getString("entrance_fee"));
				bean.setRoom_type(rs.getString("room_type"));
				bean.setSex(rs.getString("sex"));
				bean.setEmail(rs.getString("email"));
				bean.setUrl(rs.getString("url"));
				bean.setTel_no1_1(rs.getString("tel_no1_1"));
				bean.setTel_no1_2(rs.getString("tel_no1_2"));
				bean.setTel_no1_3(rs.getString("tel_no1_3"));
				bean.setTel_no2_1(rs.getString("tel_no2_1"));
				bean.setTel_no2_2(rs.getString("tel_no2_2"));
				bean.setTel_no2_3(rs.getString("tel_no2_3"));

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setPhoto_name5(rs.getString("photo_name5"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(rs.getString("read_count"));
				if(brflg){
					bean.setDetail_info(Util.changeRnToBrTag(rs
							.getString("detail_info")));
				} else {
					bean.setDetail_info(Util.changeNullStr(rs
							.getString("detail_info")));
				}

			}
		} catch (SQLException e) {
			throw new AppException("SQLException", e);

		} catch (Exception e) {
			throw new AppException("Exception", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt1 != null){
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt2 != null){
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}			
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}