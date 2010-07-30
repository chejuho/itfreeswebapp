package inform.handler;

import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InformDetailHandler {
	/**
	 * RoomInfo
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public InformBean getInformBean(HttpServletRequest request,int id) throws AppException {
		KankokujinLogger.getInstance().debug("InformDetailHandler.getInformBean.start");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InformBean bean = new InformBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String strSql2 = "select * from inform where id = ?";

			pstmt = con.prepareStatement(strSql2);

			pstmt.setInt(1, id);
			KankokujinLogger.getInstance().debug("getInformBean sql=" + strSql2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setDetail_info(rs.getString("detail_info"));
				bean.setRegist_date(rs.getTimestamp("regist_date"));
			}
		} catch (SQLException e) {
			throw new AppException("SQLException", e);

		} catch (Exception e) {
			throw new AppException("Exception" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0036", e);
				}
			}	
			if (pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			}	
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}
