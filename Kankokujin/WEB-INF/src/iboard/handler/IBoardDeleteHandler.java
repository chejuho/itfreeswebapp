package iboard.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;


public class IBoardDeleteHandler {
	private static IBoardDeleteHandler instance = null;
	private IBoardDeleteHandler(){
		
	}
    public static IBoardDeleteHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardDeleteHandler.class) {
                if (instance == null) {
                    instance = new IBoardDeleteHandler();
                }
            }
        }

        return instance;
    }	
    
    public boolean delete(Connection con, int id) throws AppException {
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "delete from iboard_info where id= ?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("IBoardDeleteHandler.delete" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new AppException("Exception", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		return false;
	}
	
}
