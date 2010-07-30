package findjob.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

import findjob.bean.FindjobBean;

public class FindjobDetailHandler {
	private static FindjobDetailHandler instance = null;
	private FindjobDetailHandler(){
		
	}
    public static FindjobDetailHandler getInstance() {
        if (instance == null) {
            synchronized (FindjobDetailHandler.class) {
                if (instance == null) {
                    instance = new FindjobDetailHandler();
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
	public FindjobBean getFindjobBean(FindjobBean bean, boolean updateflg, boolean brflg) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			if(updateflg){
				String strSql = "update findjob_info set read_count = read_count + 1 where id = ?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, bean.getId());
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("FindjobDetailHandler.getFindjobBean.sql1=" + pstmt1.getQueryString());
				if (result == 1) {
					//return bean;
				}
				
			}
			String strSql2 = "select * from findjob_info, member where findjob_info.id = ? and findjob_info.user_id= member.user_id";
			pstmt2 = new LogPreparedStatement(con, strSql2);
			pstmt2.setString(1, bean.getId());
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("FindjobDetailHandler.getFindjobBean.sql2=" + pstmt2.getQueryString());
			if (rs.next()) {

				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setWork_sort(Util.changeNullStr(rs.getString("work_sort")));
				bean.setBirthday(Util.changeNullStr(rs.getString("birthday")));
				bean.setSex(Util.changeNullStr(rs.getString("sex")));
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
