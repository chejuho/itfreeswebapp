package engmail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class EngMailDeleteHandler {
	/**
	 * db:house_infoのidからハウス情報を削除するメソッド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteEngMailInfo(String id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug("EngMailDeleteHandler.deleteEngMailInfo.start");
			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "DELETE FROM eng_email WHERE mail_id= ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setString(1, id);
			KankokujinLogger.getInstance().debug(
					"deleteEngMailInfo sql =" + strSql);
			int result = pstmt.executeUpdate();
			if (result == 1) {

				return true;
			}

		} catch (SQLException e) {
			throw new AppException("EngMailDeleteHandler.deleteEngMailInfo.SQLException", e);
		} catch (Exception e) {
			throw new AppException("EngMailDeleteHandler.deleteEngMailInfo.Exception", e);
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
