package housesell.handler;

import housesell.bean.HouseBean;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class HouseSellUpdateHandler {
	private static HouseSellUpdateHandler instance = null;
	private HouseSellUpdateHandler(){
		
	}
    public static HouseSellUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (HouseSellUpdateHandler.class) {
                if (instance == null) {
                    instance = new HouseSellUpdateHandler();
                }
            }
        }

        return instance;
    }
	public boolean updateHouseSellBean(HouseBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update house_info set title=?, house_name=?, detail_info=?, manage_fee=?, house_sort=?,");
			sb.append("dimension=?, house_fee=?, deposit=?, reikin=?, walk_time=?, build_year=?, madori=?,");
			sb.append("all_stairs=?, stairs=?, flg_tadami=?, toilet=?, line_code=?, station_code=?, photo_name1=?, photo_name2=?,");
			sb.append("photo_name3=?, photo_name4=?, area_code_1=?, area_code_2=?, main_area=?, user_id=?, email=?, tel_no1_1=?, tel_no1_2=?, tel_no1_3=?, tel_no2_1=?, tel_no2_2=?, tel_no2_3=?, photo_name5=?,");
			sb.append("area_fast=?, area_code_3=?, point_compass=?,come_dock=?,come_dock_year=?,come_dock_month=?,build_month=?,");
			sb.append("guaranty_money=?,house_option=?,madori_info=?,update_date=(now()) , read_count= 0 where id=? ");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getHouse_name());
			pstmt.setString(3, bean.getDetail_info());
			pstmt.setString(4, Util.changeNullStrToNull(bean.getManage_fee()));
			pstmt.setString(5, bean.getHouse_sort());
			pstmt.setString(6, Util.changeNullStrToNull(bean.getDimension()[0]));
			pstmt.setString(7, Util.changeNullStrToNull(bean.getHouse_fee()[0]));
			pstmt.setString(8, bean.getDeposit());
			pstmt.setString(9, bean.getReikin());
			pstmt.setString(10, Util.changeNullStrToNull(bean.getWalk_time()));
			pstmt.setString(11, bean.getBuild_year());
			pstmt.setString(12, bean.getMadori());
			pstmt.setString(13, bean.getAll_stairs());
			pstmt.setString(14, bean.getStairs());
			pstmt.setString(15, bean.getFlg_tadami());
			//pstmt.setString(16, bean.getToilet()[0]);
			pstmt.setString(16, bean.getToilet());
			pstmt.setString(17, Util.changeNullCode(0, bean.getLine_code()));
			pstmt.setString(18, Util.changeNullCode(0, bean.getStation_code()));
			pstmt.setString(19, bean.getPhoto_name1());
			pstmt.setString(20, bean.getPhoto_name2());
			pstmt.setString(21, bean.getPhoto_name3());
			pstmt.setString(22, bean.getPhoto_name4());
			pstmt.setString(23, Util.changeNullCode(0, bean.getArea_code_1()));
			pstmt.setString(24, Util.changeNullCode(1, bean.getArea_code_2()));
			pstmt.setString(25, bean.getMain_area());
			pstmt.setString(26, bean.getUser_id());
			pstmt.setString(27, bean.getEmail());
			pstmt.setString(28, bean.getTel_no1_1());
			pstmt.setString(29, bean.getTel_no1_2());
			pstmt.setString(30, bean.getTel_no1_3());
			pstmt.setString(31, bean.getTel_no2_1());
			pstmt.setString(32, bean.getTel_no2_2());
			pstmt.setString(33, bean.getTel_no2_3());
			pstmt.setString(34, bean.getPhoto_name5());
			pstmt.setString(35, bean.getArea_fast());
			pstmt.setString(36, bean.getArea_code_3());
			pstmt.setString(37, bean.getPoint_compass());
			pstmt.setString(38, bean.getCome_dock());
			pstmt.setString(39, bean.getCome_dock_year());
			pstmt.setString(40, bean.getCome_dock_month());
			pstmt.setString(41, bean.getBuild_month());
			pstmt.setString(42, bean.getGuaranty_money());
			pstmt.setString(43, Util.changeArrayToStr(bean.getHouse_option()));
			pstmt.setString(44, bean.getMadori_info());
			pstmt.setString(45, bean.getId());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("HouseSellUpdateHandler.getHouseBeanList" + pstmt.getQueryString());
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