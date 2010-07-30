package iboard.handler;

import iboard.bean.IBoardBean;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;


public class IBoardUpdateHandler {
	private static IBoardUpdateHandler instance = null;
	private IBoardUpdateHandler(){
		
	}
    public static IBoardUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardUpdateHandler.class) {
                if (instance == null) {
                    instance = new IBoardUpdateHandler();
                }
            }
        }
        return instance;
    }
	public boolean update(IBoardBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			//sb.append("update iboard_info set title=?, content=?, file_name1=?, file_name2=?, file_name3=?,update_date=(now()) , read_count= 0");
			sb.append("update iboard_info set title=?, content=?,user_name = ?,update_date=(now()) , read_count= 0");
			sb.append(" where id=? ");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getUser_name());
			//pstmt.setString(3, bean.getFilename1());
			//pstmt.setString(4, bean.getFilename2());
			//pstmt.setString(5, bean.getFilename3());
			pstmt.setInt(4, Integer.valueOf(bean.getId()));
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("IBoardUpdateHandler.update" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new AppException("Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
	
	
}