package engmgn.handler;

import engmgn.bean.EngMgnBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class EngMgnUpdateHandler {
	public boolean updateEngMgnBean(EngMgnBean bean) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug(
					"EngMgnUpdateHandler.updateEngMgnBean.start");
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE engineer ");
			sb.append(" SET " );
			sb.append(" eng_type=?, eng_initial=?, eng_name1=?, eng_name2=?, " );
			sb.append(" eng_nation=?, eng_skilllicense=?, eng_japlicense=?, eng_age=?, eng_career=?, " );
			sb.append(" eng_os=?, eng_db=?, eng_language=?, eng_process=?, eng_possibledate=?, ");
			sb.append(" eng_japanese=?, eng_ment=?, eng_salary=?, eng_state=?," );
			if(!Util.isEmpty(bean.getEng_filename())){
				sb.append(" eng_filename='"+bean.getEng_filename() + "' ,");
			}
			sb.append(" eng_updatedate=(now()), eng_id_position=?, eng_sex=? , view_flg=?");
			sb.append(" where eng_id=?");
			
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, bean.getEng_type());
			pstmt.setString(2, bean.getEng_initial());
			pstmt.setString(3, bean.getEng_name1());
			pstmt.setString(4, bean.getEng_name2());
			
			pstmt.setString(5, bean.getEng_nation());
			pstmt.setString(6, bean.getEng_skilllicense());
			pstmt.setString(7, bean.getEng_japlicense());
			pstmt.setString(8, bean.getEng_age());
			pstmt.setString(9, bean.getEng_career());
			
			pstmt.setString(10, bean.getEng_os());
			pstmt.setString(11, bean.getEng_db());
			pstmt.setString(12, bean.getEng_language());
			pstmt.setString(13, bean.getEng_process());
			pstmt.setString(14, bean.getEng_possibledate());
			
			pstmt.setString(15, bean.getEng_japanese());
			pstmt.setString(16, bean.getEng_ment());
			pstmt.setString(17, bean.getEng_salary());
			pstmt.setString(18, bean.getEng_state());
			
			pstmt.setString(19, bean.getEng_id_position());
			pstmt.setString(20, bean.getEng_sex());
			pstmt.setString(21, bean.getViewflg());
			pstmt.setString(22, bean.getEng_id());

			KankokujinLogger.getInstance().debug("getEngMgnBeanList sql =" + sb.toString());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			throw new AppException(
					"EngMgnUpdateHandler.updateEngMgnBean.SQLException", e);
		} catch (Exception e) {
			throw new AppException("EngMgnUpdateHandler.updateEngMgnBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnUpdateHandler.updateEngMgnBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	
}