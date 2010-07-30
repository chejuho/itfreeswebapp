package inform.handler;

import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;


public class InformRegistHandler {	
	/**
	 * RoomInfo��INSERT���郁�\�b�h�h
	 * 
	 * @return boolean
	 * @throws AppException 
	 */
	 public boolean insertInformBean(InformBean bean) throws AppException{
			Connection con= null;
			PreparedStatement pstmt = null;
			try{
				KankokujinLogger.getInstance().debug("BuySellRegistHandler.insertbuySellBean.start");
				con = DBConnectionMgr.getInstance().getConnection();
				String sql = 						        
				"insert into inform (title, detail_info, user_id, modify_user_id, regist_date, update_date) values(?, ?, ?, ?, now(),now())";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getTitle());
				pstmt.setString(2, bean.getDetail_info());
				pstmt.setString(3, bean.getUser_id());
				pstmt.setString(4, bean.getUser_id());
				
				KankokujinLogger.getInstance().debug("insertbuySellBean sql =" + sql);
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

