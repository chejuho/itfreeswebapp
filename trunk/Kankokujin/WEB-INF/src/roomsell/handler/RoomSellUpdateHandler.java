package roomsell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import roomsell.bean.RoomBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class RoomSellUpdateHandler {
	private static RoomSellUpdateHandler instance = null;
	private RoomSellUpdateHandler(){
		
	}
    public static RoomSellUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (RoomSellUpdateHandler.class) {
                if (instance == null) {
                    instance = new RoomSellUpdateHandler();
                }
            }
        }

        return instance;
    }	
	public boolean updateRoomSellBean(RoomBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update room_info set title=?, room_name=?, room_sort=?, build_sort=?, main_area=?,");
			sb.append("area_fast=?, area_code_1=?, area_code_2=?, area_code_3=?, line_code=?,");
			sb.append("station_code=?, walk_time=?, room_fee=?, fee_unit=?, equipment_fee=?,");
			sb.append("deposit_fee=?, entrance_fee=?,room_type=?, sex=?, email=?, url=?,");
			sb.append("tel_no1_1=?, tel_no1_2=?, tel_no1_3=?, tel_no2_1=?, tel_no2_2=?,");
			sb.append("tel_no2_3=?, photo_name1=?,photo_name2=?,photo_name3=?,photo_name4=?,");
			sb.append("photo_name5=?, detail_info=?, update_date=(now()) where id=?");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getRoom_name());
			pstmt.setString(3, bean.getRoom_sort());
			pstmt.setString(4, Util.changeNullStrToNull(bean.getBuild_sort()));
			pstmt.setString(5, bean.getMain_area());
			pstmt.setString(6, bean.getArea_fast());
			pstmt.setString(7, Util.changeNullCode(0, bean.getArea_code_1()));
			pstmt.setString(8, Util.changeNullCode(1, bean.getArea_code_2()));
			pstmt.setString(9, bean.getArea_code_3());
			pstmt.setString(10, Util.changeNullCode(0, bean.getLine_code()));
			pstmt.setString(11, Util.changeNullCode(1, bean.getStation_code()));
			pstmt.setString(12, Util.changeNullStrToNull(bean.getWalk_time()));			
			pstmt.setString(13, bean.getRoom_fee());
			pstmt.setString(14, bean.getFee_unit());
			pstmt.setString(15, bean.getEquipment_fee());
			pstmt.setString(16, bean.getDeposit_fee());
			pstmt.setString(17, bean.getEntrance_fee());
			pstmt.setString(18, bean.getRoom_type());
			pstmt.setString(19, bean.getSex());
			pstmt.setString(20, bean.getEmail());
			pstmt.setString(21, bean.getUrl());
			pstmt.setString(22, bean.getTel_no1_1());
			pstmt.setString(23, bean.getTel_no1_2());
			pstmt.setString(24, bean.getTel_no1_3());
			pstmt.setString(25, bean.getTel_no2_1());
			pstmt.setString(26, bean.getTel_no2_2());
			pstmt.setString(27, bean.getTel_no2_3());			
			pstmt.setString(28, bean.getPhoto_name1());
			pstmt.setString(29, bean.getPhoto_name2());
			pstmt.setString(30, bean.getPhoto_name3());
			pstmt.setString(31, bean.getPhoto_name4());
			pstmt.setString(32, bean.getPhoto_name5());
			pstmt.setString(33, bean.getDetail_info());
			pstmt.setString(34, bean.getId());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("RoomSellUpdateHandler.updateRoomSellBean sql =" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new AppException("Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	
}