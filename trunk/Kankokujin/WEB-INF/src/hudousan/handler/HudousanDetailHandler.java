package hudousan.handler;

import hudousan.bean.HudousanBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class HudousanDetailHandler {
	private static HudousanDetailHandler instance = null;
	private HudousanDetailHandler(){
		
	}
    public static HudousanDetailHandler getInstance() {
        if (instance == null) {
            synchronized (HudousanDetailHandler.class) {
                if (instance == null) {
                    instance = new HudousanDetailHandler();
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
	public HudousanBean getHudousanBean(String id, String leaseSign,boolean updateflg, boolean brflg) throws AppException {
		Connection con = null;
		HudousanBean bean = new HudousanBean();
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			if(updateflg){
				String strSql = "update hudousan set read_count = read_count + 1 where id = ?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, bean.getId());
				pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("HouseSellDetailHandler.getHouseBean.sql1=" + pstmt1.getQueryString());
			}
			StringBuffer sb = new StringBuffer();
			sb.append("select * FROM  hudousan AS M ");
			sb.append("INNER JOIN member AS A ON M.user_id=A.user_id ");
			sb.append("INNER JOIN t_area AS B ON M.area_code_1=B.area_code_1 AND M.area_code_2=B.area_code_2 ");
			sb.append("INNER JOIN t_train AS C ON M.line_code=C.line_code AND M.station_code=C.station_code ");
			sb.append("where M.id = ? AND M.lease_sign = ?");
			pstmt2 = new LogPreparedStatement(con, sb.toString());
			pstmt2.setString(1, id);
			pstmt2.setString(2, leaseSign);
			rs = pstmt2.executeQuery();
			System.out.println(pstmt2.getQueryString());
			KankokujinLogger.getInstance().debug("HouseSellDetailHandler.getHouseBean.sql2=" + pstmt2.getQueryString());
			if (rs.next()) {
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setTitle(rs.getString("title"));
				bean.setHouse_name(rs.getString("house_name"));
				if(brflg){
					bean.setDetail_info(Util.changeRnToBrTag(rs.getString("detail_info")));
					
				} else {
					bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				}
				
				bean.setManage_fee(Util.changePriceToMan(rs.getString("manage_fee")));
				bean.setHouse_sort(rs
						.getString("house_sort"));
				bean.setDimension(new String[]{Util.changeNullStr(rs.getString("dimension"))});
				bean.setHouse_fee(new String[]{Util.changePriceToMan(rs.getString("house_fee"))});
				bean.setDeposit(rs.getString("deposit"));
				bean.setReikin(rs.getString("reikin"));
				bean.setWalk_time(Util.changeNullStr(rs.getString("walk_time")));
				bean.setBuild_year(rs.getString("build_year"));
				bean.setBuild_month(rs.getString("build_month"));
				bean.setMadori(rs.getString("madori"));
				bean.setAll_stairs(rs.getString("all_stairs"));
				bean.setStairs(rs.getString("stairs"));
				bean.setFlg_tadami(rs.getString("flg_tadami"));
				bean.setToilet(Util.changeNullStr(rs.getString("toilet")));
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
				
				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setPhoto_name5(rs.getString("photo_name5"));
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setEmail(rs.getString("email"));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));				
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setPoint_compass(rs.getString("point_compass"));
				bean.setCome_dock(rs.getString("come_dock"));
				bean.setCome_dock_year(rs.getString("come_dock_year"));
				bean.setCome_dock_month(rs.getString("come_dock_month"));
				bean.setGuaranty_money(rs.getString("guaranty_money"));
				bean.setMadori_info(rs.getString("madori_info"));
				bean.setHouse_option(Util.changeStrToArray(rs
						.getString("house_option")));
			}
		} catch (SQLException e) {
			throw new AppException("SQLException", e);

		} catch (Exception e) {
			throw new AppException("Exception" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			if (pstmt2 != null)
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}				
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}