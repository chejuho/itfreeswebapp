package buysell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class BuySellDeleteHandler {
	/**
	 * db:house_infoのidからハウス情報を削除するメソッド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteBuySellInfo(String id, String flg) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "update buysell_info set deleteflg=? where id=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, flg);
			pstmt.setString(2, id);
			KankokujinLogger.getInstance().debug("BuySellDeleteHandler.deleteBuySellInfo sql =" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			if (result == 1) {

				return true;
			}

		} catch (Exception e) {
			throw new AppException("BuySellDeleteHandler.deleteBuySellInfo.Exception", e);
		} finally {
			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

}
