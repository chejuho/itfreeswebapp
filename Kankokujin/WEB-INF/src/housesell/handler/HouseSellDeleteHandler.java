package housesell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class HouseSellDeleteHandler {
	private static HouseSellDeleteHandler instance = null;
	private HouseSellDeleteHandler(){
		
	}
    public static HouseSellDeleteHandler getInstance() {
        if (instance == null) {
            synchronized (HouseSellDeleteHandler.class) {
                if (instance == null) {
                    instance = new HouseSellDeleteHandler();
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
	public boolean deleteHouseSellInfo(int id) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "delete from house_info where id= ?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("HouseSellDeleteHandler.deleteHouseSellInfo" + pstmt.getQueryString());
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
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

}
