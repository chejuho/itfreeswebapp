package inform.handler;

import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InformUpdateOpenHandler {
	/**
	 * RoomInfo
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public InformBean getInformBean(int id) throws AppException {
		KankokujinLogger.getInstance().debug("InformUpdateOpenHandler.getInterpretBean.start");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InformBean bean = new InformBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select * from inform where id = ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setInt(1, id);
			KankokujinLogger.getInstance().debug("getInformBean sql=" + strSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setId(Util.changeNullStr(rs.getString("id")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
			}
		} catch (SQLException e) {
			throw new AppException("InformUpdateOpenHandler.getInformBean.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InformUpdateOpenHandler.getInformBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InformUpdateOpenHandler.getInformBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}
