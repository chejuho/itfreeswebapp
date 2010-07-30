package iboard.handler;

import iboard.bean.IBoardBean;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class IBoardRegistHandler {
	private static IBoardRegistHandler instance = null;
	private IBoardRegistHandler(){
		
	}
    public static IBoardRegistHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardRegistHandler.class) {
                if (instance == null) {
                    instance = new IBoardRegistHandler();
                }
            }
        }

        return instance;
    }
	public boolean insert(IBoardBean bean) throws AppException {
		Connection con= null;
		LogPreparedStatement pstmt = null;
		try{
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer("insert into iboard_info ");//1-5
			sb.append("(title, content, file_name1, file_name2, file_name3, board_id, user_name, pass_word, regist_date, update_date, read_count)");
			sb.append(" values (?, ?, ?, ?, ?, ?, ?, ?, now(), now() , 0)");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getFilename1());
			pstmt.setString(4, bean.getFilename2());
			pstmt.setString(5, bean.getFilename3());
			pstmt.setString(6, bean.getBoardId());
			pstmt.setString(7, bean.getUser_name());
			pstmt.setString(8, Util.password(bean.getPassword()));
			
			KankokujinLogger.getInstance().debug("IBoardRegistHandler.insert" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			if(result==1){
			
			return true;
			}
			
	    }catch (Exception e) {
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
