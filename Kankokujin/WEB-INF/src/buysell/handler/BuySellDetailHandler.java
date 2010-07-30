package buysell.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import buysell.bean.BuySellBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class BuySellDetailHandler {
	private static BuySellDetailHandler instance = null;
	private BuySellDetailHandler(){
		
	}
    public static BuySellDetailHandler getInstance() {
        if (instance == null) {
            synchronized (BuySellDetailHandler.class) {
                if (instance == null) {
                    instance = new BuySellDetailHandler();
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
	public BuySellBean getBuySellBean(BuySellBean bean, boolean updateflg, boolean brflg)
			throws SysException {

		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			if (updateflg) {
				String strSql = "update buysell_info set read_count = read_count + 1 where id = ?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, bean.getId());
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("BuySellDetailHandler.getBuySellBean sql1=" + pstmt1.getQueryString());
				if (result == 1) {
					// return bean;
				}
			}
			StringBuffer sb = new StringBuffer("select * from buysell_info,t_buysell_category, member  where buysell_info.id = ? and ");
			sb.append(" member.user_id=buysell_info.user_id and ");			
			sb.append(" buysell_info.cate_code_1=t_buysell_category.cate_code_1 and ");
			sb.append(" buysell_info.cate_code_2=t_buysell_category.cate_code_2 ");			

			pstmt2 = new LogPreparedStatement(con, sb.toString());
			pstmt2.setString(1, bean.getId());
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("BuySellDetailHandler.getBuySellBean sql2=" + pstmt2.getQueryString());
			
			if (rs.next()) {

				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setUser_name(rs.getString("name"));
				if ("2".equals(rs.getString("deleteflg"))) {
					bean.setTitle("<img src='jsp/images/common/img_soldout.gif'> " + rs.getString("title"));
				} else {
					bean.setTitle(rs.getString("title"));
				}
				if (!"1".equals(Util.changeNullStr(rs.getString("free_price"))) && !"0".equals(rs.getString("price"))) {
					bean.setPrice(rs.getString("price"));
					bean.setPrice_unit(Util.changeNullStr(rs.getString("price_unit")));
				}
				bean.setSell_place(rs.getString("sell_place"));
				bean.setSend_method(Util.changeNullStr(rs.getString("send_method")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setFree_price(Util.changeNullStr(rs.getString("free_price")));

				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setCate_name_1(rs.getString("category_name_1"));
				bean.setCate_name_2(rs.getString("category_name_2"));
				if(brflg){
					bean.setDetail_info(Util.changeRnToBrTag(rs.getString("detail_info")));
				} else {
					bean.setDetail_info(rs.getString("detail_info"));
				}
				
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setPhoto_name2(Util.changeNullStr(rs.getString("photo_name2")));
				bean.setPhoto_name3(Util.changeNullStr(rs.getString("photo_name3")));
				bean.setPhoto_name4(Util.changeNullStr(rs.getString("photo_name4")));
				bean.setPhoto_name5(Util.changeNullStr(rs.getString("photo_name5")));
				bean.setPro_status(Util.changeNullStr(rs.getString("pro_status")));
				bean.setMember_sort(Util.changeNullStr(rs.getString("member_sort")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setDeleteflg(rs.getString("deleteflg"));
			}
		} catch (SQLException e) {
			throw new SysException("SQLException", e);

		} catch (Exception e) {
			throw new SysException("Exception", e);
		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0017", e);
				}
			}
			if (pstmt1 != null){
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SQLException", e);
				}
			}
			if (pstmt2 != null){
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new SysException("SQLException", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}
