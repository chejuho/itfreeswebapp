package admin.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.SysException;

public class TestComHandler {
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean insertCom() throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strsqr = "insert into t_comunication (regist_date)"
					+ "values"
					+ "(now())";
			pstmt = con.prepareStatement(strsqr);
			int result = pstmt.executeUpdate();
			if (result == 1) {

				return true;
			}

		} catch (Exception e) {
			throw new SysException("SYE0000", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0000", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
}
