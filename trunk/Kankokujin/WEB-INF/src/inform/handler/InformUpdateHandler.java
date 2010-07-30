package inform.handler;

import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class InformUpdateHandler {
	
	public boolean updateInformBean(InformBean bean) throws AppException{
		Connection con= null;
		PreparedStatement pstmt = null;
		try{
			KankokujinLogger.getInstance().debug("BuySellUpdateHandler.updateBuySellBean.start");
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();  
			sb.append("UPDATE inform ");
			sb.append(" SET " );
			sb.append(" title=?, detail_info=?," );
			sb.append(" update_date=(now())" );
			sb.append(" where id=?");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getDetail_info());
			pstmt.setString(3, bean.getId());

			KankokujinLogger.getInstance().debug("updateInformBean sql =" + sb.toString());
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
				KankokujinLogger.getInstance().debug("InformUpdateHandler.updateInformBean.end");
		}
		return false;
	}	

}