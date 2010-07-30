package main.handler;

import java.sql.Connection;
import java.sql.SQLException;

import main.bean.ContactusBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class ContactusRegistHandler {
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean insertContactusBean(ContactusBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer("insert into contactus_info (name, email, tel_no1_1, tel_no1_2, tel_no1_3,");
			sb.append("tel_no2_1, tel_no2_2, tel_no2_3, title, detail_info, regist_date, update_date)");
			sb.append("values");
			sb.append("(?, ?, ?, ?, ?,");
			sb.append("?, ?, ?, ?, ?, now(), now())");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getTel_no1_1());
			pstmt.setString(4, bean.getTel_no1_2());
			pstmt.setString(5, bean.getTel_no1_3());
			pstmt.setString(6, bean.getTel_no2_1());
			pstmt.setString(7, bean.getTel_no2_2());
			pstmt.setString(8, bean.getTel_no2_3());			
			pstmt.setString(9, bean.getTitle());
			pstmt.setString(10, bean.getDetail_info());			
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("ContactusRegistHandler.insertContactusBean" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
}
