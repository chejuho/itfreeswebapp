package roomsell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class RoomSellDeleteHandler {
	private static RoomSellDeleteHandler instance = null;
	private RoomSellDeleteHandler(){
		
	}
    public static RoomSellDeleteHandler getInstance() {
        if (instance == null) {
            synchronized (RoomSellDeleteHandler.class) {
                if (instance == null) {
                    instance = new RoomSellDeleteHandler();
                }
            }
        }

        return instance;
    }	
	/**
	 * db:room_infoÇÃidÇ©ÇÁïîâÆèÓïÒÇçÌèúÇ∑ÇÈÉÅÉ\ÉbÉh
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean deleteRoomSellInfo(int id) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "delete from room_info where id= ?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("RoomSellDeleteHandler.deleteRoomSellInfo" + pstmt.getQueryString());
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
