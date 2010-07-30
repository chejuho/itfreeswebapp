package engmgn.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

import engmgn.bean.EngMgnBean;

public class EngMgnUpdateOpenHandler {
	
	public EngMgnBean getEngMgnBean(HttpServletRequest request,int id) throws AppException {
		KankokujinLogger.getInstance().debug("EngMgnUpdateOpenHandler.getEngMgnBean.start");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EngMgnBean bean = new EngMgnBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select * from engineer where eng_id = ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setInt(1, id);
			KankokujinLogger.getInstance().debug("getEngMgnBean sql=" + strSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				bean.setEng_id(rs.getString("eng_id"));
				bean.setEng_type(rs.getString("eng_type"));
				bean.setEng_initial(rs.getString("eng_initial"));
				bean.setEng_name1(rs.getString("eng_name1"));
				bean.setEng_name2(rs.getString("eng_name2"));
				bean.setEng_nation(rs.getString("eng_nation"));
				bean.setEng_skilllicense(rs.getString("eng_skilllicense"));
				bean.setEng_japlicense(rs.getString("eng_japlicense"));
				bean.setEng_age(rs.getString("eng_age"));
				bean.setEng_career(rs.getString("eng_career"));				
				bean.setEng_os(rs.getString("eng_os"));
				bean.setEng_db(rs.getString("eng_db"));
				bean.setEng_language(rs.getString("eng_language"));
				bean.setEng_process(rs.getString("eng_process"));
				bean.setEng_possibledate(rs.getString("eng_possibledate"));
				bean.setEng_japanese(rs.getString("eng_japanese"));
				
				bean.setEng_ment(rs.getString("eng_ment"));
				bean.setEng_salary(rs.getString("eng_salary"));
				bean.setEng_state(rs.getString("eng_state"));
				bean.setEng_filename(rs.getString("eng_filename"));
				bean.setEng_id_position(rs.getString("eng_id_position"));
				
				
			}
		} catch (SQLException e) {
			throw new AppException("EngMgnUpdateOpenHandler.getEngMgnBean.SQLException", e);

		} catch (Exception e) {
			throw new AppException("EngMgnUpdateOpenHandler.getEngMgnBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnUpdateOpenHandler.getEngMgnBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}
