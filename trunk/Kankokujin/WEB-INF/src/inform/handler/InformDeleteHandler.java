package inform.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class InformDeleteHandler {
	/**
	 * db:house_info��id����n�E�X����폜���郁�\�b�h
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteInformInfo(int id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug("InformDeleteHandler.deleteInformInfo.start");
			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "DELETE FROM inform WHERE ID= ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setInt(1, id);
			KankokujinLogger.getInstance().debug(
					"deleteInformInfo sql =" + strSql);
			int result = pstmt.executeUpdate();
			if (result == 1) {

				return true;
			}

		} catch (SQLException e) {
			throw new AppException("InformDeleteHandler.deleteInformInfo.SQLException", e);
		} catch (Exception e) {
			throw new AppException("InformDeleteHandler.deleteInformInfo.Exception", e);
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
