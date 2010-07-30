package iboard.handler;

import iboard.bean.IBoardBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class IBoardDetailHandler {
	private static IBoardDetailHandler instance = null;
	private IBoardDetailHandler(){
		
	}
    public static IBoardDetailHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardDetailHandler.class) {
                if (instance == null) {
                    instance = new IBoardDetailHandler();
                }
            }
        }

        return instance;
    }	
    
    
    /**
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public IBoardBean getIBoardBean(Connection con, String id, boolean updateflg) throws SysException {
		
		IBoardBean bean = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			if (updateflg){
				String strSql = "update iboard_info set read_count = read_count + 1 where id = ?";
				pstmt1 = new LogPreparedStatement(con, strSql);
				pstmt1.setString(1, id);
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("IBoardDetailHandler.getIBoardBean.sql1=" + pstmt1.getQueryString());
				if (result == 1) {
					//return bean;
				}
			}
			StringBuffer sb = new StringBuffer("select * from iboard_info where id = ? ");
			pstmt2 = new LogPreparedStatement(con, sb.toString());
			pstmt2.setString(1, id);
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("IBoardDetailHandler.getIBoardBean.sql2=" + pstmt2.getQueryString());
			
			if (rs.next()) {
				bean = new IBoardBean();
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setFilename1(rs.getString("file_name1"));
				bean.setFilename2(rs.getString("file_name2"));
				bean.setFilename3(rs.getString("file_name3"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setUpdate_dateTime(rs.getTimestamp("update_date"));
				bean.setUser_name(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			throw new SysException("SYE0015", e);

		} catch (Exception e) {
			throw new SysException("SYE0015" , e);
		} finally {
			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}
			if (pstmt2 != null)
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}				
		}
		return bean;
	}
	

}
