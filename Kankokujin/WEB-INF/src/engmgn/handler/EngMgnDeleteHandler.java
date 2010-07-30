package engmgn.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class EngMgnDeleteHandler {
	/**
	 * db:house_infoのidからハウス情報を削除するメソッド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteEngMgnInfo(String eng_id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug("EngMgnDeleteHandler.deleteEngMgnInfo.start");
			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "DELETE FROM engineer WHERE eng_id= ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setString(1, eng_id);
			KankokujinLogger.getInstance().debug(
					"deleteInterpretInfo sql =" + strSql);
			int result = pstmt.executeUpdate();
			if (result == 1) {

				return true;
			}

		}catch (SQLException e) {
			throw new AppException("EngMgnDeleteHandler.deleteEngMgnInfo.SQLException" + e);

		} catch (Exception e) {
			throw new AppException("EngMgnDeleteHandler.deleteEngMgnInfo.Exception" + e);

		} finally {
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnDeleteHandler.deleteEngMgnInfo.SQLException" + e);
				}
			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnDeleteHandler.deleteEngMgnInfo.SQLException" + e);
				}
			}
		}
		return false;
	}

}
