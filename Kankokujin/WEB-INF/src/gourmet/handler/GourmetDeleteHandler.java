package gourmet.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class GourmetDeleteHandler {
	private static GourmetDeleteHandler instance = null;
	private GourmetDeleteHandler(){
		
	}
    public static GourmetDeleteHandler getInstance() {
        if (instance == null) {
            synchronized (GourmetDeleteHandler.class) {
                if (instance == null) {
                    instance = new GourmetDeleteHandler();
                }
            }
        }

        return instance;
    }
	/**
	 * db:house_infoのidからハウス情報を削除するメソッド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteGourmetInfo(String id) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "delete from gourmet_info where id= ?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("GourmetDeleteHandler.deleteGourmetInfo" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException("SYE0014", e);
		} catch (Exception e) {
			throw new SysException("SYE0014", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0014", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

}
